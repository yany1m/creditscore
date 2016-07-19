package com.runrong.creditscore.business.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.runrong.creditscore.business.dao.CreditHistoryDao;
import com.runrong.creditscore.business.model.entity.Rule;
import com.runrong.creditscore.business.model.s62.T6252;
import com.runrong.creditscore.business.process.Resolve;
import com.runrong.creditscore.common.base.BaseRules;
import com.runrong.creditscore.common.dictionary.Constant;
import com.runrong.creditscore.config.RuleConfig;
/**
 * 信用历史分数计算
 * @author yanyimin
 *
 */
@Service
public class CreditHistoryService extends BaseRules implements Resolve {

	@Autowired
	CreditHistoryDao creditHistoryDao;
	
	//借款记录
	private static Map<String,Object> loanRecordRuleMap=new HashMap<String,Object>();
	
	/**
	 * 处理借款记录
	 * @param accountId
	 * @param map
	 * @return
	 */
	public Map<String, Integer> resolveLoanRecord(int accountId,Map<String, Integer> map){
		Map<String,Integer> rules;
		rules=(Map<String, Integer>) loanRecordRuleMap.get("rules");
		
		Rule rule=new Rule();
		List<T6252> list=creditHistoryDao.getLoanRecord(accountId);
		if(list.size()==0){
			rule.setNoBlank(false);
			map.put(Constant.LOAN_RECORD,rule(rule));
			return map;
		}
		
		//平均逾期概率
		double overdueRate=0;
		List<Double> overdueList=new ArrayList();
		//提前还款
		double advance=0;
		List<Double> advanceList=new ArrayList();
		//准时还款
		double onTime=0;
		List<Double> onTimeList=new ArrayList();
		
		int bidId=0;
		//未还次数
		int WH=0;
		
		for(T6252 t6252:list){
			
			if(bidId!=0 && bidId!=t6252.getF02()){
				
//				if(overdueRate>6 || (overdueRate/(overdueRate+advanceRate+onTimeRate))>0.6){
//					//出现坏账或等同于坏账的逾期还款方式
//				}
				if(WH>6){
					//出现坏账
					rule.setNoBlank(false);
					//扣80分
					rule.setMinScore(rules.get("minScore"));
					map.put(Constant.LOAN_RECORD,rule(rule));
					return map;
				}
				overdueList.add(overdueRate/(overdueRate+advance+onTime));
				advanceList.add(advance);
				onTimeList.add(onTime);
				
				overdueRate=0;
				advance=0;
				onTime=0;
			}
			
			bidId=t6252.getF02();
			
			//是否考虑 提前还款情况
			if(t6252.getF09().equals("WH")){
				WH=WH+1;
				continue;
			}
			//提前还款
			if(t6252.getF08().after(t6252.getF10())){			
				advance=advance+1;
			//逾期
			}else if(t6252.getF08().before(t6252.getF10())){
				overdueRate=overdueRate+1;
			//准时还款
			}else{
				onTime=onTime+1;
			}					
			
		}
		
		double x=0;
		if(overdueList.size()!=0){
			for(double i:overdueList){
				x=x+i;
			}
			overdueRate=x/overdueList.size();
		}
		
		x=0;
		if(advanceList.size()!=0){
			for(double i:advanceList){
				x=x+i;
			}
			advance=x;
		}
		if(onTimeList.size()!=0){
			for(double i:onTimeList){
				x=x+i;
			}
			onTime=x;
		}
		
		
		rule.setMaxScore(rules.get("score"));
		map.put(Constant.LOAN_RECORD, rule(rule,overdueRate,advance,onTime));
		return map;
	}
	
	public int rule(Rule rule,double overdueRate,double advance,double onTime){
		
		int maxScore=rule.getMaxScore();
				
		int i=(int) (-(overdueRate*overdueRate*maxScore)+((1-Math.pow(3, -advance))*advance*maxScore)/(advance+onTime)+((1-Math.pow(2, -onTime))*onTime*maxScore)/(advance+onTime));
		
		return i;
	}
	
	@Override
	public Map CountScore(int accountId) {
		init();
		
		Map<String,Integer> map=new HashMap<String, Integer>();
		int count=0;
		
		map=resolveLoanRecord(accountId, map);
			
		Set<Map.Entry<String, Integer>> entryseSet=map.entrySet();
		for (Map.Entry<String, Integer> entry:entryseSet) {
			count=count+entry.getValue();
		}
		
		Map<String,Object> identityMap=new HashMap<String, Object>();
		identityMap.put(Constant.MODEL, Constant.CREDIT_HISTORY);
		identityMap.put(Constant.INCLUDE,map);
		identityMap.put(Constant.COUNT, count);
		
		return identityMap;
		
	}

	@Override
	public void init() {
		List<Map> list=(List<Map>) RuleConfig.creidtHistoryMap.get("include");
		for(Map map:list){
			if(map.get("name").equals(Constant.LOAN_RECORD)){
				loanRecordRuleMap=map;
			}
			
		}
	}
}

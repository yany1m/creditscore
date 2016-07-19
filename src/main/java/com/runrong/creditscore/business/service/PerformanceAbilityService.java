package com.runrong.creditscore.business.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.runrong.creditscore.business.dao.PerformanceAbilityDao;
import com.runrong.creditscore.business.model.entity.Rule;
import com.runrong.creditscore.business.model.s61.T6143;
import com.runrong.creditscore.business.model.s62.T6251;
import com.runrong.creditscore.business.process.Resolve;
import com.runrong.creditscore.common.base.BaseRules;
import com.runrong.creditscore.common.dictionary.Constant;
import com.runrong.creditscore.config.RuleConfig;

/**
 * 履约能力分数计算
 * @author yanyimin
 *
 */
@Service
public class PerformanceAbilityService extends BaseRules implements Resolve{
	@Autowired
	PerformanceAbilityDao performanceAbilityDao;
	
	//工作
	private static Map<String,Object> userWorkRuleMap=new HashMap<String,Object>();
	//投资
	private static Map<String,Object> investRecordRuleMap=new HashMap<String,Object>();
	
	/**
	 * 处理工作信息
	 * @param accountId
	 * @param map
	 * @return
	 */
	public Map resolveUserWorkInfo(Integer accountId,Map<String, Integer> map){
		Map<String,Integer> rules;
		List<T6143> list=performanceAbilityDao.getUserWorkInfo(accountId);
		
		Rule rule=new Rule();
		if(list.size()==0){
			rule.setNoBlank(false);
			map.put(Constant.USER_WORK,rule(rule));
			return map;
		}
		
		rules=(Map) userWorkRuleMap.get("rules");
		rule.setMaxScore(rules.get("score"));
		map.put(Constant.USER_WORK,rule(rule));
		
		return map;
	}
	
	/**
	 * 处理投资记录
	 * @param accountId
	 * @param map
	 * @return
	 */
	public Map resolveInvestRecord(Integer accountId,Map<String, Integer> map){
		Map<String,Integer> rules;
		List<T6251> list=performanceAbilityDao.getInvestRecord(accountId);
		
		Rule rule=new Rule();
		if(list.size()==0){
			rule.setNoBlank(false);
			map.put(Constant.INVEST_RECORD,rule(rule));
			return map;
		}
		
		//投资次数
		int count=0;
		//投资总额
		double amount=0;
		for(T6251 t6251:list){
			count=count+1;		
			amount=amount+t6251.getF05();
		}
		
		//根据投资总金额进行一个阶段性的变化
		double x=0;		
		if(amount<100000){
		x=(Math.log(count*amount)/Math.log(2))/8;
		}else if(amount<200000){
		x=(Math.log(count*amount)/Math.log(2))/7;
		}
		
		//投资系数无限接近于1
		rule.setCoefficient((1-Math.pow(2, -(x))));		
		rules=(Map) investRecordRuleMap.get("rules");
		rule.setMaxScore(rules.get("score"));
		
		map.put(Constant.INVEST_RECORD, rule(rule));
		return map;
	}
	
	@Override
	public Map CountScore(int accountId) {
		init();
		
		Map<String,Integer> map=new HashMap<String, Integer>();
		int count=0;
		
		map=resolveUserWorkInfo(accountId,map);
		
		map=resolveInvestRecord(accountId,map);
		
		Set<Map.Entry<String, Integer>> entryseSet=map.entrySet();
		for (Map.Entry<String, Integer> entry:entryseSet) {
			count=count+entry.getValue();
		}
		
		Map<String,Object> identityMap=new HashMap<String, Object>();
		identityMap.put(Constant.MODEL, Constant.PERFORMANCE_ABILITY);
		identityMap.put(Constant.INCLUDE,map);
		identityMap.put(Constant.COUNT, count);
		
		return identityMap;
		
	}

	@Override
	public void init() {
		List<Map> list=(List<Map>) RuleConfig.performanceAbilityMap.get("include");
		for(Map map:list){
			if(map.get("name").equals(Constant.USER_WORK)){
				userWorkRuleMap=map;
			}
			if(map.get("name").equals(Constant.INVEST_RECORD)){
				investRecordRuleMap=map;
			}
		}
	}

}

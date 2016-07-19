package com.runrong.creditscore.business.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.runrong.creditscore.business.dao.AssetsInfoDao;
import com.runrong.creditscore.business.model.entity.Rule;
import com.runrong.creditscore.business.model.s61.T6112;
import com.runrong.creditscore.business.model.s61.T6113;
import com.runrong.creditscore.business.process.Resolve;
import com.runrong.creditscore.common.base.BaseRules;
import com.runrong.creditscore.common.dictionary.Constant;
import com.runrong.creditscore.config.RuleConfig;

/**
 * 资产信息分数计算
 * @author yanyimin
 *
 */
@Service
public class AssetsInfoService extends BaseRules implements Resolve{
	
	@Autowired
	AssetsInfoDao assetsInfoDao;
	
	//车产
	private static Map<String,Object> userCarRuleMap=new HashMap<String,Object>();
	//房产
	private static Map<String,Object> userHouseRuleMap=new HashMap<String,Object>();
	
	/**
	 * 处理车产信息
	 * @param accountId
	 * @param map
	 * @return
	 */
	public Map resolveUserCarInfo(Integer accountId,Map<String, Integer> map){
		Map<String,Integer> rules;
		List<T6113> list=assetsInfoDao.getUserCarInfo(accountId);
		
		Rule rule=new Rule();
		if(list.size()==0){
			rule.setNoBlank(false);
			map.put(Constant.USER_CAR,rule(rule));
			return map;
		}
		
		double price=0;
		for(T6113 t6113:list){
			price=price+t6113.getF07();
		}
		
		//总金额除以 设定的最高额度 等于 系数
		double Coefficient=0;
		if(price<1000000){
			Coefficient=price/1000000;
		}else{
			Coefficient=1;
		}
		
		rule.setCoefficient(Coefficient);
		rules=(Map) userCarRuleMap.get("rules");
		rule.setMaxScore(rules.get("score"));
		map.put(Constant.USER_CAR,rule(rule));
		return map;
	}
	
	/**
	 * 处理房产信息
	 * @param accountId
	 * @param map
	 * @return
	 */
	public Map resolveUserHouseInfo(Integer accountId,Map<String, Integer> map){
		Map<String,Integer> rules;
		List<T6112> list=assetsInfoDao.getUserHouseInfo(accountId);
		
		Rule rule=new Rule();
		if(list.size()==0){
			rule.setNoBlank(false);
			map.put(Constant.USER_HOUSE,rule(rule));
			return map;
		}
		
		double price=0;
		for(T6112 t6112:list){
			price=price+t6112.getF07();
		}
		
		//总金额除以 设定的最高额度 等于 系数
		double Coefficient=0;
		if(price<2000000){
			Coefficient=price/2000000;
		}else{
			Coefficient=1;
		}
			
		rule.setCoefficient(Coefficient);
		rules=(Map) userHouseRuleMap.get("rules");
		rule.setMaxScore(rules.get("score"));
		map.put(Constant.USER_HOUSE,rule(rule));
		return map;
	}
	

	@Override
	public Map CountScore(int accountId) {
		init();
		
		Map<String,Integer> map=new HashMap<String, Integer>();
		int count=0;
		
		map=resolveUserCarInfo(accountId,map);
		
		map=resolveUserHouseInfo(accountId,map);
		
		Set<Map.Entry<String, Integer>> entryseSet=map.entrySet();
		for (Map.Entry<String, Integer> entry:entryseSet) {
			count=count+entry.getValue();
		}
		
		Map<String,Object> identityMap=new HashMap<String, Object>();
		identityMap.put(Constant.MODEL, Constant.ASSETS_INFO);
		identityMap.put(Constant.INCLUDE,map);
		identityMap.put(Constant.COUNT, count);
		
		return identityMap;
	}

//	@Override
//	public int rule(Rule rule) {
//		if(!rule.isBlank()){
//			return rule.getMinScore();
//		}
//		return (int) (rule.getMaxScore()*rule.getCoefficient());
//	}

	@Override
	public void init() {
		List<Map> list=(List<Map>) RuleConfig.assetsMap.get("include");
		for(Map map:list){
			if(map.get("name").equals(Constant.USER_CAR)){
				userCarRuleMap=map;
			}
			if(map.get("name").equals(Constant.USER_HOUSE)){
				userHouseRuleMap=map;
			}
		}
		
	}
}

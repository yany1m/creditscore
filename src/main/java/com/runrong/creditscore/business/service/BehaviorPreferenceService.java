package com.runrong.creditscore.business.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.runrong.creditscore.business.dao.BehaviorPreferenceDao;
import com.runrong.creditscore.business.model.entity.Rule;
import com.runrong.creditscore.business.model.s80.T8060;
import com.runrong.creditscore.business.process.Resolve;
import com.runrong.creditscore.common.base.BaseRules;
import com.runrong.creditscore.common.dictionary.Constant;
import com.runrong.creditscore.config.RuleConfig;

/**
 * 行为偏好分数计算
 * @author yanyimin
 *
 */
@Service
public class BehaviorPreferenceService extends BaseRules implements Resolve{

	@Autowired
	BehaviorPreferenceDao behaviorPreferenceDao;
	
	//用户活跃度
	private static Map<String,Object> userActivityMap=new HashMap<String,Object>();
	
	/**
	 * 处理用户活跃度
	 * @param accountId
	 * @param map
	 * @return
	 */
	public Map resolveUserActivity(Integer accountId,Map<String, Integer> map){
		Map<String,Integer> rules;
		double i=behaviorPreferenceDao.getAccountActivity(accountId);
		
		Rule rule=new Rule();
		if(i==0){
			rule.setNoBlank(false);
			map.put(Constant.USER_ACTIVITY,rule(rule));
			return map;
		}
		
		double coefficient;
		if(i<50){
			coefficient=i/(double)50;
		}else{
			coefficient=1;
		}
		
		rule.setCoefficient(coefficient);
		rules=(Map) userActivityMap.get("rules");
		rule.setMaxScore(rules.get("score"));
		map.put(Constant.USER_ACTIVITY,rule(rule));
		return map;
	}

	@Override
	public Map CountScore(int accountId) {
		
		init();
		
		Map<String,Integer> map=new HashMap<String, Integer>();
		int count=0;
		
		map=resolveUserActivity(accountId,map);
		
		Set<Map.Entry<String, Integer>> entryseSet=map.entrySet();
		for (Map.Entry<String, Integer> entry:entryseSet) {
			count=count+entry.getValue();
		}
		
		Map<String,Object> identityMap=new HashMap<String, Object>();
		identityMap.put(Constant.MODEL, Constant.BEHAVIOR_PREFERNCE);
		identityMap.put(Constant.INCLUDE,map);
		identityMap.put(Constant.COUNT, count);
		
		return identityMap;
	}

	@Override
	public void init() {
		List<Map> list=(List<Map>) RuleConfig.behaviorPerferenceMap.get("include");
		for(Map map:list){
			if(map.get("name").equals(Constant.USER_ACTIVITY)){
				userActivityMap=map;
			}
		}
		
	}
}

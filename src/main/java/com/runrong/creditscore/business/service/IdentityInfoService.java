package com.runrong.creditscore.business.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.runrong.creditscore.business.dao.IdentityInfoDao;
import com.runrong.creditscore.business.model.entity.Rule;
import com.runrong.creditscore.business.model.s61.T6114;
import com.runrong.creditscore.business.model.s61.T6118;
import com.runrong.creditscore.business.model.s61.T6142;
import com.runrong.creditscore.business.process.Resolve;
import com.runrong.creditscore.common.base.BaseRules;
import com.runrong.creditscore.common.dictionary.Constant;
import com.runrong.creditscore.common.dictionary.DefineType;
import com.runrong.creditscore.config.RuleConfig;

/**
 * 身份信息分数计算
 * @author yanyimin
 *
 */
@Service
public class IdentityInfoService extends BaseRules implements Resolve{

	@Autowired
	IdentityInfoDao identityInfoDao;
	
	//身份证
	private static Map<String,Object> idRuleMap=new HashMap<String,Object>();
	//手机
	private static Map<String,Object> phoneRuleMap=new HashMap<String,Object>();
	//邮件
	private static Map<String,Object> emailRuleMap=new HashMap<String,Object>();
	//交易密码
	private static Map<String,Object> tradePwdRuleMap=new HashMap<String,Object>();
	//学历
	private static Map<String,Object> eduRuleMap=new HashMap<String,Object>();
	//银行卡
	private static Map<String,Object> bankCardRuleMap=new HashMap<String,Object>();
	
	/**
	 * 处理安全认证信息（身份证，手机，邮箱，交易密码）
	 * @param accountId
	 * @param map
	 * @return
	 */
	public Map resolveSecurityInfo(int accountId,Map<String, Integer> map){
		Map<String,Integer> rules;
		
		List<T6118> list=identityInfoDao.getSecurityCertification(accountId);
		
		Rule rule=new Rule();
		
		T6118 t6118=list.get(0);
		
		rules=(Map) idRuleMap.get("rules");
		rule.setMaxScore(rules.get("score"));
		rule.setNoBlank(t6118.getF02().equals(DefineType.TG));
		map.put(Constant.ID,rule(rule));
		
		rules=(Map) phoneRuleMap.get("rules");
		rule.setMaxScore(rules.get("score"));
		rule.setNoBlank(t6118.getF03().equals(DefineType.TG));		
		map.put(Constant.PHONE,rule(rule));
		
		rules=(Map) emailRuleMap.get("rules");
		rule.setMaxScore(rules.get("score"));
		rule.setNoBlank(t6118.getF04().equals(DefineType.TG));			
		map.put(Constant.EMAIL,rule(rule));
		
		rules=(Map) tradePwdRuleMap.get("rules");
		rule.setMaxScore(rules.get("score"));
		rule.setNoBlank(t6118.getF05().equals(DefineType.YSZ));
		map.put(Constant.TRADE_PWD,rule(rule));
			
		
		return map;
	}
	
	/**
	 * 处理教育信息
	 * @param accountId
	 * @param map
	 * @return
	 */
	public Map resolveEduInfo(int accountId,Map<String, Integer> map){
		Map<String,Integer> rules=(Map) eduRuleMap.get("rules");
		
		List<T6142> list=identityInfoDao.getEduInfo(accountId);
		
		Rule rule=new Rule();
		rule.setMaxScore(rules.get("score"));
		rule.setNoBlank(list.size()!=0);
		
		map.put(Constant.EDU_INFO,rule(rule));		
		return map;
	}
	
	/**
	 * 处理银行卡信息
	 * @param accountId
	 * @param map
	 * @return
	 */
	public Map resolveBankCard(int accountId,Map<String, Integer> map){
		Map<String,Integer> rules=(Map) eduRuleMap.get("rules");
		
		List<T6114> list=identityInfoDao.getBankCard(accountId);
		
		Rule rule=new Rule();
		rule.setMaxScore(rules.get("score"));
		rule.setNoBlank(list.size()!=0);
		
		map.put(Constant.BANK_CARD,rule(rule));
			
		return map;
	}
		

	@Override
	public Map CountScore(int accountId) {
		init();
		
		Map<String,Integer> map=new HashMap<String, Integer>();
		int count=0;
		map=resolveSecurityInfo(accountId,map);
		map=resolveEduInfo(accountId, map);
		map=resolveBankCard(accountId,map);
		
		Set<Map.Entry<String, Integer>> entryseSet=map.entrySet();
		for (Map.Entry<String, Integer> entry:entryseSet) {
			count=count+entry.getValue();
		}
		
		Map<String,Object> identityMap=new HashMap<String, Object>();
		identityMap.put(Constant.MODEL, Constant.IDENTITY_INFO);
		identityMap.put(Constant.INCLUDE,map);
		identityMap.put(Constant.COUNT, count);
		
		return identityMap;
	}

//	@Override
//	public int rule(Rule rule) {
//		if(rule.isBlank()){
//			return rule.getMaxScore();
//		}
//		return rule.getMinScore();
//	}

	@Override
	public void init() {
		List<Map> list=(List<Map>) RuleConfig.identityMap.get("include");
		for(Map map:list){
			if(map.get("name").equals(Constant.ID)){
				idRuleMap=map;
			}
			if(map.get("name").equals(Constant.PHONE)){
				phoneRuleMap=map;
			}
			if(map.get("name").equals(Constant.EMAIL)){
				emailRuleMap=map;
			}
			if(map.get("name").equals(Constant.TRADE_PWD)){
				tradePwdRuleMap=map;
			}
			if(map.get("name").equals(Constant.EDU_INFO)){
				eduRuleMap=map;
			}
			if(map.get("name").equals(Constant.BANK_CARD)){
				bankCardRuleMap=map;
			}
		}
		
	}
}

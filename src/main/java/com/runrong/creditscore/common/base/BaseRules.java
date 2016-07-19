package com.runrong.creditscore.common.base;

import com.runrong.creditscore.business.model.entity.Rule;

public class BaseRules {
	
	/**
	 * 系数乘以分数得到得分
	 * @param rule
	 * @return
	 */
	protected int rule(Rule rule) {
		if(rule.isNoBlank()){
			return (int) (rule.getMaxScore()*rule.getCoefficient());
		}
		return rule.getMinScore();
	}
}

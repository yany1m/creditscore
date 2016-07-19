package com.runrong.creditscore.business.process;

import org.springframework.stereotype.Component;

/**
 * 计算规则
 * @author yanyimin
 *
 */

@Component
public class CalculationRules {
	
	/**
	 * 填写就有分，暂时无法认证
	 * @param score
	 * @param countScore
	 * @return
	 */
	public int Rule(int score,int countScore){
		
		return countScore;	
	}
}

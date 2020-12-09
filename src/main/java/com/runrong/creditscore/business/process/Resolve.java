package com.runrong.creditscore.business.process;

import java.util.Map;

import com.runrong.creditscore.business.model.entity.Rule;

/**
 * 处理信息接口
 * @author yanyimin
 *
 */
public interface Resolve{
	
//	/**
//	 * 计算规则
//	 * @param rule
//	 * @return
//	 */
//	public int rule(Rule rule);
	
	/**
	 * 统计分数
	 * @return
	 */
	public abstract Map CountScore(int accountId);
	
	/**
	 * 初始化，解析map
	 */
	public void init();
}

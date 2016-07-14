package com.runrong.creditscore.business.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.runrong.creditscore.common.base.BaseDao;

/**
 * 履约能力
 * @author yanyimin
 *
 */
@Repository
public class PerformanceAbilityDao extends BaseDao{

	/**
	 * 得到工作信息
	 * @param accountId
	 * @return
	 */
	public List<Map> getUserWorkInfo(Integer accountId){
		List<Map> list=new ArrayList<Map>();
		
 		return list;
	}
	
	
	/**
	 * 得到投资记录
	 * @param accountId
	 * @return
	 */
	public List<Map> getInvestHistory(Integer accountId){
		List<Map> list=new ArrayList<Map>();
		
 		return list;
	}
}

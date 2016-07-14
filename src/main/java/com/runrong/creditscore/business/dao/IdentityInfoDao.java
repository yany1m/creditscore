package com.runrong.creditscore.business.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.runrong.creditscore.common.base.BaseDao;

/**
 * 身份信息
 * @author yanyimin
 *
 */
@Repository
public class IdentityInfoDao extends BaseDao{
	
	/**
	 * 拿到手机号
	 * @param accountId
	 * @return
	 */
	public List<Map> getPhone(Integer accountId){
		List<Map> list=new ArrayList<Map>();
		
		return list;
	}
	
	/**
	 * 拿到邮箱
	 * @param accountId
	 * @return
	 */
	public List<Map> getEmail(Integer accountId){
		List<Map> list=new ArrayList<Map>();
		
		return list;
	}
	
	/**
	 * 拿到身份证
	 * @param accountId
	 * @return
	 */
	public List<Map> getID(Integer accountId){
		List<Map> list=new ArrayList<Map>();
		
		return list;
	}
	
	/**
	 * 拿到银行卡
	 * @param accountId
	 * @return
	 */
	public List<Map> getBankCard(Integer accountId){
		List<Map> list=new ArrayList<Map>();
		
		return list;
	}
		
	/**
	 * 拿到学历
	 * @param accountId
	 * @return
	 */
	public List<Map> getEduInfo(Integer accountId){
		List<Map> list=new ArrayList<Map>();
		
		return list;
	}
}

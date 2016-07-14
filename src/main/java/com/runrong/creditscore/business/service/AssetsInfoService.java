package com.runrong.creditscore.business.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.runrong.creditscore.business.dao.AssetsInfoDao;
import com.runrong.creditscore.common.base.ResultModel;

/**
 * 资产信息分数计算
 * @author yanyimin
 *
 */
@Service
public class AssetsInfoService {
	
	@Autowired
	AssetsInfoDao assetsInfoDao;
	
	/**
	 * 处理车产信息
	 * @param accountId
	 * @return
	 */
	public List<Map> resolveUserCarInfo(Integer accountId){
		
		List<Map> list=assetsInfoDao.getUserCarInfo(accountId);
		
		return list;
	}
	
	/**
	 * 处理房产信息
	 * @param accountId
	 * @return
	 */
	public List<Map> resolveUserHouseInfo(Integer accountId){
		
		List<Map> list=assetsInfoDao.getUserHouseInfo(accountId);
		
		return list;
	}
	
	public ResultModel createScore(Integer accountId){
		
		resolveUserCarInfo(accountId);
		
		resolveUserHouseInfo(accountId);
		
		return ResultModel.successModel("");
	}
}

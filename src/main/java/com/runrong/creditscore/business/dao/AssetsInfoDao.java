package com.runrong.creditscore.business.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.runrong.creditscore.common.base.BaseDao;

/**
 * 资产信息
 * @author yanyimin
 *
 */
@Repository
public class AssetsInfoDao extends BaseDao{
	
	/**
	 * 得到用户车产信息
	 * @param accountId
	 * @return
	 */
	public List<Map> getUserCarInfo(Integer accountId){
		String sql="SELECT * FROM S61.T6113 WHERE F02=?";
		
		List<Map> list=jdbcTemplate.query(sql,new RowMapper<Map>(){

			@Override
			public Map mapRow(ResultSet rs, int rowNum) throws SQLException {
				Map<String,Object> map=new HashMap<String, Object>();
				map.put("F01",rs.getInt("F01"));
				map.put("F02",rs.getInt("F02"));
				map.put("F03",rs.getString("F03"));
				map.put("F04",rs.getString("F04"));
				map.put("F05",rs.getInt("F05"));
				map.put("F06",rs.getDouble("F06"));
				map.put("F07",rs.getDouble("F07"));
				
				return map;
			}} ,accountId);
		if(list.size()==0){
			list=new ArrayList<Map>();
			return list;
		}
		
		return list;
	}
	
	/**
	 * 得到用户房产信息
	 * @param accountId
	 * @return
	 */
	public List<Map> getUserHouseInfo(Integer accountId){
		String sql="SELECT * FROM S61.T6112 WHERE F02=?";
		
		List<Map> list=jdbcTemplate.query(sql,new RowMapper<Map>(){

			@Override
			public Map mapRow(ResultSet rs, int rowNum) throws SQLException {
				Map<String,Object> map=new HashMap<String, Object>();
				map.put("F01",rs.getInt("F01"));
				map.put("F02",rs.getInt("F02"));
				map.put("F03",rs.getString("F03"));
				map.put("F04",rs.getFloat("F04"));
				map.put("F05",rs.getInt("F05"));
				map.put("F06",rs.getDouble("F06"));
				map.put("F07",rs.getDouble("F07"));
				map.put("F08",rs.getInt("F08"));
				map.put("F09",rs.getString("F09"));
				map.put("F10",rs.getString("F10"));
				map.put("F11",rs.getDouble("F11"));
				
				return map;
			}} ,accountId);
		if(list.size()==0){
			list=new ArrayList<Map>();
			return list;
		}
		
		return list;
	}
}

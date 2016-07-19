package com.runrong.creditscore.business.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.runrong.creditscore.business.model.s61.T6112;
import com.runrong.creditscore.business.model.s61.T6113;
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
	public List<T6113> getUserCarInfo(Integer accountId){
		String sql="SELECT * FROM S61.T6113 WHERE F02=?";
		
		List<T6113> list=jdbcTemplate.query(sql,new RowMapper<T6113>(){

			@Override
			public T6113 mapRow(ResultSet rs, int rowNum) throws SQLException {
				T6113 t6113=new T6113();
				t6113.setF01(rs.getInt("F01"));
				t6113.setF02(rs.getInt("F02"));
				t6113.setF03(rs.getString("F03"));
				t6113.setF04(rs.getString("F04"));
				t6113.setF05(rs.getInt("F05"));
				t6113.setF06(rs.getDouble("F06"));
				t6113.setF07(rs.getDouble("F07"));
				
				return t6113;
			}} ,accountId);
		if(list.size()==0){
			list=new ArrayList<T6113>();
			return list;
		}
		
		return list;
	}
	
	/**
	 * 得到用户房产信息
	 * @param accountId
	 * @return
	 */
	public List<T6112> getUserHouseInfo(Integer accountId){
		String sql="SELECT * FROM S61.T6112 WHERE F02=?";
		
		List<T6112> list=jdbcTemplate.query(sql,new RowMapper<T6112>(){

			@Override
			public T6112 mapRow(ResultSet rs, int rowNum) throws SQLException {
				T6112 t6112=new T6112();
				t6112.setF01(rs.getInt("F01"));
				t6112.setF02(rs.getInt("F02"));
				t6112.setF03(rs.getString("F03"));
				t6112.setF04(rs.getFloat("F04"));
				t6112.setF05(rs.getInt("F05"));
				t6112.setF06(rs.getDouble("F06"));
				t6112.setF07(rs.getDouble("F07"));
				t6112.setF08(rs.getInt("F08"));
				t6112.setF09(rs.getString("F09"));
				t6112.setF10(rs.getString("F10"));
				t6112.setF11(rs.getDouble("F11"));
				
				return t6112;
			}} ,accountId);
		if(list.size()==0){
			list=new ArrayList<T6112>();
			return list;
		}
		
		return list;
	}
}

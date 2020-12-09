package com.runrong.creditscore.business.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.runrong.creditscore.business.model.s61.T6143;
import com.runrong.creditscore.business.model.s62.T6251;
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
	public List<T6143> getUserWorkInfo(Integer accountId){
		String sql="SELECT * FROM S61.t6143 WHERE F02=?";
		List<T6143> list=new ArrayList<T6143>();
		list=jdbcTemplate.query(sql,new RowMapper<T6143>(){

			@Override
			public T6143 mapRow(ResultSet rs, int rowNum) throws SQLException {
				T6143 t6143=new T6143();
				t6143.setF01(rs.getInt("F01"));
				t6143.setF02(rs.getInt("F02"));
				t6143.setF03(rs.getString("F03"));
				t6143.setF04(rs.getString("F04"));
				t6143.setF05(rs.getString("F05"));
				t6143.setF06(rs.getString("F06"));
				t6143.setF07(rs.getInt("F07"));
				t6143.setF08(rs.getString("F08"));
				t6143.setF09(rs.getString("F09"));
				t6143.setF10(rs.getString("F10"));
				t6143.setF11(rs.getString("F11"));
				
				return t6143;
			}} ,accountId);
		if(list.size()==0){
			list=new ArrayList<T6143>();
			return list;
		}
		
 		return list;
	}
	
	
	/**
	 * 得到投资记录
	 * @param accountId
	 * @return
	 */
	public List<T6251> getInvestRecord(Integer accountId){
		String sql="SELECT * FROM S62.T6251 WHERE F04=?";
		List<T6251> list=new ArrayList<T6251>();
		list=jdbcTemplate.query(sql,new RowMapper<T6251>(){

			@Override
			public T6251 mapRow(ResultSet rs, int rowNum) throws SQLException {
				T6251 t6251=new T6251();
				t6251.setF01(rs.getInt("F01"));
				t6251.setF02(rs.getString("F02"));
				t6251.setF03(rs.getInt("F03"));
				t6251.setF04(rs.getInt("F04"));
				t6251.setF05(rs.getDouble("F05"));
				t6251.setF06(rs.getDouble("F06"));
				t6251.setF07(rs.getDouble("F07"));
				t6251.setF08(rs.getString("F08"));
				t6251.setF09(rs.getDate("F09"));
				t6251.setF10(rs.getDate("F10"));
				t6251.setF11(rs.getInt("F11"));
				
				
				return t6251;
			}} ,accountId);
		if(list.size()==0){
			list=new ArrayList<T6251>();
			return list;
		}
 		return list;
	}
}

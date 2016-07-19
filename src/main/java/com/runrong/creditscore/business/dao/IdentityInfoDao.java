package com.runrong.creditscore.business.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.runrong.creditscore.business.model.s61.T6114;
import com.runrong.creditscore.business.model.s61.T6118;
import com.runrong.creditscore.business.model.s61.T6142;
import com.runrong.creditscore.common.base.BaseDao;

/**
 * 身份信息
 * @author yanyimin
 *
 */
@Repository
public class IdentityInfoDao extends BaseDao{
	
	/**
	 * 安全认证表(手机，邮箱，身份，交易密码)
	 * @param accountId
	 * @return
	 */
	public List<T6118> getSecurityCertification (Integer accountId){
		List<T6118> list=new ArrayList<T6118>();
		
		String sql="SELECT * FROM S61.T6118 WHERE F01=?";
		
		list=jdbcTemplate.query(sql,new RowMapper<T6118>(){

			@Override
			public T6118 mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				T6118 t6118=new T6118();
				t6118.setF01(rs.getInt("F01"));
				t6118.setF02(rs.getString("F02"));
				t6118.setF03(rs.getString("F03"));
				t6118.setF04(rs.getString("F04"));
				t6118.setF05(rs.getString("F05"));
				t6118.setF06(rs.getString("F06"));
				t6118.setF07(rs.getString("F07"));
				t6118.setF08(rs.getString("F08"));
				t6118.setF09(rs.getString("F09"));
				
				return t6118;
			}},accountId);
		
		return list;
	}
		
	
	/**
	 * 拿到银行卡
	 * @param accountId
	 * @return
	 */
	public List<T6114> getBankCard(Integer accountId){
		List<T6114> list=new ArrayList<T6114>();
		
		String sql="SELECT * FROM S61.T6114 WHERE F02=?";
		
		list=jdbcTemplate.query(sql,new RowMapper<T6114>(){

			@Override
			public T6114 mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				T6114 t6114=new T6114();
				t6114.setF01(rs.getInt("F01"));
				t6114.setF02(rs.getInt("F02"));
				t6114.setF03(rs.getInt("F03"));
				t6114.setF04(rs.getInt("F04"));
				t6114.setF05(rs.getString("F05"));
				t6114.setF06(rs.getString("F06"));
				t6114.setF07(rs.getString("F07"));
				t6114.setF08(rs.getString("F08"));
				t6114.setF09(rs.getDate("F09"));
				t6114.setF10(rs.getString("F10"));
				
				return t6114;
			}},accountId);
		return list;
	}
		
	/**
	 * 拿到学历
	 * @param accountId
	 * @return
	 */
	public List<T6142> getEduInfo(Integer accountId){
		List<T6142> list=new ArrayList<T6142>();
		
		String sql="SELECT * FROM S61.T6142 WHERE F02=?";
		
		list=jdbcTemplate.query(sql,new RowMapper<T6142>(){

			@Override
			public T6142 mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				T6142 t6142=new T6142();
				t6142.setF01(rs.getInt("F01"));
				t6142.setF02(rs.getInt("F02"));
				t6142.setF03(rs.getString("F03"));
				t6142.setF04(rs.getInt("F04"));
				t6142.setF05(rs.getString("F05"));
				t6142.setF06(rs.getString("F06"));
				
				return t6142;
			}},accountId);
		return list;
	}
}

package com.runrong.creditscore.business.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.runrong.creditscore.business.model.s62.T6252;
import com.runrong.creditscore.common.base.BaseDao;

/**
 * 信用历史
 * @author yanyimin
 *
 */
@Repository
public class CreditHistoryDao extends BaseDao{
	
	public List<T6252> getLoanRecord(Integer accountId){
		//根据应还时间与标进行分组,查看用户之前是否有逾期或者坏账的情况
		String sql="SELECT * FROM S62.T6252 GROUP BY F02,F08 HAVING F03=? AND DATEDIFF(NOW(),F08)>0;";
		List<T6252> list=new ArrayList<T6252>();
		list=jdbcTemplate.query(sql,new RowMapper<T6252>(){

			@Override
			public T6252 mapRow(ResultSet rs, int rowNum) throws SQLException {
				T6252 t6252=new T6252();
				t6252.setF01(rs.getInt("F01"));
				t6252.setF02(rs.getInt("F02"));
				t6252.setF03(rs.getInt("F03"));
				t6252.setF04(rs.getInt("F04"));
				t6252.setF05(rs.getInt("F05"));
				t6252.setF06(rs.getInt("F06"));
				t6252.setF07(rs.getInt("F07"));
				t6252.setF08(rs.getDate("F08"));
				t6252.setF09(rs.getString("F09"));
				t6252.setF10(rs.getDate("F10"));
				t6252.setF11(rs.getInt("F11"));
				
				return t6252;
			}} ,accountId);
		if(list.size()==0){
			list=new ArrayList<T6252>();
			return list;
		}
		
 		return list;
	} 
}

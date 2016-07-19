package com.runrong.creditscore.business.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.runrong.creditscore.business.model.s61.T6113;
import com.runrong.creditscore.business.model.s80.T8060;
import com.runrong.creditscore.common.base.BaseDao;

/**
 * 行为偏好
 * @author yanyimin
 *
 */
@Repository
public class BehaviorPreferenceDao extends BaseDao{

	/**
	 * 得到用户活跃度
	 * @param accountId
	 * @return
	 */
	public int getAccountActivity(Integer accountId){
		String sql="SELECT COUNT(*) AS F01 FROM S80.T8060 WHERE F02=?";
	
		List<Integer> list=jdbcTemplate.query(sql,new RowMapper<Integer>(){

			@Override
			public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Integer i=rs.getInt("F01");		
				return i;
			}} ,accountId);
		if(list.size()==0){
			return 0;
		}
		return list.get(0);
		
	}
}

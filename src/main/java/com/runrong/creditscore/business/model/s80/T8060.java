package com.runrong.creditscore.business.model.s80;

import java.sql.Timestamp;

/**
 * 用户活跃度
 * @author yanyimin
 *
 */
public class T8060 {
	
	private int F01;
	private int F02;
	private String F03;
	private Timestamp F04;
	
	/**
	 * 自增id
	 */
	public int getF01() {
		return F01;
	}
	/**
	 * 自增id
	 */
	public void setF01(int f01) {
		F01 = f01;
	}
	/**
	 * 用户id
	 */
	public int getF02() {
		return F02;
	}
	/**
	 * 用户id
	 */
	public void setF02(int f02) {
		F02 = f02;
	}
	/**
	 * 用户访问页面
	 */
	public String getF03() {
		return F03;
	}
	/**
	 * 用户访问页面
	 */
	public void setF03(String f03) {
		F03 = f03;
	}
	/**
	 * 时间戳
	 */
	public Timestamp getF04() {
		return F04;
	}
	/**
	 * 时间戳
	 */
	public void setF04(Timestamp f04) {
		F04 = f04;
	}
	
	
}

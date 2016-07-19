package com.runrong.creditscore.business.model.s61;
/**
 * 学历信息
 * @author yanyimin
 *
 */
public class T6142 {
	
	private int F01;
	private int F02;
	private String F03;
	private int F04;
	private String F05;
	private String F06;
	
	/**
	 * 学历记录ID,自增
	 */
	public int getF01() {
		return F01;
	}
	/**
	 * 学历记录ID,自增
	 */
	public void setF01(int f01) {
		F01 = f01;
	}
	/**
	 * 用户ID,参考T6110.F01
	 */
	public int getF02() {
		return F02;
	}
	/**
	 * 用户ID,参考T6110.F01 
	 */
	public void setF02(int f02) {
		F02 = f02;
	}
	/**
	 * 毕业院校
	 */
	public String getF03() {
		return F03;
	}
	/**
	 * 毕业院校
	 */
	public void setF03(String f03) {
		F03 = f03;
	}
	/**
	 * 入学年份
	 */
	public int getF04() {
		return F04;
	}
	/**
	 * 入学年份
	 */
	public void setF04(int f04) {
		F04 = f04;
	}
	/**
	 * 专业
	 */
	public String getF05() {
		return F05;
	}
	/**
	 * 专业
	 */
	public void setF05(String f05) {
		F05 = f05;
	}
	/**
	 * 在校情况简介
	 */
	public String getF06() {
		return F06;
	}
	/**
	 * 在校情况简介
	 */
	public void setF06(String f06) {
		F06 = f06;
	}
	
	
}

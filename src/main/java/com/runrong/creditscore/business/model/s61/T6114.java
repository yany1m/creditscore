package com.runrong.creditscore.business.model.s61;

import java.sql.Date;

/**
 * 银行卡信息
 * @author yanyimin
 *
 */
public class T6114 {
	
	private int F01;
	private int F02;
	private int F03;
	private int F04;
	private String F05;
	private String F06;
	private String F07;
	private String F08;
	private Date F09;
	private String F10;
	
	/**
	 * 用户银行卡ID,自增ID
	 */
	public int getF01() {
		return F01;
	}
	/**
	 * 用户银行卡ID,自增ID
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
	 * 银行ID,参考T5020.F01
	 */
	public int getF03() {
		return F03;
	}
	/**
	 * 银行ID,参考T5020.F01
	 */
	public void setF03(int f03) {
		F03 = f03;
	}
	/**
	 * 开户行所在地区域ID,参考T5119.F01
	 */
	public int getF04() {
		return F04;
	}
	/**
	 * 开户行所在地区域ID,参考T5119.F01
	 */
	public void setF04(int f04) {
		F04 = f04;
	}
	/**
	 * 开户行
	 */
	public String getF05() {
		return F05;
	}
	/**
	 * 开户行
	 */
	public void setF05(String f05) {
		F05 = f05;
	}
	/**
	 * 银行卡号,前4位,后3位保留,其他星号代替
	 */
	public String getF06() {
		return F06;
	}
	/**
	 * 银行卡号,前4位,后3位保留,其他星号代替
	 */
	public void setF06(String f06) {
		F06 = f06;
	}
	/**
	 * 银行卡号,加密存储
	 */
	public String getF07() {
		return F07;
	}
	/**
	 * 银行卡号,加密存储
	 */
	public void setF07(String f07) {
		F07 = f07;
	}
	/**
	 * 状态,QY:启用;TY:停用;
	 */
	public String getF08() {
		return F08;
	}
	/**
	 * 状态,QY:启用;TY:停用;
	 */
	public void setF08(String f08) {
		F08 = f08;
	}
	/**
	 * 创建时间
	 */
	public Date getF09() {
		return F09;
	}
	/**
	 * 创建时间
	 */
	public void setF09(Date f09) {
		F09 = f09;
	}
	/**
	 * 实名认证,TG:通过;BTG:不通过;
	 */
	public String getF10() {
		return F10;
	}
	/**
	 * 实名认证,TG:通过;BTG:不通过;
	 */
	public void setF10(String f10) {
		F10 = f10;
	}
	
	
}

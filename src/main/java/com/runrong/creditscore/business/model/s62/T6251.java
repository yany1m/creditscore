package com.runrong.creditscore.business.model.s62;

import java.sql.Date;

/**
 * 具备债权的标
 * @author yanyimin
 *
 */
public class T6251 {
	
	private int F01;
	private String F02;
	private int F03;
	private int F04;
	private double F05;
	private double F06;
	private double F07;
	private String F08;
	private Date F09;
	private Date F10;
	private int F11;
	
	/**
	 * 自增ID
	 */
	public int getF01() {
		return F01;
	}
	/**
	 * 自增ID
	 */
	public void setF01(int f01) {
		F01 = f01;
	}
	/**
	 * 债权编码
	 */
	public String getF02() {
		return F02;
	}
	/**
	 * 债权编码
	 */
	public void setF02(String f02) {
		F02 = f02;
	}
	/**
	 * 标ID,参考T6230.F01
	 */
	public int getF03() {
		return F03;
	}
	/**
	 * 标ID,参考T6230.F01
	 */
	public void setF03(int f03) {
		F03 = f03;
	}
	/**
	 * 债权人ID,参考T6110.F01
	 */
	public int getF04() {
		return F04;
	}
	/**
	 * 债权人ID,参考T6110.F01
	 */
	public void setF04(int f04) {
		F04 = f04;
	}
	/**
	 * 购买价格
	 */
	public double getF05() {
		return F05;
	}
	/**
	 * 购买价格
	 */
	public void setF05(double f05) {
		F05 = f05;
	}
	/**
	 * 原始债权金额
	 */
	public double getF06() {
		return F06;
	}
	/**
	 * 原始债权金额
	 */
	public void setF06(double f06) {
		F06 = f06;
	}
	/**
	 * 持有债权金额
	 */
	public double getF07() {
		return F07;
	}
	/**
	 * 持有债权金额
	 */
	public void setF07(double f07) {
		F07 = f07;
	}
	/**
	 * 是否正在转让,S:是;F:否;
	 */
	public String getF08() {
		return F08;
	}
	/**
	 * 是否正在转让,S:是;F:否;
	 */
	public void setF08(String f08) {
		F08 = f08;
	}
	/**
	 * 创建日期
	 */
	public Date getF09() {
		return F09;
	}
	/**
	 * 创建日期
	 */
	public void setF09(Date f09) {
		F09 = f09;
	}
	/**
	 * 起息日期
	 */
	public Date getF10() {
		return F10;
	}
	/**
	 * 起息日期
	 */
	public void setF10(Date f10) {
		F10 = f10;
	}
	/**
	 * 投资记录ID,参考T6250.F01
	 */
	public int getF11() {
		return F11;
	}
	/**
	 * 投资记录ID,参考T6250.F01
	 */
	public void setF11(int f11) {
		F11 = f11;
	}
	
}

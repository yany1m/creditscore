package com.runrong.creditscore.business.model.s62;

import java.sql.Date;

/**
 * 标还款记录
 * @author yanyimin
 *
 */
public class T6252 {
	private int F01;
	private int F02;
	private int F03;
	private int F04;
	private int F05;
	private int F06;
	private double F07;
	private Date F08;
	private String F09;
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
	 * 标ID,参考T6230.F01
	 */
	public int getF02() {
		return F02;
	}
	/**
	 * 标ID,参考T6230.F01
	 */
	public void setF02(int f02) {
		F02 = f02;
	}
	/**
	 * 付款用户ID,参考T6110.F01
	 */
	public int getF03() {
		return F03;
	}
	/**
	 * 付款用户ID,参考T6110.F01
	 */
	public void setF03(int f03) {
		F03 = f03;
	}
	/**
	 * 收款用户ID,参考T6110.F01
	 */
	public int getF04() {
		return F04;
	}
	/**
	 * 收款用户ID,参考T6110.F01
	 */
	public void setF04(int f04) {
		F04 = f04;
	}
	/**
	 * 交易类型ID,参考T5122.F01
	 */
	public int getF05() {
		return F05;
	}
	/**
	 * 交易类型ID,参考T5122.F01
	 */
	public void setF05(int f05) {
		F05 = f05;
	}
	/**
	 * 期号
	 */
	public int getF06() {
		return F06;
	}
	/**
	 * 期号
	 */
	public void setF06(int f06) {
		F06 = f06;
	}
	/**
	 * 金额
	 */
	public double getF07() {
		return F07;
	}
	/**
	 * 金额
	 */
	public void setF07(double f07) {
		F07 = f07;
	}
	/**
	 * 应还日期
	 */
	public Date getF08() {
		return F08;
	}
	/**
	 * 应还日期
	 */
	public void setF08(Date f08) {
		F08 = f08;
	}
	/**
	 * 状态,WH:未还;YH:已还;HKZ:还款中;TQH:提前还;DF:垫付
	 */
	public String getF09() {
		return F09;
	}
	/**
	 * 状态,WH:未还;YH:已还;HKZ:还款中;TQH:提前还;DF:垫付
	 */
	public void setF09(String f09) {
		F09 = f09;
	}
	/**
	 * 实际还款时间
	 */
	public Date getF10() {
		return F10;
	}
	/**
	 * 实际还款时间
	 */
	public void setF10(Date f10) {
		F10 = f10;
	}
	/**
	 * 债权ID,参考T6251.F01
	 */
	public int getF11() {
		return F11;
	}
	/**
	 * 债权ID,参考T6251.F01
	 */
	public void setF11(int f11) {
		F11 = f11;
	}
	
}

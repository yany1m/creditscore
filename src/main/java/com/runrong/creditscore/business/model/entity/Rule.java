package com.runrong.creditscore.business.model.entity;

public class Rule {
	
	//最高得分
	private int maxScore;
	//最低得分
	private int minScore=0;
	//系数
	private double coefficient=1;
	//该项是否是空白
	private boolean noBlank=true;
	
	public int getMaxScore() {
		return maxScore;
	}
	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}
	public int getMinScore() {
		return minScore;
	}
	public void setMinScore(int minScore) {
		this.minScore = minScore;
	}
	public double getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}
	public boolean isNoBlank() {
		return noBlank;
	}
	public void setNoBlank(boolean noBlank) {
		this.noBlank = noBlank;
	}
	
	
	
	
}

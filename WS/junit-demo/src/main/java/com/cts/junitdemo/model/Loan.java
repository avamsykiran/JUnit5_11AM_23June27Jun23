package com.cts.junitdemo.model;

public class Loan {

	private double principal;
	private double rateOfInterest;
	private double termsInYears;
	private double simpleInterest;
	
	public Loan(){
		
	}

	public Loan(double principal, double rateOfInterest, double termsInYears, double simpleInterest) {
		super();
		this.principal = principal;
		this.rateOfInterest = rateOfInterest;
		this.termsInYears = termsInYears;
		this.simpleInterest = simpleInterest;
	}

	public double getPrincipal() {
		return principal;
	}

	public void setPrincipal(double principal) {
		this.principal = principal;
	}

	public double getRateOfInterest() {
		return rateOfInterest;
	}

	public void setRateOfInterest(double rateOfInterest) {
		this.rateOfInterest = rateOfInterest;
	}

	public double getTermsInYears() {
		return termsInYears;
	}

	public void setTermsInYears(double termsInYears) {
		this.termsInYears = termsInYears;
	}

	public double getSimpleInterest() {
		return simpleInterest;
	}

	public void setSimpleInterest(double simpleInterest) {
		this.simpleInterest = simpleInterest;
	}
	
	
}

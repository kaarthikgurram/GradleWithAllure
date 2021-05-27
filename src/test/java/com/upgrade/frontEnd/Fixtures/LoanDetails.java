package com.upgrade.frontEnd.Fixtures;

public class LoanDetails {

  public String loanAmount;
  public String monthlyPayment;
  public String term;
  public String interestRate;
  public String apr;

  public String getLoanAmount() {
    return loanAmount;
  }

  public void setLoanAmount(String loanAmount) {
    this.loanAmount = loanAmount;
  }

  public String getMonthlyPayment() {
    return monthlyPayment;
  }

  public void setMonthlyPayment(String monthlyPayment) {
    this.monthlyPayment = monthlyPayment;
  }

  public String getTerm() {
    return term;
  }

  public void setTerm(String term) {
    this.term = term;
  }

  public String getInterestRate() {
    return interestRate;
  }

  public void setInterestRate(String interestRate) {
    this.interestRate = interestRate;
  }

  public String getApr() {
    return apr;
  }

  public void setApr(String apr) {
    this.apr = apr;
  }
}

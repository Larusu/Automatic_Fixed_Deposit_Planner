package model;

import logic.TimeReference.DurationUnit;
import logic.TimeReference.Frequency;
import session.Session;

public class DepositPlan 
{
    private int userId = 0;
    private int goalId = 0;
    private double principalAmount = 0;
    private BankReference interestRate;
    private int durationValue = 0;
    private DurationUnit durationUnit;
    private Frequency compoundingFrequency;
    private String startDate = "";

    public DepositPlan(int goal_id, double principal_amount, BankReference interest_rate, int duration_value, 
                        DurationUnit duration_unit, Frequency compounding_frequency, String start_date) 
    {
        this.userId = Session.userId;
        this.goalId = goal_id;
        this.principalAmount = principal_amount;
        this.interestRate = interest_rate;
        this.durationValue = duration_value;
        this.durationUnit = duration_unit;
        this.compoundingFrequency = compounding_frequency;
        this.startDate = start_date;
    }

    public DepositPlan(double principal_amount, BankReference interest_rate, int duration_value, 
                        DurationUnit duration_unit, Frequency compounding_frequency, String start_date) 
    {
        this.userId = Session.userId;
        this.principalAmount = principal_amount;
        this.interestRate = interest_rate;
        this.durationValue = duration_value;
        this.durationUnit = duration_unit;
        this.compoundingFrequency = compounding_frequency;
        this.startDate = start_date;
    }

    public int getUserId() { return userId;}
    public int getGoalId() { return goalId;}
    public double getPrincipalAmount() { return principalAmount;}
    public double getInterestRate() { return interestRate.getRate();}
    public int getDurationValue() { return durationValue;}
    public String getDurationUnit() { return durationUnit.toString();}
    public String getCompoundingFrequency() { return compoundingFrequency.toString();}
    public String getStartDate() { return startDate;}
}

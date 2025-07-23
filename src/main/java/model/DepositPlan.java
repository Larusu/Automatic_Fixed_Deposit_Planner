package model;

import session.Session;

public class DepositPlan 
{
    private String name = "";
    private int userId = 0;
    private int goalId = 0;
    private double principalAmount = 0;
    private double interestRate;
    private int durationValue = 0;
    private String durationUnit;
    private String compoundingFrequency;
    private String startDate = "";

    public DepositPlan(String name, int goal_id, double principal_amount, double interest_rate, int duration_value, 
                        String duration_unit, String compounding_frequency, String start_date) 
    {
        this.name = name;
        this.userId = Session.userId;
        this.goalId = goal_id;
        this.principalAmount = principal_amount;
        this.interestRate = interest_rate;
        this.durationValue = duration_value;
        this.durationUnit = duration_unit;
        this.compoundingFrequency = compounding_frequency;
        this.startDate = start_date;
    }

    public DepositPlan(String name, double principal_amount, double interest_rate, int duration_value, 
                        String duration_unit, String compounding_frequency, String start_date) 
    {
        this.name = name;
        this.userId = Session.userId;
        this.principalAmount = principal_amount;
        this.interestRate = interest_rate;
        this.durationValue = duration_value;
        this.durationUnit = duration_unit;
        this.compoundingFrequency = compounding_frequency;
        this.startDate = start_date;
    }

    public String getName() { return name; }
    public int getUserId() { return userId;}
    public int getGoalId() { return goalId;}
    public double getPrincipalAmount() { return principalAmount;}
    public double getInterestRate() { return interestRate;}
    public int getDurationValue() { return durationValue;}
    public String getDurationUnit() { return durationUnit;}
    public String getCompoundingFrequency() { return compoundingFrequency;}
    public String getStartDate() { return startDate;}
}

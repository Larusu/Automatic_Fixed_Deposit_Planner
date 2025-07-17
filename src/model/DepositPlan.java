package model;

public class DepositPlan 
{
    private int userId = 0;
    private int goalId = 0;
    private double principalAmount = 0;
    private double interestRate = 0;
    private int durationValue = 0;
    private String durationUnit = "";
    private String compoundingFrequency = "";
    private String startDate = "";

    public DepositPlan(int user_id, int goal_id, double principal_amount, double interest_rate, int duration_value, String duration_unit,
                   String compounding_frequency, String start_date) 
    {
        this.userId = user_id;
        this.goalId = goal_id;
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
    public double getInterestRate() { return interestRate;}
    public int getDurationValue() { return durationValue;}
    public String getDurationUnit() { return durationUnit;}
    public String getCompoundingFrequency() { return compoundingFrequency;}
    public String getStartDate() { return startDate;}
}

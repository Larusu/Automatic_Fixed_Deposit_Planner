package model;

public class MaturityEntry{

    private int investment_id;
    private int period_number;
    private String date;
    private double interest_earned;
    private double tax_deducted;
    private double total_balance;

    public MaturityEntry(int investment_id, int period_number, String date, double interest_earned,
                double tax_deducted, double total_balance){
        this.investment_id = investment_id;
        this.period_number = period_number;
        this.date = date;
        this.interest_earned = interest_earned;
        this.tax_deducted = tax_deducted;
        this.total_balance = total_balance;
    }

    public int getInvestmentId(){ return investment_id;}
    public int getPeriodNumber(){ return period_number;}
    public String getDate(){ return date;}
    public double getInterestEarned(){ return interest_earned;}
    public double getTaxDeducted(){ return tax_deducted;}
    public double getTotalBalance(){ return total_balance;}
}
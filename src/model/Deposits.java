package model;

public class Deposits {

    private double principal;
    private double interestRate;
    private int durationValue;
    private String durationUnit;
    private String compoundingFrequency;
    private String startDate;
    private int is_tax_applied;

    Deposits(double principal, double interestRate, int durationValue, String durationUnit,
                   String compoundingFrequency, String startDate, int is_tax_applied) {
        this.principal = principal;
        this.interestRate = interestRate;
        this.durationValue = durationValue;
        this.durationUnit = durationUnit;
        this.compoundingFrequency = compoundingFrequency;
        this.startDate = startDate;
        this.is_tax_applied = is_tax_applied;
    }
    public double getPrincipal() { return principal; }
    public double getInterestRate() { return interestRate; }
    public int getDurationValue() { return durationValue; }
    public String getDurationUnit() { return durationUnit; }
    public String getCompoundingFrequency() { return compoundingFrequency; }
    public String getStartDate() { return startDate; }
    public int getIsTaxApplied() { return is_tax_applied; }
}

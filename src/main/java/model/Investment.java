package model;

public class Investment {
    
    private int depositId;
    private String maturityDate;
    private double maturityAmount;
    private double totalInterest;
    private double estimatedTax;

    public Investment(int deposit_id, String maturity_date, double maturity_amount, double total_interest, double estimated_tax){

        this.depositId = deposit_id;
        this.maturityDate = maturity_date;
        this.maturityAmount = maturity_amount;
        this.totalInterest = total_interest;
        this.estimatedTax = estimated_tax;
    }

    public int getDepositId(){ return depositId; }
    public String getMaturityDate(){ return maturityDate;}
    public double getMaturityAmount(){ return maturityAmount;}
    public double getTotalInterest(){ return totalInterest;}
    public double getEstimateTax(){ return estimatedTax;}
}

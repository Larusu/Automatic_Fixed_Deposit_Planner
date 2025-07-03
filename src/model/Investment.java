package model;

public class Investment {
    
    private int deposit_id;
    private double maturity_amount;
    private double total_interest;
    private double estimated_tax;

    Investment(int deposit_id, double maturity_amount, double total_interest, int estimated_tax){

        this.deposit_id = deposit_id;
        this.maturity_amount = maturity_amount;
        this.total_interest = total_interest;
        this.estimated_tax = estimated_tax;
    }

    public int getDepositId(){ return deposit_id; }
    public double getMaturityAmount(){ return maturity_amount;}
    public double getMTotalInterest(){ return total_interest;}
    public double getEstimateTax(){ return estimated_tax;}
}

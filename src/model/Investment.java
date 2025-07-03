package model;

public class Investment {
    
    private double deposit_id;
    private double maturity_amount;
    private int total_interest;
    private int estimated_tax;

    Investment(double deposit_id, double maturity_amount, int total_interest, int estimated_tax){
        
        this.deposit_id = deposit_id;
        this.maturity_amount = maturity_amount;
        this.total_interest = total_interest;
        this.estimated_tax = estimated_tax;
    }
}

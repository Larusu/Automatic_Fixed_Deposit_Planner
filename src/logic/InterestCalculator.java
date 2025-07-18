package logic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import logic.TimeReference.Frequency;

public class InterestCalculator{

    // Reference :
    // "https://www.manilatimes.net/2025/07/10/business/top-business/cmepa-amendments-affecting-debt-markets/2146429"
    // "https://www.philstar.com/business/2025/07/14/2457715/banks-slap-uniform-20-tax-interest-income"
    private final double taxRate = 20; // 20% final withholding tax on bank interest

    public double maturityAmount(int principal, double rate, Frequency duration, double time)
    {
        int freq = duration.getFrequency();            
        if(freq == 0) return 0;                        

        double r = rate / 100.0;                       // Convert annual interest rate from % to decimal (e.g., 5% becomes 0.05)
        double base = 1 + (r / freq);                  // Calculate base of the compound formula: (1 + r/n)
        double exponent = freq * time;                 // Calculate exponent of the formula: (nt)

        double compounded = Math.pow(base, exponent);  // Raise base to exponent: (1 + r/n)^(nt)
        double totalAmount = principal * compounded;   // Multiply by principal: P * (1 + r/n)^(nt)  

        return BigDecimal.valueOf(totalAmount).setScale(2, RoundingMode.HALF_UP).doubleValue(); 
    }

    public double maturityAmountWithTax(int principal, double rate, Frequency duration, double time)
    {
        int freq = duration.getFrequency();
        if(freq == 0) return 0;

        double grossMaturity = maturityAmount(principal, rate, duration, time); // Get gross maturity 
        double interest = grossMaturity - principal;         // Calculate earned interest: Gross - Principal
        double tax = interest * (taxRate / 100.0);           // Compute tax based on interest earned
        double totalAmount = grossMaturity - tax;            // Final amount after deducting tax
        
        return BigDecimal.valueOf(totalAmount).setScale(2, RoundingMode.HALF_UP).doubleValue(); 
    } 

    // Calculates the total tax paid based on the difference between gross and net maturity amounts
    public double totalTaxPaid(int principal, double rate, Frequency duration, double time)
    {
        double d = maturityAmount(principal, rate, duration, time) - maturityAmountWithTax(principal, rate, duration, time);
        return BigDecimal.valueOf(d).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    // Calculates the total interest earned before tax, based on the maturity amount minus the principal.
    public double totalInterest(int principal, double rate, Frequency duration, double time)
    {
        double i = maturityAmount(principal, rate, duration, time) - principal;
        return BigDecimal.valueOf(i).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
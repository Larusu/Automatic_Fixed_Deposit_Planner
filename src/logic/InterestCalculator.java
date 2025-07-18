package logic;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InterestCalculator{

    /**
    * For resident and non-resident aliens engaged in trade or business in the Philippines, 
    * the maximum rate on income subject to final tax (usually passive investment income) is 20%.
    * "https://taxsummaries.pwc.com/philippines/individual/taxes-on-personal-income#:~:text=For%20resident%20and%20non%2Dresident,rate%20is%20a%20flat%2025%25."
    */
    private final int taxRate = 20; 

    public enum Frequency 
    {
        ANNUALLY("Annually", 1),
        SEMIANNUALLY("Semiannually", 2),
        QUARTERLY("Quarterly", 6),
        MONTHLY("Monthly", 12),
        BIWEEKLY("Biweekly", 26),
        WEEKLY("Weekly", 52),
        DAILY("Daily", 365);

        private final String label;
        private final int frequency;

        Frequency(String label, int frequency) 
        { 
            this.label = label; 
            this.frequency = frequency;
        }

        public int getFrequency() { return frequency; }

         // Finds the matching enum from a string input (case-insensitive)
        public static Frequency find(String value)
        {
            try { return Frequency.valueOf(value.toUpperCase()); } 
            catch (IllegalArgumentException e) { return null; }
        }

        @Override
        public String toString() { return label; }
    }

    public enum DurationUnit
    {
        MONTHS("Months", 12),
        YEARS("Years", 1);

        private final String label;
        private final int divisor;

        DurationUnit(String label, int divisor) 
        { 
            this.label = label; 
            this.divisor = divisor; 
        }

         // Converts a duration value (e.g., 6 months) to years
        public double toYears(int value)
        {
            double getYear = (double)value;
            if(this == MONTHS){ getYear /= (double) divisor; } // If unit is in months, Divide by 12 to convert to years
            return BigDecimal.valueOf(getYear).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }

        // Finds matching enum from a string input (case-insensitive)
        public static DurationUnit find(String value) 
        {
            try { return DurationUnit.valueOf(value.toUpperCase()); } 
            catch (IllegalArgumentException e) { return null; }
        }
        
        @Override
        public String toString() { return label; }
    }


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
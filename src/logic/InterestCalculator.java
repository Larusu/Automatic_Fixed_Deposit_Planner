package logic;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InterestCalculator{

    // For resident and non-resident aliens engaged in trade or business in the Philippines, 
    // the maximum rate on income subject to final tax (usually passive investment income) is 20%.
    // "https://taxsummaries.pwc.com/philippines/individual/taxes-on-personal-income#:~:text=For%20resident%20and%20non%2Dresident,rate%20is%20a%20flat%2025%25."
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

        public double toYears(int value)
        {
            double getYear = (double)value;
            if(this == MONTHS){ getYear /= (double) divisor; }
            return BigDecimal.valueOf(getYear).setScale(2, RoundingMode.HALF_UP).doubleValue();
        }

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
        
        // P * (1 + r/n)^(nt)
        double r = rate / 100;          // rate% = ra.te
        double base = 1 + (r / freq);   // 1 + r / n
        double exponent = freq * time;     // ^(nt)

        double compounded = Math.pow(base, exponent); // (1 + r /n)^(nt)
        double totalAmount = principal * compounded;    // principal * result
        
        // round to 2 decimal places
        return BigDecimal.valueOf(totalAmount).setScale(2, RoundingMode.HALF_UP).doubleValue(); 
    }

    public double maturityAmountWithTax(int principal, double rate, Frequency duration, double time)
    {
        int freq = duration.getFrequency();
        if(freq == 0) return 0;

        // P *[1 + (r * (1 - taxrate)/n)]^(nt)
        double grossMaturity = maturityAmount(principal, rate, duration, time);    // P * (1 + r/n)^(nt)
        double interest = grossMaturity - principal;      // interest = [P * (1 + r/n)^(nt)] - P
        double tax = interest * (taxRate / 100.0);          // tax = i * (tax / 100)
        double totalAmount = grossMaturity - tax;    // p + result
        
        // round to 2 decimal places
        return BigDecimal.valueOf(totalAmount).setScale(2, RoundingMode.HALF_UP).doubleValue(); 
    } 

    public double totalTaxPaid(int principal, double rate, Frequency duration, double time)
    {
        double d = maturityAmount(principal, rate, duration, time) - maturityAmountWithTax(principal, rate, duration, time);

        return BigDecimal.valueOf(d).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public double totalInterest(int principal, double rate, Frequency duration, double time)
    {
        double i = maturityAmount(principal, rate, duration, time) - principal;

        return BigDecimal.valueOf(i).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
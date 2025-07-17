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
        
        @Override
        public String toString() { return label; }
    }

    public double compoundInterest(int principal, double rate, Frequency duration, double time)
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

    public double compoundInterestWithTax(int principal, double rate, Frequency duration, double time)
    {
        int freq = duration.getFrequency();
        if(freq == 0) return 0;

        // P *[1 + (r * (1 - taxrate)/n)]^(nt)
        double tax = calculatedTax(rate);    // r * (1 - taxrate) 
        double base = 1 + (tax / freq);      // 1 + [r * (1 - taxrate)/ n)]
        double exponent = freq * time;          // ^(nt)

        double compounded = Math.pow(base, exponent); // 1 + (r * t / n) ^ (nt)
        double totalAmount = principal * compounded;    // p + result
        
        // round to 2 decimal places
        return BigDecimal.valueOf(totalAmount).setScale(2, RoundingMode.HALF_UP).doubleValue(); 
    } 

    public double totalTaxPaid(int principal, double rate, Frequency duration, double time)
    {
        double d = compoundInterest(principal, rate, duration, time) - compoundInterestWithTax(principal, rate, duration, time);

        return BigDecimal.valueOf(d).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    private double calculatedTax(double rate)
    { 
        BigDecimal t = BigDecimal.valueOf(taxRate).divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP);
        BigDecimal r = BigDecimal.valueOf(rate).divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP);
        BigDecimal tax = r.multiply(BigDecimal.ONE.subtract(t)); // r * (1 - taxrate)

        return tax.doubleValue(); 
    }
}
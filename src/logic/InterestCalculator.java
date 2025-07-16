package logic;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class InterestCalculator{

    // For resident and non-resident aliens engaged in trade or business in the Philippines, 
    // the maximum rate on income subject to final tax (usually passive investment income) is 20%.
    // "https://taxsummaries.pwc.com/philippines/individual/taxes-on-personal-income#:~:text=For%20resident%20and%20non%2Dresident,rate%20is%20a%20flat%2025%25."
    private final int taxRate = 20; 

    public static void main(String[] args) {

        InterestCalculator calc = new InterestCalculator();
        int principal = 1000;
        double rate = 1;
        int time = 5;
        String duration = "monthly";
        System.out.println("Principal: " + principal);
        System.out.println("Rate: " + rate + "%");
        System.out.println("Time: " + time + " years");
        System.out.println("Duration: " + duration);
        System.out.println("Tax: " + calc.taxRate + "%");
        System.out.println("Total Interest paid: " + calc.totalTaxPaid(principal, rate, duration, time));
        System.out.println("Maturity With Tax: " + calc.compoundInterestWithTax(principal, rate, duration, time));
        System.out.println("Maturity: " + calc.compoundInterest(principal, rate, duration, time));
    }

    public double compoundInterest(int principal, double rate, String duration, int time)
    {
        int freq = strFrequency(duration);
        if(freq == 0) return 0;
        
        // P * (1 + r/n)^(nt)
        double r = rate / 100;          // rate% = ra.te
        double base = 1 + (r / freq);   // 1 + r / n
        int exponent = freq * time;     // ^(nt)

        double result = Math.pow(base, exponent); // (1 + r /n)^(nt)
        double calculate = principal * result;    // principal * result

        BigDecimal c = BigDecimal.valueOf(calculate);
        
        return c.setScale(2, RoundingMode.HALF_UP).doubleValue(); // get 2 decimal places that is rounded
    }

    public double compoundInterestWithTax(int principal, double rate, String duration, int time)
    {
        int freq = strFrequency(duration);
        if(freq == 0) return 0;

        // P *[1 + (r * (1 - taxrate)/n)]^(nt)
        double tax = calculatedTax(rate);    // r * (1 - taxrate) 
        double base = 1 + (tax / freq);      // 1 + [r * (1 - taxrate)/ n)]
        int exponent = freq * time;          // ^(nt)

        double result = Math.pow(base, exponent); // 1 + (r * t / n) ^ (nt)
        double calculate = principal * result;    // p + result

        BigDecimal c = BigDecimal.valueOf(calculate);
        
        return c.setScale(2, RoundingMode.HALF_UP).doubleValue(); // get 2 decimal places that is rounded
    } 

    public double totalTaxPaid(int principal, double rate, String duration, int time)
    {
        double d = compoundInterest(principal, rate, duration, time) - compoundInterestWithTax(principal, rate, duration, time);

        BigDecimal taxPaid = BigDecimal.valueOf(d);

        return taxPaid.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    private int strFrequency(String frequency)
    {
        switch (frequency.toLowerCase()) 
        {
            case "annually": return 1;
            case "semiannually": return 2;
            case "quarterly": return 4;
            case "monthly": return 12;
            case "biweekly": return 26;
            case "weekly": return 52;
            case "daily": return 365;
            default: return 0;
        }
    }

    private double calculatedTax(double rate)
    { 
        BigDecimal t = BigDecimal.valueOf(taxRate).divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP);
        BigDecimal r = BigDecimal.valueOf(rate).divide(BigDecimal.valueOf(100), 10, RoundingMode.HALF_UP);
        BigDecimal tax = r.multiply(BigDecimal.ONE.subtract(t)); // r * (1 - taxrate)

        return tax.doubleValue(); 
    }
}
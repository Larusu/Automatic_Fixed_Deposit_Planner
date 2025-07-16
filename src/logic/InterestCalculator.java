package logic;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class InterestCalculator{

    private static int strFrequency(String frequency){

        switch (frequency.toLowerCase()) {
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
    public static double compoundInterest(String duration, int principal, double rate, int time){

        int freq = strFrequency(duration);
        if(freq == 0) return 0;

        // P(1 + r/n)^(nt)
        BigDecimal n = BigDecimal.valueOf(freq);                                           // n    = amount of times the interest is compounded
        BigDecimal r = BigDecimal.valueOf(rate).divide(BigDecimal.valueOf(100));       // r    = rate / 100 
        BigDecimal base = BigDecimal.ONE.add(r.divide(n, 20, RoundingMode.HALF_UP)); // base = (1 + r/n)
        int exponent = freq * time;                                                        // ^(nt)

        BigDecimal p = BigDecimal.valueOf(principal); // p          = principal
        BigDecimal result = base.pow(exponent);       // result     = (1 + r/n)^(nt)
        BigDecimal calculated = p.multiply(result);   // calculated = p * result

        return calculated.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
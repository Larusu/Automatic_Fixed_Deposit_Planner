package logic;

public class InterestCalculator{

    InterestCalculator(String duration, int principal, double rate, int time){

        compoundInterest(duration, principal, rate, time);
    }

    private static int strFrequency(String frequency){

        frequency = frequency.toLowerCase();
        switch (frequency) {
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
    private static double compoundInterest(String duration, int principal, double rate, int time){

        int n = strFrequency(duration);
        if(n == 0) return 0;

        rate = rate / 100.0;
        double base = 1 + (rate / n);
        double exponent = n * time;

        double factor = 1.0;
        for (int i = 0; i < exponent; i++) {
            factor *= base;
        }

        double calculated = principal * factor;

        return Math.round(calculated * 100.0) / 100.0;
    }
}
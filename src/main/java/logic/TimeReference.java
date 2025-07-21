package logic;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TimeReference 
{
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
}

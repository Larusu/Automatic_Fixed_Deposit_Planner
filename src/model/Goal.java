package model;

public class Goal{

   private String name;
   private int timeframeValue;
   private String timeframeUnit;
   private double price;

    public Goal(String name, int timeframe_value, String timeframe_unit, double price)
    {
        this.name = name;
        this.timeframeValue = timeframe_value;
        this.timeframeUnit = timeframe_unit;
        this.price = price;
    }

    public String getName(){ return name;}
    public int getTimeframeValue(){ return timeframeValue;}
    public String getTimeframeUnit(){ return timeframeUnit;}
    public double getPrice(){ return price;}
}
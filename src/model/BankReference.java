package model;

public enum BankReference {
    
    // Reference : "https://pinoytechsaga.blogspot.com/2023/05/ph-digital-banks-interest-rates.html"

    MAYASAVINGS("Maya Savings", 3.5),
    CIMB("CIMB Bank PH", 3.0),
    BPI("BPI Direct BanKo", 5.0),
    RCBC("RCBC DiskarTech", 6.5),
    TONIK("Tonik", 4.5),
    NETBANK("Netbank Mobile", 4.0),
    SEABANK("SeaBank", 4.0),
    OWNBANK("OwnBank (Own It)", 3.8),
    UNO("Uno Digital Bank", 3.75),
    GOTYME("GoTyme Bank", 3.5);

    private final String label;
    private final double rate;

    BankReference(String label, double rate)
    {
        this.label = label;
        this.rate = rate;
    }

    public double getRate(){ return rate; }

    @Override
    public String toString(){ return label; }
}

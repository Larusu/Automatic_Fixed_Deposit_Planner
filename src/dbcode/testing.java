package dbcode;

import constant.AppConfig;
import logic.InterestCalculator;
import logic.InterestCalculator.DurationUnit;
import logic.InterestCalculator.Frequency;
import model.DepositPlan;
import model.User;

public class testing {
    
    public static void main(String[] args) {
        
        // User user = new User("testing", "testing@gmail.com", "12345678");
        // UserDAO users = new UserDAO();
        // users.insert(user);


        InterestCalculator calc = new InterestCalculator();
        int principal = 5000;
        double rate = 10;
        int time = 5;
        Frequency duration = Frequency.QUARTERLY;
        System.out.println("Principal: " + principal);
        System.out.println("Rate: " + rate + "%");
        System.out.println("Time: " + time + " years");
        System.out.println("Duration: " + duration);
        System.out.println("Tax: 20%\n");
        System.out.println("Total Interest: " + calc.totalInterest(principal, rate, duration, time));
        System.out.println("Tax on interest: " + calc.totalTaxPaid(principal, rate, duration, time));
        System.out.println("Maturity (before tax): " + calc.maturityAmount(principal, rate, duration, time));
        System.out.println("Maturity (after tax): " + calc.maturityAmountWithTax(principal, rate, duration, time));

        int useId = 1;

        // DatabaseInitializer.ResetDB("depositplan");
        // DepositPlan depositPlan = new DepositPlan(useId, 5000, 5, DurationUnit.YEARS, Frequency.QUARTERLY, "2025-08-10");
        // DepositPlanDAO depositDAO = new DepositPlanDAO();
        // depositDAO.insert(depositPlan);

        // DatabaseInitializer.ResetDB("investments");
        InvestmentDAO invest = new InvestmentDAO();
        invest.calculateSQL();

        DurationUnit unit = DurationUnit.find("Months");
        System.out.println(unit);
    }
}

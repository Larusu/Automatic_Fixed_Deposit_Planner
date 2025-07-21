package dbcode;

import java.time.Duration;
import java.util.Scanner;

import logic.InterestCalculator;
import logic.TimeReference.DurationUnit;
import logic.TimeReference.Frequency;
import model.BankReference;
import model.DepositPlan;
// import model.Investment;
import model.User;
import session.Session;

public class testing {
    
    public static void main(String[] args) {

        DatabaseInitializer.initializeDatabase();
        
        // User user = new User("testing", "testing@gmail.com", "12345678");
        // UserDAO users = new UserDAO();
        // users.insert(user);

        
        // int useId = 1;

        // DatabaseInitializer.ResetDB("depositplan");
        // DepositPlan depositPlan = new DepositPlan(useId, 5000, BankReference.BPI, 5, DurationUnit.YEARS, Frequency.QUARTERLY, "2025-08-10");
        // DepositPlanDAO depositDAO = new DepositPlanDAO();
        // depositDAO.insert(depositPlan);

        // DatabaseInitializer.ResetDB("goal"); System.out.println("reset done");
        
        // DatabaseInitializer.ResetDB("investments");
        // InvestmentDAO invest = new InvestmentDAO();
        // invest.calculateSQL();

        // DurationUnit unit = DurationUnit.find("Months");
        // System.out.println(unit);

        Scanner scan = new Scanner(System.in);
        
        int choice;
        boolean running = true;
        do
        {
            System.out.println("Where dyu wanna go bruh?");
            System.out.println("1 - Login \n2 - Register \n3 - calculate\n4 - Make a deposit\n5 - Logout");
            choice = Integer.parseInt(scan.nextLine());
            
            switch (choice)
            {
                case 1: tryLogin(scan); break;
                case 2: tryRegister(scan); break;
                case 3: testInterestCalculator(scan); break;
                case 4: testDeposit(scan); break;
                case 5: Session.logout(); running = false; break;
                default: break;
            }
        }
        while(running);
        scan.close();
    }

    static void tryRegister(Scanner scan)
    {
        System.out.println("\nCreate an Account:");
        System.out.println("Username: ");
        String username = scan.nextLine();
        System.out.println("Email: ");
        String email = scan.nextLine();
        System.out.println("Password: ");
        String password = scan.nextLine();

        User user = new User(username, email, password);
        UserDAO userDAO = new UserDAO();
        userDAO.register(user);
    }

    static void tryLogin(Scanner scan)
    {
        System.out.println("\nLogin ka na dito boi:");
        System.out.println("Email: ");
        String email = scan.nextLine();
        System.out.println("Password: ");
        String password = scan.nextLine();

        Session.login(email, password);
    }

    static void testInterestCalculator(Scanner scan)
    {
        InterestCalculator calc = new InterestCalculator();

        int principal = 5000;
        double rate = 10;
        int time = 5;
        Frequency duration = Frequency.QUARTERLY;
        System.out.println("Principal: ");
        principal = Integer.parseInt(scan.nextLine());
        System.out.println("What bank?");
        for (BankReference bank : BankReference.values()) 
        {
            System.out.println(bank + " - " + bank.getRate() + "%");
        }
        String bank = scan.nextLine();
        BankReference b = BankReference.valueOf(bank);
        rate = b.getRate();

        System.out.println("Time: ");
        time = Integer.parseInt(scan.nextLine());
        System.out.println("Duration: ");
        for(Frequency f : Frequency.values())
        {
            System.out.println("-" + f);
        }
        String dura = scan.nextLine();
        duration = Frequency.find(dura);

        System.out.println("Tax: 20%\n");
        System.out.println("Total Interest: " + calc.totalInterest(principal, rate, duration, time));
        System.out.println("Tax on interest: " + calc.totalTaxPaid(principal, rate, duration, time));
        System.out.println("Maturity (before tax): " + calc.maturityAmount(principal, rate, duration, time));
        System.out.println("Maturity (after tax): " + calc.maturityAmountWithTax(principal, rate, duration, time));
    }

    static void testDeposit(Scanner scan) {
        // 1. Principal Amount
        System.out.print("Enter principal amount: ");
        double principalAmount = Double.parseDouble(scan.nextLine().trim());

        // 2. Interest Rate (via BankReference enum)
        System.out.println("Select a bank for interest rate:");
        for (BankReference bank : BankReference.values()) {
            System.out.println("- " + bank); // uses toString()
        }
        BankReference interestRate = null;
        while (interestRate == null) {
            System.out.print("Enter bank name: ");
            String bankInput = scan.nextLine().trim();
            for (BankReference bank : BankReference.values()) {
                if (bank.toString().equalsIgnoreCase(bankInput)) {
                    interestRate = bank;
                    break;
                }
            }
            if (interestRate == null) {
                System.out.println("Invalid bank name. Try again.");
            }
        }

        // 3. Duration Value
        System.out.print("Enter duration value (e.g., 6): ");
        int durationValue = Integer.parseInt(scan.nextLine().trim());

        // 4. Duration Unit (e.g., days/months/years)
        System.out.println("Duration units:");
        for (DurationUnit unit : DurationUnit.values()) {
            System.out.println("- " + unit);
        }
        DurationUnit durationUnit = null;
        while (durationUnit == null) {
            System.out.print("Enter duration unit: ");
            String unitInput = scan.nextLine().trim();
            try {
                durationUnit = DurationUnit.valueOf(unitInput.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid duration unit. Try again.");
            }
        }

        // 5. Compounding Frequency
        System.out.println("Compounding frequencies:");
        for (Frequency freq : Frequency.values()) {
            System.out.println("- " + freq);
        }
        Frequency compoundingFrequency = null;
        while (compoundingFrequency == null) {
            System.out.print("Enter compounding frequency: ");
            String freqInput = scan.nextLine().trim();
            compoundingFrequency = Frequency.find(freqInput);
            if (compoundingFrequency == null) {
                System.out.println("Invalid frequency. Try again.");
            }
        }

        // 6. Start Date (format can be flexible or you can validate it)
        System.out.print("Enter start date (e.g., 2025-07-18): ");
        String startDate = scan.nextLine().trim();

        DepositPlan depositPlan = new DepositPlan(principalAmount, interestRate, durationValue, durationUnit, compoundingFrequency, startDate);
        DepositPlanDAO depositPlanDAO = new DepositPlanDAO();
        depositPlanDAO.insert(depositPlan);

        InvestmentDAO investmentDAO = new InvestmentDAO();
        investmentDAO.calculateSQL();
    }

}

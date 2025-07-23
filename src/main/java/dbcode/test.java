package dbcode;

import java.util.ArrayList;
import java.util.Scanner;

import logic.TimeReference.DurationUnit;
import logic.TimeReference.Frequency;
import model.BankReference;
import model.DepositPlan;
import model.Goal;
import model.User;
import session.Session;

public class test {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try{
            //Session.login("test", "test");

            
            // System.out.println("Register Email: ");
            // String email = scan.nextLine();
            // System.out.println("Register Username: ");
            // String username = scan.nextLine();
            // System.out.println("Register Password: ");
            // String password = scan.nextLine();

            // User user = new User(username, email, password);
            UserDAO userDAO = new UserDAO();
            // userDAO.register(user);

            System.out.println("login Email: ");
            String loginemail = scan.nextLine();
            System.out.println("login Password: ");
            String loginpassword = scan.nextLine();

            User user1 = new User(loginemail, loginpassword);
            userDAO.login(user1);

            System.out.println("Add Goal Name: ");
            String goalName = scan.nextLine();
            System.out.println("Add Time Frame Value: ");
            int goalTimeValue = Integer.parseInt(scan.nextLine());
            System.out.println("Add Time Frame Unit: ");
            String goalTImeUnit = scan.nextLine();
            System.out.println("Price: ");
            Double price = Double.parseDouble(scan.nextLine());

            Goal goal = new Goal(goalName, goalTimeValue, goalTImeUnit, price);
            GoalDAO goalDAO = new GoalDAO();
            goalDAO.insert(goal);

            // Plan name
            System.out.print("Enter plan name: ");
            String name = scan.nextLine();

            // Principal amount
            System.out.print("Enter principal amount: ");
            double principal = scan.nextDouble();
            scan.nextLine(); // clear newline

            // Show available banks
            System.out.println("Available Banks:");
            for (BankReference bank : BankReference.values()) {
                System.out.println("- " + bank.name() + " (" + bank + "): " + bank.getRate() + "%");
            }

            // Get BankReference
            BankReference bankRef = null;
            while (bankRef == null) {
                System.out.print("Enter bank (type the name shown above): ");
                String bankInput = scan.nextLine().trim().toUpperCase();
                try {
                    bankRef = BankReference.valueOf(bankInput);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid bank. Please try again.");
                }
            }

            // Duration value
            System.out.print("Enter duration value (e.g. 12): ");
            int durationValue = scan.nextInt();
            scan.nextLine();

            // Duration unit
            DurationUnit durationUnit = null;
            while (durationUnit == null) {
                System.out.print("Enter duration unit (DAYS, WEEKS, MONTHS, YEARS): ");
                String unitInput = scan.nextLine().trim().toUpperCase();
                try {
                    durationUnit = DurationUnit.valueOf(unitInput);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid duration unit. Please try again.");
                }
            }

            // Frequency
            Frequency frequency = null;
            while (frequency == null) {
                System.out.print("Enter compounding frequency (DAILY, WEEKLY, BIWEEKLY, MONTHLY, QUARTERLY, SEMIANNUALLY, ANNUALLY): ");
                String freqInput = scan.nextLine().trim().toUpperCase();
                try {
                    frequency = Frequency.valueOf(freqInput);
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid frequency. Please try again.");
                }
            }

            // Start date
            System.out.print("Enter start date (YYYY-MM-DD): ");
            String startDate = scan.nextLine();

            DepositPlan plan = new DepositPlan(name, principal, bankRef, durationValue, durationUnit, frequency, startDate);
            DepositPlanDAO depositPlanDAO = new DepositPlanDAO();
            depositPlanDAO.insert(plan);

            // DatabaseInitializer.ResetDB("goal");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("okay na");
        scan.close();
    }
}

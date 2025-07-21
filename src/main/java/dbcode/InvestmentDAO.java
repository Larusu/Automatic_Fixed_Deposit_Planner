package dbcode;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import logic.InterestCalculator;
import logic.TimeReference.DurationUnit;
import logic.TimeReference.Frequency;
import model.Investment;
import session.Session;

public class InvestmentDAO extends CrudDAO<Investment>{
    
    InterestCalculator calc = new InterestCalculator();

    @Override
    protected String getTableName() {
        return "investments";
    }

    @Override
    protected String getColumnName() {
        return "deposit_id, maturity_date, maturity_amount, total_interest, estimated_tax";
    }

    @Override
    protected ArrayList<Object> InsertData(Investment i) {

       ArrayList<Object> fields = new ArrayList<>();
        fields.add(i.getDepositId());
        fields.add(i.getMaturityDate());
        fields.add(i.getMaturityAmount());
        fields.add(i.getTotalInterest());
        fields.add(i.getEstimateTax());

        return fields;
    }

    public void calculateSQL()
    {
        // Declare variables for storing values that will be retrieve in databae
        int userId = Session.userId; 
        int principal = 0, durationValue = 0;
        double interest = 0;
        String durationUnit = "", frequency= "", startDateStr = "";

        if (Session.userId == -1) {
            JOptionPane.showMessageDialog(null,
            "Please log in first to continue.",
            "Authentication Required",
            JOptionPane.WARNING_MESSAGE);
            return; // or redirect to login screen
        }

        try(Connection conn = DatabaseInitializer.connect();)
        {
            String sqlGetLatestPlan = """
                SELECT id, principal_amount, interest_rate, duration_value, 
                duration_unit, compounding_frequency, start_date
                FROM deposit_plan 
                ORDER BY id DESC 
                LIMIT 1
            """;

            Statement stmt = conn.createStatement();
            ResultSet rsGetID = stmt.executeQuery(sqlGetLatestPlan);

            // Get values
            if (rsGetID.next()) 
            {
                userId = rsGetID.getInt("id");
                principal = rsGetID.getInt("principal_amount");
                interest = rsGetID.getDouble("interest_rate");
                durationValue = rsGetID.getInt("duration_value");
                durationUnit = rsGetID.getString("duration_unit");
                frequency = rsGetID.getString("compounding_frequency");
                startDateStr = rsGetID.getString("start_date");
            }

            // String -> enums
            Frequency freqEnum = Frequency.find(frequency);
            DurationUnit durationEnum = DurationUnit.find(durationUnit);
            if(freqEnum == null || durationEnum == null)
            {
                System.err.println("Invalid frequency or duration unit in database.");
                return;
            }
            double durationInYears = durationEnum.toYears(durationValue); // Convert duration value to years
            
            // Calculate maturity date
            LocalDate startDate = LocalDate.parse(startDateStr);
            LocalDate endDate = (durationEnum == DurationUnit.MONTHS) 
                                ? startDate.plusMonths(durationValue) 
                                : startDate.plusYears(durationValue);
            String maturityDate = endDate.toString();

            // For financial values
            double maturityAmount = calc.maturityAmountWithTax(principal, interest, freqEnum, durationInYears);
            double totalInterest = calc.totalTaxPaid(principal, interest, freqEnum, durationInYears);
            double taxOnInterest = calc.totalInterest(principal, interest, freqEnum, durationInYears);

            Investment investment = new Investment(userId, maturityDate, maturityAmount, totalInterest, taxOnInterest);
            this.insert(investment);
        }
        catch(SQLException e)
        {
            System.err.println("Error during calculation: " + e.getMessage());
            JOptionPane.showMessageDialog(null, 
            "We couldn't complete the calculation.\nPlease check your inputs and try again.", 
            "Calculation Error", 
            JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}

import dbcode.CreateDB;

import java.util.Properties;
import javax.swing.JFrame;
import org.jdatepicker.impl.*;

import DateFomat.DateLabelFormatter;

public class Main {
    
    public static void main(String[] args) {

        CreateDB.InitializeDatabase();
        
        JFrame frame = new JFrame("Date Picker Example");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Configure the date picker
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        frame.getContentPane().add(datePicker);
        frame.setVisible(true);
    }
}
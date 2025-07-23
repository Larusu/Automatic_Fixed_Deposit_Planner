import dbcode.DatabaseInitializer;
// import gui.LoginForm;

public class Main {
    
    public static void main(String[] args) {
        
        DatabaseInitializer.initializeDatabase();

        // java.awt.EventQueue.invokeLater(new Runnable() {
        //     public void run()
        //     {
        //         new LoginForm().setVisible(true);
        //     }
        // });
    }
}
// import java.util.Properties;
// import javax.swing.JFrame;
// import org.jdatepicker.impl.*;

// import DateFomat.DateLabelFormatter;

// // Configure the date picker
// UtilDateModel model = new UtilDateModel();
// Properties p = new Properties();
// p.put("text.today", "Today");
// p.put("text.month", "Month");
// p.put("text.year", "Year");

// JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
// JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

// frame.getContentPane().add(datePicker);
// frame.setVisible(true);
import javax.swing.SwingUtilities;

import dbcode.DatabaseInitializer;
import gui.MenuFrame;

public class Main {
    
    public static void main(String[] args) {
        
        DatabaseInitializer.initializeDatabase();
        
        SwingUtilities.invokeLater(MenuFrame::new);
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
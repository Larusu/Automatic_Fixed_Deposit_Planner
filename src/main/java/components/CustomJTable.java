package components;

import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import javax.swing.*;

public class CustomJTable extends JTable {

    public CustomJTable() {
        super(); 
        customizeAppearance();
    }

    public void customizeAppearance() {
        try {
            Font cellFont = FontLoader.loadFont("bebas_neue_regular.ttf", Font.PLAIN, 13f);
            Font headerFont = FontLoader.loadFont("bebas_neue_regular.ttf", Font.BOLD, 14f);

            System.out.println("Loaded Font (cell): " + cellFont.getFontName());
            System.out.println("Loaded Font (header): " + headerFont.getFontName());

            JTableHeader header = this.getTableHeader();
            if (header != null) {
                header.setFont(headerFont);
                header.setBackground(new Color(43, 82, 136));
                header.setForeground(Color.WHITE);
                header.setOpaque(false);
            }

            this.setRowHeight(30);
            this.setShowVerticalLines(false);
            this.setShowHorizontalLines(false);
            this.setGridColor(new Color(220, 220, 220));
            this.setForeground(new Color(60, 60, 60));
            this.setSelectionBackground(new Color(210, 228, 238));
            this.setSelectionForeground(Color.BLACK);

            this.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                               boolean hasFocus, int row, int column) {
                    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                    if (!isSelected) {
                        c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(245, 245, 245));
                    }

                    c.setFont(cellFont);

                    if (c instanceof JLabel label) {
                        label.setHorizontalAlignment(SwingConstants.CENTER);
                    }

                    return c;
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

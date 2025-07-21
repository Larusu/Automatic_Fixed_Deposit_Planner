package components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RoundedButton2 extends JButton {
    private Color backgroundColor = new Color(43, 82, 136); 
    private Color hoverColor = new Color(33, 62, 106);    
    private int cornerRadius = 50;

    public RoundedButton2(String text) {
        super(text);
        initialize();
    }

    public RoundedButton2() {
        super();
        initialize();
    }
    
    private void initialize() {
        setContentAreaFilled(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setForeground(Color.WHITE);
        setFont(new Font("Segoe UI", Font.BOLD, 14));
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Hover effect
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(backgroundColor);
            }
        });

        setBackground(backgroundColor); // Initial color
    }

    public void setCornerRadius(int radius) {
        this.cornerRadius = radius;
        repaint();
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
        setBackground(color); // for hover toggle
        repaint();
    }

    public void setHoverColor(Color color) {
        this.hoverColor = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Draw rounded background
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        // Optional: paint a rounded border
        // Graphics2D g2 = (Graphics2D) g.create();
        // g2.setColor(Color.DARK_GRAY);
        // g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, cornerRadius, cornerRadius);
        // g2.dispose();
    }
}


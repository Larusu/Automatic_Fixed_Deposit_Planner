package components;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RoundedButton3 extends JButton {
    private Color backgroundColor = new Color(43, 82, 136);
    private Color hoverColor = new Color(239, 239, 239);
    private int cornerRadius = 80;

    public RoundedButton3(String text) {
        super(text);
        initialize();
    }

    public RoundedButton3() {
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

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(hoverColor);
                setForeground(new Color(43, 82, 136));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(backgroundColor);
                setForeground(Color.WHITE);
            }
        });

        setBackground(backgroundColor); 
    }

    public void setCornerRadius(int radius) {
        this.cornerRadius = radius;
        repaint();
    }

    public void setBackgroundColor(Color color) {
        this.backgroundColor = color;
        setBackground(color); 
        repaint();
    }

    public void setHoverColor(Color color) {
        this.hoverColor = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), cornerRadius, cornerRadius);

        super.paintComponent(g2);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        float thickness = 3f;
        g2.setStroke(new BasicStroke(thickness));
        g2.setColor(new Color(43, 82, 136));

        float pad = thickness / 2f;

        g2.drawRoundRect(
            Math.round(pad),
            Math.round(pad),
            (int) (getWidth() - thickness),
            (int) (getHeight() - thickness),
            cornerRadius,
            cornerRadius
        );

        g2.dispose();
    }
}

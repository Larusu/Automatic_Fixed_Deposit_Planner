package src.gui;

import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class MenuFrame extends JFrame {

    final int maxHeight = 800;
    final int maxWidth = 500;

    public MenuFrame() {
        setTitle("Automated Fixed Deposit Planner");
        setSize(maxWidth, maxHeight);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);

        ImageIcon rawIcon = new ImageIcon("img/logo.png");
        Image scaledImage = rawIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(scaledImage);

        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBounds(centerX(300), 40, 300, 300);

        JLabel welcomeLabel = new JLabel("Start planning your fixed deposit today");
        welcomeLabel.setForeground(new Color(0x2B5288));
        welcomeLabel.setFont(new Font("Verdana", Font.BOLD, 13));
        welcomeLabel.setBounds(centerX(280), 360, 280, 20);

        RoundedButton depositPlanButton = new RoundedButton("CREATE A NEW DEPOSIT PLAN", 50);
        depositPlanButton.setBounds(centerX(280), 450, 280, 45);
        depositPlanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Button clicked!");
            }
        });

        RoundedButton viewSavedPlansButton = new RoundedButton("VIEW SAVED PLANS", 50);
        viewSavedPlansButton.setBounds(centerX(280), 530, 280, 45);
        viewSavedPlansButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Button clicked!");
            }
        });

        RoundedButton exitButton = new RoundedButton("EXIT APPLICATION", 50);
        exitButton.setBounds(centerX(280), 610, 280, 45);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Button clicked!");
            }
        });

        add(imageLabel);
        add(welcomeLabel);
        add(depositPlanButton);
        add(viewSavedPlansButton);
        add(exitButton);

        setVisible(true);
    }

    private int centerX(int componentWidth) {
        return (maxWidth - componentWidth) / 2;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MenuFrame();
            }
        });
    }
}

class RoundedButton extends JButton {
    private int radius;

    public RoundedButton(String text, int radius) {
        super(text);
        this.radius = radius;
        setOpaque(false);
        setFocusPainted(false);
        setBorderPainted(false);
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setBackground(new Color(0x2B5288));
        setFont(new Font("Arial", Font.BOLD, 13));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        super.paintComponent(g);
    }

    @Override
    public void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, radius, radius);
        g2.dispose();
    }
}

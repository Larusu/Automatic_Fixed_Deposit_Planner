package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuFrame extends JFrame {

    private static final int WIDTH = 500;
    private static final int HEIGHT = 800;

    public MenuFrame() {
        setTitle("Automated Fixed Deposit Planner");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null); 

        JPanel logoPanel = new JPanel();
        logoPanel.setLayout(new BoxLayout(logoPanel, BoxLayout.Y_AXIS));
        logoPanel.setBorder(BorderFactory.createEmptyBorder(60, 40, 40, 40));
        logoPanel.setBackground(Color.WHITE);

        JLabel logoImage = new JLabel();
        ImageIcon rawIcon = new ImageIcon("img/logo.png");
        Image scaledImage = rawIcon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        logoImage.setIcon(new ImageIcon(scaledImage));
        logoImage.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel welcomeLabel = new JLabel("Start planning your fixed deposit today");
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcomeLabel.setForeground(new Color(0x2B5288));
        welcomeLabel.setFont(new Font("Verdana", Font.BOLD, 15));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setOpaque(false); 

        Dimension buttonSize = new Dimension(280, 60);

        RoundedButton depositPlanButton = new RoundedButton("CREATE A NEW DEPOSIT PLAN", 50);
        depositPlanButton.setFont(new Font("Arial", Font.BOLD, 15));
        depositPlanButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        depositPlanButton.setPreferredSize(buttonSize);
        depositPlanButton.setMaximumSize(buttonSize);
        depositPlanButton.setMinimumSize(buttonSize);

        RoundedButton viewSavedPlansButton = new RoundedButton("VIEW SAVED PLANS", 50);
        viewSavedPlansButton.setFont(new Font("Arial", Font.BOLD, 15));
        viewSavedPlansButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        viewSavedPlansButton.setPreferredSize(buttonSize);
        viewSavedPlansButton.setMaximumSize(buttonSize);
        viewSavedPlansButton.setMinimumSize(buttonSize);

        RoundedButton exitButton = new RoundedButton("EXIT APPLICATION", 50);
        exitButton.setFont(new Font("Arial", Font.BOLD, 15));
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setPreferredSize(buttonSize);
        exitButton.setMaximumSize(buttonSize);
        exitButton.setMinimumSize(buttonSize);

        depositPlanButton.addActionListener(e -> {
            new DepositForm();
            dispose();
        });
        
        viewSavedPlansButton.addActionListener(e -> {
            //new DepositForm();
            dispose();
        });

        exitButton.addActionListener(e -> System.exit(0));

        buttonPanel.add(depositPlanButton);
        buttonPanel.add(Box.createVerticalStrut(35));
        buttonPanel.add(viewSavedPlansButton);
        buttonPanel.add(Box.createVerticalStrut(35));
        buttonPanel.add(exitButton);

        logoPanel.add(logoImage);
        logoPanel.add(Box.createVerticalStrut(50));
        logoPanel.add(welcomeLabel);
        logoPanel.add(Box.createVerticalStrut(50));
        logoPanel.add(buttonPanel); 

        add(logoPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuFrame::new);
    }
}

class RoundedButton extends JButton {
    private final int radius;
    private final Color base = new Color(0x2B5288);
    private final Color hover = Color.WHITE;
    private boolean isHovered;

    public RoundedButton(String text, int radius) {
        super(text);
        this.radius = radius;

        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setForeground(Color.WHITE);
        setBackground(base);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setMargin(new Insets(0, 0, 0, 0));

        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                isHovered = true;
                setForeground(base);
                setBackground(hover);
                repaint();
            }

            public void mouseExited(MouseEvent e) {
                isHovered = false;
                setForeground(Color.WHITE);
                setBackground(base);
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(isHovered ? hover : base);
        g2.fillRoundRect(1, 1, getWidth() - 2, getHeight() - 2, radius, radius);

        FontMetrics fm = g2.getFontMetrics(getFont());
        int x = (getWidth() - fm.stringWidth(getText())) / 2;
        int y = (getHeight() + fm.getAscent()) / 2 - 3;

        g2.setColor(getForeground());
        g2.setFont(getFont());
        g2.drawString(getText(), x, y);
        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(base);
        g2.setStroke(new BasicStroke(2f));
        g2.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, radius, radius);
        g2.dispose();
    }
}

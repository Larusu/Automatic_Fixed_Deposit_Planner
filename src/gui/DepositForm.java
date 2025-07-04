package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DepositForm extends JFrame {

    static final int WIDTH = 1000;
    static final int HEIGHT = 700;

    RoundedButton2 depositPlanButton;
    RoundedButton2 savedPlansListButton;
    RoundedButton2 exitButton;

    public DepositForm() {
        setTitle("New Deposit Plan");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        menuPanel.setBackground(new Color(0x2B5288));
        menuPanel.setPreferredSize(new Dimension(200, HEIGHT));

        JLabel logoImage = new JLabel();
        ImageIcon rawIcon = new ImageIcon("img/logowhite.png");
        Image scaledImage = rawIcon.getImage().getScaledInstance(65, 65, Image.SCALE_SMOOTH);
        logoImage.setIcon(new ImageIcon(scaledImage));
        logoImage.setAlignmentX(Component.CENTER_ALIGNMENT);

        Dimension buttonSize = new Dimension(160, 55);

        depositPlanButton = new RoundedButton2("CREATE NEW DEPOSIT PLAN", 50);
        depositPlanButton.setFont(new Font("Arial Narrow", Font.PLAIN, 10));
        depositPlanButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        depositPlanButton.setPreferredSize(buttonSize);
        depositPlanButton.setMaximumSize(buttonSize);

        savedPlansListButton = new RoundedButton2("SAVED PLANS LIST", 50);
        savedPlansListButton.setFont(new Font("Arial Narrow", Font.PLAIN, 10));
        savedPlansListButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        savedPlansListButton.setPreferredSize(buttonSize);
        savedPlansListButton.setMaximumSize(buttonSize);

        exitButton = new RoundedButton2("EXIT APPLICATION", 50);
        exitButton.setFont(new Font("Arial Narrow", Font.PLAIN, 10));
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setPreferredSize(buttonSize);
        exitButton.setMaximumSize(buttonSize);

        JPanel depositPlanPanel = new JPanel();
        depositPlanPanel.setLayout(null);
        depositPlanPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        depositPlanPanel.setBackground(Color.WHITE);
        depositPlanPanel.setPreferredSize(new Dimension(200, HEIGHT));

        JTextField createDepositPlanName = new JTextField();
        createDepositPlanName.setText("Deposit Plan 1");
        createDepositPlanName.setFont(new Font("Arial", Font.BOLD, 50));
        createDepositPlanName.setForeground(new Color(0x2B5288));
        createDepositPlanName.setBorder(null);
        createDepositPlanName.setBounds(45,35,480,65);

        RoundedButton submitButton = new RoundedButton("SUBMIT", 30);
        submitButton.setBounds(45, 300, 100, 30);

        final boolean[] cleared = {false};
        createDepositPlanName.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!cleared[0]) {
                    createDepositPlanName.setText("");
                    cleared[0] = true;
                }
            }
        });

        depositPlanButton.addActionListener(e -> {
            depositPlanButton.isSelected = true;
            depositPlanButton.setForeground(depositPlanButton.base);
            depositPlanButton.setBackground(depositPlanButton.hover);

            savedPlansListButton.deselect();
        });

        savedPlansListButton.addActionListener(e -> {
            savedPlansListButton.isSelected = true;
            savedPlansListButton.setForeground(savedPlansListButton.base);
            savedPlansListButton.setBackground(savedPlansListButton.hover);

            depositPlanButton.deselect();
        });

        exitButton.addActionListener(e -> {
            depositPlanButton.deselect();
            savedPlansListButton.deselect();
            System.exit(0);
        });

        depositPlanButton.isSelected = true;
        depositPlanButton.setForeground(depositPlanButton.base);
        depositPlanButton.setBackground(depositPlanButton.hover);

        String planName = createDepositPlanName.getText();

        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(logoImage);
        menuPanel.add(Box.createVerticalStrut(80));
        menuPanel.add(depositPlanButton);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(savedPlansListButton);
        menuPanel.add(Box.createVerticalStrut(10));
        menuPanel.add(exitButton);

        depositPlanPanel.add(createDepositPlanName);
        depositPlanPanel.add(submitButton);

        add(menuPanel, BorderLayout.WEST);
        add(depositPlanPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DepositForm::new);
    }
}

class RoundedButton2 extends JButton {
    final int radius;
    final Color base = new Color(0x2B5288); 
    final Color hover = Color.WHITE;        
    boolean isHovered = false;
    boolean isSelected = false;

    public RoundedButton2(String text, int radius) {
        super(text);
        this.radius = radius;

        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setForeground(Color.WHITE);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setMargin(new Insets(0, 0, 0, 0));
        setFont(new Font("SansSerif", Font.BOLD, 13));

        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                isHovered = true;
                if (!isSelected) {
                    setForeground(base); 
                    setBackground(hover); 
                }
                repaint();
            }

            public void mouseExited(MouseEvent e) {
                isHovered = false;
                if (!isSelected) {
                    setForeground(Color.WHITE);
                    setBackground(base);
                }
                repaint();
            }

            public void mousePressed(MouseEvent e) {
                isSelected = true;
                setForeground(base);  
                setBackground(hover); 
                repaint();
            }
        });
    }

    public void deselect() {
        isSelected = false;
        setForeground(Color.WHITE);
        setBackground(base);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color bg = (isSelected || isHovered) ? hover : base;
        g2.setColor(bg);
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

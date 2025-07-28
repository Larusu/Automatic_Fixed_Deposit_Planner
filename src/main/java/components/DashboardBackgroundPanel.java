package components;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DashboardBackgroundPanel extends JPanel {
    private Image backgroundImage;

    public DashboardBackgroundPanel() {
        backgroundImage = new ImageIcon(getClass().getResource("/images/dashboard_bg.png")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}

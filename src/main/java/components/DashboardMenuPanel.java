package components;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class DashboardMenuPanel extends JPanel {
    private Image backgroundImage;

    public DashboardMenuPanel() {
        backgroundImage = new ImageIcon(getClass().getResource("/images/dashboard_menu_bg.png")).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}

package components;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class SplashScreenBackgroundPanel extends JPanel {
    private Image backgroundImage;
    
    public SplashScreenBackgroundPanel() {
        backgroundImage = new ImageIcon(getClass().getResource("/images/splashscreen_bg.png")).getImage();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}

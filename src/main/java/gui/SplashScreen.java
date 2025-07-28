package gui;

import java.awt.Font;
import java.awt.geom.RoundRectangle2D;

public class SplashScreen extends javax.swing.JFrame {

    public SplashScreen() {
        initComponents();
        setLocationRelativeTo(null);
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 50, 50));
        
        launchingLabel.setFont(FontLoader.loadFont("shrikhand_regular.ttf", Font.BOLD, 28f));
        mottoLabel.setFont(FontLoader.loadFont("agrandir_wide.otf", Font.BOLD, 10f));
        
        new Thread(() -> {
            try {
                Thread.sleep(4000); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            java.awt.EventQueue.invokeLater(() -> {
                new LoginForm().setVisible(true); 
                this.dispose();
                
            });
        }).start();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        splashScreenBackgroundPanel1 = new components.SplashScreenBackgroundPanel();
        jLabel1 = new javax.swing.JLabel();
        launchingLabel = new javax.swing.JLabel();
        mottoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        splashScreenBackgroundPanel1.setPreferredSize(new java.awt.Dimension(350, 450));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logo_gif.gif"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setPreferredSize(new java.awt.Dimension(180, 180));

        launchingLabel.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        launchingLabel.setForeground(new java.awt.Color(255, 255, 255));
        launchingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        launchingLabel.setText("Launching...");
        launchingLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        mottoLabel.setForeground(new java.awt.Color(255, 255, 255));
        mottoLabel.setText("Turn intentions into actions");

        javax.swing.GroupLayout splashScreenBackgroundPanel1Layout = new javax.swing.GroupLayout(splashScreenBackgroundPanel1);
        splashScreenBackgroundPanel1.setLayout(splashScreenBackgroundPanel1Layout);
        splashScreenBackgroundPanel1Layout.setHorizontalGroup(
            splashScreenBackgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(splashScreenBackgroundPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(splashScreenBackgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(splashScreenBackgroundPanel1Layout.createSequentialGroup()
                        .addComponent(launchingLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(splashScreenBackgroundPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(88, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, splashScreenBackgroundPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mottoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        splashScreenBackgroundPanel1Layout.setVerticalGroup(
            splashScreenBackgroundPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(splashScreenBackgroundPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(launchingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mottoLabel)
                .addGap(66, 66, 66))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(splashScreenBackgroundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(splashScreenBackgroundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SplashScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel launchingLabel;
    private javax.swing.JLabel mottoLabel;
    private components.SplashScreenBackgroundPanel splashScreenBackgroundPanel1;
    // End of variables declaration//GEN-END:variables
}

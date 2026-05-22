import javax.swing.*;
import java.awt.*;

public class MainGame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private CookieGame game;
    
    public MainGame() {
        initUI();
    }
    
    private void initUI() {
        setTitle("🍪 COOKIEWOMAN - Cookie Decorator Game 🍪");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1300, 900);
        setLocationRelativeTo(null);
        
        // macOS optimizations
        try {
            System.setProperty("apple.awt.graphics.UseQuartz", "true");
            System.setProperty("apple.awt.textantialiasing", "true");
            System.setProperty("apple.awt.application.name", "Cookie Decorator");
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (Exception e) {}
        
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(new Color(255, 245, 235));
        
        game = new CookieGame(this, cardLayout, mainPanel);
        
        add(mainPanel);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainGame());
    }
}
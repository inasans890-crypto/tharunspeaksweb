import javax.swing.*;
import java.awt.*;

public class MainGame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private GameManager gameManager;
    
    public MainGame() {
        initUI();
    }
    
    private void initUI() {
        setTitle("🎭 Emotion Odyssey - The Story Weaver 🎭");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 750);
        setLocationRelativeTo(null);
        
        // macOS specific optimizations
        try {
            System.setProperty("apple.awt.graphics.UseQuartz", "true");
            System.setProperty("apple.awt.textantialiasing", "true");
            System.setProperty("apple.awt.application.name", "Emotion Odyssey");
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {}
        
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(new Color(15, 15, 25));
        
        gameManager = new GameManager(this, cardLayout, mainPanel);
        
        add(mainPanel);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainGame();
        });
    }
}
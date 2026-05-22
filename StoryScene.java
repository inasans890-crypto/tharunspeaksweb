import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class StoryScene extends JPanel {
    private JLabel titleLabel;
    private JTextArea storyArea;
    private JPanel buttonPanel;
    private JPanel characterPanel;
    private JLabel characterImageLabel;
    private String sceneType;
    private Image backgroundImage;
    private Timer animationTimer;
    private float alpha = 0f;
    
    public StoryScene(JFrame parent, String title, String story, String sceneType) {
        this.sceneType = sceneType;
        setLayout(new BorderLayout(20, 20));
        setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        
        // Load background with higher quality for macOS Retina displays
        backgroundImage = ImageLoader.getInstance().getImage("bg_" + sceneType);
        
        // Create animated title with macOS-friendly font
        titleLabel = new JLabel(title, SwingConstants.CENTER);
        titleLabel.setFont(new Font("SF Pro Display", Font.BOLD, 34));
        titleLabel.setForeground(createGradientColor());
        titleLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        
        // Create character panel
        characterPanel = createStyledCharacterPanel();
        
        // Create story text area with macOS-friendly settings
        storyArea = new JTextArea(story);
        storyArea.setFont(new Font("SF Mono", Font.PLAIN, 15));
        storyArea.setLineWrap(true);
        storyArea.setWrapStyleWord(true);
        storyArea.setEditable(false);
        storyArea.setOpaque(false);
        storyArea.setForeground(Color.WHITE);
        storyArea.setMargin(new Insets(20, 30, 20, 30));
        storyArea.setCaretColor(Color.WHITE);
        
        JScrollPane scrollPane = new JScrollPane(storyArea);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(255, 215, 0, 100), 2),
            BorderFactory.createEmptyBorder()
        ));
        
        // Create button panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2, 20, 15));
        buttonPanel.setOpaque(false);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        
        // Assemble the scene
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setOpaque(false);
        centerPanel.add(characterPanel, BorderLayout.NORTH);
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        
        add(titleLabel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        // Start fade-in animation
        startFadeInAnimation();
    }
    
    private void startFadeInAnimation() {
        alpha = 0f;
        animationTimer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alpha += 0.05f;
                if (alpha >= 1f) {
                    alpha = 1f;
                    animationTimer.stop();
                }
                repaint();
            }
        });
        animationTimer.start();
    }
    
    private JPanel createStyledCharacterPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10));
        
        // Character image with glow effect (using emoji for cross-platform compatibility)
        characterImageLabel = new JLabel(getCharacterIcon(), SwingConstants.CENTER);
        characterImageLabel.setFont(new Font("Apple Color Emoji", Font.PLAIN, 90));
        characterImageLabel.setForeground(getCharacterColor());
        
        // Add glow effect
        characterImageLabel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(getCharacterColor(), 2, true),
            BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        
        JLabel nameLabel = new JLabel(getCharacterName(), SwingConstants.CENTER);
        nameLabel.setFont(new Font("SF Pro Text", Font.BOLD, 18));
        nameLabel.setForeground(getCharacterColor());
        
        panel.add(characterImageLabel, BorderLayout.CENTER);
        panel.add(nameLabel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private String getCharacterIcon() {
        switch(sceneType) {
            case "forest": return "🌲🧚";
            case "anger": return "👿🔥";
            case "calm": return "😇💙";
            case "curious": return "🦉🔮";
            case "good": return "👑✨";
            case "bad": return "💀⚡";
            default: return "❓";
        }
    }
    
    private String getCharacterName() {
        switch(sceneType) {
            case "forest": return "Ancient Forest Spirit";
            case "anger": return "Fury Guardian";
            case "calm": return "Serenity Keeper";
            case "curious": return "Mystic Owl";
            case "good": return "Divine Being";
            case "bad": return "Shadow Entity";
            default: return "Mysterious Entity";
        }
    }
    
    private Color getCharacterColor() {
        switch(sceneType) {
            case "anger": return new Color(255, 100, 100);
            case "calm": return new Color(100, 200, 255);
            case "curious": return new Color(200, 100, 255);
            case "good": return new Color(100, 255, 100);
            case "bad": return new Color(255, 50, 50);
            default: return new Color(255, 215, 0);
        }
    }
    
    private Color createGradientColor() {
        switch(sceneType) {
            case "anger": return new Color(255, 150, 150);
            case "calm": return new Color(150, 200, 255);
            case "curious": return new Color(200, 150, 255);
            default: return new Color(255, 215, 0);
        }
    }
    
    public void addEmotionButton(String text, String emotionType, Runnable action) {
        JButton button = createStyledButton(text, emotionType);
        button.addActionListener(e -> {
            // Add click animation
            button.setEnabled(false);
            Timer t = new Timer(200, evt -> button.setEnabled(true));
            t.setRepeats(false);
            t.start();
            action.run();
        });
        buttonPanel.add(button);
    }
    
    private JButton createStyledButton(String text, String emotionType) {
        JButton button = new JButton(text);
        button.setFont(new Font("SF Pro Text", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        Color bgColor;
        switch(emotionType) {
            case "ANGRY":
                bgColor = new Color(220, 50, 50);
                break;
            case "CALM":
                bgColor = new Color(50, 150, 200);
                break;
            case "CURIOUS":
                bgColor = new Color(150, 50, 200);
                break;
            default:
                bgColor = new Color(100, 100, 100);
        }
        
        button.setBackground(bgColor);
        button.setOpaque(true);
        button.setBorderPainted(false);
        
        // Add hover effect
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor.darker());
                button.setFont(new Font("SF Pro Text", Font.BOLD, 16));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(bgColor);
                button.setFont(new Font("SF Pro Text", Font.BOLD, 14));
            }
        });
        
        return button;
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
            // Enable high quality rendering for Retina displays
            g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            g2d.dispose();
        }
    }
}
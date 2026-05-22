import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import java.util.List;

public class CookieGame {
    private JFrame parent;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private int score;
    private int currentCustomerIndex;
    private List<Customer> customers;
    private JLabel scoreLabel;
    private JLabel customerLabel;
    private JLabel requirementLabel;
    private JPanel gamePanel;
    private String selectedFlavor;
    private List<String> selectedDecorations;
    private int customersServed;
    
    // Cookie canvas
    private CookieCanvas cookieCanvas;
    
    // 15 Delicious Flavors
    private String[] flavors = {
        "🍦 Vanilla Dream", "🍫 Belgian Chocolate", "🌈 Rainbow Sparkle", 
        "🍪 Lotus Biscoff", "🍓 Strawberry Kiss", "🍬 Cotton Candy",
        "🍯 Honey Caramel", "🌿 Mint Magic", "🥜 Peanut Butter",
        "🎂 Birthday Cake", "☕ Coffee Crunch", "🍋 Lemon Zest",
        "🍪 Red Velvet", "🥥 Coconut Paradise", "🍎 Apple Cinnamon"
    };
    
    // 15 Decorations
    private String[] decorations = {
        "⭐ Sprinkles", "🌸 Flower", "❤️ Heart", "🦄 Unicorn Dust",
        "✨ Glitter", "🍫 Chocolate Chips", "🥥 Coconut Flakes",
        "🌈 Rainbow Drops", "🎈 Candy Balls", "🍬 Gummy Bears",
        "🍪 Cookie Crumbles", "🍦 Icing Swirl", "🎀 Ribbon Bow",
        "🌟 Star Burst", "🐻 Teddy Bear"
    };
    
    public CookieGame(JFrame parent, CardLayout cardLayout, JPanel mainPanel) {
        this.parent = parent;
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.score = 0;
        this.customersServed = 0;
        this.selectedDecorations = new ArrayList<>();
        
        createCustomers();
        showStartScreen();
    }
    
    private void createCustomers() {
        customers = new55 ArrayList<>();
        
        customers.add(new Customer("👧 Mrudula", "LOVES Vanilla with sprinkles and hearts!", 
            "🍦 Vanilla Dream", Arrays.asList("⭐ Sprinkles", "❤️ Heart"), 55));
            
        customers.add(new Customer("👩 Amulya", "Chocolate with chocolate chips and crumbles!", 
            "🍫 Belgian Chocolate", Arrays.asList("🍫 Chocolate Chips", "🍪 Cookie Crumbles"), 65));
            
        customers.add(new Customer("👧 Harshitha", "Rainbow sparkle with rainbow drops and unicorn dust!", 
            "🌈 Rainbow Sparkle", Arrays.asList("🌈 Rainbow Drops", "🦄 Unicorn Dust"), 85));
            
        customers.add(new Customer("👩 Vaishnavi", "Lotus Biscoff with ribbon bow - fancy!", 
            "🍪 Lotus Biscoff", Arrays.asList("🎀 Ribbon Bow", "⭐ Sprinkles"), 70));
            
        customers.add(new Customer("👧 Asritha", "Strawberry with hearts and glitter!", 
            "🍓 Strawberry Kiss", Arrays.asList("❤️ Heart", "✨ Glitter"), 60));
            
        customers.add(new Customer("👩 Srisha", "Cotton candy with EVERYTHING colorful!", 
            "🍬 Cotton Candy", Arrays.asList("🌈 Rainbow Drops", "🎈 Candy Balls", "⭐ Sprinkles"), 80));
            
        customers.add(new Customer("👧 Sumedha", "Honey caramel with teddy bears!", 
            "🍯 Honey Caramel", Arrays.asList("🐻 Teddy Bear", "🍬 Gummy Bears"), 75));
            
        customers.add(new Customer("👩 Hasini", "Mint magic with star burst!", 
            "🌿 Mint Magic", Arrays.asList("🌟 Star Burst", "⭐ Sprinkles"), 65));
            
        customers.add(new Customer("👧 Hamsika", "CHOCOLATE biscuit with chocolate chips!", 
            "🍫 Belgian Chocolate", Arrays.asList("🍫 Chocolate Chips", "🍪 Cookie Crumbles"), 90));
            
        customers.add(new Customer("👩 Hasitha", "Peanut butter with coconut flakes!", 
            "🥜 Peanut Butter", Arrays.asList("🥥 Coconut Flakes", "🍪 Cookie Crumbles"), 70));
            
        customers.add(new Customer("👧 Sahasra", "Birthday cake with sprinkles and ribbon!", 
            "🎂 Birthday Cake", Arrays.asList("⭐ Sprinkles", "🎀 Ribbon Bow"), 85));
            
        customers.add(new Customer("👩 Tejasri", "Red velvet with hearts - elegant!", 
            "🍪 Red Velvet", Arrays.asList("❤️ Heart", "✨ Glitter"), 75));
            
        customers.add(new Customer("🧒 Rohan", "Coffee crunch with everything chocolate!", 
            "☕ Coffee Crunch", Arrays.asList("🍫 Chocolate Chips", "🍪 Cookie Crumbles"), 80));
            
        customers.add(new Customer("🧒 Ramu", "Lemon zest with sprinkles - simple!", 
            "🍋 Lemon Zest", Arrays.asList("⭐ Sprinkles"), 50));
            
        customers.add(new Customer("🧒 Santhosh", "Coconut paradise with coconut flakes!", 
            "🥥 Coconut Paradise", Arrays.asList("🥥 Coconut Flakes", "⭐ Sprinkles"), 60));
            
        customers.add(new Customer("🧒 Samuel", "Apple cinnamon with star burst!", 
            "🍎 Apple Cinnamon", Arrays.asList("🌟 Star Burst", "❤️ Heart"), 65));
            
        customers.add(new Customer("👧 Sanjivani", "Rainbow sparkle with unicorn dust!", 
            "🌈 Rainbow Sparkle", Arrays.asList("🦄 Unicorn Dust", "✨ Glitter", "🌈 Rainbow Drops"), 95));
            
        customers.add(new Customer("🧒 Daniel", "Belgian chocolate with gummy bears!", 
            "🍫 Belgian Chocolate", Arrays.asList("🍬 Gummy Bears", "🍫 Chocolate Chips"), 70));
            
        customers.add(new Customer("👧 Deepthi", "Vanilla with flower decorations!", 
            "🍦 Vanilla Dream", Arrays.asList("🌸 Flower", "⭐ Sprinkles"), 60));
            
        customers.add(new Customer("👩 Brahmani", "Red velvet with ribbon bow!", 
            "🍪 Red Velvet", Arrays.asList("🎀 Ribbon Bow", "❤️ Heart"), 80));
            
        customers.add(new Customer("👧 Gayatri", "Lotus Biscoff with cookie crumbles!", 
            "🍪 Lotus Biscoff", Arrays.asList("🍪 Cookie Crumbles", "⭐ Sprinkles"), 75));
            
        customers.add(new Customer("👩 Ruthika", "Rainbow sparkle with unicorn dust and glitter!", 
            "🌈 Rainbow Sparkle", Arrays.asList("🦄 Unicorn Dust", "✨ Glitter", "🌈 Rainbow Drops"), 100));
    }
    
    private void showStartScreen() {
        JPanel startPanel = createStyledPanel();
        startPanel.setLayout(new BorderLayout(30, 30));
        
        JLabel titleLabel = new JLabel("🍪 COOKIEWOMAN'S COOKIE BAKERY 🍪", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 44));
        titleLabel.setForeground(new Color(139, 69, 19));
        
        JLabel subtitleLabel = new JLabel("Decorate Cookies & Make Customers Happy!", SwingConstants.CENTER);
        subtitleLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        subtitleLabel.setForeground(new Color(160, 82, 45));
        
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setOpaque(false);
        titlePanel.add(titleLabel, BorderLayout.CENTER);
        titlePanel.add(subtitleLabel, BorderLayout.SOUTH);
        
        JLabel cookiewomanLabel = new JLabel("👩‍🍳🍪✨", SwingConstants.CENTER);
        cookiewomanLabel.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 180));
        
        JTextArea speechBubble = new JTextArea(
            "🌸 Welcome to my bakery! 🌸\n\n" +
            "I'm COOKIEWOMAN!\n" +
            "Let's make DELICIOUS cookies together!\n\n" +
            "✨ Pick a FLAVOR - the cookie changes color!\n" +
            "🎨 Add DECORATIONS - they appear ON the cookie!\n" +
            "⭐ Serve to customers for HIGH SCORES!\n\n" +
            "Ready to bake? 🍪"
        );
        speechBubble.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
        speechBubble.setEditable(false);
        speechBubble.setOpaque(true);
        speechBubble.setBackground(new Color(255, 250, 240));
        speechBubble.setForeground(new Color(139, 69, 19));
        speechBubble.setBorder(BorderFactory.createLineBorder(new Color(139, 69, 19), 2, true));
        
        JPanel characterPanel = new JPanel(new GridLayout(1, 2, 30, 0));
        characterPanel.setOpaque(false);
        characterPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        characterPanel.add(cookiewomanLabel);
        characterPanel.add(speechBubble);
        
        JButton startButton = createBigButton("🍪 START BAKING! 🍪", new Color(139, 69, 19));
        startButton.addActionListener(e -> startGame());
        
        JButton exitButton = createBigButton("🚪 EXIT 🚪", new Color(100, 100, 100));
        exitButton.addActionListener(e -> System.exit(0));
        
        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 20, 15));
        buttonPanel.setOpaque(false);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 200, 50, 200));
        buttonPanel.add(startButton);
        buttonPanel.add(exitButton);
        
        startPanel.add(titlePanel, BorderLayout.NORTH);
        startPanel.add(characterPanel, BorderLayout.CENTER);
        startPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        mainPanel.add(startPanel, "start");
        cardLayout.show(mainPanel, "start");
    }
    
    private void startGame() {
        score = 0;
        customersServed = 0;
        currentCustomerIndex = 0;
        selectedFlavor = null;
        selectedDecorations.clear();
        createGameUI();
        showCurrentCustomer();
    }
    
    private void createGameUI() {
        gamePanel = createStyledPanel();
        gamePanel.setLayout(new BorderLayout(15, 15));
        
        // TOP PANEL
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setOpaque(false);
        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        scoreLabel = new JLabel("🍪 SCORE: " + score + " 🍪", SwingConstants.LEFT);
        scoreLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
        scoreLabel.setForeground(new Color(139, 69, 19));
        
        JLabel titleTop = new JLabel("👩‍🍳 COOKIEWOMAN'S KITCHEN 👩‍🍳", SwingConstants.CENTER);
        titleTop.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        titleTop.setForeground(new Color(160, 82, 45));
        
        JLabel cookiewomanIcon = new JLabel("🍪", SwingConstants.RIGHT);
        cookiewomanIcon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 40));
        
        topPanel.add(scoreLabel, BorderLayout.WEST);
        topPanel.add(titleTop, BorderLayout.CENTER);
        topPanel.add(cookiewomanIcon, BorderLayout.EAST);
        
        // CUSTOMER PANEL
        JPanel customerPanel = new JPanel(new GridLayout(2, 1, 10, 5));
        customerPanel.setOpaque(false);
        customerPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(139, 69, 19), 3),
            BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));
        
        customerLabel = new JLabel("", SwingConstants.CENTER);
        customerLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        customerLabel.setForeground(new Color(139, 69, 19));
        
        requirementLabel = new JLabel("", SwingConstants.CENTER);
        requirementLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
        requirementLabel.setForeground(new Color(100, 100, 100));
        
        customerPanel.add(customerLabel);
        customerPanel.add(requirementLabel);
        
        // COOKIE CANVAS - Draws the actual cookie!
        cookieCanvas = new CookieCanvas();
        cookieCanvas.setPreferredSize(new Dimension(400, 400));
        cookieCanvas.setBackground(new Color(255, 248, 225));
        cookieCanvas.setBorder(BorderFactory.createLineBorder(new Color(139, 69, 19), 3, true));
        
        JPanel cookiePanel = new JPanel(new GridBagLayout());
        cookiePanel.setOpaque(false);
        cookiePanel.add(cookieCanvas);
        
        // ACTION BUTTONS
        JPanel actionPanel = new JPanel(new GridLayout(1, 3, 20, 10));
        actionPanel.setOpaque(false);
        actionPanel.setBorder(BorderFactory.createEmptyBorder(20, 80, 20, 80));
        
        JButton resetBtn = createBigButton("🔄 RESET COOKIE", new Color(255, 140, 0));
        resetBtn.addActionListener(e -> {
            selectedFlavor = null;
            selectedDecorations.clear();
            cookieCanvas.setFlavor(null);
            cookieCanvas.setDecorations(selectedDecorations);
            cookieCanvas.repaint();
            showMessage("Cookie reset! Start fresh! 🍪", "Reset");
        });
        
        JButton serveBtn = createBigButton("🍽️ SERVE TO CUSTOMER! 🍽️", new Color(50, 200, 100));
        serveBtn.addActionListener(e -> serveCookie());
        
        JButton nextBtn = createBigButton("⏩ SKIP CUSTOMER ⏩", new Color(100, 100, 200));
        nextBtn.addActionListener(e -> skipCustomer());
        
        actionPanel.add(resetBtn);
        actionPanel.add(serveBtn);
        actionPanel.add(nextBtn);
        
        // FLAVOR PANEL
        JPanel flavorPanel = new JPanel();
        flavorPanel.setLayout(new GridLayout(3, 5, 10, 10));
        flavorPanel.setOpaque(false);
        
        for (String flavor : flavors) {
            JButton flavorBtn = createFlavorButton(flavor);
            flavorBtn.addActionListener(e -> {
                selectedFlavor = flavor;
                cookieCanvas.setFlavor(flavor);
                cookieCanvas.repaint();
                showMessage("🍪 You chose " + flavor + " flavor! 🍪\nThe cookie changed color!\nNow add some decorations!", "Flavor Selected");
            });
            flavorPanel.add(flavorBtn);
        }
        
        JScrollPane flavorScrollPane = new JScrollPane(flavorPanel);
        flavorScrollPane.setOpaque(false);
        flavorScrollPane.getViewport().setOpaque(false);
        flavorScrollPane.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(139, 69, 19), 2),
            "🍦 CHOOSE YOUR FLAVOR 🍦 (Cookie changes color!)",
            TitledBorder.CENTER,
            TitledBorder.TOP,
            new Font("Comic Sans MS", Font.BOLD, 14),
            new Color(139, 69, 19)
        ));
        flavorScrollPane.setPreferredSize(new Dimension(1100, 130));
        
        // DECORATION PANEL
        JPanel decorationPanel = new JPanel();
        decorationPanel.setLayout(new GridLayout(3, 5, 10, 10));
        decorationPanel.setOpaque(false);
        
        for (String decoration : decorations) {
            JButton decoBtn = createDecorationButton(decoration);
            decoBtn.addActionListener(e -> {
                if (!selectedDecorations.contains(decoration)) {
                    selectedDecorations.add(decoration);
                    cookieCanvas.setDecorations(selectedDecorations);
                    cookieCanvas.repaint();
                    showMessage("✨ Added " + decoration + "! ✨\nSee it appear on the cookie!\nTotal: " + selectedDecorations.size() + " decorations", "Decoration Added");
                } else {
                    showMessage("You already added " + decoration + "!\nTry something different!", "Already Added");
                }
            });
            decorationPanel.add(decoBtn);
        }
        
        JScrollPane decorationScrollPane = new JScrollPane(decorationPanel);
        decorationScrollPane.setOpaque(false);
        decorationScrollPane.getViewport().setOpaque(false);
        decorationScrollPane.setBorder(BorderFactory.createTitledBorder(
            BorderFactory.createLineBorder(new Color(139, 69, 19), 2),
            "✨ ADD DECORATIONS ✨ (They appear ON the cookie!)",
            TitledBorder.CENTER,
            TitledBorder.TOP,
            new Font("Comic Sans MS", Font.BOLD, 14),
            new Color(139, 69, 19)
        ));
        decorationScrollPane.setPreferredSize(new Dimension(1100, 130));
        
        // Bottom Panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.Y_AXIS));
        bottomPanel.setOpaque(false);
        bottomPanel.add(flavorScrollPane);
        bottomPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        bottomPanel.add(decorationScrollPane);
        
        // Main Center Panel
        JPanel centerPanel = new JPanel(new BorderLayout(15, 15));
        centerPanel.setOpaque(false);
        centerPanel.add(customerPanel, BorderLayout.NORTH);
        centerPanel.add(cookiePanel, BorderLayout.CENTER);
        centerPanel.add(actionPanel, BorderLayout.SOUTH);
        
        gamePanel.add(topPanel, BorderLayout.NORTH);
        gamePanel.add(centerPanel, BorderLayout.CENTER);
        gamePanel.add(bottomPanel, BorderLayout.SOUTH);
        
        mainPanel.add(gamePanel, "game");
        cardLayout.show(mainPanel, "game");
    }
    
    private void showCurrentCustomer() {
        if (currentCustomerIndex < customers.size()) {
            Customer c = customers.get(currentCustomerIndex);
            customerLabel.setText("👤 " + c.name + " 👤");
            String requirement = c.requirement;
            if (requirement.length() > 50) {
                requirement = requirement.substring(0, 47) + "...";
            }
            requirementLabel.setText("📋 " + requirement);
        }
    }
    
    private void serveCookie() {
        if (selectedFlavor == null) {
            showMessage("⚠️ You forgot to choose a flavor! ⚠️\n\nPick a flavor from the FLAVOR section below!\nThe cookie will CHANGE COLOR!", "Missing Flavor");
            return;
        }
        
        Customer current = customers.get(currentCustomerIndex);
        int earnedPoints = current.evaluateCookie(selectedFlavor, selectedDecorations);
        
        if (earnedPoints > 0) {
            score += earnedPoints;
            customersServed++;
            scoreLabel.setText("🍪 SCORE: " + score + " 🍪");
            
            String feedback;
            String emoji;
            if (earnedPoints >= 90) {
                feedback = "PERFECT! You're a Cookie Master!";
                emoji = "🌟🎉🍪";
            } else if (earnedPoints >= 70) {
                feedback = "Great job! Customer is very happy!";
                emoji = "😊👍✨";
            } else if (earnedPoints >= 50) {
                feedback = "Good try! Almost perfect!";
                emoji = "👍😊";
            } else {
                feedback = "Customer is okay... Try matching their request better!";
                emoji = "😐";
            }
            
            showMessage("🎉 +" + earnedPoints + " points! 🎉\n\n" + emoji + "\n" + feedback, "🍪 Cookie Served! 🍪");
            
            currentCustomerIndex++;
            selectedFlavor = null;
            selectedDecorations.clear();
            cookieCanvas.setFlavor(null);
            cookieCanvas.setDecorations(selectedDecorations);
            cookieCanvas.repaint();
            
            if (currentCustomerIndex >= customers.size()) {
                gameComplete();
            } else {
                showCurrentCustomer();
                showMessage("✨ Next customer is here!\n\n👤 " + customers.get(currentCustomerIndex).name + "\n📋 " + customers.get(currentCustomerIndex).requirement + "\n\nLet's bake them a special cookie!\n💡 Pick the RIGHT flavor and decorations!", "👤 New Customer 👤");
            }
        } else {
            showMessage("😢 Customer didn't like your cookie...\n\n💡 TIP: Read their request carefully!\n💡 They wanted: " + current.desiredFlavor + "\n💡 With decorations: " + String.join(", ", current.desiredDecorations) + "\n\nWatch the cookie change color when you pick flavor!\nTry again!", "😭 Not Happy 😭");
        }
    }
    
    private void skipCustomer() {
        currentCustomerIndex++;
        selectedFlavor = null;
        selectedDecorations.clear();
        cookieCanvas.setFlavor(null);
        cookieCanvas.setDecorations(selectedDecorations);
        cookieCanvas.repaint();
        
        if (currentCustomerIndex >= customers.size()) {
            gameComplete();
        } else {
            showCurrentCustomer();
            showMessage("Customer skipped! Next please! 🏃‍♀️\n\n👤 Next: " + customers.get(currentCustomerIndex).name, "⏩ Skipped ⏩");
        }
    }
    
    private void gameComplete() {
        String rating;
        String crown;
        if (score >= 800) {
            rating = "LEGENDARY BAKER!";
            crown = "👑🌟👑";
        } else if (score >= 600) {
            rating = "MASTER CHEF!";
            crown = "🏆🍪🏆";
        } else if (score >= 400) {
            rating = "GREAT BAKER!";
            crown = "⭐🍪⭐";
        } else {
            rating = "GOOD JOB!";
            crown = "😊🍪😊";
        }
        
        String message = String.format(
            "🎉 GAME COMPLETE! 🎉\n\n" +
            "%s\n\n" +
            "🍪 Final Score: %d\n" +
            "👥 Customers Served: %d/22\n\n" +
            "🏆 Rating: %s\n\n" +
            "💡 TIP: For maximum points:\n" +
            "   • Pick the RIGHT flavor (cookie changes color!)\n" +
            "   • Add the decorations they want (they appear on cookie!)\n\n" +
            "Want to bake more cookies? 🍪",
            crown, score, customersServed, rating
        );
        
        int option = JOptionPane.showConfirmDialog(parent, message, "🎉 Game Complete! 🎉", 
            JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        
        if (option == JOptionPane.YES_OPTION) {
            startGame();
        } else {
            showStartScreen();
        }
    }
    
    private void showMessage(String message, String title) {
        JOptionPane.showMessageDialog(parent, message, title, JOptionPane.INFORMATION_MESSAGE);
    }
    
    private JPanel createStyledPanel() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, new Color(255, 248, 225), 
                    getWidth(), getHeight(), new Color(255, 235, 205));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        panel.setLayout(new BorderLayout());
        return panel;
    }
    
    private JButton createFlavorButton(String flavor) {
        JButton button = new JButton(flavor);
        button.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        button.setBackground(new Color(255, 228, 196));
        button.setForeground(new Color(80, 40, 20));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 6, 8, 6));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(255, 218, 185));
                button.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
            }
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(255, 228, 196));
                button.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
            }
        });
        
        return button;
    }
    
    private JButton createDecorationButton(String decoration) {
        JButton button = new JButton(decoration);
        button.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
        button.setBackground(new Color(255, 218, 185));
        button.setForeground(new Color(80, 40, 20));
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(8, 6, 8, 6));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(255, 200, 150));
                button.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
            }
            public void mouseExited(MouseEvent e) {
                button.setBackground(new Color(255, 218, 185));
                button.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
            }
        });
        
        return button;
    }
    
    private JButton createBigButton(String text, Color color) {
        JButton button = new JButton(text);
        button.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        button.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                button.setBackground(color.darker());
            }
            public void mouseExited(MouseEvent e) {
                button.setBackground(color);
            }
        });
        
        return button;
    }
}

// ============================================================
// COOKIE CANVAS - Draws a beautiful cookie with decorations!
// ============================================================
class CookieCanvas extends JPanel {
    private String currentFlavor;
    private List<String> decorations;
    private Map<String, Color> flavorColors;
    private Random random;
    
    public CookieCanvas() {
        this.decorations = new ArrayList<>();
        this.random = new Random();
        initializeFlavorColors();
        setPreferredSize(new Dimension(400, 400));
        setBackground(new Color(255, 248, 225));
    }
    
    private void initializeFlavorColors() {
        flavorColors = new HashMap<>();
        flavorColors.put("🍦 Vanilla Dream", new Color(255, 235, 190));
        flavorColors.put("🍫 Belgian Chocolate", new Color(101, 67, 33));
        flavorColors.put("🌈 Rainbow Sparkle", new Color(255, 220, 230));
        flavorColors.put("🍪 Lotus Biscoff", new Color(205, 133, 63));
        flavorColors.put("🍓 Strawberry Kiss", new Color(255, 200, 210));
        flavorColors.put("🍬 Cotton Candy", new Color(200, 230, 240));
        flavorColors.put("🍯 Honey Caramel", new Color(218, 165, 32));
        flavorColors.put("🌿 Mint Magic", new Color(170, 240, 170));
        flavorColors.put("🥜 Peanut Butter", new Color(188, 143, 143));
        flavorColors.put("🎂 Birthday Cake", new Color(255, 235, 235));
        flavorColors.put("☕ Coffee Crunch", new Color(139, 69, 19));
        flavorColors.put("🍋 Lemon Zest", new Color(255, 250, 180));
        flavorColors.put("🍪 Red Velvet", new Color(200, 80, 80));
        flavorColors.put("🥥 Coconut Paradise", new Color(255, 250, 240));
        flavorColors.put("🍎 Apple Cinnamon", new Color(222, 184, 135));
    }
    
    public void setFlavor(String flavor) {
        this.currentFlavor = flavor;
        repaint();
    }
    
    public void setDecorations(List<String> decorations) {
        this.decorations = new ArrayList<>(decorations);
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        
        int width = getWidth();
        int height = getHeight();
        int centerX = width / 2;
        int centerY = height / 2;
        int cookieSize = Math.min(width, height) - 80;
        int cookieRadius = cookieSize / 2;
        
        // Draw shadow
        g2d.setColor(new Color(0, 0, 0, 40));
        g2d.fillOval(centerX - cookieRadius + 8, centerY - cookieRadius + 8, cookieSize, cookieSize);
        
        // Draw cookie base with gradient
        Color cookieColor = currentFlavor != null && flavorColors.containsKey(currentFlavor) 
            ? flavorColors.get(currentFlavor) : new Color(205, 133, 63);
        
        GradientPaint gradient = new GradientPaint(
            centerX - cookieRadius, centerY - cookieRadius, cookieColor,
            centerX + cookieRadius, centerY + cookieRadius, cookieColor.darker()
        );
        g2d.setPaint(gradient);
        g2d.fillOval(centerX - cookieRadius, centerY - cookieRadius, cookieSize, cookieSize);
        
        // Draw cookie edge
        g2d.setColor(cookieColor.darker());
        g2d.setStroke(new BasicStroke(4));
        g2d.drawOval(centerX - cookieRadius, centerY - cookieRadius, cookieSize, cookieSize);
        
        // Draw cookie texture spots
        g2d.setColor(new Color(139, 69, 19, 60));
        for (int i = 0; i < 60; i++) {
            int spotX = centerX - cookieRadius + 10 + (int)(random.nextDouble() * (cookieSize - 20));
            int spotY = centerY - cookieRadius + 10 + (int)(random.nextDouble() * (cookieSize - 20));
            double distance = Math.hypot(spotX - centerX, spotY - centerY);
            if (distance < cookieRadius - 15) {
                g2d.fillOval(spotX, spotY, 3, 3);
            }
        }
        
        // Draw crust rim
        g2d.setStroke(new BasicStroke(2));
        g2d.setColor(new Color(139, 69, 19, 100));
        g2d.drawOval(centerX - cookieRadius + 15, centerY - cookieRadius + 15, cookieSize - 30, cookieSize - 30);
        
        // Draw decorations ON the cookie
        int decoIndex = 0;
        for (String decoration : decorations) {
            double angle = (decoIndex * 36 + random.nextInt(10)) % 360;
            double rad = Math.toRadians(angle);
            int radius = cookieRadius - 45;
            int x = centerX + (int)(Math.cos(rad) * radius) - 12;
            int y = centerY + (int)(Math.sin(rad) * radius) - 12;
            
            if (decoration.contains("Sprinkles")) {
                g2d.setColor(new Color(255, 100, 100));
                g2d.fillRect(x, y, 10, 5);
                g2d.setColor(new Color(100, 255, 100));
                g2d.fillRect(x + 12, y + 3, 10, 5);
                g2d.setColor(new Color(100, 100, 255));
                g2d.fillRect(x + 6, y + 8, 10, 5);
                g2d.setColor(new Color(255, 255, 100));
                g2d.fillRect(x + 18, y + 10, 10, 5);
            } else if (decoration.contains("Heart")) {
                g2d.setColor(new Color(255, 80, 120));
                drawHeart(g2d, x, y, 18);
            } else if (decoration.contains("Flower")) {
                g2d.setColor(new Color(255, 160, 180));
                drawFlower(g2d, x, y, 16);
            } else if (decoration.contains("Unicorn Dust")) {
                g2d.setColor(new Color(255, 100, 255));
                for (int i = 0; i < 5; i++) {
                    g2d.fillOval(x + i * 4, y + random.nextInt(8), 3, 3);
                }
                g2d.setColor(new Color(100, 255, 255));
                for (int i = 0; i < 5; i++) {
                    g2d.fillOval(x + i * 4 + 2, y + 5 + random.nextInt(6), 3, 3);
                }
            } else if (decoration.contains("Glitter")) {
                g2d.setColor(new Color(255, 215, 0));
                g2d.fillOval(x, y, 4, 4);
                g2d.fillOval(x + 8, y + 3, 4, 4);
                g2d.fillOval(x + 4, y + 8, 4, 4);
                g2d.fillOval(x + 12, y + 10, 4, 4);
            } else if (decoration.contains("Chocolate Chips")) {
                g2d.setColor(new Color(101, 67, 33));
                g2d.fillRoundRect(x, y, 14, 10, 5, 5);
                g2d.fillRoundRect(x + 10, y + 5, 12, 9, 5, 5);
            } else if (decoration.contains("Coconut Flakes")) {
                g2d.setColor(new Color(255, 255, 240));
                g2d.fillOval(x, y, 8, 6);
                g2d.fillOval(x + 6, y + 4, 8, 6);
                g2d.fillOval(x + 3, y + 8, 8, 6);
            } else if (decoration.contains("Rainbow Drops")) {
                g2d.setColor(new Color(255, 100, 100));
                g2d.fillOval(x, y, 10, 10);
                g2d.setColor(new Color(255, 200, 100));
                g2d.fillOval(x + 8, y + 2, 10, 10);
                g2d.setColor(new Color(100, 255, 100));
                g2d.fillOval(x + 4, y + 8, 10, 10);
                g2d.setColor(new Color(100, 150, 255));
                g2d.fillOval(x + 12, y + 10, 10, 10);
            } else if (decoration.contains("Candy Balls")) {
                g2d.setColor(new Color(255, 100, 200));
                g2d.fillOval(x, y, 12, 12);
                g2d.setColor(Color.WHITE);
                g2d.fillOval(x + 3, y + 3, 4, 4);
            } else if (decoration.contains("Gummy Bears")) {
                g2d.setColor(new Color(255, 120, 80));
                g2d.fillOval(x, y, 14, 10);
                g2d.fillOval(x + 8, y, 14, 10);
                g2d.fillOval(x + 4, y - 5, 10, 14);
                g2d.fillOval(x + 2, y + 8, 6, 4);
                g2d.fillOval(x + 12, y + 8, 6, 4);
            } else if (decoration.contains("Cookie Crumbles")) {
                g2d.setColor(new Color(160, 100, 50));
                g2d.fillRoundRect(x, y, 10, 7, 3, 3);
                g2d.fillRoundRect(x + 8, y + 5, 9, 6, 3, 3);
                g2d.fillRoundRect(x + 3, y + 10, 8, 5, 3, 3);
            } else if (decoration.contains("Icing Swirl")) {
                g2d.setColor(new Color(255, 255, 255));
                g2d.setStroke(new BasicStroke(3));
                g2d.drawArc(x, y, 18, 18, 0, 180);
                g2d.drawArc(x + 4, y - 3, 18, 18, 180, 180);
                g2d.drawArc(x + 8, y, 18, 18, 90, 180);
            } else if (decoration.contains("Ribbon Bow")) {
                g2d.setColor(new Color(255, 80, 120));
                g2d.fillOval(x, y, 12, 8);
                g2d.fillOval(x + 12, y, 12, 8);
                g2d.fillRect(x + 5, y + 6, 14, 8);
                g2d.fillOval(x + 5, y + 10, 4, 4);
            } else if (decoration.contains("Star Burst")) {
                g2d.setColor(new Color(255, 215, 0));
                drawStar(g2d, x, y, 14);
                g2d.setColor(new Color(255, 200, 0));
                drawStar(g2d, x + 3, y + 3, 8);
            } else if (decoration.contains("Teddy Bear")) {
                g2d.setColor(new Color(160, 100, 60));
                g2d.fillOval(x, y, 14, 14);
                g2d.fillOval(x - 6, y + 4, 9, 10);
                g2d.fillOval(x + 12, y + 4, 9, 10);
                g2d.fillOval(x + 2, y + 10, 4, 4);
                g2d.fillOval(x + 8, y + 10, 4, 4);
                g2d.fillOval(x + 4, y - 3, 6, 6);
            }
            decoIndex++;
        }
        
        // Draw cute face on cookie
        g2d.setColor(new Color(80, 40, 20));
        g2d.fillOval(centerX - 28, centerY - 15, 14, 14);
        g2d.fillOval(centerX + 14, centerY - 15, 14, 14);
        g2d.setColor(Color.WHITE);
        g2d.fillOval(centerX - 25, centerY - 12, 5, 5);
        g2d.fillOval(centerX + 17, centerY - 12, 5, 5);
        g2d.setColor(new Color(80, 40, 20));
        g2d.setStroke(new BasicStroke(4));
        g2d.drawArc(centerX - 22, centerY + 2, 44, 28, 0, -180);
        g2d.setColor(new Color(255, 100, 120, 80));
        g2d.fillOval(centerX - 38, centerY + 5, 16, 12);
        g2d.fillOval(centerX + 22, centerY + 5, 16, 12);
    }
    
    private void drawHeart(Graphics2D g, int x, int y, int size) {
        int[] xPoints = {x + size/2, x + size, x + size, x + size/2, x, x};
        int[] yPoints = {y + size/3, y, y + size/2, y + size, y + size/2, y};
        g.fillPolygon(xPoints, yPoints, 6);
    }
    
    private void drawFlower(Graphics2D g, int x, int y, int size) {
        for (int i = 0; i < 5; i++) {
            double angle = i * 72 * Math.PI / 180;
            int px = x + (int)(Math.cos(angle) * size/2);
            int py = y + (int)(Math.sin(angle) * size/2);
            g.fillOval(px, py, size/2, size/2);
        }
        g.setColor(new Color(255, 200, 50));
        g.fillOval(x, y, size/2, size/2);
    }
    
    private void drawStar(Graphics2D g, int x, int y, int size) {
        int[] xPoints = new int[10];
        int[] yPoints = new int[10];
        for (int i = 0; i < 10; i++) {
            double angle = i * 36 * Math.PI / 180;
            int r = (i % 2 == 0) ? size : size/2;
            xPoints[i] = x + (int)(Math.cos(angle) * r);
            yPoints[i] = y + (int)(Math.sin(angle) * r);
        }
        g.fillPolygon(xPoints, yPoints, 10);
    }
}

// Customer Class
class Customer {
    String name;
    String requirement;
    String desiredFlavor;
    List<String> desiredDecorations;
    int basePoints;
    
    public Customer(String name, String requirement, String desiredFlavor, List<String> desiredDecorations, int basePoints) {
        this.name = name;
        this.requirement = requirement;
        this.desiredFlavor = desiredFlavor;
        this.desiredDecorations = desiredDecorations;
        this.basePoints = basePoints;
    }
    
    public int evaluateCookie(String flavor, List<String> decorations) {
        int points = 0;
        
        if (flavor != null && flavor.equals(desiredFlavor)) {
            points += 50;
        } else if (flavor != null) {
            points += 10;
        }
        
        int matches = 0;
        for (String deco : decorations) {
            if (desiredDecorations.contains(deco)) {
                matches++;
            }
        }
        
        points += matches * 15;
        
        if (matches == desiredDecorations.size() && desiredDecorations.size() > 0) {
            points += 25;
        }
        
        if (flavor != null && flavor.equals(desiredFlavor) && matches == desiredDecorations.size() && desiredDecorations.size() > 0) {
            points += 30;
        }
        
        return Math.min(points, basePoints + 50);
    }
}
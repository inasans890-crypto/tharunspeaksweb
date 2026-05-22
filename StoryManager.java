import javax.swing.*;
import java.awt.*;

class StoryManager {
    private JFrame parent;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private StoryState currentState;
    private int sceneCounter = 1;
    
    public StoryManager(JFrame parent, CardLayout cardLayout, JPanel mainPanel) {
        this.parent = parent;
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        this.currentState = new StoryState();
        createFirstScene();
    }
    
    private void createFirstScene() {
        StoryScene firstScene = new StoryScene(
            parent,
            "✨ THE LOST AMULET ✨",
            "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n" +
            "📖 CHAPTER 1: The Awakening\n\n" +
            "You wake up in an enchanted forest, surrounded by glowing mushrooms\n" +
            "and ancient trees that seem to whisper secrets.\n\n" +
            "A magnificent amulet hangs from a golden branch, pulsing with\n" +
            "mysterious energy. A ghostly voice echoes through the mist:\n\n" +
            "⚜️ 'Traveler, your emotions shall shape your destiny...' ⚜️\n\n" +
            "How do you respond?\n\n" +
            "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━",
            "forest"
        );
        
        firstScene.addEmotionButton("💢 ANGRY - SMASH THROUGH! 💢", "ANGRY", () -> handleAngryPath());
        firstScene.addEmotionButton("😌 CALM - MEDITATE 😌", "CALM", () -> handleCalmPath());
        firstScene.addEmotionButton("🔍 CURIOUS - INVESTIGATE 🔍", "CURIOUS", () -> handleCuriousPath());
        
        mainPanel.add(firstScene, "scene" + sceneCounter++);
        cardLayout.show(mainPanel, "scene" + (sceneCounter - 1));
    }
    
    private void handleAngryPath() {
        currentState.increaseAnger();
        
        if (currentState.getAngerLevel() > 3) {
            currentState.addEnding("The Destroyer");
            showEndingScreen(
                "💢 DARK PATH ENDING 💢",
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n" +
                "Your rage has consumed you completely!\n\n" +
                "The amulet shatters, releasing a wave of destructive energy.\n" +
                "The forest burns, and you become a cautionary tale for future adventurers.\n\n" +
                "🏆 Achievement Unlocked: 'The Destroyer'\n\n" +
                "🌑 Bad Ending - Darkness Prevails 🌑\n\n" +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━",
                "bad"
            );
        } else {
            StoryScene angryScene = new StoryScene(
                parent,
                "⚡ THE PATH OF WRATH ⚡",
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n" +
                "Your fist clenches with fury! You grab the amulet violently,\n" +
                "and it burns with crimson energy. The ground trembles!\n\n" +
                "A massive GUARDIAN SPIRIT materializes before you,\n" +
                "its eyes blazing like twin suns.\n\n" +
                "GUARDIAN: 'Foolish mortal! Your anger blinds you!'\n\n" +
                "What will you do?\n\n" +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━",
                "anger"
            );
            
            angryScene.addEmotionButton("🗡️ ATTACK FURIOUSLY!", "ANGRY", () -> showBattleOutcome());
            angryScene.addEmotionButton("🧘 TAKE A DEEP BREATH...", "CALM", () -> showReasonOutcome());
            
            mainPanel.add(angryScene, "scene" + sceneCounter++);
            cardLayout.show(mainPanel, "scene" + (sceneCounter - 1));
        }
    }
    
    private void handleCalmPath() {
        StoryScene calmScene = new StoryScene(
            parent,
            "🌊 THE SERENE PATH 🌊",
            "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n" +
            "You close your eyes and breathe deeply. The forest responds\n" +
            "with a gentle breeze, and the amulet glows soft blue.\n\n" +
            "A benevolent SPIRIT OF WISDOM appears, radiating peace:\n\n" +
            "✨ 'Your calm heart has unlocked three visions of destiny...' ✨\n\n" +
            "Which vision calls to you?\n\n" +
            "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━",
            "calm"
        );
        
        calmScene.addEmotionButton("🌿 HEAL THE VILLAGE 🌿", "CALM", () -> {
            currentState.addEnding("The Great Healer");
            showGoodEnding(
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n" +
                "You become a legendary HEALER!\n\n" +
                "Using the amulet's power, you cure all diseases and bring prosperity to the land.\n" +
                "Statues are erected in your honor, and peace reigns for a thousand years.\n\n" +
                "🏆 Achievement Unlocked: 'The Great Healer'\n\n" +
                "✨ Good Ending - Golden Age ✨\n\n" +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
            );
        });
        
        calmScene.addEmotionButton("📚 MASTER ANCIENT MAGIC 📚", "CURIOUS", () -> {
            currentState.addEnding("The Archmage");
            showGoodEnding(
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n" +
                "You unlock the SECRETS OF THE UNIVERSE!\n\n" +
                "Becoming the Archmage, you establish a great academy and teach generations of wizards.\n" +
                "Your name is spoken with reverence across all realms.\n\n" +
                "🏆 Achievement Unlocked: 'The Archmage'\n\n" +
                "✨ Good Ending - Eternal Wisdom ✨\n\n" +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
            );
        });
        
        calmScene.addEmotionButton("🏠 SIMPLE LIFE 🏠", "CALM", () -> {
            currentState.addEnding("The Content One");
            showNeutralEnding(
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n" +
                "You choose CONTENTMENT over power.\n\n" +
                "Living a humble life in a small cottage, you find true happiness in simple pleasures.\n" +
                "You become known as the kind neighbor who always helps others.\n\n" +
                "🏆 Achievement Unlocked: 'The Content One'\n\n" +
                "📖 Neutral Ending - Peaceful Life 📖\n\n" +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
            );
        });
        
        mainPanel.add(calmScene, "scene" + sceneCounter++);
        cardLayout.show(mainPanel, "scene" + (sceneCounter - 1));
    }
    
    private void handleCuriousPath() {
        StoryScene curiousScene = new StoryScene(
            parent,
            "🔮 THE CURIOUS PATH 🔮",
            "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n" +
            "You examine the amulet with scholarly interest.\n" +
            "Runes glow in sequence, and suddenly you're teleported to\n" +
            "the GREAT LIBRARY OF INFINITE KNOWLEDGE!\n\n" +
            "A floating OWL-LIKE CREATURE greets you:\n\n" +
            "🦉 'Knowledge seeker! The library holds ALL secrets...'\n\n" +
            "What knowledge do you seek?\n\n" +
            "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━",
            "curious"
        );
        
        curiousScene.addEmotionButton("📖 READ FORBIDDEN TOMES 📖", "CURIOUS", () -> {
            currentState.addEnding("The Eternal Guardian");
            showMysteryEnding(
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n" +
                "You GAIN COSMIC KNOWLEDGE beyond mortal comprehension!\n\n" +
                "But the truth shatters your mind - you become a benevolent ghost,\n" +
                "forever guarding the library and helping worthy seekers.\n\n" +
                "🏆 Achievement Unlocked: 'The Eternal Guardian'\n\n" +
                "🔮 Mystery Ending - Bound to Knowledge 🔮\n\n" +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
            );
        });
        
        curiousScene.addEmotionButton("💡 LEARN PRACTICAL MAGIC 💡", "CALM", () -> {
            currentState.addEnding("The Innovator");
            showGoodEnding(
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n" +
                "You master USEFUL MAGIC that changes the world!\n\n" +
                "Inventing flying ships, eternal lights, and magical farming,\n" +
                "you usher in an era of technological and magical advancement.\n\n" +
                "🏆 Achievement Unlocked: 'The Innovator'\n\n" +
                "✨ Good Ending - Renaissance Era ✨\n\n" +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
            );
        });
        
        mainPanel.add(curiousScene, "scene" + sceneCounter++);
        cardLayout.show(mainPanel, "scene" + (sceneCounter - 1));
    }
    
    private void showBattleOutcome() {
        StoryScene outcome = new StoryScene(
            parent,
            "⚔️ EPIC BATTLE ⚔️",
            "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n" +
            "You charge with primal fury! The battle shakes the very foundations\n" +
            "of the forest. After an intense struggle, the Guardian speaks:\n\n" +
            "👁️ 'Your courage is formidable, but your heart lacks wisdom.'\n\n" +
            "The spirit offers you a final choice...\n\n" +
            "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━",
            "anger"
        );
        
        outcome.addEmotionButton("⚡ TAKE DARK POWER ⚡", "ANGRY", () -> {
            currentState.addEnding("The Tyrant");
            showNeutralEnding(
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n" +
                "You gain UNLIMITED POWER but lose your humanity!\n\n" +
                "Ruling with an iron fist, you bring order through fear.\n" +
                "The world is peaceful, but at what cost?\n\n" +
                "🏆 Achievement Unlocked: 'The Tyrant'\n\n" +
                "⚖️ Neutral Ending - Order Through Fear ⚖️\n\n" +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
            );
        });
        
        outcome.addEmotionButton("🤝 SEEK WISDOM 🤝", "CALM", () -> {
            currentState.addEnding("The Balanced One");
            showGoodEnding(
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n" +
                "The Guardian teaches you BALANCE!\n\n" +
                "You become a legendary warrior-sage, protecting both realms.\n" +
                "Your legend inspires generations of heroes.\n\n" +
                "🏆 Achievement Unlocked: 'The Balanced One'\n\n" +
                "✨ Good Ending - Legendary Hero ✨\n\n" +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
            );
        });
        
        mainPanel.add(outcome, "scene" + sceneCounter++);
        cardLayout.show(mainPanel, "scene" + (sceneCounter - 1));
    }
    
    private void showReasonOutcome() {
        StoryScene outcome = new StoryScene(
            parent,
            "🕊️ DIPLOMACY SUCCESS 🕊️",
            "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n" +
            "You lower your guard and speak with respect.\n" +
            "The Guardian is moved by your restraint:\n\n" +
            "🌟 'Wisdom over rage... The amulet is yours, noble soul.' 🌟\n\n" +
            "How will you use this power?\n\n" +
            "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━",
            "calm"
        );
        
        outcome.addEmotionButton("💚 HEAL THE WORLD 💚", "CALM", () -> {
            currentState.addEnding("The Divine One");
            showGoodEnding(
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n" +
                "You become a DIVINE HEALER!\n\n" +
                "Your compassion heals not just bodies but souls.\n" +
                "A golden age of peace and understanding begins.\n\n" +
                "🏆 Achievement Unlocked: 'The Divine One'\n\n" +
                "✨ Good Ending - Golden Millennium ✨\n\n" +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
            );
        });
        
        outcome.addEmotionButton("🧠 UNDERSTAND EXISTENCE 🧠", "CURIOUS", () -> {
            currentState.addEnding("The Enlightened");
            showGoodEnding(
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n" +
                "You unlock the MEANING OF EXISTENCE!\n\n" +
                "Sharing this wisdom wisely, you elevate civilization\n" +
                "to unprecedented heights of enlightenment.\n\n" +
                "🏆 Achievement Unlocked: 'The Enlightened'\n\n" +
                "✨ Good Ending - Age of Enlightenment ✨\n\n" +
                "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
            );
        });
        
        mainPanel.add(outcome, "scene" + sceneCounter++);
        cardLayout.show(mainPanel, "scene" + (sceneCounter - 1));
    }
    
    private void showGoodEnding(String message) {
        showEndingScreen("✨ GOOD ENDING ✨", message, "good");
    }
    
    private void showNeutralEnding(String message) {
        showEndingScreen("📖 NEUTRAL ENDING 📖", message, "neutral");
    }
    
    private void showMysteryEnding(String message) {
        showEndingScreen("🔮 MYSTERY ENDING 🔮", message, "mystery");
    }
    
    private void showEndingScreen(String title, String message, String themeType) {
        StoryScene ending = new StoryScene(parent, title, message, themeType);
        ending.addEmotionButton("🔄 PLAY AGAIN", "CALM", () -> restartGame());
        ending.addEmotionButton("🌟 VIEW ACHIEVEMENTS", "CURIOUS", () -> showAchievements());
        ending.addEmotionButton("🚪 EXIT GAME", "CALM", () -> System.exit(0));
        
        mainPanel.add(ending, "ending");
        cardLayout.show(mainPanel, "ending");
    }
    
    private void showAchievements() {
        StringBuilder achievementText = new StringBuilder("🏆 YOUR ACHIEVEMENTS 🏆\n\n");
        achievementText.append("📊 Game Statistics:\n");
        achievementText.append("⭐ Scenes Completed: ").append(sceneCounter - 1).append("\n");
        achievementText.append("💢 Anger Level: ").append(currentState.getAngerLevel()).append("/10\n");
        achievementText.append("😌 Calm Level: ").append(currentState.getCalmLevel()).append("/10\n");
        achievementText.append("🔍 Curiosity Level: ").append(currentState.getCuriosityLevel()).append("/10\n\n");
        
        achievementText.append("🔓 Unlocked Endings:\n");
        java.util.ArrayList<String> endings = currentState.getUnlockedEndings();
        if (endings.isEmpty()) {
            achievementText.append("   No endings yet. Keep playing!\n");
        } else {
            for (String ending : endings) {
                achievementText.append("   • ").append(ending).append("\n");
            }
        }
        
        achievementText.append("\n🎮 Total Endings Discovered: ").append(endings.size()).append("/8\n");
        achievementText.append("💡 Tip: Make different choices to unlock more endings!");
        
        JOptionPane.showMessageDialog(parent,
            achievementText.toString(),
            "Achievements",
            JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void restartGame() {
        currentState = new StoryState();
        sceneCounter = 1;
        mainPanel.removeAll();
        mainPanel.revalidate();
        mainPanel.repaint();
        createFirstScene();
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class ImageLoader {
    private static ImageLoader instance;
    private HashMap<String, Image> imageCache;
    
    private ImageLoader() {
        imageCache = new HashMap<>();
        loadImages();
    }
    
    public static ImageLoader getInstance() {
        if (instance == null) {
            instance = new ImageLoader();
        }
        return instance;
    }
    
    private void loadImages() {
        // Create colored gradient backgrounds for macOS compatibility
        imageCache.put("bg_forest", createGradientImage(new Color(34, 139, 34), new Color(0, 50, 0)));
        imageCache.put("bg_anger", createGradientImage(new Color(139, 0, 0), new Color(50, 0, 0)));
        imageCache.put("bg_calm", createGradientImage(new Color(25, 25, 112), new Color(0, 0, 50)));
        imageCache.put("bg_curious", createGradientImage(new Color(75, 0, 130), new Color(25, 0, 50)));
        imageCache.put("bg_good", createGradientImage(new Color(0, 100, 0), new Color(0, 50, 0)));
        imageCache.put("bg_bad", createGradientImage(new Color(100, 0, 0), new Color(50, 0, 0)));
        imageCache.put("bg_neutral", createGradientImage(new Color(139, 69, 19), new Color(70, 35, 10)));
        imageCache.put("bg_mystery", createGradientImage(new Color(75, 0, 130), new Color(128, 0, 128)));
    }
    
    private Image createGradientImage(Color color1, Color color2) {
        BufferedImage img = new BufferedImage(900, 700, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = img.createGraphics();
        GradientPaint gradient = new GradientPaint(0, 0, color1, 900, 700, color2);
        g2d.setPaint(gradient);
        g2d.fillRect(0, 0, 900, 700);
        g2d.dispose();
        return img;
    }
    
    public Image getImage(String key) {
        return imageCache.getOrDefault(key, createGradientImage(Color.DARK_GRAY, Color.BLACK));
    }
}
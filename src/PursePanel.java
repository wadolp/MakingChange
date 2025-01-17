import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PursePanel extends JPanel {
    public Purse purse;
    private final int ICON_WIDTH = 50;  // Adjust size as needed
    private final int ICON_HEIGHT = 50; // Adjust size as needed
    private final int SPACING = 10;     // Space between icons


    public PursePanel() {
        purse = new Purse();
        setBackground(Color.WHITE);

    }

    @Override
    protected void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int xStart = 50; // Initial x position for the first group
        int yStart = 50; // Initial y position

        for (Map.Entry<Denomination, Integer> entry : purse.map.entrySet()) {
            String image = entry.getKey().img();
            int count = entry.getValue();

            Image icon = Toolkit.getDefaultToolkit().getImage(image);

            for (int i = 0; i < count; i++) {
                // Draw each image with a slight offset for repeats
                g2d.drawImage(icon, xStart + i * 5, yStart + i * 5, null);
            }

            // Move to the next group position
            xStart += 100; // Adjust spacing between groups
        }


    }
}

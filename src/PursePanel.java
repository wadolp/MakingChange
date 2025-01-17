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
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int x = 50; // Initial x position for the first group
        int y = 50; // Initial y position

        if (purse == null) return;

        for (Map.Entry<Denomination, Integer> entry : purse.map.entrySet()) {
            Denomination denom = entry.getKey();
            int count = entry.getValue();

            // For now, let's draw colored rectangles with denomination names
            // until we set up the images properly
            for (int i = 0; i < count; i++) {
                g2d.setColor(new Color(0, 100, 0));
                g2d.fillRect(x, y, ICON_WIDTH, ICON_HEIGHT);
                g2d.setColor(Color.BLACK);
                g2d.drawRect(x, y, ICON_WIDTH, ICON_HEIGHT);
                g2d.drawString(denom.name(), x + 5, y + ICON_HEIGHT/2);

                x += ICON_WIDTH + SPACING;
                if (x + ICON_WIDTH > getWidth()) {
                    x = SPACING;
                    y += ICON_HEIGHT + SPACING;
                }
            }
        }
    }
}

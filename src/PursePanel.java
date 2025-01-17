import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class PursePanel extends JPanel {
    public Purse purse;
    private final int ICON_WIDTH = 50;  // Adjust size as needed
    private final int ICON_HEIGHT = 50; // Adjust size as needed
    private final int SPACING = 10;     // Space between icons
    int xStart = 50; // Initial x position for the first group
    int yStart = 50; // Initial y position

    public PursePanel() {
        purse = new Purse();
        setBackground(Color.WHITE);

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;



        if (purse == null) return;
        int i=0;
        for (Map.Entry<Denomination, Integer> entry : purse.map.entrySet()) {

            int x = xStart + i * (ICON_WIDTH + 5); // Offset each image within the group
            int y = yStart;
            Denomination denom = entry.getKey();
            int count = entry.getValue();

            //Image Icon attempt
            ImageIcon icon = new ImageIcon(getClass().getResource(denom.img()));
            if (icon.getImage() != null) {
                g2d.drawImage(icon.getImage(), x, y, ICON_WIDTH, ICON_HEIGHT, this);
            } else {
                // Fallback to colored rectangles if image loading fails
                g2d.setColor(new Color(0, 255, 0));
                g2d.fillRect(x, y, ICON_WIDTH, ICON_HEIGHT);
                g2d.setColor(Color.BLACK);
                g2d.drawString(denom.name(), x + 5, y + ICON_HEIGHT/2);
            }
            i = i+1;
        }
    }
}

//          Code for Drawing Rectangles of Money
//            for (int i = 0; i < count; i++) {
//                g2d.setColor(new Color(0, 100, 0));
//                g2d.fillRect(x, y, ICON_WIDTH, ICON_HEIGHT);
//                g2d.setColor(Color.BLACK);
//                g2d.drawRect(x, y, ICON_WIDTH, ICON_HEIGHT);
//                g2d.drawString(denom.name(), x + 5, y + ICON_HEIGHT/2);
//
//                x += ICON_WIDTH + SPACING;
//                if (x + ICON_WIDTH > getWidth()) {
//                    x = SPACING;
//                    y += ICON_HEIGHT + SPACING;
//                }
//            }

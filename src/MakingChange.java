import javax.swing.*;

public class MakingChange {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("MakingChange");
        frame.setSize(500, 500);

        RegisterPanel panel = new RegisterPanel();
        frame.add(panel);
        //frame.pack();
        frame.setVisible(true);
    }
}

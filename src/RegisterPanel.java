import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
RegisterPanel (class, extends JPanel)
	register: Register  // a register object to run the logic
	inputPanel: JPanel  // a panel to hold the JTextField for the user to enter an amount
input: JTextField   // a place for the user to enter the amount
	changePanel: PursePanel  // a panel to display the change
	InputListener (class, implements ActionListener)   // a listener for changes to the input
		actionPerformed(ActionEvent e): void   // what happens when input changes

*/
public class RegisterPanel extends JPanel {
    Register register;
    JPanel inputPanel;
    JTextField input;
    PursePanel changePanel;
    //Graphics g;


    public RegisterPanel() {
        //Create the register
        register = new Register();
        //set Border Layout for Master Panel
        this.setLayout(new BorderLayout());

        //Create Input Panel
        inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Input"));
        //Create TextField to be added to inputPanel
        input = new JTextField(20);
        input.addActionListener(new InputListener());
        inputPanel.add(input);
        //Create and add purse panel for displaying money
        changePanel = new PursePanel();
        changePanel.setLayout(new FlowLayout());
        changePanel.setBorder(BorderFactory.createTitledBorder("Change"));
        //add sub panels to border layout of RegisterPanel
        this.add(inputPanel, BorderLayout.NORTH);
        this.add(changePanel, BorderLayout.CENTER);
        //Prefered Size
        this.setPreferredSize(new Dimension(400, 300));
        //set visible
        inputPanel.setVisible(true);
        changePanel.setVisible(true);
        this.setVisible(true);
    }
    public class InputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try{
                //get text convert to double
                double amount = Double.parseDouble(input.getText());
                //Update Purse
                changePanel.purse = register.makeChange(amount);
                //display
                repaint();
                //clear input
                //input.setText("");

            }catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Please enter a number!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

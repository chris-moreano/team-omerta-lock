//---------------------------------------------------------

// Project Keypad
// Class MyFrame
    
// Enter digits in a textfield with
// Buttons on a keypad.
    
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
    
public class GUI extends JFrame
{
	
	public static void main(String arg[])
	{
		GUI gui = new GUI();
	}
	
    private static final int FRAME_WIDTH  = 245;
    private static final int FRAME_HEIGHT = 440;
    private static final int BUTTON_WIDTH = 50;
    private static final int BUTTON_HEIGHT = 50;
    private static final int BUTTON_Y = 260;
	  
    JButton[] key;
    JButton reset;
    JTextField display;
    JPanel panel;
    
    //@SuppressWarnings("deprecation")
	public GUI()
    {
        // Set title in title bar.
        super("Omerta Electronic System");
        
        // Local variables.
        int row, col, i;
        
        // Create array of keys.
        key = new JButton[12];
        
        // Create and configure panel.
        panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(null);
        
        // Create ActionListener for keys.
        KeyDetect keyAL = new KeyDetect();
        
        // Create and position individual 
        // keys with numbers 1 through 9.
        for(i = 0; i <= 9; i++)
        {
        	
            key[i] = new JButton(String.valueOf(i));
            panel.add(key[i]);
            row = (i - 1) / 3;
            col = (i - 1) % 3;
            key[i].setBounds(20+70*col, 50+70*row, BUTTON_WIDTH, BUTTON_HEIGHT);
            key[i].addActionListener(keyAL);
        }
        
        // Create and position button 0.
        key[0] = new JButton("0");
        panel.add(key[0]);
        key[0].setBounds(20+70*1, BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
        key[0].addActionListener(keyAL);
        
     // Create and position button *.
        key[10] = new JButton("*");
        panel.add(key[10]);
        key[10].setBounds(20, BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
        key[10].addActionListener(keyAL);
        
     // Create and position button #.
        key[11] = new JButton("#");
        panel.add(key[11]);
        key[11].setBounds( 160, BUTTON_Y, BUTTON_WIDTH, BUTTON_HEIGHT);
        key[11].addActionListener(keyAL);
       
       
        // Create and configure reset button.
        reset = new JButton("Reset");
        panel.add(reset);
        reset.setBounds(20, 330, 190, BUTTON_HEIGHT);
        reset.addActionListener(new ResetDetect());
        
        // Create and configure textfield.
        display = new JTextField(1);
        panel.add(display);
        display.setBounds(20, 10, 190, 20);
        display.setEditable(false);
        
        // Set size and show the frame.
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setVisible(true);
    }
    
    private class KeyDetect implements ActionListener
    {
        // When a button is clicked, append the digit
        // in the caption of the button to the digits
        // in the textfield.
        
        // Note: the reference e.getSource must be cast
        // to a JButton to be able to get its text.
        public void actionPerformed(ActionEvent e)
        {
            String s;
            
            if(display.getText().length() < 5)
            {
                s = display.getText();
                s += ((JButton) e.getSource()).getText();
                display.setText(s);
            }
        }
    }
    
    private class ResetDetect implements ActionListener
    {
        // Clear the textfield.
        public void actionPerformed(ActionEvent e)
        {
            display.setText("");
        }
    }
}

package frame;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

// PLEASE NOTE - many of constructors / patterns based off of code examples from the lectures, frequently written by `@author evansrb1`

public class Composer {

	public static void main(String[] args) {

		System.out.println("---Start of Main Method---");
		
        // create the button group
        ButtonGroup bg = new ButtonGroup();

        // create the panel for the radio buttons
        JPanel radioPanel = new JPanel();
        
        // create the 3 radio buttons
        JRadioButton rbtn1;
        JRadioButton rbtn2;
        JRadioButton rbtn3;
        
        
        rbtn1 = new JRadioButton("Gardiner Lake", true); // default to first radio selected
        rbtn2 = new JRadioButton("Hellroaring Plateau");        
        rbtn3 = new JRadioButton("Beaten Path");                
        bg.add(rbtn1);
        bg.add(rbtn2);
        bg.add(rbtn3);
        radioPanel.setBorder(BorderFactory.createTitledBorder("Hike Options:"));
        
        radioPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = GridBagConstraints.RELATIVE;
        gbc3.insets = new Insets(5, 5, 5, 5);
        gbc3.anchor = GridBagConstraints.WEST;
        gbc3.weightx = 1.0;
        radioPanel.add(rbtn1, gbc3);
        radioPanel.add(rbtn2, gbc3);
        radioPanel.add(rbtn3, gbc3);

        // ass a Date object to JFormatted TextField, you will get a text field that will only allow a valid date to be entered
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        JFormattedTextField dateTextField = new JFormattedTextField(dateFormat);
       
        
        
        
        
        
        
	    
        // create the frame
        JFrame jf = new JFrame("Beartooth Hiking Company!");
        
        // add the radio panel
//        jf.add(radioPanel);
//        jf.add(dateTextField);
        
        
		JButton b=new JButton("Submit");    
		b.setBounds(100,100,140, 40);    
					//enter name label
		JLabel label = new JLabel();		
		label.setText("Enter Name :");
		label.setBounds(10, 10, 100, 100);
					//empty label which will show event after button clicked
		JLabel label1 = new JLabel();
		label1.setBounds(10, 110, 200, 100);
					// textfield to enter name
		JTextField textfield= new JTextField();
		textfield.setBounds(110, 50, 130, 30);
					//add to frame
		jf.add(label1);
		jf.add(textfield);
		jf.add(label);
		jf.add(b);
		
        jf.add(radioPanel);
//        jf.add(dateTextField);
        
        
		jf.setSize(900,900);    
		jf.setLayout(null);    
        
        

//        jf.pack();
//        jf.setLocationByPlatform(true);        
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        jf.setVisible(true);
        
    	System.out.println("----End of Main Method----");

	}

}

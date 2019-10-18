package frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

// PLEASE NOTE - many of constructors / patterns based off of code examples from the lectures, frequently written by `@author evansrb1`

public class Composer extends JFrame implements ActionListener {
	JButton submitButton = new JButton("Submit");

	// choices radio buttons
    ButtonGroup hikesButtonGroup = new ButtonGroup();
    JPanel choiceRadioPanel = new JPanel();
    JRadioButton rbtn1;
    JRadioButton rbtn2;
    JRadioButton rbtn3;

    // range radio buttons
    ButtonGroup rangesButtonGroup = new ButtonGroup();
    JPanel rangesRadioPanel = new JPanel();
    JRadioButton rbtnRange1;
    JRadioButton rbtnRange2;
    JRadioButton rbtnRange3;

    // cost field
    JTextField costTextField = new JTextField("$$");
    String costTextFieldHolder = "";

    // Hike Status
    String hikeStatus = "firstHike";

	// Compose all the pieces together
	public Composer() {
		// RADIO BUTTONS CHOICE
        // create the button group
        // create the panel for the radio buttons
        // create the 3 radio buttons
        rbtn1 = new JRadioButton("Gardiner Lake", true); // default to first radio selected
        rbtn2 = new JRadioButton("Hellroaring Plateau");
        rbtn3 = new JRadioButton("Beaten Path");
        hikesButtonGroup.add(rbtn1);
        hikesButtonGroup.add(rbtn2);
        hikesButtonGroup.add(rbtn3);
        choiceRadioPanel.setBorder(BorderFactory.createTitledBorder("Hike Options:"));
        choiceRadioPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc3 = new GridBagConstraints();
        gbc3.gridx = 0;
        gbc3.gridy = GridBagConstraints.RELATIVE;
        gbc3.insets = new Insets(5, 5, 5, 5);
        gbc3.anchor = GridBagConstraints.WEST;
        gbc3.weightx = 1.0;
        choiceRadioPanel.add(rbtn1, gbc3);
        choiceRadioPanel.add(rbtn2, gbc3);
        choiceRadioPanel.add(rbtn3, gbc3);

		// RADIO BUTTONS RANGE
        // create the button group
        // create the panel for the radio buttons
        rbtnRange1 = new JRadioButton("3", true); // default to first radio selected
        rbtnRange2 = new JRadioButton("5");
        rbtnRange3 = new JRadioButton("NA");
        rangesButtonGroup.add(rbtnRange1);
        rangesButtonGroup.add(rbtnRange2);
        rangesButtonGroup.add(rbtnRange3);
        rangesRadioPanel.setBorder(BorderFactory.createTitledBorder("Range Options:"));
        rangesRadioPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc4 = new GridBagConstraints();
        gbc4.gridx = 0;
        gbc4.gridy = GridBagConstraints.RELATIVE;
        gbc4.insets = new Insets(5, 5, 5, 5);
        gbc4.anchor = GridBagConstraints.WEST;
        gbc4.weightx = 1.0;
        rangesRadioPanel.add(rbtnRange1, gbc4);
        rangesRadioPanel.add(rbtnRange2, gbc4);
        rangesRadioPanel.add(rbtnRange3, gbc4);

		// DATE FIELD
        // ass a Date object to JFormatted TextField, you will get a text field that will only allow a valid date to be entered
        JPanel datePanel = new JPanel(new BorderLayout());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        JFormattedTextField dateTextField = new JFormattedTextField(dateFormat);
        JLabel dateLabel = new JLabel("Date: YYYY-MM-DD");
        datePanel.add(dateLabel,BorderLayout.NORTH);
        datePanel.add(dateTextField,BorderLayout.CENTER);

        // ACTION LISTENERS
        rbtn1.addActionListener(this);
        rbtn2.addActionListener(this);
        rbtn3.addActionListener(this);
        rbtnRange1.addActionListener(this);
        rbtnRange2.addActionListener(this);
        rbtnRange3.addActionListener(this);
        submitButton.addActionListener(this);


        // FRAME COMPOSITION
        JFrame jf = new JFrame("Beartooth Hiking Company!");

        choiceRadioPanel.setPreferredSize(new Dimension(200, 200));
        jf.add(choiceRadioPanel, BorderLayout.NORTH);
        rangesRadioPanel.setPreferredSize(new Dimension(200, 200));
        jf.add(rangesRadioPanel, BorderLayout.EAST);
        dateTextField.setPreferredSize(new Dimension(200, 30));
        jf.add(submitButton, BorderLayout.CENTER);
        jf.add(datePanel, BorderLayout.WEST);
        jf.add(costTextField, BorderLayout.SOUTH);

        jf.pack();
        jf.setLocationByPlatform(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

	}


    // exit the application
    private void exit() {
        System.exit(0);
    }

    // gnarly set of conditionals to address required action sets
    public void actionPerformed(ActionEvent evt) {
        Object src = evt.getSource();
    	System.out.println("actionPerformed()");
        if (src == submitButton) {
        	System.out.println("actionPerformed(): in the submit button conditional!");
            costTextField.setText(costTextFieldHolder);
        } else if (src == rbtn1) {
        	System.out.println("actionPerformed(): button 1 in the hikes radio conditional!");
        	hikeStatus = "firstHike";
        	rbtnRange1.setText("3");
        	rbtnRange2.setText("5");
        	rbtnRange3.setText("NA");
        } else if (src == rbtn2) {
        	System.out.println("actionPerformed(): button 2 in the hikes radio conditional!");
        	hikeStatus = "secondHike";
        	rbtnRange1.setText("2");
        	rbtnRange2.setText("3");
        	rbtnRange3.setText("4");
        } else if (src == rbtn3) {
        	System.out.println("actionPerformed(): button 3 in the hikes radio conditional!");
        	hikeStatus = "thirdHike";
        	rbtnRange1.setText("5");
        	rbtnRange2.setText("7");
        	rbtnRange3.setText("NA");
        } else if (src == rbtnRange1) {
        	System.out.println("actionPerformed(): button 1 in the ranges radio conditional!");
        	if (hikeStatus == "firstHike") {
            	costTextFieldHolder = "$120";
        	} else if (hikeStatus == "secondHike") {
            	costTextFieldHolder = "$75";
        	} else if (hikeStatus == "thirdHike") {
            	costTextFieldHolder = "$225";
        	}
        } else if (src == rbtnRange2) {
        	System.out.println("actionPerformed(): button 2 in the ranges radio conditional!");
        	if (hikeStatus == "firstHike") {
            	costTextFieldHolder = "$200";
        	} else if (hikeStatus == "secondHike") {
            	costTextFieldHolder = "$105";
        	} else if (hikeStatus == "thirdHike") {
            	costTextFieldHolder = "$315";
        	}
        } else if (src == rbtnRange3) {
        	System.out.println("actionPerformed(): button 3 in the ranges radio conditional!");
        	if (hikeStatus == "firstHike") {
            	costTextFieldHolder = "This Range Option is Unavailable for the Selected Hike";
        		JOptionPane dialog = new JOptionPane();
        		dialog.showMessageDialog( this, "You cannot select this range option", "Error", JOptionPane.ERROR_MESSAGE );
        	} else if (hikeStatus == "secondHike") {
            	costTextFieldHolder = "$140";
        	} else if (hikeStatus == "thirdHike") {
            	costTextFieldHolder = "This Range Option is Unavailable for the Selected Hike";
        		JOptionPane dialog = new JOptionPane();
        		dialog.showMessageDialog( this, "You cannot select this range option", "Error", JOptionPane.ERROR_MESSAGE );
        	}
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
			System.out.println("---Start of Main Method---");
    	new Composer();
    	System.out.println("----End of Main Method----");

    }

}

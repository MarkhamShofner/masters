package edu.jhu.ep.hw5;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.NumberFormat;
import javax.swing.DefaultComboBoxModel;

/** 
 * Homework 5 sample solution
 * JHU-EP, 605.681.82
 * @author RF Spiegel
 */
public class BHCLauncher extends JFrame implements ActionListener {
    
    private static final String[] HIKE_NAMES = { "The Hellroaring Plateau", "Gardiner Lake", "The Beaten Path"};
    
    
    private JComboBox<String> hikeCombo;
    
    private JLabel durationLabel;
    private JComboBox<String> durationOptions;
  
    private JLabel startDateLabel;
    private JTextField startDateText;
    
    private JLabel costLabel;
    private JLabel costText;
    private JButton submission;
    
    /**
     * Create new form TourCost.
     */
    public BHCLauncher() {
        super("BHC Tour Planning Tool");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel cPane = (JPanel)getContentPane();
        cPane.setLayout(new GridBagLayout());

        GridBagConstraints gc = new GridBagConstraints();
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.insets = new Insets(5, 5, 5, 5);
        
        // default durations in durationOptions
        durationOptions = new JComboBox<>();
        
        hikeCombo = new JComboBox<>(HIKE_NAMES);
        hikeCombo.addActionListener(this);
        hikeCombo.setSelectedIndex(0);
        
        durationLabel = new JLabel("Hike Length(days): ");
                        
        startDateLabel = new JLabel("Start Date (mm/dd/yyyy):");
        startDateText = new JTextField();
        
        costLabel = new JLabel("Cost (in dollars): ");
        costText = new JLabel();
        
        submission = new JButton("submit");
        submission.addActionListener(this);
        
        gc.gridx = 0;
        gc.gridy = 0; //first row
        cPane.add(new JLabel("Select Hike:"), gc);

        gc.gridx = 1;
        cPane.add(hikeCombo, gc);

        gc.gridx = 2;
        cPane.add(durationLabel, gc);

        gc.gridx = 3;
        cPane.add(durationOptions, gc);
        
        gc.gridx = 0;
        gc.gridy = 1; //second row
        cPane.add(startDateLabel, gc);
        
        gc.gridx = 1;
        gc.gridy = 1;
        cPane.add(startDateText, gc);
        
        gc.gridx = 2;
        gc.gridy = 1;
        cPane.add(costLabel, gc);
        
        gc.gridx = 3;
        gc.gridy = 1;
        cPane.add(costText, gc);
        
        gc.gridx = 3;
        gc.gridy = 2; //third row
        cPane.add(submission, gc);
        
        // size the JFrame based on added components
        pack();
       
        // make JFrame visible
        setVisible(true);
    }

  
    /** 
     * When the submit button is clicked, the tour cost is calculated, 
     * and the begin date is validated, based on inputs provided by the user.
     * 
     * The BookingDay and Rates classes by evansrb1 are utilized for the cost calculation and date validation steps.
     * 
     * @param ActionEvent the action that occurs
     */
    public void actionPerformed(ActionEvent evt) {          
        
        Rates.HIKE hike;
        
                
        String selectedTourValue = hikeCombo.getSelectedItem().toString();

        switch (selectedTourValue) {
            case "The Hellroaring Plateau":
                hike = Rates.HIKE.HELLROARING;
                break;
            case "Gardiner Lake":
                hike = Rates.HIKE.GARDINER;
                break;
            default:
                hike = Rates.HIKE.BEATEN;
                break;
        }
                
        // get rates based on selected hike
        Rates rates = new Rates(hike);    
        
        if (evt.getSource().equals(hikeCombo)) {
            // default durations in durationOptions
            int[] numDurations = rates.getDurations();
            String[] durations = new String[numDurations.length];            
            for (int i = 0; i < numDurations.length; i++) {
                durations[i] = Integer.toString(numDurations[i]);
            }
                
            DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(durations);
            durationOptions.setModel(model);
            durationOptions.validate();
        } else if (evt.getSource().equals(submission)) {         
            try {
                String durValue = durationOptions.getSelectedItem().toString();
                // split the user-provided date (e.g.: 6/7/2009) into month, day, and year
                String[] stringStartDate = startDateText.getText().split("/");                
                int startMonth = Integer.parseInt(stringStartDate[0]);
                int startDay = Integer.parseInt(stringStartDate[1]);
                int startYear = Integer.parseInt(stringStartDate[2]);
                BookingDay startDate = new BookingDay(startYear, startMonth, startDay);
                rates.setBeginDate(startDate);
                
                int hikeValue;
                if (selectedTourValue == "Gardiner Lake") {
                	hikeValue = 0;
                } else if (selectedTourValue == "The Hellroaring Plateau") {
                	hikeValue = 1;
                } else {
                	hikeValue = 2;
                }
                
//                setUpSocketAndMakeCall(hikeValue, startYear, startMonth, startDay, durValue);
                // TODO the problem here is connecting the constructed userInput in this action to the actual sockets in main
        		String userInput = hikeValue + ":" + startYear + ":" + startMonth + ":" + startDay + ":" + durValue;

                // based on start date, determine end date (required to calculate cost)
                // code was taken directly from the following link (authors: "Dave", "Sam Hasler")
                // http://stackoverflow.com/questions/428918/how-can-i-increment-a-date-by-one-day-in-java
                // start of code taken from external source
                String dt = (startYear + "/" + startMonth + "/" + startDay);  // start date
                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                Calendar c = Calendar.getInstance();
                // this try-catch block is required by NetBeans
                try {
                    c.setTime(sdf.parse(dt));
                } catch (ParseException ex) {
                    //Logger.getLogger(TourCost.class.getName()).log(Level.SEVERE, null, ex);
                }
            
                c.add(Calendar.DATE, Integer.parseInt(durValue));  // number of days to add (the duration)
                dt = sdf.format(c.getTime());  // dt is now the new date
                // end of code taken from external source
           
                // split the end date (e.g.: 6/9/2009) into month, day, and year
                String[] stringEndDate = dt.split("/");
            
                int endMonth = Integer.parseInt(stringEndDate[0]);
                int endDay = Integer.parseInt(stringEndDate[1]);
                int endYear = Integer.parseInt(stringEndDate[2]); 
                BookingDay endDate = new BookingDay(endMonth, endDay, endYear);
                rates.setEndDate(endDate); 
            
                // set duration of the hike to help calculate the cost
                rates.setDuration(Integer.parseInt(durValue));
                    
                // handle any "junk" in the input fields by catching exceptions
                } catch(NumberFormatException | ArrayIndexOutOfBoundsException ex) {
                  // when an exception is caught, nothing happens in the catch block
                  // instead move to the next line of code  
                }
        
            // if date is invalid, display pop-up alert box
            // the messages in the getDetails() method of the Rates class were modified for clarity
            if (!rates.isValidDates()) {
                JOptionPane.showMessageDialog(null, "Sorry, but " + rates.getDetails() 
                        + ". Try entering a new start date.");
            }
        
            // display the cost of the tour to the user
            NumberFormat formatter = NumberFormat.getCurrencyInstance();
            String moneyString = formatter.format(rates.getCost());            
            costText.setText(moneyString);  
        }
        
        
    }
    
	/**
     * The "main" method creates an instance of the TourCost class.
     * // LOTS OF THE BELOW CODE IS MIRRORED FROM THE "echoserverclient" EXAMPLE FROM THE LECTURE
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
    	
    	System.out.println("----Start of Main Method----");
    	
    	new BHCLauncher();
    	        
    	// Stand up the socket
		Socket echoSocket = null;
		PrintWriter out = null;
		BufferedReader in = null;

		try {
			System.out.println("Making the Socketz...");
			echoSocket = new Socket("web6.jhuep.com", 20025);
			System.out.println("Making the PrintWriter...");
			out = new PrintWriter(echoSocket.getOutputStream(), true);
			System.out.println("Making the BufferedReader...");
			in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
		} catch (UnknownHostException e) {
			System.err.println(e);
			System.err.println("Don't know about host: web6.jhuep.com");
			System.exit(1);
		} catch (IOException e) {
			System.err.println(e);
			System.err.println("Couldn't get I/O for " + "the connection to: web6.jhuep.com.");
			System.exit(1);
		}
		System.out.println("Constructing queryString...");
		// TODO: the problem here is connecting the sockets here to the userIput constructed in the action function
		String userInput = "1:2008:7:1:3";		
		String echo;	
		out.println(userInput);
		echo = in.readLine();
		System.out.println(echo);
		out.close();
		in.close();
		echoSocket.close();
        System.out.println("----End of Main Method----");
        
    }
}


/*
 * ClientThread.java
 * 
 * Created on Nov 4, 2007
 * Updated on June 22, 2019 for eclipse
 * DRAWN HEAVILY from the lecture notes for homework
 */

package BHCMultithreading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Generate a threaded client to a local server
 */
public class ClientThread extends Thread {

    private final Socket socket;
    
    public ClientThread(Socket clientSocket) {
        this.socket = clientSocket;
    }
    
    public void run () {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println("Welcome to Markham's BHC Multithreaded server\n\rType \"bye\" to disconnect\n\r");
            String outputLine = null;
            while (!socket.isClosed()) {
                outputLine = in.readLine();
                if (outputLine == null) {
                    break;
                }
                if (outputLine.equalsIgnoreCase("bye")) {
                    break;
                } else {
                    String responseLine = generateResponse(outputLine);
                    out.println("Your input of: " + outputLine);
                    out.println("Generates an output of...");
                    out.println(responseLine);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /** 
     * Receive an input to from the client and triage to an output
     *
     * @param inputString
     * 		hike_id:begin_year:begin_month:begin_day:duration (e.g: 1:2008:7:1:3)
     * @return responseString
     */
    public String generateResponse(String inputString) {
    	String responseString = "";
    	
        try {
            String[] clientInputs = inputString.split(":");
            
            for (String a: clientInputs)
                System.out.println(a);
            
            System.out.println("There were " + clientInputs.length + " arguments passed in.");
            
            // wrong number of arguments
            if (clientInputs.length != 5) {
                responseString = "$-0.01: You passed in the wrong number of argument(s). You passed in " + clientInputs.length + " arguments. The server expects 4. (e.g: 1:2008:7:1:3).";
                return responseString;
            }
            
            // wrong type of arguments
            int hikeId = 0;
            int startYear = 0;
            int startMonth = 0;
            int startDay = 0;
            int duration = 0;
            try {
                hikeId = Integer.parseInt(clientInputs[0]); 
                startYear = Integer.parseInt(clientInputs[1]); 
                startMonth = Integer.parseInt(clientInputs[2]); 
                startDay = Integer.parseInt(clientInputs[3]); 
                duration = Integer.parseInt(clientInputs[4]); 
            } catch (NumberFormatException e){
            	responseString = "$-0.01: One of your passed in arguments could not be converted to an integer " + e;
                return responseString;
            }
            
            responseString = "$50: pseudo value but that needs to connect your valid inputs to a generator function or server";            
        } catch (Exception e) {
        	System.out.println(e);
        }
        
        // return the cost cost followed by a ":", followed by some text. 
        	// If things go well, you'll give the cost and the text "Quoted Rate"
        
        // if there is a problem, the cost will by -0.01 and the text will have some explanation.
    	return responseString;
    }
}


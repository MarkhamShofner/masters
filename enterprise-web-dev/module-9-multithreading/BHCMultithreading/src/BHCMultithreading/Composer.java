package BHCMultithreading;

import java.io.*;
import java.net.*;

/**
 *
 * Main class for creating a socket server and generating 
 * threads which are clients for socket
 * BASED HEAVILY ON THE NOTES FROM THE LECTURE
 */
public class Composer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        
        try {
            serverSocket = new ServerSocket(20008);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 20008.");
            System.exit(1);
        }

        Socket clientSocket = null;
        while (true) {
            clientSocket = serverSocket.accept();
            ClientThread thread = new ClientThread(clientSocket);
            thread.start();
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfixexpressor;

// TODOs 

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

    // file input output

// General plan
    // operator class
    // operand class
        // checks if valid, throw errors if not
    // stack class

/**
 *
 * @author mark8604
 */
public class PostfixExpressor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("main");
        // read the data
        try ( FileReader fr = new FileReader("../ProvidedStrings.txt"))
        {
            int c;
            while((c = fr.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
        
        
        try ( BufferedWriter bw = new BufferedWriter (new FileWriter("../OutputStrings.txt")) )
        {
            bw.append("Placeholder Output Strings");
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
        
    }
    
}



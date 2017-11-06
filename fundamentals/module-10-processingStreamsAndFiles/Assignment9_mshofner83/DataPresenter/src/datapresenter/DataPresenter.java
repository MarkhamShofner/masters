/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datapresenter;
import java.io.*;

/**
 *
 * @author mark8604
 */
public class DataPresenter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("File: ../SmallAreaIncomePovertyEstDataManipulated.txt");
        System.out.println("Id" + " \t " + "Population" + " \t " + "ChildPop" + " \t " + "CPovPop" + " \t " +  "CPovPop%");

        // read the data
        try ( FileReader fr = new FileReader("../SmallAreaIncomePovertyEstDataManipulated.txt"))
        {
            int c;
            while((c = fr.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
        
    }
    
    


//        (second report) Note before the report is displayed, a single line with “File: “ then the path of the input file for the report is displayed.
//             summary report which calculate basic statistics at the state level.

//        The second program will have 2 run-time parameters,
//            the input file path and
//            the number of records.
    
}

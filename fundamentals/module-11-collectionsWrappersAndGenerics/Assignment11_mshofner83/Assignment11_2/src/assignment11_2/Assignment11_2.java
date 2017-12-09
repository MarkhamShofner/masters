/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment11_2;
import java.util.*;

/**
 *
 * @author mark8604
 */
public class Assignment11_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int printTime;
        long rnSeed = 100;
        LinkedList<Integer> ll = new LinkedList<Integer>();
        Random rnGenerator = new Random( rnSeed ); // creates a Random object

        for (int i = 0; i < 10; i ++) {
            printTime = rnGenerator.nextInt( 1000 ) + 10; // next int in range 10-1000
            ll.add(printTime);
        }
        
        System.out.println(ll);
    }
}

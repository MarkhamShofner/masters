/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3_1;
import java.util.Scanner;
/**
 *
 * @author mark8604
 */
public class Assignment3_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Grab initial inputs from the user
        Scanner input = new Scanner (System.in);
        System.out.println("How many asterisks would you like to show (max)");
        int displayNumber = input.nextInt();
        System.out.println("Would you prefer your asterisks to be shown in increasing (enter '1') or decreasing (enter '2') order");
        int displayChoice = input.nextInt();
        
        // Show the asterisks in increasing order
        if (displayChoice == 1) {
            for (int i = 0; i < displayNumber; i++) {
                for (int j = 0; j <= i; j ++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
        
        // Show the asterisks in a decreasing order
        else if (displayChoice == 2) {
            for (int i = displayNumber; i > 0; i--) {
                for (int j = i; j > 0; j --) {
                    System.out.print("*");
                }
                System.out.println();
            }
        } 
        
        else {
            System.out.print("Please rerun the program and input '1' or '2' as a display choice");
        }
    }
    
}

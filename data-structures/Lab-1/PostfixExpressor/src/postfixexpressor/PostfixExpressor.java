/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfixexpressor;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author mark8604
 */
public class PostfixExpressor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // set up file read and write
        try {
            FileReader fr = new FileReader("../ProvidedStrings.txt"); // input file
            int c;
            int fileCount = 1;
            while((c = fr.read()) !=-1) {
                String inputString = "";
                try {
                    while ((c = fr.read()) != 10) {
                        System.out.println(c);
                        char cChar = intValue(c);
                        inputString = inputString+cChar;
                        System.out.println(inputString);
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e); 
                }
                String translatedString = translatePostfix(inputString);
                System.out.println("--------------------");
                System.out.println(translatedString);

                // open, transfer, and close file writer
                FileWriter fw = new FileWriter("../OutputStrings" + fileCount + ".txt"); // output file
                fw.write(translatedString);
                fw.close();
                fileCount++;
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
        
    public static char intValue (int i) throws Exception {
        char charValue;
        // values we want that are NOT in the 65 to 95 range. i.e. \n, +, -, *, /
        if (i==10 || i==42 || i==43 || i==45 || i==47) {
            charValue = (char) i;
        } 
        // range to throw exceptions
        else if (i<65 || i>90) {
            charValue = 0;
            throw new Exception("This character is not in the acceptable range");
        } 
        // range of acceptable uppercase letters
        else { 
            charValue = (char) i;
        }
        return charValue;
    }
    
    public static String translatePostfix (String pString) {
        String translatedString = "";
        PostfixStack myPostfixStack = new PostfixStack();  
        int varMule = 100;
        for (int j=0; j<pString.length(); j++) {
            int i = pString.charAt(j);
            // if it's an operator, pop the stack twice and perform an operation 
            // with those values and push the result back onto the stack
            if (isOperator(i)) { 
                char iChar = (char) i;
                char c = (char) myPostfixStack.pop();
                char d = (char) myPostfixStack.pop();
                     
                int t = varMule;
                int varCount = t-99;
                varMule++;
                myPostfixStack.push(t);

                String cString;
                String dString;
                String varString = "TEMP"+varCount;
                String convertedOperator = translateOperator(iChar);

                if (c>99) {
                    int cCount = c-99;
                    cString = "TEMP"+cCount;
                } else {
                    cString = "" + c;
                }
                if (d>99) {
                    int dCount = d-99;
                    dString = "TEMP"+dCount;
                } else {
                    dString = "" + d;
                }
                
                
                translatedString = translatedString + "LD " + "\t"+ dString + "\n";
                translatedString = translatedString + convertedOperator + "\t"+ cString + "\n";
                translatedString = translatedString + "ST " + "\t" + varString + "\n";
            } else { // if it's an operand, push it onto the stack
                myPostfixStack.push(i);
            }
        }
        return translatedString;
    }
    
    // translateOperatior
    public static String translateOperator (int i) {
        switch (i) {
            default:
                System.out.println("How did you get here");
                return "NO";
            case 42:
                return "ML";
            case 43:
                return "AD";
            case 45:
                return "SB";
            case 47:
                return "DV";
        }
    }
    
    public static boolean isOperator (int i) {
        // +, -, *, /
        return i==42 || i==43 || i==45 || i==47; 
    }
}

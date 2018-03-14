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
 * Translate postfix expressions to machine language based on input values
 * And output those values to named .txt files
 * @author Markham Shofner
 */
public class PostfixExpressor {

    /**
     * set up file read, postfix translate, and file write
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // open up the file reader
            FileReader fr = new FileReader("../InputStrings/**ProvidedStrings.txt"); // input file
            int c;
            int fileCount = 1; // starting count for file names, may increase
            // while the file reader has characters
            while((c = fr.read()) !=-1) {
                String inputString = "";
                String errorString = "";
                try {
                    // until a new line
                    while ((c = fr.read()) != 10) {
                        char cChar = intValue(c);
                        inputString = inputString+cChar;
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e); 
                    errorString = "" + e;
                }
                // translate the passed in postfix string
                String translatedString = translatePostfix(inputString);
                System.out.println("--------------------");
                System.out.println(translatedString);

                // open, transfer, and close file writer
                FileWriter fw = new FileWriter("../OutputStrings/Output" + fileCount + ".txt");
                fw.write("input: A" + inputString + "\n-------------\n"); //input string
                fw.write(translatedString); // translated string
                fw.write(errorString); // error messages
                fw.close(); // close the connection
                fileCount++; // bump file name for future output files
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }
    
    // return acceptable values and throw errors for inputs outside that range
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
    
    // take a postfix string and return a machine language version of that string
    public static String translatePostfix (String pString) {
        String translatedString = "";
        PostfixStack myPostfixStack = new PostfixStack();  
        int varMule = 100; // safe int values to hold variable count for TEMPX
        for (int j=0; j<pString.length(); j++) {
            int i = pString.charAt(j);
            // if it's an operator, pop the stack twice and perform an operation 
            // with those values and push the result back onto the stack
            if (isOperator(i)) { 
                char iChar = (char) i;
                char c = (char) myPostfixStack.pop();
                char d = (char) myPostfixStack.pop();
                
                // determine which variable# we are on
                int t = varMule;
                int varCount = t-99;
                varMule++;
                
                // push onto the stack
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
                
                // Add to the constructed translatedString as appropriate
                translatedString = translatedString + "LD " + "\t"+ dString + "\n";
                translatedString = translatedString + convertedOperator + "\t"+ cString + "\n";
                translatedString = translatedString + "ST " + "\t" + varString + "\n";
            } else { // if it's an operand, push it onto the stack
                myPostfixStack.push(i);
            }
        }
        return translatedString;
    }
    
    // String return of the operator value of the int passed in
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
    
    // boolean return on whether or not the int passed in represents an operator
    public static boolean isOperator (int i) {
        // +, -, *, /
        return i==42 || i==43 || i==45 || i==47; 
    }
}

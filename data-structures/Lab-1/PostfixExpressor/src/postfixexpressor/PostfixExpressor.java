/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfixexpressor;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

 
// operators/operands on off the stack in the right order

// TD - temp variables for data 

// map the operators to text language


// producing the machine language (strings) around that

/**
 *
 * @author mark8604
 */
public class PostfixExpressor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // set up the stack
//        PostfixStack myPostfixStack = new PostfixStack();
        
        translatePostfix("AB+C-");
        
        return;

        // read the data
        try {
            FileReader fr = new FileReader("../ProvidedStrings.txt"); // input file
            FileWriter fw = new FileWriter("../OutputStrings.txt"); // output file

            int c;
            while ((c = fr.read()) != -1) { // read and process one character
                if (isOperator(c)) { // replace all occurrences of 'a' with '@'
                    myPostfixStack.push(c);
                    System.out.println(myPostfixStack.head);
                    System.out.println('0');
                    fw.write('t');
                }
                else { 
                    fw.write(c);
                    myPostfixStack.push(c);
                    System.out.println(myPostfixStack.head.data);
                    char testChar;
                    try {
                        testChar = intValue(c);
                    } catch (Exception e) {
                        testChar = 0;
                        System.out.println("Error: " + e);
                    }
                    System.out.println(testChar);
//                    System.out.println('1');
                }
            }
            System.out.println(myPostfixStack);
            fw.close();
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

//        pString = "ABC+*CBA-+*";
//        pString = "ABC+*/";
//        pString ="ABCD-+*EF*-";
        pString ="ABC*+DE-/";

        System.out.println(pString);
  
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
                
                String varString = "TEMP"+varCount;

                myPostfixStack.push(t);
                
                String cString;
                String dString;
                
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
                
                String convertedOperator = translateOperator(iChar);
                
                System.out.println("LD " + "\t"+ dString);
                System.out.println(convertedOperator + "\t"+ cString);
                System.out.println("ST " + "\t" + varString);                
            } else { // if it's an operand, push it onto the stack
                myPostfixStack.push(i);
            }

        }
        System.out.println("Translated String: " + translatedString);
        return translatedString; // 
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
                return "ST";
            case 47:
                return "DV";
        }
    }
    
    public static boolean isOperator (int i) {
        // +, -, *, /
        return i==42 || i==43 || i==45 || i==47; 
    }
    
    public static int operatorPrecedence (int i) {
        int operatorPrecedence = 0;
        if (i==43 || i==45) { // +,- have a lower precedence
            operatorPrecedence = 1;
        } else if (i==42 || i==47) { // *,/ have a higher precedence
            operatorPrecedence = 2;
        }
        return operatorPrecedence;
    }
}

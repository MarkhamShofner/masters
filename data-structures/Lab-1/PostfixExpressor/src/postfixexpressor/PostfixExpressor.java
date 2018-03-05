/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfixexpressor;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
        // set up the stack
        PostfixStack myPostfixStack = new PostfixStack();

        // read the data
        try {
            FileReader fr = new FileReader("../ProvidedStrings.txt"); // input file
            FileWriter fw = new FileWriter("../OutputStrings.txt"); // output file

            int c;
            while ((c = fr.read()) != -1) { // read and process one character
                if (c=='a') { // replace all occurrences of 'a' with '@'
                    fw.write('t');
                    myPostfixStack.push(c);
                    System.out.println(myPostfixStack.head);
                    System.out.println('0');
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
    
    public static boolean isOperator (int i) {
        return i<60; // TODO or whatever i is
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

//        System.out.println(myPostfixStack.isEmpty() + "  :empty?");
//        myPostfixStack.push('a');
//        System.out.println(myPostfixStack.head.data + "  data");
//        System.out.println(myPostfixStack.head.next + "  next");
//        System.out.println(myPostfixStack.isEmpty() + "  :empty?");
//        myPostfixStack.push('b');
//        System.out.println(myPostfixStack.head.data + "  data");
//        System.out.println(myPostfixStack.head.next + "  next");
//        System.out.println(myPostfixStack.isEmpty() + "  :empty?");
//        myPostfixStack.push('c');
//        System.out.println(myPostfixStack.head.data + "  data");
//        System.out.println(myPostfixStack.head.next + "  next");
//        System.out.println(myPostfixStack.isEmpty() + "  :empty?");
//        myPostfixStack.push('d');
//        System.out.println(myPostfixStack.head.data + "  data");
//        System.out.println(myPostfixStack.head.next + "  next");
//        System.out.println(myPostfixStack.isEmpty() + "  :empty?");
//        myPostfixStack.push('e');
//        System.out.println(myPostfixStack.head.data + "  data");
//        System.out.println(myPostfixStack.head.next + "  next");
//        System.out.println(myPostfixStack.isEmpty() + "  :empty?");
//        myPostfixStack.push('f');
//        System.out.println(myPostfixStack.head.data + "  data");
//        System.out.println(myPostfixStack.head.next + "  next");
//        System.out.println(myPostfixStack.isEmpty() + "  :empty?");
//        myPostfixStack.pop();
//        System.out.println(myPostfixStack.head.data + "  data");
//        System.out.println(myPostfixStack.head.next + "  next");
//        System.out.println(myPostfixStack.isEmpty() + "  :empty?");
//        myPostfixStack.pop();
//        System.out.println(myPostfixStack.head.data + "  data");
//        System.out.println(myPostfixStack.head.next + "  next");
//        System.out.println(myPostfixStack.isEmpty() + "  :empty?");
//        myPostfixStack.pop();
//        System.out.println(myPostfixStack.head.data + "  data");
//        System.out.println(myPostfixStack.head.next + "  next");
//        System.out.println(myPostfixStack.isEmpty() + "  :empty?");
//        myPostfixStack.pop();
//        System.out.println(myPostfixStack.head.data + "  data");
//        System.out.println(myPostfixStack.head.next + "  next");
//        System.out.println(myPostfixStack.isEmpty() + "  :empty?");
//        myPostfixStack.pop();
//        System.out.println(myPostfixStack.head.data + "  data");
//        System.out.println(myPostfixStack.head.next + "  next");
//        System.out.println(myPostfixStack.isEmpty() + "  :empty?");
//        myPostfixStack.pop();
//        System.out.println(myPostfixStack.head.data + "  data");
//        System.out.println(myPostfixStack.head.next + "  next");
//        System.out.println(myPostfixStack.isEmpty() + "  :empty?");
//        myPostfixStack.pop();
//        System.out.println(myPostfixStack.head.data + "  data");
//        System.out.println(myPostfixStack.head.next + "  next");
//        System.out.println(myPostfixStack.isEmpty() + "  :empty?");
//        myPostfixStack.pop();
//        System.out.println(myPostfixStack.head.data + "  data");
//        System.out.println(myPostfixStack.head.next + "  next");
//        System.out.println(myPostfixStack.isEmpty() + "  :empty?");
//        myPostfixStack.pop();
//        System.out.println(myPostfixStack.head.data + "  data");
//        System.out.println(myPostfixStack.head.next + "  next");
//        System.out.println(myPostfixStack.isEmpty() + "  :empty?");
//        myPostfixStack.pop();
//        System.out.println(myPostfixStack.head.data + "  data");
//        System.out.println(myPostfixStack.head.next + "  next");
//        System.out.println(myPostfixStack.isEmpty() + "  :empty?");
//        myPostfixStack.pop();
//        System.out.println(myPostfixStack.head.data + "  data");
//        System.out.println(myPostfixStack.head.next + "  next");
//        System.out.println(myPostfixStack.isEmpty() + "  :empty?");
//        myPostfixStack.pop();
//        System.out.println(myPostfixStack.head.data + "  data");
//        System.out.println(myPostfixStack.head.next + "  next");
//        System.out.println(myPostfixStack.isEmpty() + "  :empty?");
    
}

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
        // read the data
        try {
            FileReader fr = new FileReader("../ProvidedStrings.txt"); // input file
            FileWriter fw = new FileWriter("../OutputStrings.txt"); // output file

            int c;
            while ((c = fr.read()) != -1) { // read and process one character
                if (c=='a') { // replace all occurrences of 'a' with '@'
                    fw.write('t');
                    System.out.println('0');
                }
                else { 
                    fw.write('t');
                    System.out.println('1');
                }
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        } 

        PostfixStack myPostfixStack = new PostfixStack();

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
}

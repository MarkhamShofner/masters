/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towersofhanoi;

//import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * And output those values to named .txt files
 * @author Markham Shofner
 */
public class TowersOfHanoi {

    /**
     * set up file read, postfix translate, and file write
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (String s: args) {
            System.out.println(s);
        }

        int n = 9;
        initializeStacks(n);
    }

    public static void initializeStacks (int n) {
        DiscStack stackA = new DiscStack(n, "A");
        DiscStack stackB = new DiscStack("B");
        DiscStack stackC = new DiscStack("C");

        long startTime;
        long endTime;
        long totalTime;
        long totalTimeSeconds;

        try {
            FileWriter fw = new FileWriter("../OutputMoves/Moves.txt");
            startTime = System.nanoTime();
            moveStackRecursively(stackA, stackB, stackC, stackA.size, fw);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            totalTimeSeconds = totalTime / 1000000000;
            fw.write("\n-------------\n It took " + totalTime + " nano seconds to solve the Towers of Hanoi for " + n + " discs.");
            System.out.println("\n-------------\n It took " + totalTime + " nano seconds (" + totalTimeSeconds + " seconds rounding down) to solve the Towers of Hanoi for " + n + " discs.");
            fw.close();
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }

    // recursive solution
    // public static void moveStack (int n, DiscStack A, DiscStack B, DiscStack C) {
    public static void moveStackRecursively (DiscStack giveStack, DiscStack receiveStack, DiscStack otherStack, int n, FileWriter fw) {
//        System.out.println("------------------------------------------ " + n);
        try {
            if (n == 0) { // base case where the initial stack somehow empty
                // throw some sort of error
                return;
            } else if (n == 1) { // base case where there is one disc left
                fw.write("Move disc " + n + " from tower " + giveStack.name + " to tower " + receiveStack.name + "\n");
//                System.out.println("Move disc " + n + " from tower " + giveStack.name + " to tower " + receiveStack.name);
                receiveStack.push(giveStack.pop());
            } else {
                moveStackRecursively(giveStack, otherStack, receiveStack, n-1, fw); // giveStack.size);
                fw.write("Move disc " + n + " from tower " + giveStack.name + " to tower " + receiveStack.name + "\n");
//                System.out.println("Move disc " + n + " from tower " + giveStack.name + " to tower " + receiveStack.name);
                receiveStack.push(giveStack.pop());
                moveStackRecursively(otherStack, receiveStack, giveStack, n-1, fw); //giveStack.size);

    //            System.out.println("Stack [" + giveStack.name + "] -- Top Disc (" + giveStack.peek() + ")");
    //            System.out.println("Stack [" + receiveStack.name + "] -- Top Disc (" + receiveStack.peek() + ")");
    //            System.out.println("Stack [" + otherStack.name + "] -- Top Disc (" + otherStack.peek() + ")");
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }



    // iteratively
    public static void moveStackIteratively(DiscStack giveStack, DiscStack receiveStack, DiscStack otherStack, int n) {
        System.out.println("n: " + n);
        double i = Math.pow(2, n) - 1;
        double j = 0;
        System.out.println("i: " + i);

        DiscStack tempStack = new DiscStack("temp");
        while (j < i) { //
            j++;
            System.out.println(j);

            while (n > 0) {
                System.out.println("Move disc " + giveStack.head.data + " from tower " + giveStack.name + " to tower " + receiveStack.name);
                receiveStack.push(giveStack.pop());
                tempStack = otherStack;
                otherStack = receiveStack;
                receiveStack = tempStack;
                n--;
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towersofhanoi;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Solve the Towers of Hanoi problem for n discs (specific number passed in via
 * the command line) And output the answer to named .txt file
 *
 * @author Markham Shofner
 */
public class TowersOfHanoi {

    /**
     * set up # of discs, name of output file, and whether to solve to problem
     * recursively or iteratively
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("-------------Start Of Main Method-------------");
        String solvingMethod = args[0];
        int n = Integer.parseInt(args[1]);
        n = 4;
        solvingMethod = "i";
        String fn;
        if (args.length < 3) {
            fn = "moves";
        } else {
            fn = args[2];
        }
        if (solvingMethod.equals("r")) {
            System.out.println("Recursively solving the Towers of Hanoi problem.");
        } else if (solvingMethod.equals("i")) {
            System.out.println("Iteratively solving the Towers of Hanoi problem.");
        } else {
            throw new java.lang.RuntimeException("incorrect first argument for solving");
        }
        System.out.println("Working on " + n + " discs");
        System.out.println("Writing to ../OutputMoves/" + fn + ".txt");
        initializeStacks(n, solvingMethod, fn);
    }

    // set up the stacks and parameters (file name, # of discs) before calling the
    // recursive or iterative moveStack() function
    public static void initializeStacks(int n, String solvingMethod, String fileName) {
        // declare and initialize the three stacks, with stack A containing all the discs to start
        DiscStack stackA = new DiscStack(n, "A");
        DiscStack stackB = new DiscStack("B");
        DiscStack stackC = new DiscStack("C");

        // declare variables that will be used to track execution time
        long startTime;
        long endTime;
        long totalTime;
        long totalTimeSeconds;

        // create a file writer, start the timer, and solve the problem
        try (FileWriter fw = new FileWriter("../OutputMoves/" + fileName + ".txt")) {
            startTime = System.nanoTime();
            if (solvingMethod.equals("r")) {
                moveStackRecursively(stackA, stackB, stackC, stackA.size, fw);
            } else if (solvingMethod.equals("i")) {
                moveStackIteratively(stackA, stackB, stackC, stackA.size, fw);
            }
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            totalTimeSeconds = totalTime / 1000000000;
            fw.write("\n-------------\n It took " + totalTime + " nano seconds (" + totalTimeSeconds + " seconds rounding down) to solve the Towers of Hanoi for " + n + " discs.");
            System.out.println("\n-------------\n It took " + totalTime + " nano seconds (" + totalTimeSeconds + " seconds rounding down) to solve the Towers of Hanoi for " + n + " discs.");
        } catch (IOException e) { // catch any IO errors and print to the console
            System.out.println("I/O Error: " + e);
        }
    }

    // recursively solve the problem by pushing and popping discs off of and onto stacks until
    // reaching the base case where no more discs are left
    public static void moveStackRecursively(DiscStack giveStack, DiscStack receiveStack, DiscStack otherStack, int n, FileWriter fw) {
        try {
            if (n == 0) { // base case where the initial stack somehow empty
                // throw some sort of error
                throw new java.lang.RuntimeException("Unreachable base case reached");
            } else if (n == 1) { // base case where there is one disc left
                fw.write("Move disc " + n + " from tower " + giveStack.name + " to tower " + receiveStack.name + "\n");
                System.out.println(n + " from " + giveStack.name + " to " + receiveStack.name);
                receiveStack.push(giveStack.pop());
            } else { // body of the recursive function
                moveStackRecursively(giveStack, otherStack, receiveStack, n - 1, fw);
                fw.write("Move disc " + n + " from tower " + giveStack.name + " to tower " + receiveStack.name + "\n");
                System.out.println(n + " from " + giveStack.name + " to " + receiveStack.name);
                System.out.println("--------------------------------------");
                receiveStack.push(giveStack.pop());
                moveStackRecursively(otherStack, receiveStack, giveStack, n - 1, fw);
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }

    public static void moveStackIteratively(DiscStack giveStack, DiscStack receiveStack, DiscStack otherStack, int n, FileWriter fw) {
        try {
            double i = Math.pow(2, n) - 1;
            double j = 1;
            boolean useSmallestDisc = true;
            int flipDestination = 1;

            DiscStack[] stackOrderArray = new DiscStack[3];
            stackOrderArray[0] = giveStack;
            stackOrderArray[1] = receiveStack;
            stackOrderArray[2] = otherStack;

            DiscStack A = giveStack;
            DiscStack B = receiveStack;
            DiscStack C = otherStack;
            DiscStack tempStack = new DiscStack("temp");

            while (j <= i) {
                if (useSmallestDisc) {
                        System.out.print("pre " + giveStack.name);
                        System.out.print(receiveStack.name);
                        System.out.println(otherStack.name);
                    // find where
                    if ((giveStack.head != null) && (giveStack.head.data == 1)) {
                        System.out.println("in the smallest disc giveStack");
                    } 
    //                else if (receiveStack.head.data == 1) {
    //                    System.out.println("in the smallest disc receiveStack");
    //                    tempStack = giveStack;
    //                    giveStack = receiveStack;
    //                    receiveStack = otherStack;
    //                    otherStack = tempStack;
    //                } 
                    else {
                        System.out.println("in the smallest disc auxStack");
                        tempStack = giveStack;
                        giveStack = otherStack;
                        otherStack = tempStack;
                    }

                    if (flipDestination % 3 == 0) {
                        tempStack = otherStack;
                        otherStack = receiveStack;
                        receiveStack = tempStack;
                    }

                        System.out.print("post " + giveStack.name);
                        System.out.print(receiveStack.name);
                        System.out.println(otherStack.name);

                    System.out.println(giveStack.head.data + " <smallest> from " + giveStack.name + " to " + receiveStack.name);
                    fw.write("Move disc " + giveStack.head.data + " from tower " + giveStack.name + " to tower " + receiveStack.name + "\n");
                    receiveStack.push(giveStack.pop());

                    flipDestination++;
                } else {
                        System.out.print("pre " + giveStack.name);
                        System.out.print(receiveStack.name);
                        System.out.println(otherStack.name);
                    // find the next smallest top of stack
                    //            if 
    //                if ((otherStack.head != null) && (giveStack.head.data > otherStack.head.data)) {
    //                    if (giveStack.head.data > otherStack.head.data) {
    //                        tempStack = giveStack;
    //                        giveStack = otherStack;
    //                        otherStack = tempStack;
    //                    }
    //                }
                    if (giveStack.head == null) {
                        System.out.println("givestackNULL---------------------------------");
                        tempStack = giveStack;
                        giveStack = otherStack;
                        otherStack = tempStack;
                    }
                    tempStack = otherStack;
                    otherStack = receiveStack;
                    receiveStack = tempStack;

                                        System.out.print("post " + giveStack.name);
                        System.out.print(receiveStack.name);
                        System.out.println(otherStack.name);

                    System.out.println(giveStack.head.data + " <2ndsmallest> from " + giveStack.name + " to " + receiveStack.name);
                    giveStack.head.destinationStack = receiveStack.name;
                    fw.write("Move disc " + giveStack.head.data + " from tower " + giveStack.name + " to tower " + receiveStack.name + "\n");
                    receiveStack.push(giveStack.pop());
                }

                // alternate between smallest and next smallest 
                useSmallestDisc = !useSmallestDisc;
                j++;
            }
        } catch (IOException e) {
            System.out.println("I/O Error: " + e);
        }
    }

    // iteratively solve the problem
    public static void mMoveStackIteratively(DiscStack giveStack, DiscStack receiveStack, DiscStack otherStack, int n, FileWriter fw) {
        double i = Math.pow(2, n) - 1;
        double j = 1;
        System.out.println("i: " + i);
        System.out.println("n: " + n);

        DiscStack tempStack = new DiscStack("temp");
        while (j <= i) {
            if (j % 2 == 1) {
                if (receiveStack.head.data == 1) {
                    tempStack = giveStack;
                    giveStack = receiveStack;
//                    receiveStack = tempStack.head.destinationStack;
                }
                System.out.println(giveStack.head);
                if (giveStack.head.destinationStack.equals(receiveStack.name)) {

                } else if (giveStack.head.destinationStack == otherStack.name) {
                    tempStack = receiveStack;
                    receiveStack = otherStack;
                    otherStack = receiveStack;
                }

                System.out.println(giveStack.head.data + " <1> from " + giveStack.name + " to " + receiveStack.name);
                receiveStack.push(giveStack.pop());
            } else {
                if (giveStack.head.data % 2 == 1) { // if the disc is odd
                    //        moveStackRecursively(giveStack, otherStack, receiveStack, n-1, fw);
                    //                System.out.println(giveStack.head.data + " " + giveStack.name);
                    System.out.println("j:" + j);
                    System.out.println(giveStack.head.data + " from " + giveStack.name + " to " + receiveStack.name);
                    //                String tempPrevious = giveStack.head.previousStack;

                    if (giveStack.head.destinationStack == receiveStack.name) {

                    } else if (giveStack.head.destinationStack == otherStack.name) {
                        tempStack = receiveStack;
                        receiveStack = otherStack;
                        otherStack = receiveStack;
                    }

                    giveStack.head.destinationStack = receiveStack.name;
                    //                giveStack.head.previousStack = giveStack.head.destinationStack;
                    System.out.println(giveStack.head.data + " <2a> from " + giveStack.name + " to " + receiveStack.name);
                    receiveStack.push(giveStack.pop());
                    //                tempStack = otherStack;
                    //                otherStack = receiveStack;
                    //                receiveStack = tempStack;
                } else {
                    //                            moveStackRecursively(otherStack, receiveStack, giveStack, n-1, fw);
                    //                if (giveStack.isEmpty()) {
                    //                    tempStack = giveStack;
                    //                    giveStack = otherStack;
                    //                    otherStack = tempStack;
                    //                }
                    tempStack = otherStack;
                    otherStack = receiveStack;
                    receiveStack = tempStack;

                    //                System.out.println(giveStack.head.data + " " + giveStack.name);
                    System.out.println("j:" + j);
                    System.out.println(giveStack.head.data + " <2b> from " + giveStack.name + " to " + receiveStack.name);
                    receiveStack.push(giveStack.pop());

                    //                tempStack = otherStack;
                    //                otherStack = receiveStack;
                    //                receiveStack = tempStack;
                    //                if (receiveStack.head.data > otherStack.head.data) {
                    //                    tempStack = giveStack;
                    //                    giveStack = otherStack;
                    //                    otherStack = tempStack;
                    //                } 
                }
            }
//                else {
//                }

//                if (j % 3 == 1) {
//                    System.out.println(giveStack.head.data + " from " + giveStack.name + " to " + receiveStack.name);
//                    receiveStack.push(giveStack.pop());
//                    tempStack = otherStack;
//                    otherStack = receiveStack;
//                    receiveStack = tempStack;
//                } else if (j % 3 == 2) {
//                                   System.out.println(giveStack.head.data + " from " + giveStack.name + " to " + receiveStack.name);
//                    receiveStack.push(giveStack.pop());
//                    tempStack = giveStack;
//                    giveStack = otherStack;
//                    otherStack = tempStack;
//          
//                } else if (j % 3 == 0) {
//                                    System.out.println(giveStack.head.data + " from " + giveStack.name + " to " + receiveStack.name);
//                    receiveStack.push(giveStack.pop());
//                    tempStack = giveStack;
//                    giveStack = otherStack;
//                    otherStack = receiveStack;
//                    receiveStack = tempStack;
//                }
//             
            j++;
        }
    }
}

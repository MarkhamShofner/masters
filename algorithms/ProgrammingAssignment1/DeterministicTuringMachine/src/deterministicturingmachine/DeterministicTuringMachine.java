/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deterministicturingmachine;

import java.util.ArrayList;

/**
 * This application can create a Turing Machine based on a set of given states,
 * a read/write tape, and a transition (new state, tape write, move direction)
 * based on every input state/tape combination. This file contains the primary
 * logic of the app, setting up the necessary tape/state and running the conditional flow.
 * The output is a qY(yes) or qN(no) based on which of those states the machine reached.
 * @author MarkhamShofner
 */
public class DeterministicTuringMachine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("-------------Start Of Main Method-------------");

        // *USER*: add your tape (any combination of 0s and 1s between the starting and ending -1)
        ArrayList<Integer> tapeArrayList = new ArrayList();
        tapeArrayList.add(-1); // start the tape with a "b" value of -1 to avoid index out of bounds issues
        tapeArrayList.add(1);
        tapeArrayList.add(1);
        tapeArrayList.add(0);
        tapeArrayList.add(1);
        tapeArrayList.add(0);
        tapeArrayList.add(0);
        tapeArrayList.add(0);
        tapeArrayList.add(0);
        tapeArrayList.add(-1); // end the tape with a "b" value of -1 to avoid index out of bounds issues

        // create the TuringMachine based on the user identified tape
        TuringMachine myTM = new TuringMachine(tapeArrayList);

        // add the TransitionActions options from the table
        myTM.addTransitionActionToOptions("q0", 0, "q0", 0, 1);
        myTM.addTransitionActionToOptions("q0", 1, "q0", 1, 1);
        myTM.addTransitionActionToOptions("q0", -1, "q1", -1, -1);
        myTM.addTransitionActionToOptions("q1", 0, "q2", -1, -1);
        myTM.addTransitionActionToOptions("q1", 1, "q3", -1, -1);
        myTM.addTransitionActionToOptions("q1", -1, "qN", -1, -1);
        myTM.addTransitionActionToOptions("q2", 0, "qY", -1, -1);
        myTM.addTransitionActionToOptions("q2", 1, "qN", -1, -1);
        myTM.addTransitionActionToOptions("q2", -1, "qN", -1, -1);
        myTM.addTransitionActionToOptions("q3", 0, "qN", -1, -1);
        myTM.addTransitionActionToOptions("q3", 1, "qN", -1, -1);
        myTM.addTransitionActionToOptions("q3", -1, "qN", -1, -1);

        // initialize the move, writeState, and writeTape values that will be constantly overwritten in our loop
        int move = 0;
        String writeState = "";
        int writeTape = -1;

        myTM.currentState = "q0"; // set our startState before we begin the loop. this will change.
        myTM.currentIndex = 1; // start at 1 (since the tapeArrayList above index of 0 returns -1)

        while (myTM.isStillWorking) { // while loop until finished when isStillWorking is set to false
            // grab the move, writeState, and writeTape values using functions from the TuringMachine class
            move = myTM.findActionMove(myTM.currentState, myTM.tape.get(myTM.currentIndex));
            writeState = myTM.findActionState(myTM.currentState, myTM.tape.get(myTM.currentIndex));
            writeTape = myTM.findActionTape(myTM.currentState, myTM.tape.get(myTM.currentIndex));

            // set the state, write the tape, and move based on the return values above
            myTM.currentState = writeState; // set state
            myTM.tape.set(myTM.currentIndex, writeTape); // write tape
            myTM.currentIndex = myTM.currentIndex + move; // move left or right

            // if either of the end conditions are reached, end the loop
            if ((myTM.currentState == "qY") || (myTM.currentState == "qN")) {
                myTM.isStillWorking = false;
            }
        }
        System.out.println("The Machine Landed on "+myTM.currentState);
        System.out.println("-------------End Of Main Method-------------");
    }
}

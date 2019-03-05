/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deterministicturingmachine;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

/**
 *
 * @author mark8604
 */
public class DeterministicTuringMachine {

    /**
     * @param args the command line arguments
     */
    // set of states
    // tape alphabet
    // for every state and tape option, define the transition (new state, tape write, direction move)
    public static void main(String[] args) {
        System.out.println("-------------Start Of Main Method-------------");

        ArrayList<Integer> myArrayList = new ArrayList();
        myArrayList.add(-1);
        myArrayList.add(1);
        myArrayList.add(1);
        myArrayList.add(0);
        myArrayList.add(1);
        myArrayList.add(0);
        myArrayList.add(0);
        myArrayList.add(0);
        myArrayList.add(0);
        myArrayList.add(-1);
        
        String states[] = { "q0", "q1", "q2", "q3", "qY", "qN" };
        Set statesSet = new HashSet(Arrays.asList(states));

        // implement tape as an array, with values of either 0, 1, or some blank
        TuringMachine myTM = new TuringMachine(myArrayList, statesSet);

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

//        TransitionAction transitionAction = myTM.findTransitionAction("q0", 0); // generate the first action
        int move = 0;
        String writeState = "";
        int writeTape = -1;
        
        myTM.currentState = "q0";
        myTM.currentIndex = 1;

        while (myTM.isStillWorking) { // while loop until finished
            move = myTM.findActionMove(myTM.currentState, myTM.tape.get(myTM.currentIndex));
            writeState = myTM.findActionState(myTM.currentState, myTM.tape.get(myTM.currentIndex));
            writeTape = myTM.findActionTape(myTM.currentState, myTM.tape.get(myTM.currentIndex));
            
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

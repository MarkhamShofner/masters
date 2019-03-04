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
    public static void main(String[] args) {
        System.out.println("-------------Start Of Main Method-------------");
        
        ArrayList<Integer> myArrayList = new ArrayList(); 
        myArrayList.add(1);
        myArrayList.add(1);
        myArrayList.add(0);
        myArrayList.add(1);
        myArrayList.add(0);
        
        String states[] = { "q0", "q1", "q2", "q3", "qY", "qN" };
        Set statesSet = new HashSet(Arrays.asList(states));
        
        // implement tape as an array, with values of either 0, 1, or some blank
        TuringMachine myTuringMachine = new TuringMachine(myArrayList, statesSet);
        
        myTuringMachine.addTransitionActionToOptions("qO", 0, "q0", 0, 1);
        myTuringMachine.addTransitionActionToOptions("qO", 1, "q0", 1, 1);
        myTuringMachine.addTransitionActionToOptions("qO", -1, "q1", -1, -1);
        myTuringMachine.addTransitionActionToOptions("q1", 0, "q2", -1, -1);
        myTuringMachine.addTransitionActionToOptions("q1", 1, "q3", -1, -1);
        myTuringMachine.addTransitionActionToOptions("q1", -1, "qN", -1, -1);
        myTuringMachine.addTransitionActionToOptions("q2", 0, "qY", -1, -1);
        myTuringMachine.addTransitionActionToOptions("q2", 1, "qN", -1, -1);
        myTuringMachine.addTransitionActionToOptions("q2", -1, "qN", -1, -1);
        myTuringMachine.addTransitionActionToOptions("q3", 0, "qN", -1, -1);
        myTuringMachine.addTransitionActionToOptions("q3", 1, "qN", -1, -1);
        myTuringMachine.addTransitionActionToOptions("q3", -1, "qN", -1, -1);

        TransitionAction transitionAction = myTuringMachine.findTransitionAction("q1", 0);
        int move = myTuringMachine.findActionMove("q1", 0);
        String writeState =myTuringMachine.findActionState("q1", 0);
        int writeTape =myTuringMachine.findActionTape("q1", 0);
        System.out.println("Write: "+writeState+", Tape: "+writeTape+", Move: "+move);
        
        for (int i : myTuringMachine.tape) {
            System.out.println("tape reads: "+i); 
        }
        for (String i : myTuringMachine.states) {
            System.out.println("state reads: "+i); 
        }
        for (TransitionAction i : myTuringMachine.transitionOptions) {
            System.out.println("Action input state reads: "+i.inputState); 
        }
        
        System.out.println("-------------End Of Main Method-------------");
    }


    
    // set of states Q
    // tape alphabet S
    // for every q in Q and s in S, define the move
      // move(q,s) = (p,t,D) // in state q with s on the tape, change to state p, write t on the tape, the move the head D (left or right)

    // i. States method, this method should have all of the operations of your TM.
        // 	[one method that does all the methods in the turing machine]
    // ii. Program line that executes the operations for each identified state, this should follow the n-tuple TM as described above for M.
        // 	[18:30ish in module 3]
    // iii. Print method that outputs the change in tape (x ≤ 30) after each transition function is executed.
    // iv. Write method, for tape larger than x > 30 write the outputs to a file
}

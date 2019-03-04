/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deterministicturingmachine;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

/**
 // set of states Q
 // tape alphabet S
 // for every q in Q and s in S, define the move
 // move(q,s) = (p,t,D) // in state q with s on the tape, change to state p, write t on the tape, the move the head D (left or right)
 * @author mark8604
 */
public class TuringMachine {
    // TuringState turingState;
    ArrayList<Integer> tape; // tape array - should hold values of 0, 1, or b
    Set<String> states; // states set - can hold values of q
    Set<TransitionAction> transitionOptions;
 
    
    // Machine constructor
    TuringMachine (ArrayList<Integer> turingArray, Set<String> turingStates) {
        this.transitionOptions = new HashSet<TransitionAction>();
        this.tape = turingArray;
        this.states = turingStates;
    }
    
    // shift tape left
    // shift tape right
    
    // generateTransition
        // receive inputTape, inputState
            // if thens
        // is finished yay/nay?
            // set decision and finish program
        // setState
        // writeTape
        // move
    
    public int findActionMove (String inputState, int inputTape) {
        TransitionAction foundTransitionAction = findTransitionAction (inputState, inputTape);
        return foundTransitionAction.move;
    }
    
    public int findActionTape (String inputState, int inputTape) {
        TransitionAction foundTransitionAction = findTransitionAction (inputState, inputTape);
        return foundTransitionAction.outputTape;
    }
    
    public String findActionState (String inputState, int inputTape) {
        TransitionAction foundTransitionAction = findTransitionAction (inputState, inputTape);
        return foundTransitionAction.outputState;
    }
 
    public TransitionAction findTransitionAction (String inputState, int inputTape) {
        TransitionAction foundTransitionAction = null;
        Iterator<TransitionAction> itrtr = transitionOptions.iterator();
        while(itrtr.hasNext()){
           foundTransitionAction = itrtr.next();
        }
        return foundTransitionAction;
    }
    
    public void addTransitionActionToOptions (String inputState, int inputTape, String outputState, int outputTape, int move) {
        TransitionAction actionToAdd = new TransitionAction(inputState, inputTape, outputState, outputTape, move);
        transitionOptions.add(actionToAdd);
    }
}

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
    String currentState; // current state
    int currentIndex; // current position in the tape
    Set<TransitionAction> transitionOptions;
    boolean isStillWorking; // 
    boolean didFinish; //
    boolean isTrue; // 
 
    
    // Machine constructor
    TuringMachine (ArrayList<Integer> turingArray, Set<String> turingStates) {
        this.transitionOptions = new HashSet<TransitionAction>();
        this.tape = turingArray;
        this.states = turingStates;
        this.isStillWorking = true;
    }
    
    public int findActionMove (String inputState, int inputTape) {
        TransitionAction foundTransitionAction = findTransitionAction (inputState, inputTape);
        System.out.println("fn findActionMove found move of ("+foundTransitionAction.move+") of found state ("+foundTransitionAction.inputState+") and tapeValue ("+foundTransitionAction.inputTape+")");
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
        TransitionAction tempTransitionAction = null;
        Iterator<TransitionAction> itrtr = transitionOptions.iterator();
        while(itrtr.hasNext()){
            tempTransitionAction = itrtr.next();
            if ((tempTransitionAction.inputState == inputState) && (tempTransitionAction.inputTape == inputTape)) {
                foundTransitionAction = tempTransitionAction;
            }
        }
        return foundTransitionAction;
    }
    
    public void addTransitionActionToOptions (String inputState, int inputTape, String outputState, int outputTape, int move) {
        TransitionAction actionToAdd = new TransitionAction(inputState, inputTape, outputState, outputTape, move);
        transitionOptions.add(actionToAdd);
    }
}

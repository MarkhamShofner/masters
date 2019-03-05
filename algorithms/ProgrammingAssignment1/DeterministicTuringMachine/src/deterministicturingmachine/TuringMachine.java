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
 * The TuringMachine class houses the tape itself, the current index of the tape,
 * the current state, the transition options (which can be thought of as a table),
 * and boolean trackers regarding whether the machine isStillWorking, if it didFinish
 * and whether or not the result isTrue.
 * @author Markham Shofner
 */
public class TuringMachine {
    ArrayList<Integer> tape; // tape array - should hold values of 0, 1, or b
    String currentState; // current state
    int currentIndex; // current position in the tape
    Set<TransitionAction> transitionOptions; // options set that the main method adds to
    boolean isStillWorking; // TODO
    boolean didFinish; //
    boolean isTrue; // 
 
    // TuringMachine constructor
    TuringMachine (ArrayList<Integer> turingArray) {
        this.transitionOptions = new HashSet<TransitionAction>(); // initialize an empty options set
        this.tape = turingArray;
        this.isStillWorking = true;
    }
 
    // based on an input state and tape, identify the TransitionAction (output state, tape, and direction)
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
        
    // use the findTransitionAction function and return the output move
    public int findActionMove (String inputState, int inputTape) {
        TransitionAction foundTransitionAction = findTransitionAction (inputState, inputTape);
        System.out.println("fn findActionMove found move of ("+foundTransitionAction.move+") of found state ("+foundTransitionAction.inputState+") and tapeValue ("+foundTransitionAction.inputTape+")");
        return foundTransitionAction.move;
    }
    
    // use the findTransitionAction function and return the output tape
    public int findActionTape (String inputState, int inputTape) {
        TransitionAction foundTransitionAction = findTransitionAction (inputState, inputTape);
        return foundTransitionAction.outputTape;
    }
    
    // use the findTransitionAction function and return the output state
    public String findActionState (String inputState, int inputTape) {
        TransitionAction foundTransitionAction = findTransitionAction (inputState, inputTape);
        return foundTransitionAction.outputState;
    }
    
    // write a transition option to the set of transition options
    public void addTransitionActionToOptions (String inputState, int inputTape, String outputState, int outputTape, int move) {
        TransitionAction actionToAdd = new TransitionAction(inputState, inputTape, outputState, outputTape, move);
        transitionOptions.add(actionToAdd);
    }
}

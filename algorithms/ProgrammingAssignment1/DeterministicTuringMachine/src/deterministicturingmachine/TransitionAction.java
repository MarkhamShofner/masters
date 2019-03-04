/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deterministicturingmachine;

/**
 *
 * @author mark8604
 */
public class TransitionAction {
    int move; // move to make
    String inputState; // state that is read 
    int inputTape; // tape that is read
    String outputState; // state that is written
    int outputTape; // tape that is written
    
    
    // TransitionAction constructor 
    // based on an input state, input tape, and set of transitions
    TransitionAction (String inputState, int inputTape, String outputState, int outputTape, int move) {
        this.move = move;
        this.inputState = inputState;
        this.inputTape = inputTape;
        this.outputState = outputState;
        this.outputTape = outputTape;
    }
    
//    public int returnMove () {
//        return move;
//    }
//    
//    public String returnState () {
//        return outputState;
//    }
//        
//    public int returnTape () {
//        return outputTape;
//    }
}

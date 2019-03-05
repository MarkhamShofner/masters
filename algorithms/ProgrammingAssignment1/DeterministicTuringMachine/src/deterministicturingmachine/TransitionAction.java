/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deterministicturingmachine;

/**
 * The TransitionAction class that simplifies the way we lookup and return options
 * from the "table". Each TransitionAction has a related move, inputState, inputTape,
 * outputState, and outputTape.
 * @author Markham Shofner
 */
public class TransitionAction {
    int move; // move to make
    String inputState; // state that is read 
    int inputTape; // tape that is read
    String outputState; // state that is written
    int outputTape; // tape that is written
    
    // TransitionAction constructor 
    TransitionAction (String inputState, int inputTape, String outputState, int outputTape, int move) {
        this.move = move;
        this.inputState = inputState;
        this.inputTape = inputTape;
        this.outputState = outputState;
        this.outputTape = outputTape;
    }
}

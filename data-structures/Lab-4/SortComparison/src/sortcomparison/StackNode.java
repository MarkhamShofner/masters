/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortcomparison;

/**
 * Node to go in the stack
 * @author Markham Shofner
 */
public class StackNode {
    int nodeData;
    StackNode next; // pointer to the next node in the stack

    // Node constructor
    StackNode (int nodeData) {
        this.nodeData = nodeData;
    }      
}

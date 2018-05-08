/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortcomparison;

/**
 * Node to go in the stack
 * @author mark8604
 */
public class StackNode {
    int nodeArr[]; // data for the node, expressed as an array of integers
    int nodeData;
    StackNode next; // pointer to the next node in the stack
    
    // TODO set the stack as some sort of array
    
    // Node constructor
    StackNode (int nodeArr[]) {
        this.nodeArr = nodeArr;
    }

    // Node constructor
    StackNode (int nodeData) {
        this.nodeData = nodeData;
    }      
}

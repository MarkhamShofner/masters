/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfixexpressor;

/**
 * Node to go in the postfix stack
 * @author Markham Shofner
 */
public class PostfixStackNode {
    int data; // data for the node, expressed as an int
    PostfixStackNode next; // pointer to the next node in the stack
    
    // Node constructor
    PostfixStackNode (int data) {
        this.data = data;
    }
}

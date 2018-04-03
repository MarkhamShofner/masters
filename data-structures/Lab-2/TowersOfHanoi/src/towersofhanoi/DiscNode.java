/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towersofhanoi;

/**
 * Node to go in the DiscStack
 * @author mark8604
 */
public class DiscNode {
    int data; // data for the node, expressed as an int
    DiscNode next; // pointer to the next node in the stack

    // Node constructor
    DiscNode (int data) {
        this.data = data;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquicksort;

/**
 * A list of items with a reference for the top of the stack, initialized to empty
 * @author mark8604
 */
public class Stack {
    // pointer to the top of the stack    
    public StackNode head;
    
    // stack size
    private int size; // = 0;

    // construct the stack
    Stack () {
        this.head = null;
        this.size = 0;
    }
    
    // construct the stack with an array
    Stack (int i) {
        this.head = null;
        this.size = 0;
    }
        
    // create a node based on a provided data value, then push that node onto the stack
    public void push (int i) {
        StackNode node = new StackNode(i);
        if (size == 0) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        size++;
    }
    
    // pop top of stack and return that data
    public int pop() {
        if (this.head != null) {
            int topData = this.head.nodeData;
            this.head = this.head.next;
            this.size--;
            return topData;
        } else {
            int topData = 0; // dummy value
            return topData;
        }
    }
    
    // check to see if the stack is empty
    public boolean isEmpty () {
        return this.size<1;
    }    
}

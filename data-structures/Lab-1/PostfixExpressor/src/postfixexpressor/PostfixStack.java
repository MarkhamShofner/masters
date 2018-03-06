/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfixexpressor;

/**
 * A list of items with a reference for the top of the stack, initialized to empty
 * @author mark8604
 */
public class PostfixStack {
    // pointer to the top of the stack    
    /*private*/ public PostfixStackNode head; // = null;
    
    // stack size
    private int size; // = 0;

    PostfixStack () {
        this.head = null;
        this.size = 0;
    }
    
    // create a node based on a provided data value, then push that node onto the stack
    public void push (int data) {
        PostfixStackNode node = new PostfixStackNode(data);
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
        int topData; 
        if (this.head != null) {
            topData = this.head.data;
            this.head = this.head.next;
            this.size--;
        } else {
            topData = 'z'; // dummy value
        }
        return topData;
    }
    
    public boolean isEmpty () {
        return this.size<1;
    }
}

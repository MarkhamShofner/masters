/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package towersofhanoi;

/**
 * A list of items with a reference for the top of the stack, initialized to empty
 * @author Markham Shofner
 */
public class DiscStack {
    // pointer to the top of the stack    
    public DiscNode head;
    
    // stack size
    public int size; // = 0;
    
    // stack name
    public String name;
    
    // starting stack
    public boolean isStartStack;

    // construct the stack
    DiscStack (String name) {
        this.head = null;
        this.size = 0;
        this.isStartStack = false;
        this.name = name;
    }
    
    // construct the stack
    DiscStack (int n, String name) {
        this.head = null;
        this.size = 0;
        this.isStartStack = true;
        this.name = name;
        while (n > 0) {
            push(n);
            n--;
        }
    }
    
    // create a node based on a provided data value, then push that node onto the stack
    public void push (int data) {
       DiscNode node = new DiscNode(data);
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
            topData = 'A'; // dummy value
        }
        return topData;
    }
    
    // check to see if the stack is empty
    public boolean isEmpty () {
        return this.size<1;
    }    
    
    // peek top of the stack
    public int peek() {
        int topData; 
        if (this.head != null) {
            topData = this.head.data;
        } else {
            topData = 0; // dummy value
        }
        return topData;
    }

    public boolean isPlaceable (int n) {
        return this.head.data > n;
    }    
    
    // set up three separate stacks
        // stack should track the number of discs it has
        // isEmpty
        // disc size of top
        // pop
        // push
    
    // flesh out the rest of the interface
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfixexpressor;

/**
 *
 * @author mark8604
 */
public class PostfixStackNode {
    char data;
    PostfixStackNode next;
    
    PostfixStackNode (char data /*, PostfixStackNode next*/) {
        this.data = data;
//        next = next;
    }
}

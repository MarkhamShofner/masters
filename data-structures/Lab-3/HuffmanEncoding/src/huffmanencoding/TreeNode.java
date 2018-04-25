/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmanencoding;

/**
 * The tree node class houses the Data, Left, and Right pointers that comprise the tree itself, 
 * as well as a String that tracks the binaryTrace needed to get to a certain node. 
 * @author Markham Shofner
 */
public class TreeNode {
    FreqData Data;
    TreeNode Left;
    TreeNode Right;
    String binaryTrace;
    
    // optional future properties for extension
        // parent pointers
        
    // Constructor for Treenode based on FreqData item
    TreeNode(FreqData item) {
        this.Data = item;
        this.Left = null;
        this.Right = null;
        System.out.println("TreeNode(Class):TreeNode(FreqData):: {Data: " + this.Data + "}" + " " + "{Data.value: " + this.Data.value + "}");
    }
    
    // Constructor for TreeNode based on a Left and Right TreeNode
    TreeNode (TreeNode Left, TreeNode Right) {
        this.Data = new FreqData (Left.Data, Right.Data);
        this.Left = Left;
        this.Right = Right;
        System.out.println("TreeNode(Class):TreeNode(FreqData):: {Data: " + this.Data + "}" + " " + "{Data.value: " + this.Data.value + "}"); 
    }
}

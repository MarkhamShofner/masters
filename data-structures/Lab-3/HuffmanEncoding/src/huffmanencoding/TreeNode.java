/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmanencoding;

/**
 *
 * @author mark8604
 */
public class TreeNode {
    FreqData Data;
    TreeNode Left;
    TreeNode Right;
    // TODO - optionally add parent pointers
    
    // could have GetData or SetDate if needed
    
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

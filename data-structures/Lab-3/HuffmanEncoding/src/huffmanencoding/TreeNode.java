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
    
//    TreeNode();
//    could have GetData or SetDate if needed
    TreeNode(FreqData item) {
        this.Data = item;
        this.Left = null;
        this.Right = null;
        System.out.println("TreeNode(Class):TreeNode():: {Data: " + this.Data + "}" + " " + "{Data.value: " + this.Data.value + "}");
    }
}

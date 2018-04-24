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
public class BinaryTree {
    // reference to root
    TreeNode Tree; 
    // reference to node in Tree where actions occur
    TreeNode Here;
    // reference node to make traversal easier
    TreeNode Parent_of_Here;
    // numNodes - optional
    // height - optional
    
    // constructor, initialize empty tree
//    public void BinaryTree() {
    BinaryTree() {
        Tree = null;
        Here = null;
        Parent_of_Here = null;
        System.out.println("BinaryTree(Class):BinaryTree()");
    }
    BinaryTree(FreqData item) {
        this.Tree = new TreeNode(item);
        this.Here = this.Tree;
        this.Parent_of_Here = null;
        System.out.println("BinaryTree(Class):BinaryTree(Item)");
    }
    
    // MakeTree - create tree containing 1 value as root with empty (no) children
        // left
        // data
        // right
    public TreeNode MakeTree(FreqData item) {
        TreeNode Temp = new TreeNode(item);
        Temp.Data = item;
        Temp.Left = null;
        Temp.Right = null;
        return Temp;
    }
    

        
    // SetRight - attach value as right child
        // calls MakeTree method with argument value and attaches the resulting tree as the right child of the parent argument.
        // returns an error if the parent already has a right child
    // add right child [to existing node P]
    public void SetRight (FreqData item) {
        TreeNode P = Here;
        if (P == null) {
            throw new java.lang.RuntimeException("BinaryTree(class):SetRight(method)::Tree Node 'Here' must exist.");
        } else if (P.Right != null) {
            throw new java.lang.RuntimeException("BinaryTree(class):SetRight(method)::Tree Node 'Here' cannot already have a Right child.");
        } else {
            TreeNode Temp = MakeTree (item);
            P.Right = Temp;
        }
    }
    
    // SetLeft (value, parent) - attach value as left child
        // calls MakeTree method with argument value and attaches the resulting tree as the left child of the parent argument.
        // returns an error if the parent already has a left child
    // add left child [to existing node P]
    public void SetLeft (FreqData item) {
        TreeNode P = Here;
        if (P == null) {
            throw new java.lang.RuntimeException("BinaryTree(class):SetLeft(method)::Tree Node 'Here' must exist.");
        } else if (P.Right != null) {
            throw new java.lang.RuntimeException("BinaryTree(class):SetLeft(method)::Tree Node 'Here' cannot already have a Right child.");
        } else {
            TreeNode Temp = MakeTree (item);
            P.Left = Temp;
        }
    } 

    public void TreeInsert (FreqData item, TreeNode Root) {
        if (Root == null) {
            Root = MakeTree (item); // TODO (this.Tree instead of Root?)
        } else if (item.frequency < Root.Data.frequency) {
            // insert at root of the Tree
            TreeInsert (item, Root.Left);
        } else {
            TreeInsert (item, Root.Right);
        }
    // also an iterative version that could be drawn from
    }
    
    // DisplayTree
    public void DisplayTree () {
        System.out.println("BinaryTree(Class):DisplayTree(Method):: " + this.Tree.Data.value);
        System.out.println("BinaryTree(Class):DisplayTree(Method):: " + this.Tree.Right.Data.value);
        System.out.println("BinaryTree(Class):DisplayTree(Method):: " + this.Tree.Right.Right.Data.value);
    }
    
    
    // SearchTree -  look for specified value
    // Search tree for value. Return result in the class variable Here.
    // Sets Here to null if the tree is impty or the item is not present
    public void TreeSearch (FreqData item) { // TODO maybe shift this to the value of the item
        // Start at root of existing tree
        Here = Tree;
        Parent_of_Here = null;
        // look through non-empty tree
        if (Here != null) { 
            while ((Here != null) && (Here.Data != item)) {
                Parent_of_Here = Here;
                if (item.frequency < Here.Data.frequency) { // TODO update the lookup values here
                    Here = Here.Left;
                } else {
                    Here = Here.Right;
                }
            }
            if (Here == null) { // item not in tree
                Parent_of_Here = null;
            }
        }
    }
    
    // TraverseTree - move through tree in orderly fashion
    
    public boolean TreeEmpty() {
        return (Tree == null);
    }
    
}

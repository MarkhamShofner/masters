/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmanencoding;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The binary tree class tracks the root of the tree and where we are in the tree (for an actions). 
 * The binary tree class offers constructors based on a frequency data item, two existing trees, or nothing. 
 * The binary tree class also supports classic methods such as MakeTree, SetRight, SetLeft 
 * as well as additional ones such as DisplayTraverse, PrintInfo and others.  * @author Markham Shofner
 */
public class BinaryTree {
    // reference to root
    TreeNode Tree;
    // reference to node in Tree where actions occur
    TreeNode Here;
    // reference node to make traversal easier
    TreeNode Parent_of_Here;

    // option future data to track
    // numNodes - optional
    // height - optional

    // constructor, initialize empty tree
    BinaryTree () {
        Tree = null;
        Here = null;
        Parent_of_Here = null;
        System.out.println("BinaryTree(Class):BinaryTree()");
    }

    // constructor, initialize tree with a root node that is the item passed in
    BinaryTree (FreqData item) {
        this.Tree = new TreeNode(item);
        this.Here = this.Tree;
        this.Parent_of_Here = null;
        System.out.println("BinaryTree(Class):BinaryTree(Item)");
    }

    // constructor, merge two trees that have already been constructed to form a combined tree
    BinaryTree (BinaryTree LeftTree, BinaryTree RightTree) {
        this.Tree = new TreeNode (LeftTree.Tree, RightTree.Tree);
        this.Here = this.Tree;
        this.Parent_of_Here = null;
        System.out.println("BinaryTree(Class):BinaryTree(Node, Node)");
    }

    // MakeTree - create tree containing 1 value as root with empty (no) children
    public TreeNode MakeTree(FreqData item) {
        TreeNode Temp = new TreeNode(item);
        Temp.Data = item;
        Temp.Left = null;
        Temp.Right = null;
        return Temp;
    }

    // MakeTree from two nodes
    public TreeNode MakeTree (TreeNode LeftNode, TreeNode RightNode) {
        this.Tree = new TreeNode (LeftNode, RightNode);
        this.Here = this.Tree;
        this.Parent_of_Here = null;
        System.out.println("BinaryTree(Class):BinaryTree(Node, Node)");
        return this.Tree;
    }

    // SetRight - attach value as right child [to existing node P]
    // calls MakeTree method with argument value and attaches the resulting tree as the right child of the parent argument.
    // returns an error if the parent already has a right child
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

    // SetLeft (value, parent) - attach value as left child [to existing node P]
    // calls MakeTree method with argument value and attaches the resulting tree as the left child of the parent argument.
    // returns an error if the parent already has a left child
    public void SetLeft (FreqData item) {
        TreeNode P = Here;
        if (P == null) {
            throw new java.lang.RuntimeException("BinaryTree(class):SetLeft(method)::Tree Node 'Here' must exist.");
        } else if (P.Left != null) {
            throw new java.lang.RuntimeException("BinaryTree(class):SetLeft(method)::Tree Node 'Here' cannot already have a Right child.");
        } else {
            TreeNode Temp = MakeTree (item);
            P.Left = Temp;
        }
    }

    // Move through tree in orderly fashion and write the traversal to an external file
    // print the huffman tree with binary values for each letter
    public void DisplayTraverse (TreeNode T, BufferedWriter bw) {
        if (T != null) {
            System.out.println("{value: " + T.Data.value + ", frequency: " + T.Data.frequency + ", binaryTrace: " + T.binaryTrace + "}");
            try {
                bw.write("{value: " + T.Data.value + ", frequency: " + T.Data.frequency + ", binaryTrace: " + T.binaryTrace + "}\n");
            }
            catch (IOException e) {
                System.out.println("Error: " + e);
            }
            DisplayTraverse (T.Left, bw); // visit left subtree
            DisplayTraverse (T.Right, bw); // visit right subtree
        }
    }

    public void AssignTrace (TreeNode T, String trace) {
        if (T != null) {
            T.binaryTrace = trace;
            AssignTrace (T.Left, trace = trace + "0"); // visit left subtree
            trace = trace.substring(0, trace.length()-1);
            AssignTrace (T.Right, trace = trace + "1"); // visit right subtree
        }
    }

    public void printInfo (TreeNode T) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("../OutputFiles/HuffmanTree.txt"))) {
            DisplayTraverse (T, bw);
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    // SearchTree -  look for specified value
    // Search tree for value. Return result.
    public void TreeSearch (TreeNode T, String rawstring, BufferedWriter bw) {        
        if (T != null) {
            if (T.Data.value.equals(rawstring)) {
                try {
                    System.out.print(T.binaryTrace);
                    bw.write(T.binaryTrace);
                }
                catch (IOException e) {
                    System.out.println("Error: " + e);
                }
            }
            TreeSearch (T.Left, rawstring, bw); // visit left subtree
            TreeSearch (T.Right, rawstring, bw); // visit right subtree
        }
    }
    
    public void encodeMessage (TreeNode T, String rawstring) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("../OutputFiles/EncodedMessage.txt"))) {
            for (int i=0; i<rawstring.length(); i++) {
                String str = rawstring.substring(i, i+1);
                str = str.toUpperCase();
                TreeSearch (T, str, bw);
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }
    

    

    // optional methods for future
        // isEmpty ()
}

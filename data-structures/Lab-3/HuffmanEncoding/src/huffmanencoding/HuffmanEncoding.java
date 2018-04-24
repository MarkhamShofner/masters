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
public class HuffmanEncoding {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("aaaaaay");
        
        FreqData a = new FreqData("A", 12);
        FreqData b = new FreqData("B", 1);
        
        BinaryTree bt = new BinaryTree(a);
        bt.SetRight(a);
//        bt.Right.SetRight(b);
        bt.DisplayTree();
    }
    
}

// It is extremely useful to walk through the construction of the tree manually, in order to clarify assumptions.  This is not necessary, but you may get some insights from the exercise.
    // At any given step, chose the two lowest frequency nodes to combine from the overall pool.  You do NOT build the tree incrementally based on the last step, but examine all frequencies, and choose the lowest two at each step.  Initially, these frequencies will all be individual letter frequencies.  In the event of a tie, use the ordering criteria below to identify the two nodes to combine.
    // At each step, you remove from consideration any nodes that have been combined, and replace them with a combined node. 
    // Use the ordering criteria to determine the element that goes to the left when creating a new node.
        // requency, then number of letters, then alphabetical order.  Examples (note that these specific examples may not occur in your tree):
            // Frequency 13 to the left of frequency 14
            // 'K' to the left of 'JV' (if frequencies are the same)
            // 'AK' to the left of 'BL' (if frequencies are the same)

// take frequency table for whole alphabet
// make a huffman tree
    // don't always use the node with that was combined for the next set of the huffman tree
        // consider the nodes with the lowest individual/combined frequency
// print the huffman tree with binary values for each letter
// encode the strings in one file
// decode the binary digits in another file

//build a Huffman Encoding Tree. 
    //Resolve ties by 
        // giving single letter groups precedence (put to the left) over multiple letter groups, 
        // then alphabetically
//read three different files: 
// a file containing the frequency table, //Use the frequency table in the supplied FreqTable.txt file. Consider experimenting
//with other frequency tables.
// a file containing clear text to be encoded. //Encode the strings in the supplied ClearText.txt file, plus several others of your
//choice:
// file containing encoded strings. //Decode the strings the supplied Encoded.txt file, plus some others of your choice:

//As a check, here is a simple string in clear text and encoded form.
//Hello World 1101101000010001111100011111101000000101100









//
//Do not worry about punctuation or capitalization
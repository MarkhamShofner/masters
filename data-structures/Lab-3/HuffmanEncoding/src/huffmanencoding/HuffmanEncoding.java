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
        
        FreqData x = new FreqData("X", 3);
        FreqData y = new FreqData("Y", 1);
        FreqData z = new FreqData("Z", 2);
        FreqData n = new FreqData("N", 4);
        FreqData m = new FreqData("M", 5);
//        
//        FreqData yz = new FreqData("YZ", 3);
//        FreqData xyz = new FreqData("XYZ", 6);
        
//        BinaryTree yzt = new BinaryTree(yz);
//        yzt.SetRight(z);
//        yzt.SetLeft(y);
//        yzt.Traverse(yzt.Tree);
//        
        BinaryTree xt = new BinaryTree (x);
//        xt.Traverse(xt.Tree);
//
//        BinaryTree xyzt = new BinaryTree (xt, yzt);
//        xyzt.Traverse(xyzt.Tree);
  
        
//        int arr[] = {12, 11, 13, 5, 6};
        BinaryTree yt = new BinaryTree (y);
        BinaryTree zt = new BinaryTree (z);
        BinaryTree nt = new BinaryTree (n);
        BinaryTree mt = new BinaryTree (m);
        BinaryTree arr[] = {nt, yt, mt, xt, zt};
//        InsertionSort ob = new InsertionSort();        
        printArray(arr);
        arr = sort(arr);
        printArray(arr);

        
        for (int i=0; i<arr.length-1; ++i)
        {
            arr = combineNodes (arr, i);
            printArray(arr);
            arr = sort(arr);
            printArray(arr);
        }
        BinaryTree finalTree = arr[arr.length-1];
        finalTree.Traverse(finalTree.Tree);
    }
    
    public static BinaryTree[] combineNodes (BinaryTree arr[], int index) {
        BinaryTree newTree = new BinaryTree (arr[index], arr[index+1]);
        arr[index+1] = newTree;
        return arr;
    }
    
    /* The below is sort built on top of work done by Rajat Mishra. https://www.geeksforgeeks.org/insertion-sort/ */
    /*Function to sort array using insertion sort*/
    public static BinaryTree[] sort(BinaryTree arr[])
    {
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int key = arr[i].Tree.Data.frequency;
            int j = i-1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && arr[j].Tree.Data.frequency > key)
            {
                BinaryTree temp = arr[j+1];
                arr[j+1] = arr[j];
                arr[j] = temp;
                j = j-1;
            }
        }
        return arr;
    }
    
    /* A utility function to print array of size n*/
    static void printArray(BinaryTree arr[]) {
        System.out.println("-------------------------------------");
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.println("HuffmanEncoding:printArray(TreeArray):: {Data: " + arr[i].Tree.Data + "}" + " " + "{Data.value: " + arr[i].Tree.Data.value +", Data.frequency: " + arr[i].Tree.Data.frequency + "}");
    }    

//    public static void sort(int arr[])
//    {
//        int n = arr.length;
//        for (int i=1; i<n; ++i)
//        {
//            int key = arr[i];
//            int j = i-1;
//
//            /* Move elements of arr[0..i-1], that are
//               greater than key, to one position ahead
//               of their current position */
//            while (j>=0 && arr[j] > key)
//            {
//                arr[j+1] = arr[j];
//                j = j-1;
//            }
//            arr[j+1] = key;
//        }
//    }
// 
//    /* A utility function to print array of size n*/
//    static void printArray(int arr[])
//    {
//        int n = arr.length;
//        for (int i=0; i<n; ++i)
//            System.out.print(arr[i] + " ");
//        System.out.println();
//    }    
    /* The above code built on top of work done by Rajat Mishra. https://www.geeksforgeeks.org/insertion-sort/ */
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
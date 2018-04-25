/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmanencoding;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 *
 * @author mark8604
 */
public class HuffmanEncoding {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("-------------Start Of Main Method-------------");

        FreqData freqDataArray[] = new FreqData[27];

        // open up the file reader and create the frequency data array
        try(BufferedReader br = new BufferedReader(new FileReader("../InputFiles/FreqTable.txt"))) {
            String line = br.readLine();
            int indexCount = 0;
            while (line != null) {
                String character = line.substring(0,1);
                int frequency = Integer.parseInt(line.substring(4));                
                freqDataArray[indexCount] = new FreqData (character, frequency);
                line = br.readLine();
                indexCount++;
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e); 
        }

        int j = 0;
        int count = 0;
        while (freqDataArray[j] != null) {
            j++;
            count++;
        }
        // create a binary tree array that is as long as the length of the frequency data array
        BinaryTree streamlinedTreeArray[] = new BinaryTree[count];
        for (int i = 0; i<count; i++) {
            streamlinedTreeArray[i] = new BinaryTree(freqDataArray[i]);
        }

        BinaryTree arr[] = streamlinedTreeArray;

        printArray(arr, 0);
        arr = sort(arr);
        printArray(arr, 0);

        for (int i=0; i<arr.length-1; ++i)
        {
            arr = combineNodes (arr, i);
            printArray(arr, i);
            arr = sort(arr);
            printArray(arr, i);
        }
        System.out.println("-------------------********--------------");
        BinaryTree finalTree = arr[arr.length-1];
        finalTree.Traverse(finalTree.Tree);
        
        translateEncoded(finalTree);
        
        System.out.println("-------------End Of Main Method-------------");
    }
    
    public static void translateEncoded (BinaryTree huffTree) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("../OutputFiles/DecodedMessage.txt"))) {
//            String encodedString = "010110010101100111110110111011000010101001101110110110001011001010110001011100011011111111110001000111111101011111011001111111000100011111000001010000001110010111"; // EIEIOHZEPHYRQZULUABRACADABRAMERLIN
//            String encodedString = "01011001010110011111011011"; // EIEIOH
//            String encodedString = "10110000101010011011101101100010110010101100010111000110111"; // ZEPHYRQZULU
//            String encodedString = "11111110001000111111101011111011001111111000100011111000001010000001110010111"; // ABRACADABRAMERLIN
            String encodedString = "1101101000010001111100011111101000000101100"; // HELLOWORLD
            String decodedMessage = "";
            
            // while there is a next val
            int counter = 0;
            while (counter < encodedString.length()) {
                // take next val
                String val = encodedString.substring(counter, counter+1);
                System.out.println("translateEncoded:whileLoop::val" + val);
                if (huffTree.Here.Left != null) {
                    System.out.println("not null");
                    if (val.equals("0")) {
                        System.out.println("0 from " + huffTree.Here.Data.value + " to " + huffTree.Here.Left.Data.value);
                        huffTree.Here = huffTree.Here.Left; 
                    } else {
                        System.out.println("1 from " + huffTree.Here.Data.value + " to " + huffTree.Here.Right.Data.value);
                        huffTree.Here = huffTree.Here.Right; 
                    }
                } else {
                    String foundValue = huffTree.Here.Data.value;
                    System.out.println("returning " + foundValue);                    
                    decodedMessage = decodedMessage + foundValue;
                    huffTree.Here = huffTree.Tree;
                    counter--;
                }
                counter++;
            }
            String foundValue = huffTree.Here.Data.value;
            System.out.println("returning " + foundValue);                    
            decodedMessage = decodedMessage + foundValue;
            System.out.println(decodedMessage);            
            
            bw.write(decodedMessage);
        }
        catch (IOException e) {
            System.out.println("Error: " + e); 
        }
    }
    
    public static BinaryTree[] combineNodes (BinaryTree arr[], int index) {
        // defaults
        BinaryTree Left = arr[index];
        BinaryTree Right = arr[index+1];
        // if three have the same frequency
//        if (arr[index].Tree.Data.frequency == arr[index+1].Tree.Data.frequency) {
//            System.out.println("RED ALERT");
//        }
        // if same frequency
//        if (arr[index].Tree.Data.frequency == arr[index+1].Tree.Data.frequency) {
//            // and if same number chars
//            if (arr[index].Tree.Data.value.length() == arr[index+1].Tree.Data.value.length()) {
//                System.out.println("SAME Length arr[index].Tree.Data.value.length() == " + arr[index].Tree.Data.value.length() +  "== arr[index+1].Tree.Data.value.length()" + arr[index+1].Tree.Data.value.length());
//                // set left to whichever Tree is alphabetically earlier
//                int compare = arr[index].Tree.Data.value.compareTo(arr[index+1].Tree.Data.value);
//                if (compare > 0) {
//                    Left = arr[index+1];
//                    Right = arr[index];
//                }
//            } else {
//                System.out.println("DIFFERENT Length arr[index].Tree.Data.value.length() == " + arr[index].Tree.Data.value.length() +  "== arr[index+1].Tree.Data.value.length()" + arr[index+1].Tree.Data.value.length());
//                // set left as whichever Tree has fewer characters
//                if (arr[index+1].Tree.Data.value.length() < arr[index].Tree.Data.value.length()) {
//                    Left = arr[index+1];
//                    Right = arr[index];
//                }
//            }
//        } else {
//            System.out.println("DIFF Freq");
////            BinaryTree newTree = new BinaryTree (arr[index], arr[index+1]);
////            arr[index+1] = newTree;
//        }
        BinaryTree newTree = new BinaryTree (Left, Right);
        arr[index+1] = newTree;
        return arr;
    }
    
    
    public static BinaryTree[] sort(BinaryTree arr[]) {
        frequencySort(arr);
        lengthSort(arr);
        alphabeticalSort(arr);
        return arr;
    }
    
    /* The below sort is built on top of work done by Rajat Mishra. https://www.geeksforgeeks.org/insertion-sort/ */
    /*Function to sort array using insertion sort*/
    public static BinaryTree[] frequencySort(BinaryTree arr[])
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
    
    public static BinaryTree[] lengthSort(BinaryTree arr[])
    {
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int key = arr[i].Tree.Data.frequency;
            int j = i-1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j>=0 && arr[j].Tree.Data.frequency == key)
            {
                // set left as whichever Tree has fewer characters
                if (arr[j+1].Tree.Data.value.length() < arr[j].Tree.Data.value.length()) {
                    System.out.println("zomg DIFFERENT Length arr[index].Tree.Data.value.length() == " + arr[j].Tree.Data.value +  "== arr[index+1].Tree.Data.value.length()" + arr[j+1].Tree.Data.value);
                    BinaryTree temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
                j = j-1;
            }
        }
        return arr;
    }
    
    public static BinaryTree[] alphabeticalSort(BinaryTree arr[])
    {
        int n = arr.length;
        for (int i=1; i<n; ++i)
        {
            int key = arr[i].Tree.Data.frequency;
            int j = i-1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while ((j>=0 && arr[j].Tree.Data.frequency == key) && arr[j+1].Tree.Data.value.length() == arr[j].Tree.Data.value.length())
            {
                // set left to whichever Tree is alphabetically earlier
                int compare = arr[j].Tree.Data.value.compareTo(arr[j+1].Tree.Data.value);
                if (compare > 0) {
                    System.out.println("Length arr[index].Tree.Data.value.length() == " + arr[j].Tree.Data.value.length() +  "== arr[index+1].Tree.Data.value.length()" + arr[j+1].Tree.Data.value.length());
                    BinaryTree temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
                j = j-1;
            }
        }
        return arr;
    }
    
        //Resolve ties by 
        // giving single letter groups precedence (put to the left) over multiple letter groups, 
        // then alphabetically
    
    
    /* A utility function to print array of size n*/
    static void printArray(BinaryTree arr[], int index) {
        System.out.println("-------------------------------------");
        int n = arr.length;
        for (int i=index; i<n; ++i) {
//            System.out.println("HuffmanEncoding:printArray(TreeArray):: {Data: " + arr[i].Tree.Data + "}" + " " + "{Data.value: " + arr[i].Tree.Data.value +", Data.frequency: " + arr[i].Tree.Data.frequency + "}");
        }
    }     
    /* The above sort is built on top of work done by Rajat Mishra. https://www.geeksforgeeks.org/insertion-sort/ */
}

// It is extremely useful to walk through the construction of the tree manually, in order to clarify assumptions.  This is not necessary, but you may get some insights from the exercise.
    // At any given step, chose the two lowest frequency nodes to combine from the overall pool.  You do NOT build the tree incrementally based on the last step, but examine all frequencies, and choose the lowest two at each step.  Initially, these frequencies will all be individual letter frequencies.  In the event of a tie, use the ordering criteria below to identify the two nodes to combine.
    // At each step, you remove from consideration any nodes that have been combined, and replace them with a combined node. 
    // Use the ordering criteria to determine the element that goes to the left when creating a new node.
        // frequency, then number of letters, then alphabetical order.  Examples (note that these specific examples may not occur in your tree):
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
// read three different files: 
// a file containing the frequency table, //Use the frequency table in the supplied FreqTable.txt file. Consider experimenting
//with other frequency tables.
// a file containing clear text to be encoded. //Encode the strings in the supplied ClearText.txt file, plus several others of your
//choice:
// file containing encoded strings. //Decode the strings the supplied Encoded.txt file, plus some others of your choice:


//As a check, here is a simple string in clear text and encoded form.
//Hello World 1101101000010001111100011111101000000101100




//Do not worry about punctuation or capitalization
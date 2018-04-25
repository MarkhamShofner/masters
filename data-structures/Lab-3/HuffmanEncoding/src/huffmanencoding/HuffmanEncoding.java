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
        arr = sort(arr);

        for (int i=0; i<arr.length-1; ++i)
        {
            arr = combineNodes (arr, i);
            arr = sort(arr);
        }
        System.out.println("-------------------********--------------");
        BinaryTree finalTree = arr[arr.length-1];
        
        finalTree.AssignTrace(finalTree.Tree, "");
        finalTree.printInfo(finalTree.Tree);
        
        translateEncoded(finalTree);
        
        System.out.println("-------------End Of Main Method-------------");
    }
    
    public static void printInfo (String treeString) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("../OutputFiles/HuffmanTree.txt"))) {
            bw.write(treeString);
        }
        catch (IOException e) {
            System.out.println("Error: " + e); 
        }
    }
    
    public static void translateEncoded (BinaryTree huffTree) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("../OutputFiles/DecodedMessage.txt"))) {
//            String encodedString = "010110010101100111110110111011000010101001101110110110001011001010110001011100011011111111110001000111111101011111011001111111000100011111000001010000001110010111"; // EIEIOHZEPHYRQZULUABRACADABRAMERLIN
//            String encodedString = "01011001010110011111011011"; // EIEIOH
//            String encodedString = "10110000101010011011101101100010110010101100010111000110111"; // ZEPHYRQZULU
            String encodedString = "11111110001000111111101011111011001111111000100011111000001010000001110010111"; // ABRACADABRAMERLIN
//            String encodedString = "1101101000010001111100011111101000000101100"; // HELLOWORLD
            String decodedMessage = "";
            
            // while there is a next val
            int counter = 0;
            while (counter < encodedString.length()) {
                // take next val
                String val = encodedString.substring(counter, counter+1);
                if (huffTree.Here.Left != null) {
                    if (val.equals("0")) {
                        huffTree.Here = huffTree.Here.Left; 
                    } else {
                        huffTree.Here = huffTree.Here.Right; 
                    }
                } else {
                    String foundValue = huffTree.Here.Data.value;
                    decodedMessage = decodedMessage + foundValue;
                    huffTree.Here = huffTree.Tree;
                    counter--;
                }
                counter++;
            }
            String foundValue = huffTree.Here.Data.value;
            decodedMessage = decodedMessage + foundValue;
            System.out.println("Encoded message: " + encodedString);
            System.out.println("Decoded Message: " + decodedMessage);            
            
            bw.write("Encoded message: " + encodedString + "\n");
            bw.write("Decoded Message: " + decodedMessage);
        }
        catch (IOException e) {
            System.out.println("Error: " + e); 
        }
    }
    
    // combine the first two BinaryTrees in an array into a single BinaryTree
    public static BinaryTree[] combineNodes (BinaryTree arr[], int index) {
        BinaryTree newTree = new BinaryTree (arr[index], arr[index+1]);
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
 
            while (j>=0 && arr[j].Tree.Data.frequency == key)
            {
                // set left as whichever Tree has fewer characters
                if (arr[j+1].Tree.Data.value.length() < arr[j].Tree.Data.value.length()) {
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
 
            while ((j>=0 && arr[j].Tree.Data.frequency == key) && arr[j+1].Tree.Data.value.length() == arr[j].Tree.Data.value.length())
            {
                // set left to whichever Tree is alphabetically earlier
                int compare = arr[j].Tree.Data.value.compareTo(arr[j+1].Tree.Data.value);
                if (compare > 0) {
                    BinaryTree temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
                j = j-1;
            }
        }
        return arr;
    }
    
    static void printArray(BinaryTree arr[], int index) {
        System.out.println("-------------------------------------");
        int n = arr.length;
        for (int i=index; i<n; ++i) {
            System.out.println("HuffmanEncoding:printArray(TreeArray):: {Data: " + arr[i].Tree.Data + "}" + " " + "{Data.value: " + arr[i].Tree.Data.value +", Data.frequency: " + arr[i].Tree.Data.frequency + "}");
        }
    }     
    /* The above sort is built on top of work done by Rajat Mishra. https://www.geeksforgeeks.org/insertion-sort/ */
}

// encode the strings in one file

// decode the binary digits in another file

// read three different files: 
    // a file containing the frequency table, //Use the frequency table in the supplied FreqTable.txt file. Consider experimenting
    // with other frequency tables.
    // a file containing clear text to be encoded. //Encode the strings in the supplied ClearText.txt file, plus several others of your
    // choice:
    // file containing encoded strings. //Decode the strings the supplied Encoded.txt file, plus some others of your choice:

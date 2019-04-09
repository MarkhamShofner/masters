/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquicksort;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.io.IOException;

/**
 *
 * @author mark8604
 */
public class PAQuickSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("-------------Start Of Main Method-------------");
        
        // set up the file read variables
        String fileInput = "asc10000.dat"; // [USER] ran50.dat dup20k.dat rev5k.dat etc...

        // use regex to replace all non integers with an empty string
        String intString = fileInput.replaceAll("[^0-9]", "");
        int dataSize = Integer.parseInt(intString);
        // set size of array based on file input
        int dataArray[] = new int[dataSize];
        int length = dataArray.length;

        // open up the file reader and create the data array
        try(BufferedReader br = new BufferedReader(new FileReader("../InputData/" + fileInput))) {
            System.out.println("---Begin File Read---");
            int c;
            int r;
            int i = 0;
            String numberString = "";

            while ((r = br.read()) != -1) {
                char ch = (char) r;
                // if a space, new line, or carriage return
                if (((r) == 32) || ((r) == 10) || ((r) == 13)) {
                    if (numberString.trim().length() > 0) {
                        dataArray[i] = Integer.parseInt(numberString);
                        i++;
                    }
                    numberString = "";
                } else {
                    numberString = numberString + ch;
                }
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }
        
        // we can declare "medianOf3", "median", or "first" to compare different partitioning strategies
        // [USER] toggle the below two lines to chose which type of pivot we use
//        double totalMoves = iterativeQuickSort (dataArray, 20, "first"); // setting 20 as the static base size for insertion sort
        double totalMoves = iterativeQuickSort (dataArray, 20, "medianOf3"); // setting 20 as the static base size for insertion sort

        // create a file writer, start the timer, and solve the problem
        try (FileWriter fw = new FileWriter("../OutputData/" + fileInput + ".out")) {
            for (int m=0; m<dataArray.length; ++m) {
                fw.write("\n" + dataArray[m]);
                System.out.println(dataArray[m]);
            }
            fw.write("\n TotalMoves " + totalMoves);
        } catch (IOException e) { // catch any IO errors and print to the console
            System.out.println("I/O Error: " + e);
        }
        System.out.println(totalMoves);
        
        
        System.out.println("-------------END Of Main Method-------------");   
    }
    
    // Iterative QuickSort, divides the data into 2 partitions separated by a pivot
    // Determines the style of type of QuickSort based on a pased in flag
    // based on pseudocode from data structures
    public static double iterativeQuickSort (int arr[], int caseNum, String pivot) {
        // increment on each push/pop. 
        double numMoves = 0; // won't be a perfect measure of the number (esp wrt insertion sorts, but will be close in terms of bigOh style reduction
        Stack quickStack = new Stack();

        // initial start and end values put on the stack
        quickStack.push(0);
        numMoves++;
        quickStack.push(arr.length-1);
        numMoves++;

        while (!quickStack.isEmpty()) {
            int k = quickStack.pop();
            numMoves++;
            int i = quickStack.pop();
            numMoves++;
            if (i >= k) { // stopping case
            } else {
                // find the partition
                int p = partition (arr, i, k, pivot);
                int partSize = k-i;
                if (partSize < caseNum) { // insertionSort() if the caseNum is met
                    insertionSort(arr, arr.length);
                    numMoves += 20; // adding 20 as the base partition size
                } else {
                    // second group on first since it's a stack
                    quickStack.push(p+1);
                    numMoves++;
                    quickStack.push(k);
                    numMoves++;
                    // first group on second since it's a stack
                    quickStack.push(i);
                    numMoves++;
                    quickStack.push(p);
                    numMoves++;
                }
            }
        }
        return numMoves;
    }
    
    // partition function 
    public static int partition (int arr[], int i, int k, String pivotType) {
        int l = 0;
        int h = 0;
        int pivot = 0;
        int midpoint = 0;
        int temp = 0;
        boolean done = false;

        if (pivotType.equals("first")) {
            // Pick first element as pivot
            pivot = arr[i];
        } else if (pivotType.equals("median")) {
            midpoint = i + (k-i) / 2;
            pivot = arr[midpoint];
        } else if (pivotType.equals("medianOf3")) {
            midpoint = i + (k-i) / 2;
            int low = arr[i];
            int medium = arr[midpoint]; 
            int high = arr[k];
            int optionsArray[] = new int[] {low, medium, high};
            pivot = medianOfThree(optionsArray);
        }

        l = i;
        h = k;

        while (!done) {
            // Increment l while numbers[l] < pivot
            while (arr[l] < pivot) {
                ++l;
            }
            // Decrement h while pivot < arr[h]
            while (pivot < arr[h]) {
              --h;
            }
            // If there are zero or one elements remaining,
            // all arr are partitioned. Return h
            if (l >= h) {
                done = true;
            }
            else {
                // Swap arr[l] and arr[h],
                // update l and h
                temp = arr[l];
                arr[l] = arr[h];
                arr[h] = temp;

                ++l;
                --h;
            }
        }
        return h;
    }
    
    public static int medianOfThree(int[] optionsArray) {
        int median = 0;
//        System.out.println("[0]"+optionsArray[0]+"[1]"+optionsArray[1]+"[2]"+optionsArray[2]);
        Arrays.sort(optionsArray); // lean on sort method for cleaner code
        median = optionsArray[1];
//        System.out.println("Chosen: "+median);
        return median;
    }
    
    // insertion sort based on pseudocode from data structures
    public static void insertionSort (int arr[], int size) {
        int i = 0;
        int j = 0;
        int temp = 0;  // Temporary variable for swap
        for (i = 1; i < size; ++i) {
            j = i;
            // Insert numbers[i] into sorted part
            // stopping once numbers[i] in correct position
            while (j > 0 && arr[j] < arr[j - 1]) {

              // Swap arr[j] and arr[j - 1]
              temp = arr[j];
              arr[j] = arr[j - 1];
              arr[j - 1] = temp;
              --j;
            }
        }
    }

}

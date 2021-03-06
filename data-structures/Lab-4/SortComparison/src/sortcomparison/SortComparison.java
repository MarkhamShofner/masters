/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortcomparison;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * Sort a series of integers based on a passed in data file a selected algorithm
 * Supported algorithms include QuickSort (with a few different implementations)
 * and HeapSort.
 * @author Markham Shofner
 */
public class SortComparison {

    /**
     * Set up the data array based on the data file,
     * Call the requested sorting function, determine the total time
     * required by the sort, and write the ordered file
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("-------------Start Of Main Method-------------");
        System.out.println("file input: " + args[0] + ", selected algorithm: " + args[1]);

        String fileInput = args[0]; // ran50.dat dup20k.dat rev5k.dat etc...
        String algorithm = args[1]; // quick1 quick2 quick3 quick4 heap

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

        System.out.println("Running " + algorithm + " sort on " + fileInput);
        
        // determine the totalTime, and call the sortTriage function
        long totalTime = sortTriage (dataArray, algorithm);

        // create a file writer, start the timer, and solve the problem
        try (FileWriter fw = new FileWriter("../OutputData/" + fileInput + ".out")) {
            for (int m=0; m<dataArray.length; ++m) {
                fw.write("\n" + dataArray[m]);
                System.out.println(dataArray[m]);
            }
            fw.write("\n TotalTime " + totalTime);
        } catch (IOException e) { // catch any IO errors and print to the console
            System.out.println("I/O Error: " + e);
        }
        System.out.println(totalTime);
    }

    // triage the passed in array and algorithm into the proper sorting subroutine
    // returns the length of time a sort operation took
    public static long sortTriage (int arr[], String algorithm) {
        long startTime = 0;
        long endTime = 0;
        // the below timing variables for the case statements are a bit repetitive
        // but we want them as close as possible to the sorting subroutines
        switch (algorithm) {
            case "quick1":
                startTime = System.nanoTime();
                iterativeQuickSort(arr, 3, "first");
                endTime = System.nanoTime();
                break;
            case "quick2":
                startTime = System.nanoTime();
                iterativeQuickSort(arr, 51, "first");
                endTime = System.nanoTime();
                break;
            case "quick3":
                startTime = System.nanoTime();
                iterativeQuickSort(arr, 101, "first");
                endTime = System.nanoTime();
                break;
            case "quick4":
                startTime = System.nanoTime();
                iterativeQuickSort(arr, 3, "median");
                endTime = System.nanoTime();
                break;
            case "heap":
                startTime = System.nanoTime();
                heapSort(arr, arr.length);
                endTime = System.nanoTime();
                break;
            default:
                System.out.println("You shouldn't be here: Improper algorithm argument -- " + algorithm);
        }
        long totalTime = endTime - startTime;
        return totalTime;
    }

    // insertion sort. based on the ZyBooks pseudocode
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

    // Iterative QuickSort, divides the data into 2 partitions separated by a pivot
    // Determines the style of type of QuickSort based on a pased in flag
    // based on the recursive ZyBooks pseudocode and built from there
    public static void iterativeQuickSort (int arr[], int caseNum, String pivot) {
        Stack quickStack = new Stack();

        // initial start and end values put on the stack
        quickStack.push(0);
        quickStack.push(arr.length-1);

//        System.out.println("-start loop-");
        while (!quickStack.isEmpty()) {
//            System.out.println("-loop iteration-");
            int k = quickStack.pop();
            int i = quickStack.pop();
            if (i >= k) { // stopping case
//                System.out.println("stopping case");
            } else {
                // find the partition
                int p = partition (arr, i, k, pivot);
                int partSize = k-i;
//                System.out.println("p: " + p + " partSize: " + partSize);
                if (partSize < caseNum) { // insertionSort() if the caseNum is met
                    insertionSort(arr, arr.length);
                } else {
                    // second group on first since it's a stack
                    quickStack.push(p+1);
                    quickStack.push(k);
                    // first group on second since it's a stack
                    quickStack.push(i);
                    quickStack.push(p);
                }
            }
        }
//        System.out.println("-end loop-");
    }

    // partition function. based on the ZyBooks pseudocode
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

    // recurisve QuickSort. based on the ZyBooks pseudocode
    public static void recursiveQuickSort (int arr[], int i, int k) {
        for (int j=0; j<arr.length; ++j) {
            System.out.println(arr[j]);
        }
        int p = 0;
        if (i >= k) {
            return;
        }
        // Partition the data within the array. Value j returned
        // from partitioning is location of last element in low partition.
        p = partition(arr, i, k, "first");

        // Recursively sort low partition (i to j) and
        // high partition (j + 1 to k)
        recursiveQuickSort(arr, i, p);
        recursiveQuickSort(arr, p + 1, k);

        for (int j=0; j<arr.length; ++j) {
            System.out.println(arr[j]);
        }
    }

    
    // Build the heap and then extract the elements in sorted order from the heap.
    // based on the ZyBooks pseudocode
    public static void heapSort (int arr[], int length) {
        // Heapify the array
        for (int i = length / 2 - 1; i >= 0; i--) {
            MaxHeapPercolateDown(i, arr, length);
        }
        // Remove the maximum value, store that value at the end index (since that is where the highest val should go in an ordered array)
        // then Decrement the end index, until the end index is 0.
        for (int i = length - 1; i > 0; i--) {
            int tempInt = arr[0];
            arr[0]=arr[i];
            arr[i]=tempInt;
            MaxHeapPercolateDown(0, arr, i);
        }
    }

    // MaxHeapPercolateDown. based on the ZyBooks pseudocode
    public static int MaxHeapPercolateDown(int nodeIndex, int heapArray[], int arraySize) {
        int childIndex = 2 * nodeIndex + 1;
        int value = heapArray[nodeIndex];

        while (childIndex < arraySize) {
            // Find the max among the node and all the node's children
            int maxValue = value;
            int maxIndex = -1;
            for (int i = 0; i < 2 && i + childIndex < arraySize; i++) {
                if (heapArray[i + childIndex] > maxValue) {
                    maxValue = heapArray[i + childIndex];
                    maxIndex = i + childIndex;
                }
            }

            if (maxValue == value) {
                  return value;
            }
            else {
                int tempInt = heapArray[nodeIndex];
                heapArray[nodeIndex] = heapArray[maxIndex];
                heapArray[maxIndex] = tempInt;
                nodeIndex = maxIndex;
                childIndex = 2 * nodeIndex + 1;
            }
        }
        return -1;
    }
}

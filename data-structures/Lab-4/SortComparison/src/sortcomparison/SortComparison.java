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
 *
 * @author mark8604
 */
public class SortComparison {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("-------------Start Of Main Method-------------");

        int dataArray[] = new int[50]; // TODO grab size of array based on file input

        // open up the file reader and create the data array
        try(BufferedReader br = new BufferedReader(new FileReader("../InputData/ran50.dat"))) {
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
                        System.out.println("--" + numberString + "--");
                        
                        dataArray[i] = Integer.parseInt(numberString);
                        i++;
                    }
                    numberString = "";
                } else {
                    numberString = numberString + ch;
                    System.out.println("Add " + ch + " to " + numberString);
                }
            }
        }
        catch (IOException e) {
            System.out.println("Error: " + e);
        }

        int arr[] = {3, 5, 7, 1, 2, 99, 12, -1, 45, 69, 100000};
//        int length = arr.length;
        int length = dataArray.length;
//        heapSort(dataArray, length);
//       quickSort(arr, 0, arr.length-1);
        quickSort(dataArray, 0, dataArray.length-1);
//        for (int i=0; i<dataArray.length; ++i) {
//            System.out.println(dataArray[i]);
//        }
    }


    // pull from zybook for quicksort roots

    public static void quickSort (int arr[], int i, int k) {
        for (int j=0; j<arr.length; ++j) {
            System.out.println(arr[j]);
        }
        int p = 0;
        if (i >= k) {
            return;
        }
        // Partition the data within the array. Value j returned
        // from partitioning is location of last element in low partition.
        p = partition(arr, i, k);


        // Recursively sort low partition (i to j) and
        // high partition (j + 1 to k)
        quickSort(arr, i, p);
        quickSort(arr, p + 1, k);

        for (int j=0; j<arr.length; ++j) {
            System.out.println(arr[j]);
        }
    }

    public static int partition (int arr[], int i, int k) {
        int l = 0;
        int h = 0;
        int pivot = 0;
        int temp = 0;
        boolean done = false;

        // Pick first element as pivot
        pivot = arr[i];

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

    // Quicksort
        // (divides the data into 2 partitions separated by a pivot)
        // The first partition contains all the items which are smaller than the pivot.
        // The remaining items are in the other partition
        // 4 versions:
            // first item as pivot, partition of size one and two as a stopping case
                // While the partition size of two may stop with two elements that are not in sorted order, you can trivially test them directly and swap as appropriate
            // first item as pivot, stopping case of a partition of size k=100. then insertion sort
            // first item as pivot, stopping case of a partition of size k=50. then insertion sort
            // median-of-three as the pivot. Treat a partition of size one and two as a stopping case. 

    // insertion sort
        // linked implementation better?
    
    // Build the heap and then extract the elements in sorted order from the heap.
    public static void heapSort (int arr[], int length) {
        for (int i=0; i<length; ++i) {
            System.out.println(arr[i]);
        }

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
        System.out.println("---------------------------");
        for (int i=0; i<length; ++i) {
            System.out.println(arr[i]);
        }
        //        return sortedArr;
    }

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

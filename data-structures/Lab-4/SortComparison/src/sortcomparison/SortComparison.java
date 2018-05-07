/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortcomparison;

/**
 *
 * @author mark8604
 */
public class SortComparison {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int arr[] = {3, 5, 7, 1, 2, 99, 12, -1, 45, 69, 100000};
        int length = arr.length;
        heapSort(arr, length);
    }
            
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
                // swap heapArray[nodeIndex] and heapArray[maxIndex]
                int tempInt = heapArray[nodeIndex];
                heapArray[nodeIndex] = heapArray[maxIndex];
                heapArray[maxIndex] = tempInt;
                nodeIndex = maxIndex;
                childIndex = 2 * nodeIndex + 1;
            }
        }
        return 1001;
    }
    
    // pull from zybook for quicksort roots
    
    // Quicksort 
        // (divides the data into 2 partitions separated by a pivot)
        // The first partition contains all the items which are smaller than the pivot. 
        // The remaining items are in the other partition
        // 4 versions:
            // first item as pivot, partition of size one and two as a stopping case
                // While the partition size of two may stop with two elements that are not in sorted order, you can trivially test them directly and swap as appropriate
            // first item as pivot, stopping case of a partition of size k=100. then insertion sort
            // first item as pivot, stopping case of a partition of size k=50. then insertion sort
    
    // insertion sort
        // linked implementation better?
    
       
    

    // Notes:
    //both be recursive or both be iterative, so that the overhead of recursion will not be a factor in your
    //comparisons. In this case iteration is recommended, but you are free to choose recursion

}

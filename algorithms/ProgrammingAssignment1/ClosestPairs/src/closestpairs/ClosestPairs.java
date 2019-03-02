/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package closestpairs;

//import java.lang.*;

/**
 *
 * @author mark8604
 */
public class ClosestPairs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("-------------Start Of Main Method-------------");

        // manually declare the two dimensional array
        // these example arrays can be toggled on and off with comments

        // small size - 3x4
//        int[][]testArray  =  {
//            { 0, 0, 1, 0 },
//            { 1, 0, 0, 0 },
//            { 0, 1, 0, 0 }
//        };

        // medium size 3x14
//        int[][]testArray  =  {
//            { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
//            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0 },
//            { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 }
//        };

        // large size 3x32
        int[][]testArray  =  {
            { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0 }
        };

        bruteforceAlgorithm(testArray);

        System.out.println("-------------End Of Main Method-------------");
    }

    public static void bruteforceAlgorithm (int arr[][]) {
        // iterate through the entire two dimensional array
            // compare each valid point to every other valid point
            // shove the valid distances (and the points related to the distance) into another array
        // then iterate through the distances array
            // find the element with the lowest distance (and the points the distance is between)

        int arrWidth = arr[0].length;
        int arrHeight = arr.length;
        System.out.println("arrary width: " + arrWidth);
        System.out.println("array height: " + arrHeight);

        // declare the tracking points for the below for loops
        int[] pointA = {0,0};
        int[] pointB = {0,0};
        double minimumDistance = -1; // initialize to -1

        for (int i=0; i<arrHeight; i++) {
//            System.out.println("i: " + i);
            for (int j=0; j<arrWidth; j++) {
//                System.out.println("j: " + j);
                if (arr[i][j] == 1) {
//                    System.out.println("arr[" +i+ "][" +j+ "] is a match!");
                    // now compare to every other point
                    for (int k=0; k<arrHeight; k++) {
//                        System.out.println("i: " + i);
                        for (int l=0; l<arrWidth; l++) {
//                            System.out.println("j: " + j);
                            if (arr[k][l] == 1) {
//                                System.out.println("arr[" +k+ "][" +l+ "] is a match!");
                                // now compare to every other point
                                double calculatedDistance = calculateDistance (j,i,l,k);
//                                System.out.println("calculated distance: " + calculatedDistance);

                                if (calculatedDistance == 0) {
                                    // do nothing since we are looking at the same point
                                } else if (minimumDistance == -1) { // initialize minimumDistance the first time
                                    System.out.println("reassign minimum distance from: " + minimumDistance);
                                    // set the minimum distance to the calc
                                    minimumDistance = calculatedDistance;
                                    // set the point coordinates to the properly looped positions
                                    pointA[0] = i;
                                    pointA[1] = j;
                                    pointB[0] = k;
                                    pointB[1] = l;
                                    System.out.println("to: " + minimumDistance);
                                } else if (calculatedDistance < minimumDistance) {
                                    // set the minimum distance to the calc
                                    System.out.println("reassign minimum distance from: " + minimumDistance);
                                    minimumDistance = calculatedDistance;
                                    System.out.println("to: " + minimumDistance);
                                    // set the point coordinates to the properly looped positions
                                    pointA[0] = i;
                                    pointA[1] = j;
                                    pointB[0] = k;
                                    pointB[1] = l;
//                                    System.out.println("arr[" +i+ "][" +j+ "] is a match!");
//                                    System.out.println("arr[" +k+ "][" +l+ "] is a match!");
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("The minimum distance is " + minimumDistance + " between Point A ("+pointA[0]+","+pointA[1]+") and Point B ("+pointB[0]+","+pointB[1]+")");
    }

    public static double calculateDistance (int x1, int y1, int x2, int y2) {
        double calculatedDistance = Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
        return calculatedDistance;
    }
}

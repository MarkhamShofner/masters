/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package closestpairs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * This application can identify the closest pair of points in a two dimensional array.
 * @author MarkhamShofner
 */
public class ClosestPairs {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("-------------Start Of Main Method-------------");
        // *USER*: TO TOGGLE OPTIONS: these example arrays can be toggled on and off with comments
        
        // manually declare the two dimensional array
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
            { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1 },
            { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0 }
        };

        // *USER*: TO TOGGLE OPTIONS: use comments to run the chosen algorithm (bruteforce or elegant)
        bruteforceAlgorithm(testArray);
//        elegantAlgorithm(testArray);
        System.out.println("-------------End Of Main Method-------------");
    }

    // utility function to return an array of all the points
    // note: does not add to overall complexity (since we're just iterating through the entire 'n' number of elements one time
    public static ArrayList<Point> identifyPoints (int arr[][]) {
        ArrayList<Point> pointsArray = new ArrayList<>();
        int arrWidth = arr[0].length;
        int arrHeight = arr.length;
        for (int i=0; i<arrHeight; i++) {
            for (int j=0; j<arrWidth; j++) {
                if (arr[i][j] == 1) { // the location is valid
                    Point point = new Point(j,i);
                    pointsArray.add(point);            
                }
            }
        }
        return pointsArray;
    }
    
    // utility function to identify min distance between two distance relationships
    public static DistanceRelationship identifyMinDistance (DistanceRelationship A, DistanceRelationship B) {
        DistanceRelationship smallerDistance;
        if (A.distance < B.distance) {
            smallerDistance = A;
        } else {
            smallerDistance = B;
        }
        return smallerDistance;
    }
    
    // iterate through every point in the array
    // if a Point A has a value, compare it to every other point in the array
    // if a distance can be generated to a valid Point B (from Point A), compare that distance to the current minimum distance and overwrite the minimum if applicable
    // output the minimum distance and the Points A & B that produced it
    public static void bruteforceAlgorithm (int arr[][]) {
        System.out.println("-------------Start of Bruteforce Algorithm-------------");
        int arrWidth = arr[0].length;
        int arrHeight = arr.length;
        System.out.println("arrary width: " + arrWidth);
        System.out.println("array height: " + arrHeight);

        // declare the tracking points for the below for loops
        int[] pointA = {0,0};
        int[] pointB = {0,0};
        double minimumDistance = -1; // initialize to -1

        for (int i=0; i<arrHeight; i++) {
            for (int j=0; j<arrWidth; j++) {
                if (arr[i][j] == 1) { // the location is valid
                    // now compare to every other point
                    for (int k=0; k<arrHeight; k++) {
                        for (int l=0; l<arrWidth; l++) {
                            if (arr[k][l] == 1) { // a comparison location is valid
                                // calculate the distance between the two locations
                                double calculatedDistance = calculateDistance (j,i,l,k);

                                if (calculatedDistance == 0) {
                                    // do nothing since we are looking at the same point
                                } else if (minimumDistance == -1) { // initialize minimumDistance the first time
                                    // set the minimum distance to the calc
                                    minimumDistance = calculatedDistance;
                                    // set the point coordinates to the properly looped positions
                                    pointA[0] = i;
                                    pointA[1] = j;
                                    pointB[0] = k;
                                    pointB[1] = l;
                                } else if (calculatedDistance < minimumDistance) {
                                    // set the minimum distance to the calc
                                    minimumDistance = calculatedDistance;
                                    // set the point coordinates to the properly looped positions
                                    pointA[0] = i;
                                    pointA[1] = j;
                                    pointB[0] = k;
                                    pointB[1] = l;
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("The minimum distance is " + minimumDistance + " between Point A ("+pointA[0]+","+pointA[1]+") and Point B ("+pointB[0]+","+pointB[1]+")");
        System.out.println("-------------End of Bruteforce Algorithm-------------");
    }

    // utility function that calculates and returns the euclidian distance between two points
    public static double calculateDistance (int x1, int y1, int x2, int y2) {
        double calculatedDistance = Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
        return calculatedDistance;
    }
    
    
    // solve the problem by recurisvely slicing the range in to smaller subranges
    // not finished...
    public static void elegantAlgorithm (int arr[][]) {
        System.out.println("-------------Start of Elegant Algorithm-------------");
        // recursively split and compare
            // split from 0 --> n/2, n/2+1 --> n
                // keep splitting down to 2 or fewer
                // create distance relationships
                // merge sort all the way back up based on distance
                
        // identify points utility function
        ArrayList<Point> identifiedPoints = identifyPoints(arr);
        System.out.println("There were "+identifiedPoints.size()+" points found.");

        // sort the array according to the x coordinate
        Collections.sort(identifiedPoints, new Comparator<Point>(){
            public int compare(Point p1, Point p2) {
                return p1.x-p2.x;
            }
        });
        for (Point i : identifiedPoints) {
            System.out.println("x coordinate: " + i.x); 
        }
        
        Point point1 = new Point(0,1);
        Point point2 = new Point(1,1);
        Point point3 = new Point(2,6);

        double distanceA = calculateDistance (point1.x, point1.y, point2.x, point2.y);
        double distanceB = calculateDistance (point1.x, point1.y, point3.x, point3.y);
        double distanceC = calculateDistance (point2.x, point2.y, point3.x, point3.y);
        DistanceRelationship distanceRelationshipA = new DistanceRelationship(point1, point2, distanceA);
        DistanceRelationship distanceRelationshipB = new DistanceRelationship(point1, point3, distanceB);
        DistanceRelationship distanceRelationshipC = new DistanceRelationship(point2, point3, distanceC);
        
        DistanceRelationship minDistanceAB = identifyMinDistance (distanceRelationshipA, distanceRelationshipB);
        DistanceRelationship minDistanceAC = identifyMinDistance (distanceRelationshipA, distanceRelationshipC);
        DistanceRelationship minDistanceBC = identifyMinDistance (distanceRelationshipB, distanceRelationshipC);

        System.out.println("minDistanceAB: " +minDistanceAB.distance+" between point ("+minDistanceAB.pointA.x+","+minDistanceAB.pointA.y+") and point ("+minDistanceAB.pointB.x+","+minDistanceAB.pointB.y+")");
        System.out.println("minDistanceAC: " +minDistanceAC.distance+" between point ("+minDistanceAC.pointA.x+","+minDistanceAC.pointA.y+") and point ("+minDistanceAC.pointB.x+","+minDistanceAC.pointB.y+")");
        System.out.println("minDistanceBC: " +minDistanceBC.distance+" between point ("+minDistanceBC.pointA.x+","+minDistanceBC.pointA.y+") and point ("+minDistanceBC.pointB.x+","+minDistanceBC.pointB.y+")");
        
        
        // utility function to find a minimum value
        // compare each column only to itself
        // find smallest distance
        // take that distance from the midpoint to any x and then make sure none of those points are closer

        System.out.println("-------------End of Elegant Algorithm-------------");
    }
    
//    public static ArrayList<DistanceRelationship> recursivelyOrderDistanceRelationships (ArrayList<Point> pointArrList) {
//        // turn the ordered identifiedPoints arrayList into an ordered DistanceRelationship arrayList
//        ArrayList<DistanceRelationship> distanceRelationships;
//        for (Point i : identifiedPoints) {
//            distanceRelationship()
//            distanceRelationships.add(point);            
//
//            System.out.println("x coordinate: " + i.x); 
//        }
//        return distanceRelationships;
//    }
    
}

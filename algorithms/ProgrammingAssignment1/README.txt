Java Version - 8
IDE - NetBeans

///// Command line args are - <data1000.file> <algorithmType>
///// Algorithm types may be quick1, quick2, quick3, quick4, and heap.,
/////
///// Data files may be formatted with delimiters being spaces, carriage returns, or new lines, but there are two requirements
/////  - manually add a delimiter at the end of the data files so that the program picks up the last integer
/////  - in the file name, change the 20k --> 20000 (5k --> 5000, etc...) to simplify the file read logic
/////
///// Files read from the /InputData directory and write to the /OutputData directory.

Problem 1a - Construct a brute-force algorithm (pseudocode) for finding the closest pair of points in a set of n points in a two dimensional plane and show the worst-case big-O estimate for the number of operations used by the algorithm.
Hint: First determine the distance between every pair of points and then find the points with the closest distance.
// iterate through the entire two dimensional array
    // compare each valid point to every other valid point
    // shove the valid distances (and the points related to the distance) into another array
// then iterate through the distances array
    // find the element with the lowest distance (and the points the distance is between)

[ ] - note that this will just pick once (and all distances would also be recorded from A-->B _and_ B-->A)

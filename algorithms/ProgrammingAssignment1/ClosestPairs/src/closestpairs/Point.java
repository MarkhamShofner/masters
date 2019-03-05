/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package closestpairs;

/**
 * The Point class that simplifies the way we track x/y coordinates 
 * and return the x value for the ranges of vals
 * @author Markham Shofner
 */
public class Point {
    int x; // x coordinate
    int y; // y coordinate

    // Point constructor
    Point (int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    // return the x value
    public int returnX() {
        return x;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package closestpairs;

/**
 * The DistanceRelationship class that tracks a two points - point A, point B - 
 * and the distance between the two.
 * @author Markham Shofner
 */
public class DistanceRelationship {
    double distance; // distance
    Point pointA; // first point
    Point pointB; // second point

    // DistanceRelationship constructor
    DistanceRelationship (Point A, Point B, double distance) {
        this.pointA = A;
        this.pointB = B;
        this.distance = distance;
    }
}

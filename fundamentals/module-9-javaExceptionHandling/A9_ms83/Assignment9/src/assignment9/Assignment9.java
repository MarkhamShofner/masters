/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment9;

/**
 *
 * @author Markham Shofner
 */
public class Assignment9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        throwNullPointerE();
//        throwArrayIndexOOBE();
//        throwClassCastE();
//        throwIllegalArgumentE(-1);
        catchNullPointerE();
        catchArrayIndexOOBE();
        catchClassCastE();
        catchIllegalArgumentE();
    }

    public static void throwNullPointerE () {
        Object object = null;
        String failure = object.toString();
    }

    public static void catchNullPointerE () {
        try {
            throwNullPointerE();
        } catch (Exception e){
            System.out.println("Catching Null Pointer --- " + e);
        }
    }

    public static void throwArrayIndexOOBE () {
        int[] myInts = new int[3];
        myInts[5] = 6;
    }

    public static void catchArrayIndexOOBE () {
        try {
            throwArrayIndexOOBE();
        } catch (Exception e){
            System.out.println("Catching Array Index OOB --- " + e);
        }
    }

    public static void throwClassCastE () {
        Object myObj = new Integer(99);
        String failureString = (String)myObj;
    }

    public static void catchClassCastE () {
        try {
            throwClassCastE();
        } catch (Exception e){
            System.out.println("Catching Class Cast --- " + e);
        }
    }

    public static void throwIllegalArgumentE (int i) {
        if (i < 0 ){
            throw new IllegalArgumentException("Argument must be a positive integer");
        }
    }

    public static void catchIllegalArgumentE () {
        try {
            throwIllegalArgumentE(-1);
        } catch (Exception e){
            System.out.println("Catching Illegal Argument --- " + e);
        }
    }
}

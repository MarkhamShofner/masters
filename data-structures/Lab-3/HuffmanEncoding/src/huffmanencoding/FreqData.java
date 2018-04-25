/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huffmanencoding;

/**
 *
 * @author mark8604
 */
public class FreqData {
    String value;
    int frequency;
    
    // Constructor for initial FreqData that takes a value and frequency
    FreqData(String value, int frequency) {
        this.value = value;
        this.frequency = frequency;
        System.out.println("FreqData(Class):FreqData(String, int):: {value: " + this.value + ", frequency:" + this.frequency + "}");
    }
    
    // Constructur for FreqData that is combined from two other FreqDatas
    FreqData (FreqData Left, FreqData Right) {
        this.value = Left.value + Right.value;
        this.frequency = Left.frequency + Right.frequency;
        System.out.println("FreqData(Class):FreqData(FreqData, FreqData):: {value: " + this.value + ", frequency:" + this.frequency + "}");
    }
}

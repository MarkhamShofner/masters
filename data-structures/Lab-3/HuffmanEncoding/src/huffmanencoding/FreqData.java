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
    
    FreqData(String value, int frequency) {
        this.value = value;
        this.frequency = frequency;
        System.out.println("FreqData(Class):FreqData():: {value: " + this.value + ", frequency:" + this.frequency + "}");
    }
}

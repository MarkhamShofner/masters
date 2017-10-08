/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;
import java.util.Scanner;

/**
 * This project involves writing a program to translate Morse code into English and English
into Morse code.
 * @author mark8604
 */
public class Assignment5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Your program shall prompt the user to specify the desired type of translation,
            input a string of Morse code characters or English characters
            then display the translated results.
        */
        Scanner input = new Scanner (System.in);

        String [] alphaNumeric = {
            "A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "O", "P",
            "Q", "R", "S", "T", "U", "V", "W", "X",
            "Y", "Z", "1", "2", "3", "4", "5", "6",
            "7", "8", "9", "0", " "
          };
        String [] morseCode = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....",
            "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
            "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--..", ".----", "..---", "...--", "....-", ".....", "-....",
            "--...", "---..", "----.", "-----", "|"
        };

        String [] cipher1 = {};
        String [] cipher2 = {};

        System.out.println("");
        
        // receive language translation direction from user
        boolean viableChoiceInput = false;
        while (!viableChoiceInput) {
            System.out.println("Do you want to translate from ABC to Morse [Enter '1'], \n or Morse to ABC [Enter '2']:");
            String userChoiceInput = input.next();
            if (userChoiceInput.equals("1") || userChoiceInput.equals("2")) {
              viableChoiceInput = true;
              if (userChoiceInput.equals("1")) {
                  cipher1 = alphaNumeric;
                  cipher2 = morseCode;
              } else {
                  cipher1 = morseCode;
                  cipher2 = alphaNumeric;
              }
            } else {
                System.out.println("Please enter a viable input.");
            }
        }

        // TODO (unfinished) - take the whole line of input [instead of just the first word] and parse it into an array that can traverse the cypher string setup below.
            // split the english inputs by spaces and the morse inputs by |s
            // extract to methods where applicable
        
        System.out.println("Please enter the phrase you would like to translate:");
        String userPhraseInput = input.next();
        
        // translate a phrase from one language to the other
        String translatedPhrase = "";
        for (int i = 0; i < userPhraseInput.length(); i ++) {
            String character = userPhraseInput.substring(i, i+1).toUpperCase();
            for (int j = 0; j < cipher1.length; j++ ){
                if (cipher1[j].equals(character)) {
                    String translatedChar = cipher2[j];
                    translatedPhrase += translatedChar;
                    break;
                }
            }
        }
        System.out.println();
        System.out.println("TranslatedPhrase:   " + translatedPhrase);               
    }
}

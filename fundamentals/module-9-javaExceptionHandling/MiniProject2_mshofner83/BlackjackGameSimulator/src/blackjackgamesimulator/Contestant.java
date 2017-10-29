/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackgamesimulator;

/**
 * This class provides a data/logic structure for contestants in a game of blackjack.
 * Superclass of Player and Dealer. Implements GameMovements interface.
 * @author Markham Shofner
 */
public class Contestant implements GameMovements{
    private int score;
    private Card[] hand = new Card[11]; // max hand at 11 cards, assuming bust at 11 2s (if using many decks)
    private int handLength; // start at 2
    private boolean playingStatus = true;
    
    Contestant () {
    }
    
    /**
    * Public facing getter method to provide the value of the card.
    * @param i int that gets passed in to alter the Player's stack by a determined integer value
    */
    public void hit () {
        hand[handLength] = new Card();
        handLength+=1; 
    }
    public void stay () {
    }
    
    /**
    * Reset the Contestent's hand.
    */
    public void generateHand () {
        hand[0] = new Card();
        hand[1] = new Card();
        this.handLength = 2;
    }
    
    /**
    * Public facing getter method to provide the value of the contestant hand.
    * @return score int
    */
    public int getHandValue () {
        int total = 0;
        for (int i = 0; i < handLength; i++) {
            if (hand[i].getRank() > 0) {
                total+= hand[i].getRank();
            }
        }
        this.score = total;
        return this.score;
    }
}

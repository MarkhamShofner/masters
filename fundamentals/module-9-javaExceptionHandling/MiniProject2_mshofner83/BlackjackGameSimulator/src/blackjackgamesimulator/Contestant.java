/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackgamesimulator;

/**
 *
 * @author mark8604
 */
public class Contestant implements GameMovements{
    private int score;
    private Card[] hand = new Card[11]; // max hand at 11 cards, assuming bust at 11 2s (if using many decks)
    private int handLength; // start at 2
    private boolean playingStatus = true;
    
    Contestant () {
    }
    
    public void hit () {
        hand[handLength] = new Card();
        handLength+=1; 
    }
    public void stay () {
    }
    public void generateHand () {
        hand[0] = new Card();
        hand[1] = new Card();
        this.handLength = 2;
    }
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

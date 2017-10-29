/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackgamesimulator;

/**
 * This class represents the data/logic for a dealer.
 * Subclass of Contestant.
 * @author Markham Shofner
 */
public class Dealer extends Contestant {
    public void deal() {
        System.out.println("Dealer Deals");
    }

    /**
    * Returns the results of a dealer's turn.
    * @return score int
    */
    public int dealerTurn() {
        boolean playing = true;
        int score = 0;
        this.generateHand();
        while (playing) {
            score = this.getHandValue();
            if (score > 21) {
                System.out.println("Dealer score is above 21, player wins!");
                playing = false;
            }
            else if (score == 21) {
                System.out.println("Dealer score is 21 - player loseswin!");
                playing = false;
            }
            else if (score < 17) {
                this.hit();
            }
            else {
                this.stay();
                playing = false;
            }
        }
        return score;
    }
}

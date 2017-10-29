/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackgamesimulator;

import java.util.Scanner;

/**
 * This class represents the data/logic for a Player.
 * Subclass of Contestant.
 * @author Markham Shofner
 */
public class Player extends Contestant {
    private int stack;

    Player (int i) {
        this.stack = i;
    }

    /**
    * @param i int that gets passed in to alter the Player's stack by a determined integer value
    */
    public void changeStack(int i) {
        this.stack+= i;
    }
    /**
    * Public facing getter method to provide the value of the Player's stack.
    * @return stack int
    */
    public int getStack() {
        return this.stack;
    }

    /**
    * Returns the results of a player's turn.
    * @return score int
    */
    public int playerTurn() {
        Scanner input = new Scanner (System.in);
        boolean playing = true;
        int score = 0;
        this.generateHand();
        while (playing) {
            score = this.getHandValue();
            if (score > 21) {
                System.out.println("Your score is above 21 - you lose!");
                playing = false;
            }
            else if (score == 21) {
                System.out.println("Your score is 21 - you win!");
                playing = false;
            } else {
                System.out.println("You are at " + this.getHandValue() + ". Would you like to hit (1) or stay (0)?");
                int choice = input.nextInt();
                if (choice == 1) {
                    this.hit();
                } else {
                    this.stay();
                    playing = false;
                }
            }
        }
        return score;
    }
}

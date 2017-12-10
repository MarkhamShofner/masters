/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackgamesimulator;
import java.util.Scanner;

/**
 * This class simulates a blackjack card game.
 * A user will play the game through a simple console-based interface.
 * @author Markham Shofner
 * @version 1.0
 */
public class BlackjackGameSimulator {

    /**
     * Main method to trigger the program by standing up an instance of the class,
     * and then calling the init() method.
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        BlackjackGameSimulator gameSimulator = new BlackjackGameSimulator();
        gameSimulator.init();
    }
    
    /**
     *
     */
    public void init() {
        Scanner input = new Scanner (System.in);
        System.out.println("Let's play a game of blackjack!");
        System.out.println("First, how much money would you like to gamble with?");
        int stack = input.nextInt();
        
        Player player = new Player(stack);
        Dealer dealer = new Dealer();
        Boolean gameOn = true;
        
        while (gameOn) {
            Boolean turnGoing = true;
            
            while (turnGoing) {
                System.out.println("You have " + player.getStack() + ".");
                System.out.println("How much would you like to wager?");
                int bet = input.nextInt();
                int playerScore = player.playerTurn();
                if (playerScore > 21) {
                    player.changeStack(-bet);
                    turnGoing = false;
                } else if (playerScore == 21) {
                    player.changeStack(bet);
                    turnGoing = false;
                } else {
                    int dealerScore = dealer.dealerTurn();
                    System.out.println("Player Score:" + playerScore);
                    System.out.println("Dealer Score:" + dealerScore);
                    if (playerScore > dealerScore || dealerScore > 21) {
                        System.out.println("Player wins!");
                        player.changeStack(bet);
                    } else {
                        System.out.println("Dealer wins :(");
                        player.changeStack(-bet);
                    }
                    turnGoing=false;
                }
            }
            System.out.println("You have " + player.getStack() + " left!");


            System.out.println("Would you like to play another turn? (1) yes, (0) no.");
            int gameChoice = input.nextInt();
            if (gameChoice == 0) gameOn = false;
        }
        System.out.println("You ended with " + player.getStack());
    }
}

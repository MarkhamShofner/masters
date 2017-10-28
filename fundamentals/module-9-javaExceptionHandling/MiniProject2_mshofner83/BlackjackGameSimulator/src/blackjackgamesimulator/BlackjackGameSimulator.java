/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackgamesimulator;
import java.util.Scanner;

/**
 *
 * @author mark8604
 */
public class BlackjackGameSimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {        
        BlackjackGameSimulator gameSimulator = new BlackjackGameSimulator();
        gameSimulator.init();
    }
    
    public void init() {
        Scanner input = new Scanner (System.in);
//        TODO comment the below back in
//        System.out.println("Let's play a game of blackjack!");
//        System.out.println("First, how much money would you like to gamble with?");
//        int stack = input.nextInt();
        int stack = 100; // delete this line
        
        Player player = new Player(stack);
        Dealer dealer = new Dealer();
        Boolean gameOn = true;
        
        while (gameOn) {
            Boolean turnGoing = true;
            
            while (turnGoing) {
                System.out.println("You have " + player.getStack() + ".");
                System.out.println("How much would you like to wager?");
                int bet = input.nextInt();
                int playerScore = playerTurn(player);
                if (playerScore > 21) {
                    player.changeStack(-bet);
                    turnGoing = false;
                } else if (playerScore == 21) {
                    player.changeStack(bet);
                    turnGoing = false;
                } else {
                    int dealerScore = dealerTurn(dealer);
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
    }
    
    public int playerTurn(Player player) {
        Scanner input = new Scanner (System.in);
        boolean playing = true;
        int score = 0;
        player.generateHand();
        while (playing) {
            score = player.getHandValue();
            if (score > 21) {
                System.out.println("Your score is above 21 - you lose!");
                playing = false;
            }
            else if (score == 21) {
                System.out.println("Your score is 21 - you win!");
                playing = false;
            } else {
                System.out.println("You are at " + player.getHandValue() + ". Would you like to hit (1) or stay (0)?");
                int choice = input.nextInt();
                if (choice == 1) {
                    player.hit();
                } else {
                    player.stay();
                    playing = false;
                }
            }
        }
        return score;
    }
    
    public int dealerTurn(Dealer dealer) {
        boolean playing = true;
        int score = 0;
        dealer.generateHand();
        while (playing) {
            score = dealer.getHandValue();
            if (score > 21) {
                System.out.println("Dealer score is above 21, player wins!");
                playing = false;
            }
            else if (score == 21) {
                System.out.println("Dealer score is 21 - player loseswin!");
                playing = false;
            } 
            else if (score < 17) {
                dealer.hit();
            }
            else {
                dealer.stay();
                playing = false;
            }
        }
        return score;
    }

}

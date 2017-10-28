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
public class Player extends Contestant {
    private int stack;
    
    Player (int i) {
        this.stack = i;
    }
    
    public void changeStack(int i) {
        this.stack+= i;
    }
    public int getStack() {
        return this.stack;
    }
    
    public void bet() {
        System.out.println("Player Bets");
    }
}

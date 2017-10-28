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
public class Card {
    private int RANGE_TOP = 13;
    private int rank;

    Card () {
        rank = this.generateRank();
    }

    private int generateRank() {
        int cardValue = (int) ( RANGE_TOP * Math.random() ) + 1;
        int cardRank;
        switch (cardValue) {
            case 1: // treating an ace as if it is always worth 11
                cardRank = 11;
                break;
            case 2:
                cardRank = 2;
                break;
            case 3:
                cardRank = 3;
                break;
            case 4:
                cardRank = 4;
                break;
            case 5:
                cardRank = 5;
                break;
            case 6:
                cardRank = 6;
                break;
            case 7:
                cardRank = 7;
                break;
            case 8:
                cardRank = 8;
                break;
            case 9:
                cardRank = 9;
                break;
            case 10: case 11: case 12: case 13:
                cardRank = 10;
                break;
            default:
                cardRank = 1;
        }
        return cardRank;
    }

    public int getRank() {
        return rank;
    }
}

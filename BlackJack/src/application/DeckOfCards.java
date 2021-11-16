package application;

import java.util.Random;
public class DeckOfCards {

    private Card[] deck;
    private int topCardIndex = 51;

    public DeckOfCards(){
        Card[] newCardDeck = new Card[52];
        int i = 0;
        for (SUITS suit : SUITS.values()) {
			for (RANKS rank : RANKS.values()) {
				deck[i++] = new Card(suit, rank);
			}
		}
        deck = newCardDeck;
        shuffleDeck();
    }

    public void shuffleDeck(){
        /*
    	 * Shuffles the deck using the built-in Collections class
    	 */
    	Collections.shuffle(Arrays.asList(deck));
    }
    
    //returns Card indicated by cardIndex then increments cardIndex
    public Card drawTop(){
        Card topCard = deck[topCardIndex];
        deck[topCardIndex] = null;
        
        topCardIndex -= 1;
        return topCard;
    }
    
  //for testing purposes inside ide
    @Override
    public String toString() {
    	String hold = "";
    	for (int i = 0; i < deck.length; i++) {
    		hold += (deck[i].toString() + "; ");
    	}
    	return hold;
    }
}

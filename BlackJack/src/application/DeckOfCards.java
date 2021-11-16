package application;

import java.util.Arrays;
import java.util.Collections;

import application.Card.RANKS;
import application.Card.SUITS;

public class DeckOfCards {
	private Card[] deck = new Card[52];
	private int topCardIndex = 51;
	
    public DeckOfCards(){
        int i = 0;
        for (SUITS suit : SUITS.values()) {
			for (RANKS rank : RANKS.values()) {
				deck[i++] = new Card(suit, rank);
			}
		}
        shuffleDeck();
    }

    public void shuffleDeck(){
    	/*
    	 * Shuffles the deck using the built-in Collections class
    	 */
    	Collections.shuffle(Arrays.asList(deck));
    	
    }
    // Returns Card of the last element in deck and changes the element to null
    public Card drawTop(){
    	
    	Card topCard = deck[topCardIndex];
    	deck[topCardIndex] = null;
    	
    	topCardIndex -= 1;
    	return topCard;
    }
    
    public Card[] getDeck() {
    	return this.deck;
    }
    
    @Override
    public String toString() {
    	String deckString = "";
    	for (Card cardTest : deck) {
    		deckString += cardTest + ", ";
    	}
    	return deckString;
    }
}

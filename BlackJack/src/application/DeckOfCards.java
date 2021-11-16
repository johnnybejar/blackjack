package application;

import java.util.Random;
public class DeckOfCards {

    private Card[] deck;
    private int cardIndex;

    public DeckOfCards(){
        Card[] newCardDeck = new Card[52];
        int i = 0;
        for (Card.SUITS s : Card.SUITS.values()){
            for (Card.RANKS r : Card.RANKS.values()){
                Card newCard = new Card(s, r);
                newCardDeck[i] = newCard;
                i++;
            }
        }
        deck = newCardDeck;
        this.cardIndex = 0;
    }

    public void ShuffleDeck(){
        int randInt;
        Random rand = new Random();
        Card temp;
        for (int i = 0; i < 52; i++){
            randInt = rand.nextInt(deck.length-1);
            temp = deck[i];
            deck[i] = deck[randInt];
            deck[randInt] = temp;
        }
    }
    //returns Card indicated by cardIndex then increments cardIndex
    public Card drawTop(){
        Card topCard = deck[cardIndex];
        cardIndex += 1;
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

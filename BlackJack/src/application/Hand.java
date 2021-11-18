package application;

import application.Hand;
import application.Card.RANKS;

public class Hand {
	private Card[] hand = new Card[5];
	private int cardTotal = 2;

    public Hand(DeckOfCards deck){
        hand[0] = deck.drawTop();
        hand[1] = deck.drawTop();
    }

    public void Draw(DeckOfCards deck){
    	cardTotal += 1;
        hand[cardTotal-1] = deck.drawTop();
    }
    
    public int getHandCount() {
    	return cardTotal;
    }

    public int getHandValue(){
    	int totalValue = 0;
    	int totalAces = 0;
        for (Card c : hand){
        	if (c == null) {
        		break;
        	}
        	
        	if (c.getRank() == RANKS.ACE) {
        		totalAces++;
        		continue;
        		
        	} else {
        		totalValue += c.getValue();
        		
        	}
        	
        }
        
        for (int i = totalAces; i > 0; i--){
            if(totalValue + (i*11) <= 21) {
                totalValue = totalValue + (i*11);
                break;
            }
            else
                totalValue += 1;
	}
        return totalValue;
    }
    
    // This method is only used for the dealer's hand
    // Figures out if the dealers hand is 17 or greater
    public boolean dealerTotalCards(Hand dealerHand) {
    	if (dealerHand.getHandValue() >= 17) {
    		return true;
    	}
    	return false;
    }
    
    public Card[] getHand() {
		return this.hand;
	}
    
    public Card getCard(int index) {
    	return this.hand[index];
    }
    
    @Override
    public String toString() {
    	String handString = "";
    	for (Card card : hand) {
    		handString += card + ", ";
    	}
    	
    	return handString;
    }
}


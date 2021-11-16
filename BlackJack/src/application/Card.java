package application;

public class Card {
    public enum SUITS{
        CLUBS("Clubs"),
        DIAMONDS("Diamonds"),
        HEARTS("Hearts"),
        SPADES("Spades");
    	
    	String suitValue;
    	
    	SUITS(String value) {
    		this.suitValue = value;
    	}
    	
    	public String getSuitValue() {
    		return suitValue;
    	}
    }
    public enum RANKS{
    	// We can handle special case for Ace when calculating hand total
    	// For now, ace is defaulted to 11
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);
    	
    	int value;
    	
    	RANKS(int value) {
			this.value = value;
		}
    	
    	public int getValue() {
    		return value;
    	}
    }
    private SUITS suit;
    private RANKS rank;
    private int value;

    public Card(SUITS suit, RANKS rank){
        this.suit = suit;
        this.rank = rank;
        this.value = rank.value;
    }
    
    public SUITS getSuit() {
    	return this.suit;
    }
    
    public RANKS getRank(){
        return this.rank;
    }
    
    public int getValue() {
    	return this.value;
    }
    
    @Override
    public String toString() {
    	String s = String.format("%d of %s", this.rank.getValue(), this.suit.getSuitValue());
    	switch (this.getRank()) {
			case ACE:
				s = String.format("Ace of %s", this.suit.getSuitValue());
				break;
			case KING:
				s = String.format("King of %s", this.suit.getSuitValue());
				break;
			case QUEEN:
				s = String.format("Queen of %s", this.suit.getSuitValue());
				break;
			case JACK:
				s = String.format("Jack of %s", this.suit.getSuitValue());
				break;
		default:
			break;
    	}
    	
    	return s;
    }
}

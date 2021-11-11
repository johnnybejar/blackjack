public class Dealer {
	private Hand hand;
	
	public Dealer(Hand hand( )) {
		this.hand = hand;
	}
	
	public Hand getHand() {
		return this.hand;
	}
	
	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
	public int getHandValue() {
		return hand.getHandValue;
	}
	
	public void dealerPlays(DeckOfCards deck) {
		while (hand.getHandValue() < 17) {
			hand.hit(DeckOfCards.getTop)
		}
	}
}

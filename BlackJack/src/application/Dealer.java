package application;
public class Dealer {
	private Hand hand;
	
	public Dealer() {
	}
	
	public Hand getHand() {
		return this.hand;
	}
	
	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
	public int getDealerTotal() {
		return this.hand.getHandValue();
	}
	
	public void dealerPlays(DeckOfCards deck) {
		while (hand.getHandValue() < 17) {
			hand.Draw(deck);
		}
	}
	public boolean bust() {
		if (this.getDealerTotal() > 21) {
			return true;
		} else return false;
	}
	
	public boolean blackjack() {
		if (this.getDealerTotal() == 21) {
			return true;
		} else return false;
	}
}

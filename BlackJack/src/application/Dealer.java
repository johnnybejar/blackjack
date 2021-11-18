package application;
public class Dealer {
	private Hand hand;
	
	public Dealer() {
	}
	
	/*
	 * returns dealers hand as a hand object
	 */
	public Hand getHandClass() {
		return this.hand;
	}
	/*
	 * returns dealers hand as an array of card objects
	 */
	public Card[] getHand() {
		return this.hand.getHand();
	}
	/*
	 * sets dealers hand
	 */
	public void setHand(Hand hand) {
		this.hand = hand;
	}
	/*
	 * returns the sum of values of cards in dealers hand
	 */
	public int getHandValue() {
		return this.hand.getHandValue();
	}
	/*
	 * returns true if dealer total above 21
	 */
	public boolean bust() {
		if (this.getHandValue() > 21) {
			return true;
		} else return false;
	}
	/*
	 * returns true if dealer total equal to 21
	 */
	public boolean blackjack() {
		if (this.getHandValue() == 21) {
			return true;
		} else return false;
	}
}

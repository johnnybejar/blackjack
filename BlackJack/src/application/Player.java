package application;

public class Player {
	private int cash;
	private Hand hand;
	/*
	 * initializes player with given amount of money in the bank
	 */
	public Player(int cash) {
		this.cash = cash;
	}
	/*
	 * sets players hand
	 */
	public void setHand(Hand hand) {
		this.hand = hand;
	}
	/*
	 * returns amount of money in players bank
	 */
	public int getCash() {
		return this.cash;
	}
	/*
	 * sets money in players bank
	 */
	public void setCash(int cash) {
		this.cash = cash;
	}
	/*
	 * returns players hand as a hand object
	 */
	public Hand getHandClass() {
		return this.hand;
	}
	/*
	 * returns players hand as an array of card objects
	 */
	public Card[] getHand() {
		return this.hand.getHand();
	}
	
	public void removeCash(int bet) {
		this.cash = this.cash - bet;
	}
	
	public void addCash(int bet) {
		this.cash = this.cash + bet;
	}
	
	public int getHandValue() {
		return hand.getHandValue();
	}

	public boolean blackjack() {
		if (getHandValue() == 21) {
			return true;
		} else return false;
	}

	public boolean bust() {
		if (getHandValue() > 21) {
			return true;
		} else return false;
	}
}


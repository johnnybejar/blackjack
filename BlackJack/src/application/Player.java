package application;

public class Player {

	private int cash;
	private int bet;
	private Hand hand;
	
	public Player(int cash, Hand hand) {
		this.cash = cash;
		this.hand = hand;
		this.bet = 0;
	}
	
	public int getCash() {
		return this.cash;
	}
	
	public void setCash(int cash) {
		this.cash = cash;
	}
	
	public void setBet(int bet) {
		this.bet = bet;
	}
	
	public void lose() {
		this.cash -= this.bet;
	}
	
	public void win() {
		this.cash += this.bet;
	}
	
	public int getHandValue() {
		return this.hand.getHandValue();
	}
	
	public void hit(DeckOfCards deck) {
		hand.Draw(deck.drawTop());
	}
}

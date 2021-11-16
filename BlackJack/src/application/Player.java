package application;

public class Player {
	private int cash;
	private int bet;
	private Hand hand;
	
	public Player(int cash, Hand hand) {
		this.cash = cash;
		this.hand = hand;
	}
	
	public int getCash() {
		return this.cash;
	}
	
	public void setCash(int cash) {
		this.cash = cash;
	}
	
	public int getBet() {
		return this.bet;
	}
	
	public void setBet(int bet) {
		this.bet = bet;
	}
	
	public Hand getHand() {
		return this.hand;
	}
	
	public void lose() {
		this.cash -= this.bet;
	}
	
	public void win() {
		this.cash += this.bet;
	}
	
	public int getHandValue() {
		return hand.getHandValue();
	}
}

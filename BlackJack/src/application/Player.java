package application;
public class Player {

	private int cash;
	private int bet;
	private Hand hand;
	
	public Player(int cash, Hand hand) {
		this.cash = cash;
		this.hand = hand;
	}
	
	public Hand getHand() {
		return hand;
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
	
	public int getBet() {
		return bet;
	}
	
	public void lose() {
		this.cash -= this.bet;
	}
	
	public void win() {
		this.cash += this.bet;
	}
	
	public int getPlayerTotal() {
		return hand.getHandValue();
	}
	
	public void hit(DeckOfCards deck) {
		hand.Draw(deck);
	}
	
	public boolean bust() {
		if (getPlayerTotal() > 21) {
			return true;
		} else return false;
	}
	
	public boolean blackjack() {
		if (getPlayerTotal() == 21) {
			return true;
		} else return false;
	}
}

package application;

public class BlackjackGame {
	
    private DeckOfCards deck;
    private Player player;
    private Dealer dealer;
    private Hand playerHand;
    private Hand dealerHand;
    /*
     * initializes a game object with a player, dealer, and deck
     */
    public BlackjackGame(DeckOfCards deck, Player player, Dealer dealer) {
    	this.deck = deck;
    	this.player = player;
    	this.dealer = dealer;
    }
	/*
     * shuffles the games deck using the shuffleDeck method from class DeckOfCards
     */
    public void shuffle() {
        deck.shuffleDeck();
    }
    /*
     * deals two cards to dealer and player
     */
    public void deal() {
    	this.dealerHand = new Hand(deck);
        this.playerHand = new Hand(deck);
        player.setHand(playerHand);
        dealer.setHand(dealerHand);
    }
    /*
     * plays the dealer using the dealerPlays method from the dealer class
     */
    public void dealerPlays() {
		while (dealerHand.getHandValue() < 17) {
			dealerHand.Draw(deck);
		}
	}
    /*
     * adds 1 card to the players hand
     */
    public void playerHit() {
    	this.playerHand.Draw(deck);
    }
    /*
     * returns true if player hand total is 21, false otherwise
     */
    public boolean checkPlayerBlackjack() {
        if (player.blackjack()) {
        	return true;
        }else return false;
    }
    /*
     * returns true if dealer hand total is 21, false otherwise
     */
    public boolean checkDealerBlackjack() {
    	if(dealer.blackjack()) {
    		return true;
    	}else return false;
    }
    /*
     * returns true if player hand total is over 21, false otherwise
     */
    public boolean checkPlayerBust() {
    	if (player.bust()) {
    		return true;
    	}else return false;
    }
    /*
     * returns true if dealer hand total is over 21, false otherwise
     */
    public boolean checkDealerBust() {
    	if (dealer.bust()) {
    		return true;
    	}else return false;
    }
    /*
     * returns num of cards in player hand
     */
    public int getHandCountP() {
    	return playerHand.getHandCount();
    }
    /*
     * returns num of cards in dealer hand
     */
    public int getHandCountD() {
    	return dealerHand.getHandCount();
    }
    /*
     * returns true if player hand count reaches 5 or more
     */
    public boolean playerCount5() {
    	if (getHandCountP() >= 5) {
    		return true;
    	}else return false;
    }
    /*
     * returns true if dealer hand count reaches 5 or more
     */
    public boolean dealerCount5() {
    	if (getHandCountD() >= 5) {
    		return true;
    	}else return false;
    }
}

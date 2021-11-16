public class BlackjackGame {
	
    private DeckOfCards deck;
    private Player player;
    private Dealer dealer;
    private Hand playerHand;
    private Hand dealerHand;
    
    public BlackjackGame(DeckOfCards deck, Player player, Dealer dealer) {
    	this.deck = deck;
    	this.player = player;
    	this.dealer = dealer;
    }
	public void newDeck(DeckOfCards newDeck) {
		this.deck = newDeck;
	}
	
    public void shuffle() {
        deck.ShuffleDeck();
    }
    
    public void deal() {
    	this.dealerHand = new Hand(deck);
        this.playerHand = new Hand(deck);
    }
    
    public void playerHit() {
    	this.playerHand.Draw(deck);
    }
    
    public void playerBet(int bet) {
    	player.setBet(bet);
    }
    
    public void doubleBet() {
    	int currentBet = player.getBet();
    	player.setBet(currentBet*2);
    }
    
    public void allIn() {
    	player.setBet(player.getCash());
    }
    
    public boolean checkPlayerBlackjack() {
        if (player.blackjack()) {
        	return true;
        }else return false;
    }
    
    public boolean checkDealerBlackjack() {
    	if(dealer.blackjack()) {
    		return true;
    	}else return false;
    }
    
    public boolean checkPlayerBust() {
    	if (player.bust()) {
    		return true;
    	}else return false;
    }
    
    public boolean checkDealerBust() {
    	if (dealer.bust()) {
    		return true;
    	}else return false;
    }
    
    public boolean checkFiveCardWinP() {
    	if (playerHand.getNumCards() == 5) {
    		return true;
    	}else return false;
    }
    public boolean checkFiveCardWinD() {
    	if (dealerHand.getNumCards() == 5) {
    		return true;
    	}else return false;
    }
	   
}

public class Hand {
    private Card[] hand;

    public Hand(DeckOfCards deck){
        hand[0] = deck.drawTop();
        hand[1] = deck.drawTop();
    }

    public void Draw(DeckOfCards deck){
        hand[hand.length] = deck.drawTop();
    }

    int getHandValue(){
        int numAces = 0;
        int totalValue = 0;
        for (Card c : hand){
            if(c.getRank() == Card.RANKS.TWO)
                totalValue += 2;
            if(c.getRank() == Card.RANKS.THREE)
                totalValue += 3;
            if(c.getRank() == Card.RANKS.FOUR)
                totalValue += 4;
            if(c.getRank() == Card.RANKS.FIVE)
                totalValue += 5;
            if(c.getRank() == Card.RANKS.SIX)
                totalValue += 6;
            if(c.getRank() == Card.RANKS.SEVEN)
                totalValue += 7;
            if(c.getRank() == Card.RANKS.EIGHT)
                totalValue += 8;
            if(c.getRank() == Card.RANKS.NINE)
                totalValue += 9;
            if(c.getRank() == Card.RANKS.TEN)
                totalValue += 10;
            if(c.getRank() == Card.RANKS.JACK)
                totalValue += 11;
            if(c.getRank() == Card.RANKS.QUEEN)
                totalValue += 12;
            if(c.getRank() == Card.RANKS.KING)
                totalValue += 13;
            if(c.getRank() == Card.RANKS.ACE)
                numAces += 1;
        }
        //Ace handling code
        for (int i = numAces; i > 0; i--){
            if(totalValue + 11 + numAces - 1 <= 21)
                totalValue = totalValue + 11 + numAces - 1;
            else
                totalValue += numAces;
        }
        return totalValue;
    }
}

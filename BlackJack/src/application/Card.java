public class Card {
    public enum SUITS{
        CLUBS,
        DIAMONDS,
        HEARTS,
        SPADES;
    }
    public enum RANKS{
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;
    }
    private SUITS suit;
    private RANKS rank;

    public Card(SUITS suit, RANKS rank){
        this.suit = suit;
        this.rank = rank;
    }
    public RANKS getRank(){
        return rank;
    }
}

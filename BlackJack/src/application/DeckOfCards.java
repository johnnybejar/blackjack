import java.util.Random;
public class DeckOfCards {

    private Card[] deck;

    public DeckOfCards(){
        Card[] newCardDeck = new Card[0];
        int i = 0;
        for (Card.SUITS s : Card.SUITS.values()){
            i++;
            for (Card.RANKS r : Card.RANKS.values()){
                Card newCard = new Card(s, r);
                newCardDeck[i] = newCard;
                deck = newCardDeck;
            }
        }
    }

    public void ShuffleDeck(){
        int randInt;
        Random rand = new Random();
        Card temp;
        for (int i = 0; i < deck.length; i++){
            randInt = rand.nextInt(deck.length-1);
            temp = deck[i];
            deck[i] = deck[randInt];
            deck[randInt] = temp;
        }
    }
    //returns Card of the last element in deck and deletes the element by making a new array and assigning it as deck
    public Card drawTop(){
        Card topCard = deck[deck.length-1];
        Card[] newDeck = new Card[0];
        for(int i = 0; i < deck.length-1; i++)
            newDeck[i]=deck[i];
        deck = newDeck;
        return topCard;
    }
}


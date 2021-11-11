import java.util.Scanner;

public class BlackjackGame {
   
    private Player player;
    private Deck deck;
    private Dealer dealer = new Dealer();

    public void shuffle() throws InvalidDeckPositionException,
            InvalidCardSuiteException, InvalidCardValueException {
        deck.shuffle();
    }

    public void getBet() {
        int betValue;

        for (int i = 0; i < users; i++) {
            if (player[i].getBank() > 0) {
                do {
                    System.out.print("How much do you want to bet?");
                    betValue = input.nextInt();
                    players[i].setBet(betValue);
                }
                while (!(betValue > 0 && betValue <= players[i].getBank()));
                System.out.println("");
            }
        }
    }

    public void dealCards() {
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < users; i++) {
                if (players[i].getBank() > 0) {
                    players[i].addCard(deck.nextCard());
                }
            }
            dealer.addCard(deck.nextCard());
        }
    }

    public void checkBlackjack() {
        if (deal.isBlackjack()) {
            System.out.println("Dealer has Blackjack!");
            for (int i = 0; i < users; i++) {
                if (players[i].getTotal() == 21) {
                    System.out.println(player.getName() + " pushes");
                    players[i].push();
                }
                else {
                    System.out.println(player.getName() + " loses");
                    players[i].bust();
                }
            }
        }
        else {
            if (deal.peek()) {
                System.out.println("Dealer peeks and does not have a Blackjack");
            }

            for (int i = 0; i < users; i++) {
                if (players[i].getTotal() == 21) {
                    System.out.println(players[i].getName() + " has blackjack!");
                    players[i].blackjack();
                }
            }
        }
    }

    public void dealerPlays() {
        boolean isPlayerInGame = false;
        for (int i = 0; i < users && isPlayerInGame == false; i++) {
            if (players[i].getBet() > 0 && players[i].getTotal() <= 21) {
                isPlayerInGame = true;
            }
        }
        if (isPlayerInGame) {
            dealer.dealerPlay(deck);
        }
    }


}

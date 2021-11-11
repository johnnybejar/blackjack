public class BlackjackGame {
   
    private Player player;
    private Deck deck;
    private Dealer dealer = new Dealer();

    public void shuffle() {
        deck.shuffle();
    }

    public void getBet() {
        int betValue;

        for (int i = 0; i < users; i++) {
            if (player.getBank() > 0) {
                do {
                    System.out.print("How much do you want to bet?");
                    betValue = input.nextInt();
                    player.setBet(betValue);
                }
                while (!(betValue > 0 && betValue <= player.getBank()));
                System.out.println("");
            }
        }
    }

    public void dealCards() {
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < users; i++) {
                if (player.getBank() > 0) {
                    player.addCard(deck.nextCard());
                }
            }
            dealer.addCard(deck.nextCard());
        }
    }

    public void checkBlackjack() {
        if (deal.isBlackjack()) {
            System.out.println("Dealer has Blackjack!");
            for (int i = 0; i < users; i++) {
                if (player.getTotal() == 21) {
                    System.out.println(player.getName() + " pushes");
                    player.push();
                }
                else {
                    System.out.println(player.getName() + " loses");
                    player.bust();
                }
            }
        }
        else {
            if (deal.peek()) {
                System.out.println("Dealer peeks and does not have a Blackjack");
            }

            for (int i = 0; i < users; i++) {
                if (player.getTotal() == 21) {
                    System.out.println(player.getName() + " has blackjack!");
                    player.blackjack();
                }
            }
        }
    }

    public void dealerPlays() {
        boolean isPlayerInGame = false;
        for (int i = 0; i < users && isPlayerInGame == false; i++) {
            if (player.getBet() > 0 && player.getTotal() <= 21) {
                isPlayerInGame = true;
            }
        }
        if (isPlayerInGame) {
            dealer.dealerPlay(deck);
        }
    }

   
}

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * creates new instances for the Deck, Player, and dealer classes
 * deals and adds the 2 cards to the player's and dealer's hand
 * checks user input for hit or stand
 * checks if player wins or loses the game
 */
public class DealerTester {
  public static void main(String[] args) {
    //New Instances
    Deck deckTester = new Deck();
    Player playerTester = new Player();
    Dealer dealerTester = new Dealer();
    //Deals first cards to the dealer
    Card dealerStartingCard = deckTester.deal();
    dealerTester.addDealerCard(dealerStartingCard);
    dealerStartingCard = deckTester.deal();
    dealerTester.addDealerCard(dealerStartingCard);
    //Deals first cards to the player
    Card startingCard = deckTester.deal();
    playerTester.add(startingCard);
    startingCard = deckTester.deal();
    playerTester.add(startingCard);
    //Displays player's and dealer's starting cards
    System.out.println(playerTester.toString());
    System.out.println("\n-----Dealer Hand-----");
    System.out.println(dealerTester.inGameDisplay());

    if (playerTester.getHandValue() > 21) {
      return;
    }

    if (playerTester.getHandValue() == 21) {
      System.out.println("\nYou Win!\n");
      return;
    }

    boolean yesEnd = false;

    String userChoice = playerTester.getUserChoice();

    while (userChoice.equals("h")) {
      startingCard = deckTester.deal();
      playerTester.add(startingCard);

      System.out.println(playerTester.toString());

      if (playerTester.getHandValue() == 21) {
        System.out.println("\nYou Win!\n");
        yesEnd = true;
      }

      if (playerTester.getHandValue() > 21) {
        System.out.println("\nYou Bust!\n");
        yesEnd = true;
      }
      userChoice = playerTester.getUserChoice();
      if (yesEnd) break;
    }

    while (userChoice.equals("s")) {
      while (dealerTester.shouldHit()) {
        Card newDealerCard = deckTester.deal();
        dealerTester.addDealerCard(newDealerCard);
      }

      if ((dealerTester.getDealerValue() >= playerTester.getHandValue() && dealerTester.getDealerValue() < 21) || dealerTester.getDealerValue() == 21) {
        System.out.println("\nThe Dealer Wins!\n");
        yesEnd = true;
      } else if (dealerTester.getDealerValue() > 21) {
        System.out.println("\nYou Win, the dealer busted!\n");
        yesEnd = true;
      } else {
        System.out.println("\nYou Win!\n");
        yesEnd = true;
      }

      System.out.println("\n-----Dealer Cards-----");
      System.out.println(dealerTester.endGameDisplay());

      if (yesEnd) break;
      }
  }
}

class Dealer {
  private Hand dealerHand = new Hand();

  public void addDealerCard(Card newDealerCard) {
    dealerHand.addCard(newDealerCard);
  }

  public boolean shouldHit() {
    if (dealerHand.getHandValue() <= 16 || (dealerHand.getHandValue() == 17 && dealerHand.isAce())) {
      return true;
    } else {
      return false;
    }
  }

  public String inGameDisplay() {
    return dealerHand.dealerHand();
  }

  public String endGameDisplay() {
    String result = dealerHand.toString();
    return result;
  }

  public int getDealerValue() {
    return dealerHand.getHandValue();
  }
}

/**
 * creates an instance of the Hand class
 * adds new card into the hand
 */
class Player {
  private Hand playerHand = new Hand();

  public void add(Card newCard) {
    playerHand.addCard(newCard);
  }

  /**
   * @return the point value of the hand
   */
  public int getHandValue() {
    return playerHand.getHandValue();
  }

  /**
   * @return the user's choice to hit or stand
   */
  public String getUserChoice() {
    Scanner in = new Scanner(System.in);
    System.out.println("Please enter (h) or (s) to hit or stand.");
    String userChoice = in.nextLine();
    in.close();

    return userChoice;
  }

  /**
   * @return the full hand
   */
  public String toString() {
    return playerHand.toString();
  }
}

/**
 * checks if one of the cards is an ace
 * makes ace worth 1 if point value is over 21
 * @return list of cards in hand and total point value
 */
class Hand {
  private ArrayList<Card> noAce = new ArrayList<>();
  private ArrayList<Card> yesAce = new ArrayList<>();
  private boolean isAce = false;

  public void addCard(Card addedCard) {
    if (addedCard.getPointValue() == 1) {
      yesAce.add(addedCard);
    } else {
      noAce.add(addedCard);
    }
  }

  public int getHandValue() {
    int handValue = 0;
    for (int i = 0; i < noAce.size(); i++) {
      handValue = handValue + noAce.get(i).getPointValue();
    }
    for (int i = 0; i < yesAce.size(); i++) {
      if (handValue + 11 > 21) {
        handValue = handValue + 1;
      } else {
        handValue = handValue + 11;
        isAce = true;
      }
    }
    return handValue;
  }

  public boolean isAce() {
    return isAce;
  }

  public String toString() {
    String result = "";
    for (int i = 0; i < noAce.size(); i++) {
      result = result + noAce.get(i).toString() + "\n";
    }
    for (int i = 0; i < yesAce.size(); i++) {
      result = result + yesAce.get(i).toString() + "\n";
    }
    return result + "Current Hand Value: " + getHandValue();
  }

  public String dealerHand() {
    String result = "";
    for (int i = 0; i < noAce.size(); i++) {
      result = noAce.get(i).toString() + "\n";
    }
    for (int i = 0; i < yesAce.size(); i++) {
      result = yesAce.get(i).toString() + "\n";
    }
    return result;
  }
}

class Deck {
  private ArrayList<Card> cards = new ArrayList<>();

  public Deck() {
    for(int i = 0; i <= 3; i++) {
      for(int a = 1; a <= 13; a++) {
        cards.add(new Card(i, a));
      }
    }
  }

  public void shuffle(List<Card> shuffledDeck) {
    for (int i = cards.size()-1; i > 0; i--) {
      int ran = (int)(Math.random() * i);
      Card temp = cards.get(ran);
      cards.set(ran, cards.get(i));
      cards.set(i, temp);
    }
  }

  public Card deal() {
    shuffle(cards);
    Card result = cards.get(cards.size()-1);
    cards.remove(cards.size()-1);
    return result;
  }
}

class Card {
  private int rank;
  private int suit;
  private String point;
  private String value;
  private int pointValue;

  public Card( int cardSuit, int cardRank ) {
    rank = cardRank;
    suit = cardSuit;
  }

  public String toString() {
    if(rank == 1) {
      point = "Ace";
      pointValue = 1;
    }
    if(rank == 2) {
      point = "Two";
      pointValue = 2;
    }
    if(rank == 3) {
      point = "Three";
      pointValue = 3;
    }
    if(rank == 4) {
      point = "Four";
      pointValue = 4;
    }
    if(rank == 5) {
      point = "Five";
      pointValue = 5;
    }
    if(rank == 6) {
      point = "Six";
      pointValue = 6;
    }
    if(rank == 7) {
      point = "Seven";
      pointValue = 7;
    }
    if(rank == 8) {
      point = "Eight";
      pointValue = 8;
    }
    if(rank == 9) {
      point = "Nine";
      pointValue = 9;
    }
    if(rank == 10) {
      point = "Ten";
      pointValue = 10;
    }
    if(rank == 11) {
      point = "Jack";
      pointValue = 10;
    }
    if(rank == 12) {
      point = "Queen";
      pointValue = 10;
    }
    if(rank == 13) {
      point = "King";
      pointValue = 10;
    }
    if(suit == 0) {
      value = "Diamonds";
    }
    if(suit == 1) {
      value = "Spades";
    }
    if(suit == 2) {
      value = "Hearts";
    }
    if(suit == 3) {
      value = "Clubs";
    }

    return point + " of " + value + " (Point Value: " + pointValue + ")";
  }

  public int getPointValue() {
    if(rank == 11) {
      return 10;
    }
    if(rank == 12) {
      return 10;
    }
    if(rank == 13) {
      return 10;
    }
    return rank;
  }
}
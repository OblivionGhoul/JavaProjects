import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * creates new instances for the Deck and Player classes
 * deals and adds the 2 cards to the hand
 * checks user input for hit or stand
 * checks if player wins or loses the game
 */
public class PlayerTester {
  public static void main(String[] args) {
    Deck deckTester = new Deck();
    Player playerTester = new Player();

    Card startingCard = deckTester.deal();
    playerTester.add(startingCard);
    startingCard = deckTester.deal();
    playerTester.add(startingCard);

    System.out.println(playerTester.toString());

    if (playerTester.getHandValue() > 21) {
      return;
    }

    if (playerTester.getHandValue() == 21) {
      System.out.println("You Win!");
      return;
    }

    while (playerTester.getUserChoice().equals("h")) {
      startingCard = deckTester.deal();
      playerTester.add(startingCard);

      System.out.println(playerTester.toString());

      if (playerTester.getHandValue() > 21) {
        System.out.println("You Bust!");
        break;
      }
    }
    if (playerTester.getHandValue() <= 21) {
      System.out.println("You win, thanks for playing!");
    } else {
      System.out.println("You lose, thanks for playing!");
    }
  }
}

/**
 * creates an instance of the Hand class
 * adds new card into the hand
 */
class Player {
  private Hand hand = new Hand();

  public void add(Card newCard) {
    hand.addCard(newCard);
  }

  /**
   * @return the point value of the hand
   */
  public int getHandValue() {
    return hand.getHandValue();
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
    return hand.toString();
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
      }
    }
    return handValue;
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
    for(int i = 0; i < cards.size(); i++) {
      int random = (int)(Math.random() * cards.size());
      Card temp = cards.get(i);
      cards.set(i, cards.get(random));
      cards.set(random, temp);
    }
  }

  public Card deal() {
    shuffle(cards);
    Card result = cards.get(cards.size()-1);
    cards.remove(cards.size()-1);
    return result;
  }
}
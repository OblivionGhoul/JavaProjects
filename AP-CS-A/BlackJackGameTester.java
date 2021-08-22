import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJackGameTester {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("\nHello, enter your name:");
    String name = in.next();
    BlackJackGame newGame = new BlackJackGame(name);
    newGame.startGame();
    in.close();
  }
}

class BlackJackGame {
  private int playerWins = 0;
  private int dealerWins = 0;
  private double playerChips = 500;
  private double betAmount;
  String name;

  Scanner in = new Scanner(System.in);

  public BlackJackGame(String name) {
    this.name = name;
  }

  /**
   * creates new instances for the Deck, Player, and dealer
   * classes deals and adds the 2 cards to the player's and dealer's hand
   * checks user input for hit or stand 
   * checks if player wins or loses the game
   */
  public void startGame() {
    while (playerChips == 0) {
      System.out.println("You are out of chips!");
      return;
    }

    System.out.print("Welcome to BlackJack " + name + "! You currently have " + playerChips + " chips. Enter how much you would like to bet: \n");
    betAmount = in.nextDouble();

    while (playerChips < betAmount || betAmount <= 0) {
      System.out.println("You are betting more chips than you have or betting less than 1, please try again: ");
      betAmount = in.nextDouble();
    }

    // New Instances
    Deck deckTester = new Deck();
    Player playerTester = new Player();
    Dealer dealerTester = new Dealer();
    // Deals first cards to the dealer

    Card dealerStartingCard = deckTester.deal();
    dealerTester.addDealerCard(dealerStartingCard);
    dealerStartingCard = deckTester.deal();
    dealerTester.addDealerCard(dealerStartingCard);
    // Deals first cards to the player
    Card startingCard = deckTester.deal();
    playerTester.add(startingCard);
    startingCard = deckTester.deal();
    playerTester.add(startingCard);
    // Displays player's and dealer's starting cards
    System.out.println("\n-----" + name + "'s Hand-----");
    System.out.println(playerTester.toString());
    System.out.println("\n-----Dealer Hand-----");
    System.out.println(dealerTester.inGameDisplay());

    if (playerTester.getHandValue() == 21) {
      System.out.println("\nYou Win!\n");
      playerWins++;
      playerChips = (1.5 * betAmount) + playerChips;
      if (playAgain()) startGame();
      else finalMessage();
      return;
    }

    String userChoice = playerTester.getUserChoice();

    while (userChoice.equals("h")) {
      startingCard = deckTester.deal();
      playerTester.add(startingCard);
      System.out.println("\n-----" + name + "'s Hand-----");
      System.out.println(playerTester.toString());

      if (playerTester.getHandValue() == 21) {
        System.out.println("\nYou Win!\n");
        playerWins++;
        playerChips = (1.5 * betAmount) + playerChips;
        if (playAgain()) startGame();
        else finalMessage();
        break;
      }

      if (playerTester.getHandValue() > 21) {
        System.out.println("\nYou Bust!\n");
        dealerWins++;
        playerChips -= betAmount;
        if (playAgain()) startGame();
        else finalMessage();
        break;
      }
      userChoice = playerTester.getUserChoice();
    }

    while (userChoice.equals("s")) {
      while (dealerTester.shouldHit()) {
        Card newDealerCard = deckTester.deal();
        dealerTester.addDealerCard(newDealerCard);
      }

      if ((dealerTester.getDealerValue() >= playerTester.getHandValue() && dealerTester.getDealerValue() < 21)
          || dealerTester.getDealerValue() == 21) {
        System.out.println("\nThe Dealer Wins!\n");
        dealerWins++;
        playerChips -= betAmount;
        System.out.println("\n-----Dealer Cards-----");
        System.out.println(dealerTester.endGameDisplay());
        if (playAgain()) startGame();
        else finalMessage();
        break;
      } else if (dealerTester.getDealerValue() > 21) {
        System.out.println("\nYou Win, the dealer busted!\n");
        playerWins++;
        playerChips += betAmount;
        System.out.println("\n-----Dealer Cards-----");
        System.out.println(dealerTester.endGameDisplay());
        if (playAgain()) startGame();
        else finalMessage();
        break;
      } else if (dealerTester.getDealerValue() == playerTester.getHandValue()) {
        System.out.println("\nIts a tie!\n");
        System.out.println("\n-----Dealer Cards-----");
        System.out.println(dealerTester.endGameDisplay());
        if (playAgain()) startGame();
        else finalMessage();
        break;
      } else {
        System.out.println("\nYou Win!\n");
        playerWins++;
        playerChips += betAmount;
        System.out.println("\n-----Dealer Cards-----");
        System.out.println(dealerTester.endGameDisplay());
        if (playAgain()) startGame();
        else finalMessage();
        break;
      }
    }
  }

  /**
   * asks the user if they want to play again
   * returns true if they want to play again
   * @return Boolean
   */
  public boolean playAgain() {
    System.out.println("\nWould you like to play again? (y/n)");
    String result = in.next();
    if (result.equals("y")) return true;
    else return false;
  }

  public void finalMessage() {
    System.out.println("\n" + name + "'s Wins: " + playerWins + "\nDealer Wins: " + dealerWins 
    + "\nChips Left: " + playerChips + "\nThanks for playing " + name + "!");
  }
}

/**
 * creates instance in Hand class method to check if the dealer should hit
 * methods to display the dealer's hand and calculate hand value
 */
class Dealer {
  private Hand dealerHand = new Hand();

  public void addDealerCard(Card newDealerCard) {
    dealerHand.addCard(newDealerCard);
  }

  /**
   * decides if the dealer should hit, which then returns a boolean
   * 
   * @return boolean
   */
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
 * creates an instance of the Hand class adds new card into the hand
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
   * gets user input if they want to hit or stand and returns result
   * 
   * @return String
   */
  public String getUserChoice() {
    Scanner in = new Scanner(System.in);
    System.out.println("\nPlease enter (h) or (s) to hit or stand.");
    String userChoice = in.nextLine();
    in.close();

    return userChoice;
  }

  /**
   * returns the full hand
   * 
   * @return String
   */
  public String toString() {
    return playerHand.toString();
  }
}

/**
 * checks if one of the cards is an ace makes ace worth 1 if point value is over 21
 */
class Hand {
  private ArrayList<Card> noAce = new ArrayList<>();
  private ArrayList<Card> yesAce = new ArrayList<>();
  private boolean isAce = false;

  /**
   * adds ace to the correct deck
   * 
   * @param addedCard
   */
  public void addCard(Card addedCard) {
    if (addedCard.getPointValue() == 1) {
      yesAce.add(addedCard);
    } else {
      noAce.add(addedCard);
    }
  }

  /**
   * gets the value of the hand and returns the result calculates the correct
   * amount for ace
   * 
   * @return int
   */
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

  /**
   * returns the list of the player's hand
   * 
   * @return String
   */
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

  /**
   * returns the list of the dealer's hand
   * 
   * @return String
   */
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

/**
 * Creates an arraylist for all cards in a deck methods to shuffle and deal from
 * this deck
 */
class Deck {
  private ArrayList<Card> cards = new ArrayList<>();

  /**
   * adds cards into the deck
   */
  public Deck() {
    for (int i = 0; i <= 3; i++) {
      for (int a = 1; a <= 13; a++) {
        cards.add(new Card(i, a));
      }
    }
  }

  /**
   * shuffles the deck
   * @param shuffledDeck
   */
  public void shuffle(List<Card> shuffledDeck) {
    for (int i = cards.size() - 1; i > 0; i--) {
      int ran = (int) (Math.random() * i);
      Card temp = cards.get(ran);
      cards.set(ran, cards.get(i));
      cards.set(i, temp);
    }
  }

  /**
   * deals a card from the deck and returns it removes the dealt card from the
   * deck
   * 
   * @return Card
   */
  public Card deal() {
    shuffle(cards);
    Card result = cards.get(cards.size() - 1);
    cards.remove(cards.size() - 1);
    return result;
  }
}

/**
 * creates cards in the check gives a point value, rank, suit for each card
 */
class Card {
  private int rank;
  private int suit;
  private String point;
  private String value;
  private int pointValue;

  public Card(int cardSuit, int cardRank) {
    rank = cardRank;
    suit = cardSuit;
  }

  /**
   * gives each ranked card a point and point value returns the point and point
   * value of each card
   * 
   * @return String
   */
  public String toString() {
    if (rank == 1) {
      point = "Ace";
      pointValue = 1;
    }
    if (rank == 2) {
      point = "Two";
      pointValue = 2;
    }
    if (rank == 3) {
      point = "Three";
      pointValue = 3;
    }
    if (rank == 4) {
      point = "Four";
      pointValue = 4;
    }
    if (rank == 5) {
      point = "Five";
      pointValue = 5;
    }
    if (rank == 6) {
      point = "Six";
      pointValue = 6;
    }
    if (rank == 7) {
      point = "Seven";
      pointValue = 7;
    }
    if (rank == 8) {
      point = "Eight";
      pointValue = 8;
    }
    if (rank == 9) {
      point = "Nine";
      pointValue = 9;
    }
    if (rank == 10) {
      point = "Ten";
      pointValue = 10;
    }
    if (rank == 11) {
      point = "Jack";
      pointValue = 10;
    }
    if (rank == 12) {
      point = "Queen";
      pointValue = 10;
    }
    if (rank == 13) {
      point = "King";
      pointValue = 10;
    }
    if (suit == 0) {
      value = "Diamonds";
    }
    if (suit == 1) {
      value = "Spades";
    }
    if (suit == 2) {
      value = "Hearts";
    }
    if (suit == 3) {
      value = "Clubs";
    }

    return point + " of " + value + " (Point Value: " + pointValue + ")";
  }

  /**
   * returns the point value of each card
   * gives the point value of 10 to each face card
   * @return int
   */
  public int getPointValue() {
    if (rank == 11) {
      return 10;
    }
    if (rank == 12) {
      return 10;
    }
    if (rank == 13) {
      return 10;
    }
    return rank;
  }
}
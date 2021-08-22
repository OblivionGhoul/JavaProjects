// Look at BlackJackGame.java for complete and correct classes (did not add point value as int or remove card from array when card dealt in this file)

import java.util.ArrayList;
import java.util.List;

public class CardTester {
  public static void main(String[] args) {
    Deck test = new Deck();
    List<Card> cards = test.getCards();
    test.printCards();
    test.shuffle(cards);
    test.deal();
  }
}

class Card {
  private int rank;
  private int suit;
  private String point;
  private String value;

  public Card( int cardSuit, int cardRank ) {
    rank = cardRank;
    suit = cardSuit;
  }

  public String toString() {
    if(rank == 1 || rank == 11) {
      point = "Ace";
    }
    if(rank == 2) {
      point = "Two";
    }
    if(rank == 3) {
      point = "Three";
    }
    if(rank == 4) {
      point = "Four";
    }
    if(rank == 5) {
      point = "Five";
    }
    if(rank == 6) {
      point = "Six";
    }
    if(rank == 7) {
      point = "Seven";
    }
    if(rank == 8) {
      point = "Eight";
    }
    if(rank == 9) {
      point = "Nine";
    }
    if(rank == 10) {
      point = "Jack";
    }
    if(rank == 12) {
      point = "Queen";
    }
    if(rank == 13) {
      point = "King";
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

    String str = point + " of " + value;
    return str;
  }

  public int getRank() {
    return rank;
  }

  public String getValue() {
    return value;
  }
}

class Deck {
  List<Card> cards = new ArrayList<>();
  
  public Deck( ) {
    for(int i = 0; i <= 3; i++) {
      for(int a = 1; a <= 13; a++) {
        cards.add(new Card(i, a));
      }
    } 
  }

  public void printCards() {
    for(int i = 0; i < cards.size(); i++) {
      System.out.println(cards.get(i));
    }
  }

  public void shuffle(List<Card> shuffledDeck) {
    for(int i = 0; i < cards.size(); i++) {
      int random = (int)(Math.random() * 52) + 0;
      Card temp = cards.get(i);
      cards.set(i, cards.get(random));
      cards.set(random, temp);
    }
    
    System.out.println("\n-----SHUFFLED DECK-----\n");
    
    for(Card shuffle : shuffledDeck) {
      System.out.println(shuffle);
    }
  }

  public void deal() {
    System.out.print("Dealt Card: " + cards.get(cards.size()-1));
  }
  
  public List<Card> getCards() {
    return cards;
  }
}
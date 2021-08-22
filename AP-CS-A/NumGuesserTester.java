import java.util.Scanner;

public class NumGuesserTester {
    public static void main(String[] args) {
        Scanner max = new Scanner(System.in);
        System.out.println("Enter the max amount for the number: ");
        int maxNum = max.nextInt();
        NumberGuesser guesser = new NumberGuesser(maxNum);
        int numGuesses = guesser.play();
        System.out.println("You guessed it in " + numGuesses + " tries!");
        max.close();
    }
}

class NumberGuesser {
    private int numToGuess;
    private Scanner input;
  
    public NumberGuesser() {
      input = new Scanner(System.in);
      numToGuess = (int)(Math.random() * 10 + 1);
    }
  
    public NumberGuesser(int max) {
      input = new Scanner(System.in);
      numToGuess = (int)(Math.random() * max + 1);
    }
  
    public int play() {
      System.out.println("Guess the number: ");
      int guess = input.nextInt();
      int numTries = 1;
      
      while ( !(numToGuess == guess) ) {
        System.out.println("It's not " + guess + " , please try again.");
        guess = input.nextInt();
  
        numTries++;
      }
      return numTries;
    }
  }
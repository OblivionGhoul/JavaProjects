import java.util.Scanner;

//Minh Dinh, LoopsA4: Bell Mkt Coin Chgr
/**
 * Creates a scanner Creates an instance of a cash register Asks user for input
 * for price of items and amount of money given Calls cashGiven and prints
 * result
 */
class CashRegisterTester_6Dinh {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    CashRegister bellMarketCoinChanger = new CashRegister(200, 200, 200, 200);
    System.out.println("Welcome to the Bell Cash Register made by Minh Dinh\n");
    System.out.print("What is the price first item you want to purchase?");
    bellMarketCoinChanger.purchase(input.nextDouble());
    System.out.print("What is the price second item you want to purchase?");
    bellMarketCoinChanger.purchase(input.nextDouble());
    System.out.print("What is the price third item you want to purchase?");
    bellMarketCoinChanger.purchase(input.nextDouble());
    System.out.print("What is the amount of money given?");
    double cashGiven = input.nextDouble();
    bellMarketCoinChanger.calculateChange(cashGiven);
    System.out.println(bellMarketCoinChanger.toString());
    System.out.println("Welcome to the Bell Cash Register made by Minh Dinh\n");
    System.out.print("What is the price first item you want to purchase?");
    bellMarketCoinChanger.purchase(input.nextDouble());
    System.out.print("What is the price second item you want to purchase?");
    bellMarketCoinChanger.purchase(input.nextDouble());
    System.out.print("What is the price third item you want to purchase?");
    bellMarketCoinChanger.purchase(input.nextDouble());
    System.out.print("What is the amount of money given?");
    cashGiven = input.nextDouble();
    bellMarketCoinChanger.calculateChange(cashGiven);
    System.out.println(bellMarketCoinChanger.toString());
  }
}

/**
 * Initializes instance variables of total, numQuarters, numDimes, numNickels,
 * numPennies Methods that calculate change and amount left in cashh register
 * Returns amount left in cash register
 */
class CashRegister {
  double total = 0;
  int numQuarters;
  int numDimes;
  int numNickels;
  int numPennies;

  /**
   * Constructor that uses data from input and makes them equal to instance
   * variables
   */
  public CashRegister(int quarters, int dimes, int nickels, int pennies) {
    numQuarters = quarters;
    numDimes = dimes;
    numNickels = nickels;
    numPennies = pennies;
  }

  /**
   * Method that uses data from input and gets the total price
   */
  public void purchase(double price) {
    total = total + price;
  }

  /**
   * Method that returns the total amount
   */
  public double total() {
    return total;
  }

  /**
   * Method that calculates change and checks if there is enough money in the
   * cashRegister
   */
  public void calculateChange(double cashGiven) {
    if (cashGiven < total) {
      System.out.println("There is not enough money");
      return;
    }
    double moneyReturn = cashGiven - total;
    int quarters = (int) (moneyReturn / 0.25);
    if (quarters > numQuarters) {
      quarters = numQuarters;
      numQuarters = 0;
    } else {
      numQuarters = numQuarters - quarters;
    }
    moneyReturn = moneyReturn - quarters * 0.25;
    System.out.println("Quarters: " + quarters);
    int dimes = (int) (moneyReturn / 0.10);
    if (dimes > numDimes) {
      dimes = numDimes;
      numDimes = 0;
    } else {
      numDimes = numDimes - dimes;
    }
    moneyReturn = moneyReturn - dimes * 0.10;
    System.out.println("Dimes: " + dimes);
    int nickels = (int) (moneyReturn / 0.05);
    if (nickels > numNickels) {
      nickels = numNickels;
      numNickels = 0;
    } else {
      numNickels = numNickels - nickels;
    }
    moneyReturn = moneyReturn - nickels * 0.05;
    System.out.println("Nickels: " + nickels);
    int pennies = (int) (moneyReturn / 0.01);
    if (pennies > numPennies) {
      pennies = numPennies;
      numPennies = 0;
    } else {
      numPennies = numPennies - pennies;
    }
    moneyReturn = moneyReturn - pennies * 0.01;
    System.out.println("Pennies: " + pennies);
  }

  /**
   * Method that returns message that includes amount left in the cashRegister
   */
  public String toString() {
    String returnString = ("Amount left in the cash register: " + numQuarters + " quarters, " + numDimes + " dimes, "
        + numNickels + " nickels, and " + numPennies + " pennies.");
    return returnString;
  }
}
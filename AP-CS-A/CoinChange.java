import java.util.Scanner;

public class CoinChange {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Register test1 = new Register();
        
        System.out.print("Amount due (in pennies): ");
        int purchaseAmount = inputScanner.nextInt();
        System.out.print("Amount given (in pennies)? ");
        int amountGiven = inputScanner.nextInt();
        test1.calculateChange(amountGiven, purchaseAmount);
        
        inputScanner.close();
      } 
}

class Register {
  public void calculateChange(int amountGiven, int amountDue) {
    int change = amountGiven - amountDue;
    int dollars = change/100;
    change -= dollars * 100;
    int quarters = change/25;
    change -= quarters * 25;
    int dimes = change/10;
    change -= dimes * 10;
    int nickels = change/5;
    change -= nickels * 5;
    int pennies = change/1;
    change -= pennies * 1;
    System.out.println("Dollars: " + dollars);
    System.out.println("Quarters: " + quarters);
    System.out.println("Dimes: " + dimes);
    System.out.println("Nickels: " + nickels);
    System.out.println("Pennies: " + pennies);
  }
}
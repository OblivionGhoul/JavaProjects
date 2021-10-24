import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class TicTacToeTester {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        TicTacToeGame game1 = new TicTacToeGame();

        game1.printBoard();
        game1.runGame(in);

        in.close();
    }
}

class TicTacToeGame {
    private final String[][] gameBoard = 
        { 
            { " ", "|", " ", "|", " " }, 
            { "-", "+", "-", "+", "-" },
            { " ", "|", " ", "|", " " }, 
            { "-", "+", "-", "+", "-" }, 
            { " ", "|", " ", "|", " " }, 
        };

    private ArrayList<Integer> playerPositions = new ArrayList<>();
    private ArrayList<Integer> comPositions = new ArrayList<>();
    
    public void printBoard() {
        for (String[] row : gameBoard) {
            for (String s : row) {
                System.out.print(s);
            }
            System.out.println();
        }
    }

    public void runGame(Scanner in) {
        while (true) {
            System.out.println("Where would you like to move? (1-9): ");
            int playerPos = in.nextInt();

            while(playerPositions.contains(playerPos) || comPositions.contains(playerPos) || playerPos < 1 || playerPos > 9) {
                System.out.println("Please enter a valid position!");
                playerPos = in.nextInt();
            }

            placePiece(playerPos, "player");

            String result = checkWinner();
            if (result.length() > 0) {
                printBoard();
                System.out.println(result);
                break;
            }

            Random randInt = new Random();
            int comPos = randInt.nextInt(9) + 1;

            while(playerPositions.contains(comPos) || comPositions.contains(comPos)) {
                comPos = randInt.nextInt(9) + 1;
            }

            placePiece(comPos, "com");

            printBoard();

            result = checkWinner();
            if (result.length() > 0) {
                printBoard();
                System.out.println(result);
                break;
            }
        }
    }

    public void placePiece(int pos, String user) {
        String symbol = " ";

        if (user.equals("player")) {
            symbol = "X";
            playerPositions.add(pos);
        } else if (user.equals("com")) {
            symbol = "O";
            comPositions.add(pos);
        } else {
            System.out.print("Invalid User!");
        }

        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
        }
    }

    public String checkWinner() {
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);

        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);

        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);

        List<List> win = new ArrayList<>();
        win.add(topRow);
        win.add(midRow);
        win.add(botRow);
        win.add(leftCol);
        win.add(midCol);
        win.add(rightCol);
        win.add(cross1);
        win.add(cross2);
        
        for (List l : win) {
            if (playerPositions.containsAll(l)) {
                return "Yay, you win!";
            } else if (comPositions.containsAll(l)) {
                return "The computer wins :(";
            } else if (playerPositions.size() == 9) {
                if (playerPositions.containsAll(l)) return "Yay, you win!";
                else if (comPositions.containsAll(l)) return "The computer wins :(";
                else return "It is a tie!";
            }
        }

        return "";
    }
}
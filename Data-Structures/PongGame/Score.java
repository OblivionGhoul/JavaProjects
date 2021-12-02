import java.awt.*;

/**
 * This is the Score class which records the score of game
 */
class Score extends Rectangle {
    private static int GAME_WIDTH;
    private static int GAME_HEIGHT;
    private int player1;
    private int player2;
    private boolean oneWin;
    private boolean twoWin;

    public Score(int GAME_WIDTH, int GAME_HEIGHT) {
        Score.GAME_WIDTH = GAME_WIDTH;
        Score.GAME_HEIGHT = GAME_HEIGHT;
        oneWin = false;
        twoWin = false;
    }

    /**
     * updates the score if player 1 scores
     */
    public void score1() {
        player1++;
    }

    /**
     * updates the score if player 2 scores
     */
    public void score2() {
        player2++;
    }

    /**
     * checks if there is a winner
     * @return boolean if there is a winner
     */
    public boolean win() {
        return oneWin || twoWin;
    }

    /**
     * @return the winner
     */
    public int getWinner() {
        if (oneWin) return 1;
        else return 2;
    }

    /**
     * updates the score
     * @Override the draw method in Graphics class
     */
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("SansSerif", Font.PLAIN, 50));

        g.drawLine(GAME_WIDTH / 2, 0, GAME_WIDTH / 2, GAME_HEIGHT);

        // draws the digits individually(first tens digit then ones digit)
        g.drawString(player1 / 10 + String.valueOf(player1 % 10), (GAME_WIDTH / 2) - 85, 50);
        g.drawString(player2 / 10 + String.valueOf(player2 % 10), (GAME_WIDTH / 2) + 20, 50);

        if (player1 >= 10) {
            g.drawString("Player 1 Wins!", 0, GAME_HEIGHT - 10);
            oneWin = true;
        }
        if (player2 >= 10) {
            g.drawString("Player 2 Wins!", GAME_WIDTH / 2, GAME_HEIGHT - 10);
            twoWin = true;
        }
    }
}

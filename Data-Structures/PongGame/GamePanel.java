import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 This class creates the game panel that shows the pong game that implements an interface that is executed by a thread
 */
class GamePanel extends JPanel implements Runnable {
    private static final int GAME_WIDTH = 1000;
    private static final int GAME_HEIGHT = 500;
    private static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);
    private static final int BALL_DIAMETER = 15;
    private static final int PADDLE_WIDTH = 15;
    private static final int PADDLE_HEIGHT = 100;
    private final double GRAVITY_CONSTANT = 1;
    private final boolean GRAVITY;
    private final boolean AI;
    private final boolean SIMULATION;

    private Paddle paddle1;
    private Paddle paddle2;
    private Ball ball;
    private final Score score;

    public GamePanel(boolean isCom, boolean isGravity, boolean isSimulation) {
        AI = isCom;
        SIMULATION = isSimulation;
        GRAVITY = isGravity;

        newBall();
        checkAI();
        score = new Score(GAME_WIDTH, GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        Thread gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     creates a new Ball when a point is scored and sets the Ball to a random ball to a set size but random position in the middle of the game panel
     */
    public void newBall() {
        Random random = new Random();
        ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2), random.nextInt(GAME_HEIGHT-BALL_DIAMETER), BALL_DIAMETER, BALL_DIAMETER, GRAVITY);
    }

    /**
     creates 2 paddles which are the paddles which the player controls
     */
    public void newPaddles() {
        paddle1 = new Player(0,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
        paddle2 = new Player(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);
    }

    /**
     * creates paddles for the Player and AI
     */
    public void newAI() {
        paddle1 = new Player(0,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
        paddle2 = new AI(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,ball);
    }

    /**
     * creates paddles for AI (Simulation Testing)
     */
    public void onlyAI() {
        paddle1 = new AI(0,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,ball);
        paddle2 = new AI(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,ball);
    }

    /**
     * Checks when AI is needed
     */
    public void checkAI(){
        if(SIMULATION) {
            onlyAI();
        }
        else if(AI) {
            newAI();
        }
        else{
            newPaddles();
        }
    }

    /**
     @param g is the Graphics panel in java.awt
     This is the method that generates
     */
    public void paint(Graphics g) {
        Image image = createImage(getWidth(), getHeight());
        Graphics graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
    }

    /**
     This method overrides the draw method in Graphics from java.awt and generates the paddles, balls, score, and synchronises the toolkits graphic state
     */
    public void draw(Graphics g) {
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);
        Toolkit.getDefaultToolkit().sync();
    }

    /**
     This moves the ball and paddles
     */
    public void move() {
        paddle1.move();
        paddle2.move();
        ball.move();
    }

    /**
     This method checks collision to see if the ball collides with either the top or bottom of
     the Game panel or with the paddle and then changes the velocity every collision
     */
    public void checkCollision() {
        //is ball collides with the top
        if(ball.y <=0) {
            ball.setYDirection(-ball.getYSpeed());
            ball.y = 0;
        }
        //is ball collides with the bottom
        if(ball.y >= GAME_HEIGHT-BALL_DIAMETER) {
            ball.setYDirection(-ball.getYSpeed());

            //gives ball gravity to bounce
            if(GRAVITY){
                int num = (int)(ball.getYSpeed() * GRAVITY_CONSTANT);
                ball.setYDirection(num);
                ball.y = GAME_HEIGHT-BALL_DIAMETER;
            }

        }

        //if ball collides with paddle1
        if(ball.intersects(paddle1)) {
            ball.setXDirection( Math.abs(ball.getXSpeed()) +1 );

            //ensures that the ball will always move either up or down to stop infinite loops
            if(ball.getYSpeed()>0)
                ball.setYDirection( ball.getYSpeed()+1);
            else
                ball.setYDirection( ball.getYSpeed()-1);

            ball.setXDirection(ball.getXSpeed());
            ball.setYDirection(ball.getYSpeed());
        }
        //if ball collides with paddle2
        if(ball.intersects(paddle2)) {
            ball.setXDirection( Math.abs(ball.getXSpeed()) +1 );

            //ensures that the ball will always move either up or down to stop infinite loops
            if(ball.getYSpeed()>0)
                ball.setYDirection( ball.getYSpeed()+1);
            else
                ball.setYDirection( ball.getYSpeed()-1);

            ball.setXDirection(-ball.getXSpeed());
            ball.setYDirection(ball.getYSpeed());
        }

        //checks if the paddle is colliding with the top or bottom of the panel
        if(paddle1.y<=0)
            paddle1.y=0;
        if(paddle1.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
            paddle1.y = GAME_HEIGHT-PADDLE_HEIGHT;

        if(paddle2.y<=0)
            paddle2.y=0;
        if(paddle2.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
            paddle2.y = GAME_HEIGHT-PADDLE_HEIGHT;


        //checks if paddle is colliding with the middle of the panel
        if(paddle1.x >= (GAME_WIDTH/2)-PADDLE_WIDTH)
            paddle1.x = (GAME_WIDTH/2)-PADDLE_WIDTH;
        if(paddle2.x <= GAME_WIDTH/2)
            paddle2.x = GAME_WIDTH/2;


        //checks paddle collisions with the sides of the panel
        if(paddle1.x <= 0)
            paddle1.x = 0;
        if(paddle2.x >= GAME_WIDTH-PADDLE_WIDTH)
            paddle2.x = GAME_WIDTH-PADDLE_WIDTH;

        //scoring on the left side
        if(ball.x <=0) {
            score.score2();
            newBall();
            checkAI();
        }

        //scoring on the right side
        if(ball.x >= GAME_WIDTH-BALL_DIAMETER) {
            score.score1();
            newBall();
            checkAI();
        }
    }

    /**
     Runs the game
     */
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while(true) {
            long now = System.nanoTime();
            delta += (now -lastTime)/ns;
            lastTime = now;
            if(delta >=1) {
                move();
                checkCollision();
                repaint();
                delta--;

                if(score.win()){
                    String winMessage = "Player 1 Wins!";

                    //asks if the player wants to play again
                    if (score.getWinner() == 2) winMessage = "Player 2 Wins!";
                    int gameMenu = JOptionPane.showConfirmDialog(null, winMessage + " Play Again?", "Game Menu", JOptionPane.YES_NO_OPTION);

                    //closes old game
                    GameFrame oldFrame = PongGame.getFrame();
                    oldFrame.setVisible(false);
                    oldFrame.dispose();

                    //restarts game if the player wants to play again
                    if (gameMenu == 0) PongGame.main(null);
                    break;
                }
            }
        }
    }

    /**
     This checks if a key is pressed and calls the keyPressed method in the Paddle class
     */
    public class AL extends KeyAdapter {
        //action listener
        public void keyPressed(KeyEvent e) {
            ((Player) paddle1).keyPressed(e);
            if(paddle2 instanceof Player) {
                ((Player) paddle2).keyPressed(e);
            }
        }
        //key released
        public void keyReleased(KeyEvent e) {
            ((Player) paddle1).keyReleased(e);
            if(paddle2 instanceof Player) {
                ((Player) paddle2).keyReleased(e);
            }
        }
    }
}
import java.awt.*;
import java.util.*;

/**
 * creates the ball for the game
 */
class Ball extends Rectangle {
    private int xVelocity;
    private int yVelocity;
    private final boolean gravity;
    private final int initialSpeed = 3;
    private final int dir = 6;

    /**
     * @param x: initial x position
     * @param y: initial y position
     * @param width: width of the ball
     * @param height: height of the ball
     */
    public Ball(int x, int y, int width, int height, boolean gravity) {
        super(x, y, width, height);
        this.gravity = gravity;
        Random random = new Random();

        int randomXDirection = random.nextInt(dir + dir) - dir;
        if (randomXDirection == 0)
            randomXDirection = random.nextInt(dir) - dir;
        setXDirection(randomXDirection * initialSpeed);

        int randomYDirection = random.nextInt(dir + dir) - dir;
        if (randomYDirection == 0)
            randomYDirection = random.nextInt(dir) - dir;
        setYDirection(randomYDirection * initialSpeed);

    }

    /**
     * mutator method to change xVelocity
     */
    public void setXDirection(int randomXDirection) {
        xVelocity = randomXDirection;
    }

    /**
     * mutator method to change yVelocity
     */
    public void setYDirection(int randomYDirection) {
        yVelocity = randomYDirection;
    }

    /**
     * mutator method to change xVelocity
     */
    public int getXSpeed() {
        return xVelocity;
    }

    /**
     * mutator method to change yVelocity
     */
    public int getYSpeed() {
        return yVelocity;
    }

    /**
     * Moves the ball according to the x and y velocity
     */
    public void move() {
        x += xVelocity;
        y += yVelocity;
        // ball increases with height over time
        if (gravity)
            yVelocity += 1;
    }

    /**
     * @Override draw method of graphics rectangle overrides the draw method in the Graphics class
     */
    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(x, y, width, height);
    }
}
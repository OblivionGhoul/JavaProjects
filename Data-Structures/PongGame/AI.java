import java.awt.*;

/**
 * class for the computer that plays against the player
 */
class AI extends Paddle {
    private final Ball ball;

    public AI(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, Ball ball) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        this.ball = ball;
    }

    /**
     * moves paddle in the direction of the ball
     */
    public void move() {
        if (super.y >= ball.y) {
            super.y -= super.getSpeed();
        } else {
            super.y += super.getSpeed();
        }

    }

    /**
     * update paddle for AI
     * @param g of the Graphics class
     */
    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }
}
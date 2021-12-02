import java.awt.*;

/**
 This class creates a paddle that creates the paddles the controllable paddles
 */
class Paddle extends Rectangle {
    private final int PADDLE_SPEED = 10;

    /**
     @param x: initial x location
     @param y: initial y location
     @param PADDLE_WIDTH: PADDLE_WIDTH is final variable called for width
     @param PADDLE_HEIGHT: PADDLE_HEIGHT is final variable called for height

     Paddle constructor which instantiates the initial position, and size. Extends the Graphics Rectangle Class
     */
    public Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT){
        super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
    }

    /**
     * moves the paddle
     */
    public void move() {
        super.y -= PADDLE_SPEED;
        super.x -= PADDLE_SPEED;
    }

    /**
     * @return the speed of the paddle
     */
    public int getSpeed(){
        return PADDLE_SPEED;
    }

    /**
     @param g of the Graphics class
     */
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, width, height);
    }
}
import java.awt.event.*;

class Player extends Paddle {
    private int xVelocity;
    private int yVelocity;
    private final int id;

    /**
     @param x: initial x location
     @param y: initial y location
     @param PADDLE_WIDTH: PADDLE_WIDTH is final variable called for width
     @param PADDLE_HEIGHT: PADDLE_HEIGHT is final variable called for height
     @param id in order to keep track of player action listeners
     */
    public Player(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT,int id){
        super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
        this.id = id;
    }

    //moving the paddles according to key press and the id that is instantiated in the constructor
    public void keyPressed(KeyEvent e) {
        switch (id) {
            //left panel id #1
            case 1 -> {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(-super.getSpeed());
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(super.getSpeed());
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    setXDirection(-super.getSpeed());
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    setXDirection(super.getSpeed());
                }
            }
            //right panel id #2
            case 2 -> {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(-super.getSpeed());
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(super.getSpeed());
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    setXDirection(-super.getSpeed());
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    setXDirection(super.getSpeed());
                }
            }
        }
    }

    /**
     * checks if the key is released the paddle stops motion
     * @param e of the KeyEvent class
     */
    public void keyReleased(KeyEvent e) {
        switch ( id ) {
            //paddle 1(left)
            case 1 -> {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_A) {
                    setXDirection(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_D) {
                    setXDirection(0);
                }
            }
            //paddle 2(right)
            case 2 -> {
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    setXDirection(0);
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    setXDirection(0);
                }
            }
        }
    }

    /**
     mutator method to change yVelocity instance variable
     */
    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }

    /**
     mutator method to change xVelocity instance variable
     */
    public void setXDirection(int xDirection) {
        xVelocity = xDirection;
    }

    /**
     mutator method to change super instance variable of y position
     */
    public void move() {
        y = y + yVelocity;
        x = x + xVelocity;
    }
}

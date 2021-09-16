import acm.graphics.GOval;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;

public class BouncingShapes extends GraphicsProgram {
    private static final double ballRadius = 20;
    private ArrayList<GOval> balls;
    private ArrayList<Double> deltaX;
    private ArrayList<Double> deltaY;

    public static void main(String[] args) {
        new BouncingShapes().start(args);
    }

    public void run() {
        GRect rec = new GRect(500, 500);
        add(rec);

        Scanner in = new Scanner(System.in);
        System.out.println("Enter Amount Of Balls: ");
        int numBalls = in.nextInt();

        balls = new ArrayList<>(numBalls);
        deltaX = new ArrayList<>(numBalls);
        deltaY = new ArrayList<>(numBalls);

        for (int i = 0; i < numBalls; i++) {
            double dx = (Math.random() * 3) - 1;
            double dy = (Math.random() * 3) - 1;
            deltaX.add(dx);
            deltaY.add(dy);
            balls.add(new Ball((Math.random() * 400) + 50, (Math.random() * 400) + 50, ballRadius * 2, ballRadius * 2));
            add(balls.get(i));
        }

        while (true) {
            wallBounce();
            ballExplode();
        }
    }

    public void wallBounce() {
        for (int i = 0; i < balls.size(); i++) {
            double bx = balls.get(i).getX();
            double by = balls.get(i).getY();

            if (bx < 0 || bx > 500 - (ballRadius * 2)) deltaX.set(i, -deltaX.get(i));
            if (by < 0 || by > 500 - (ballRadius * 2)) deltaY.set(i, -deltaY.get(i));
            balls.get(i).move(deltaX.get(i), deltaY.get(i));

            pause(1);
        }
    }

    public void ballExplode() {
        for (int i = 0; i < balls.size(); i++) {
             for (int j = i + 1; j < balls.size(); j++) {
                if (Math.hypot(balls.get(i).getX() - balls.get(j).getX(), balls.get(i).getY() - balls.get(j).getY()) <= ballRadius * 2) {
                    balls.get(j).setVisible(false);
                    balls.remove(j);

                    double dx = (Math.random() * 3) + 1;
                    double dy = (Math.random() * 3) + 1;
                    deltaX.set(i, dx);
                    deltaY.set(i, dy);
                    balls.get(i).move(dx, dy);

                    pause(1);
                }
            }
        }
    }
}

class Ball extends GOval {
    public Ball(double v, double v1, double v2, double v3) {
        super(v, v1, v2, v3);

        ArrayList<Color> colors = new ArrayList<>();
        colors.add(Color.CYAN);
        colors.add(Color.YELLOW);
        colors.add(Color.RED);
        colors.add(Color.GREEN);
        colors.add(Color.ORANGE);
        colors.add(Color.PINK);
        colors.add(Color.MAGENTA);
        int index = (int)(Math.random() * colors.size());

        super.setFillColor(colors.get(index));
        super.setFilled(true);
    }
}
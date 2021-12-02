/**
 @author Benjamin Banh
 @author Minh Dinh
 */
public class PongGame {
    private static GameFrame frame;

    public static void main(String[] args) {
        frame = new GameFrame();
        System.out.println(frame);
    }

    /**
     * @return current GameFrame object
     */
    public static GameFrame getFrame() {
        return frame;
    }
}

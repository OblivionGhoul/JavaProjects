import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CountedTester_Dinh {

    /**
    *  @author Minh Dinh
    *  @throws Exception
    *  Creates JOptionPane message with text from args
    */
    public static void main(String[] args) throws Exception {
        URL imageLocation = new URL("https://horstmann.com/java4everyone/duke.gif");
        JOptionPane.showMessageDialog(null, args[0], "Welcome", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
    }
}

class Singleton {
    private static Singleton instance = null;

    /**
     * Makes sure only one instance of itself can be created
     * @return the Singleton instance
     */
    public static Singleton getSingletonInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

class Counted {
    private static int count;

    /**
     * Counts the the number of instances of Counted
     */
    public Counted() {
        count++;
    }
}
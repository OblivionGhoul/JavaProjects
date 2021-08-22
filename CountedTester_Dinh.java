import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CountedTester_Dinh {
    public static void main(String[] args) throws Exception {
        URL imageLocation = new URL("https://horstmann.com/java4everyone/duke.gif");
        JOptionPane.showMessageDialog(null, args[0], "Welcome", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
    }
}

class Singleton {
    private static Singleton instance = null;

    public static Singleton getSingletonInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

class Counted {
    private static int count;

    public Counted() {
        count++;
    }
}
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CountedTester {
    /**
     *  @throws MalformedURLException
     *  Creates JOptionPane message with text from args
     */
    public static void main(String[] args) throws MalformedURLException {
        URL imageLocation = new URL("https://code.bcp.org/anc/bellarmine-college-preparatory-logo.jpg");
        JOptionPane.showMessageDialog(null, args[0], "Welcome", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));

        Singleton.getSingletonInstance();

        Counted count1 = new Counted();
        Counted count2 = new Counted();
        Counted count3 = new Counted();

        System.out.println(count1.getCount());
        System.out.println(count2.getCount());
        System.out.println(count3.getCount());
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
     * Counts the number of instances of Counted
     */
    public Counted() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
import java.net.URL;
import javax.swing.*;
import java.net.MalformedURLException;

public class CountedTester {
    public static void main(String[] args) throws MalformedURLException {
        URL imageLocation = new URL("http://horstmann.com/java4everyone/duke.gif");
        JOptionPane.showMessageDialog(null, "Hello", "Title", JOptionPane.PLAIN_MESSAGE, new ImageIcon(imageLocation));
    }
}
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;

public class WebReader {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner console = new Scanner(System.in);

        System.out.print("URL: ");
        String url = console.next();
        URL pageUrl = new URL(url);
        Scanner urlReader = new Scanner(pageUrl.openStream());

        System.out.print("Output file: ");
        String outputFileName = console.next();

        PrintWriter out = new PrintWriter(outputFileName);

        while (urlReader.hasNext()) {
            String data = urlReader.next();
            out.print(data);
        }

        out.close();
        console.close();
        urlReader.close();
    }
}
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FilesApp {

    public void saveResultInTXT(ArrayList <String> resultList) throws FileNotFoundException {

        PrintWriter out = new PrintWriter("src//lib//fileWithNameAndPriceDevices.txt");
        for (String line : resultList) {
            out.println(line);
        }
        out.close();

    }
}
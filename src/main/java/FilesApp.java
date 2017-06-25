import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FilesApp {

    public void saveResultInTXT(ArrayList<String> resultList) throws FileNotFoundException {

        PrintWriter out = new PrintWriter("src//lib//file.txt");


        for (String line : resultList) {
                out.println(line);
            out.close();
        }
    }

    public void saveResultInTXT(String notFound) throws FileNotFoundException {
        PrintWriter out = new PrintWriter("src//lib//file.txt");
            out.println(notFound);
            out.close();
        }
    }

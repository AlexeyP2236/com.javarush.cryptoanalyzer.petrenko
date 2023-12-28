import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WorkingWithFile {
    public static char[] readerFile(String url) {
        char[] charText = new char[url.length()];
        try {
            Path fileName = Path.of(url);
            String inStreamString = Files.readString(fileName);
            System.out.println(inStreamString);
            charText = inStreamString.toCharArray();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return charText;
    }

    public static void writeFile(String directory, String code, int modeWrite) {
        String urlCopy = "";
        if (modeWrite == 1) urlCopy = directory + "-code.txt";
        else if (modeWrite == 2) urlCopy = directory + "-decode.txt";
        else if (modeWrite == 3) urlCopy = directory + "-decode_brute_force.txt";
            try {
                Path path = Path.of(urlCopy);
                Files.writeString(path, code);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
    }
}

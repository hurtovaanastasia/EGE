import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IOException {
        String s = Files.readString(Paths.get("24_demo.txt"));

        Pattern pat = Pattern.compile("(?:XYZ)+");
        Matcher match = pat.matcher(s);

        int maxLen = 0;

        while (match.find()) {
            String found = match.group();

            if (s.contains(found + "X")) {
                found += "X";
                if (s.contains(found + "Y")) {
                    found += "Y";
                }
            }

            if (found.length() > maxLen) {
                maxLen = found.length();
            }
        }

        System.out.println("Максимальная длина цепочки вида XYZXYZXYZ... = " + maxLen);
    }
}

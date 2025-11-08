import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try {
            String s = Files.readString(Paths.get("24_demo.txt"));

            Pattern pattern = Pattern.compile("(?:XYZ)+");
            Matcher matcher = pattern.matcher(s);

            int maxLen = 0;

            while (matcher.find()) {
                String found = matcher.group();

                // проверяем возможность добавить X и Y
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

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            System.out.println("Проверьте, что файл существует и его путь и название  указаны правильно.");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так: " + e.getMessage());
        }
    }
}

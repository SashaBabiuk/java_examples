package regularEx;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    // Special characters - metacharacters
    // []/^$.|?*+()
    public static void main(String[] args) {
        //for [] exist special symbol ]\^-
        //^  заперечення q[^u] після q можуть йти всі символи окрім u
        Pattern p = Pattern.compile("([0-9]{0,3}[.])([0-9]{0,3}[.])([0-9]{0,3}[.])([0-9]{0,3})");

        Matcher m = p.matcher(Main.readFile("src/regularEx/input.txt"));
        while (m.find()) {
            System.out.printf("%s | %s \n", m.start(), m.group());
        }
    }

    private static String readFile(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Path.of(fileName));
            return String.join("\n", lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

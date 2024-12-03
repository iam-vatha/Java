package AdventOfCode.y2024.Day3.Part2;
import FileCreater.FileCreator;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.nio.file.Path;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        String line;
        int sum = 0;
        try {
            FileCreator fc = new FileCreator();
            Path path = fc.GetAdventOfCodeInputPath(2024, 3, 2);
            line = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String regex = "(mul\\(\\d{1,3},\\d{1,3}\\)|do\\(\\)|don't\\(\\))";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        boolean state = true;

        while (matcher.find()) {
            String currentString = matcher.group();
            if (currentString.startsWith("mul")) {
                StringBuilder iterator = new StringBuilder();
                ArrayList<Integer> nums = new ArrayList<>();
                for (char c : currentString.toCharArray()) {
                    if (c == ',' || c == ')') {
                        nums.add(Integer.parseInt(iterator.toString()));
                        iterator.setLength(0);
                    } else if (Character.isDigit(c)) {
                        iterator.append(c);
                    }
                }
                if (nums.size() == 2 && state) {
                    sum += (nums.get(0) * nums.get(1));
                } else if (nums.size() == 2 && !state) { //state is not always true here, it just starts true and doesn't consider that it will change below
                    sum += 0;
                    nums.clear();
                }
            } else if (currentString.equals("do()")) {
                System.out.println("in do");
                state = true;
            } else if (currentString.equals("don't()")) {
                System.out.println("in dont");
                state = false;
            }
        }
        System.out.println(sum);
    }
}

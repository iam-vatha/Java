package AdventOfCode.y2024.Day2.Part1;
import FileCreater.FileCreator;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        try {
            // Read the input file
            FileCreator fc = new FileCreator();
            Path path = fc.GetAdventOfCodeInputPath(2024, 2, 1);
            List<String> lines = Files.readAllLines(path);
            // Count the safe reports
            long safeCount = lines.stream()
                    .map(line -> Arrays.stream(line.split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList()))
                    .filter(Main::isSafe)
                    .count();

            // Print the result
            System.out.println("Number of safe reports: " + safeCount);

        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
        }
    }

    // Method to check if a report is safe
    private static boolean isSafe(List<Integer> levels) {
        boolean allIncreasing = IntStream.range(1, levels.size())
                .allMatch(i -> levels.get(i) > levels.get(i - 1) &&
                        levels.get(i) - levels.get(i - 1) <= 3);

        boolean allDecreasing = IntStream.range(1, levels.size())
                .allMatch(i -> levels.get(i) < levels.get(i - 1) &&
                        levels.get(i - 1) - levels.get(i) <= 3);

        return allIncreasing || allDecreasing;
    }
}

package AdventOfCode.y2024.Day2.Part2;
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
            FileCreator fc = new FileCreator();
            Path path = fc.GetAdventOfCodeInputPath(2024, 2, 2);
            List<String> lines = Files.readAllLines(path);
            // Count the safe reports with the Problem Dampener
            long safeCount = lines.stream()
                    .map(line -> Arrays.stream(line.split(" "))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList()))
                    .filter(Main::isSafeOrCanBeMadeSafe)
                    .count();

            // Print the result
            System.out.println("Number of safe reports: " + safeCount);

        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
        }
    }

    // Checks if a report is safe as-is or can be made safe by removing one level
    private static boolean isSafeOrCanBeMadeSafe(List<Integer> levels) {
        // Check if the report is already safe
        if (isSafe(levels)) {
            return true;
        }

        // Check if removing any single level makes the report safe
        return IntStream.range(0, levels.size())
                .anyMatch(i -> {
                    List<Integer> modifiedLevels = removeLevel(levels, i);
                    return isSafe(modifiedLevels);
                });
    }

    // Helper method to check if a report is safe
    private static boolean isSafe(List<Integer> levels) {
        boolean allIncreasing = IntStream.range(1, levels.size())
                .allMatch(i -> levels.get(i) > levels.get(i - 1) &&
                        levels.get(i) - levels.get(i - 1) <= 3);

        boolean allDecreasing = IntStream.range(1, levels.size())
                .allMatch(i -> levels.get(i) < levels.get(i - 1) &&
                        levels.get(i - 1) - levels.get(i) <= 3);

        return allIncreasing || allDecreasing;
    }

    // Helper method to remove a level at a specific index
    private static List<Integer> removeLevel(List<Integer> levels, int index) {
        return IntStream.range(0, levels.size())
                .filter(i -> i != index)
                .mapToObj(levels::get)
                .collect(Collectors.toList());
    }
}

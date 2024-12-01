package AdventOfCode.y2024.Day1.Part2;
import FileCreater.FileCreator;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FileCreator fileCreator = new FileCreator();

        System.out.println(fileCreator.GetAdventOfCodePath(2024, 1,2) + "\\input.txt");

        ArrayList<String> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(Paths.get(fileCreator.GetAdventOfCodePath(2024, 1, 2) + "\\input.txt"));
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Couldn't find the file");
        }

        int runningTotal = 0;
        ArrayList<String> leftSideList = new ArrayList<>();
        HashMap<String, Integer> rightSideMap = new HashMap<>();

        for (String line: list) {
            String[] split = line.split(" {3}");
            leftSideList.add(split[0]);
            rightSideMap.put(split[1], rightSideMap.getOrDefault(split[1], 0) + 1);
        }

        System.out.println(rightSideMap.get("22998"));

        for (String number: leftSideList) {
            if (rightSideMap.containsKey(number)) {
                int totalForNumber = Integer.parseInt(number) * rightSideMap.get(number);
                runningTotal += totalForNumber;
            }
        }
        System.out.println(runningTotal);
    }
}
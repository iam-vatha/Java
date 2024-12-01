package AdventOfCode.y2024.Day1.Part1;
import FileCreater.FileCreator;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        FileCreator fileCreator = new FileCreator();

        System.out.println(fileCreator.GetAdventOfCodePath(2024, 1, 1) + "\\input.txt");

        ArrayList<String> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(Paths.get(fileCreator.GetAdventOfCodePath(2024, 1, 1) + "\\input.txt"));
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Couldn't find the file");
        }

        ArrayList<Integer> leftList = new ArrayList<>();
        ArrayList<Integer> rightList = new ArrayList<>();

        for (String line: list) {
            String[] numberSet = line.split(" {3}");
            leftList.add(Integer.parseInt(numberSet[0]));
            rightList.add(Integer.parseInt(numberSet[1]));
        }

        Collections.sort(leftList);
        Collections.sort(rightList);

        int totalDistance = 0;

        for (int i = 0; i < leftList.size(); i++) {
            int leftNumber = leftList.get(i);
            int rightNumber = rightList.get(i);

            if (leftNumber == rightNumber) {
                continue;
            } else if (leftNumber > rightNumber) {
                totalDistance += Math.abs(leftNumber - rightNumber);
            } else {
                totalDistance += Math.abs(rightNumber - leftNumber);
            }
        }

        System.out.println(totalDistance);
    }
}
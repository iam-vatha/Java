/*
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

import FileCreater.FileCreater;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FileCreater fileCreater = new FileCreater();

        ArrayList<String> list = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(Paths.get(fileCreater.GetFilePath() + "input.txt"));
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("Could't find the file");
        }

        for (String line: list) {
            String[] numberSet = line.split(" ");
            System.out.println(numberSet);
        }
    }
}

*/
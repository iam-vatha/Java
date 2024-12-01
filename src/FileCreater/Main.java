package FileCreater;
import java.time.Year;

public class Main {
    public static void main(String[] args) {
        FileCreator fileCreator = new FileCreator();

        String AOCFilePath = fileCreator.GetRootFilePath() + "\\src\\AdventOfCode";
        fileCreator.MakeDirectory(AOCFilePath);

        int currentYear = Year.now().getValue();
        String currentYearPath = AOCFilePath + "\\" + currentYear;
        fileCreator.MakeDirectory(currentYearPath);

        for (int i = 1; i < 31; i++) {
            String currentDayString = currentYearPath + "\\Day" + i;
            fileCreator.MakeDirectory(currentDayString);
            
            for (int j = 1; j < 3; j++) {
                String currentPartString = currentDayString + "\\Part" + j;
                fileCreator.MakeDirectory(currentPartString);

                String mainJavaFilePath = currentPartString + "\\Main.java";
                fileCreator.CreateEmptyFile(mainJavaFilePath);
            }
        }
    }
}
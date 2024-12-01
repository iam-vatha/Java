import java.time.Year;

public class Main {
    public static void main(String[] args) {
        FileCreater fileCreater = new FileCreater();

        String AOCFilePath = fileCreater.GetFilePath() + "\\AdventOfCode";
        fileCreater.MakeDirectory(AOCFilePath);

        int currentYear = Year.now().getValue();
        String currentYearPath = AOCFilePath + "\\" + currentYear;
        fileCreater.MakeDirectory(currentYearPath);

        for (int i = 1; i < 31; i++) {
            String currentDayString = currentYearPath + "\\Day" + i;
            fileCreater.MakeDirectory(currentDayString);
            
            for (int j = 1; j < 3; j++) {
                String currentPartString = currentDayString + "\\Part" + j;
                fileCreater.MakeDirectory(currentPartString);

                String srcFilePath = currentPartString + "\\src";
                fileCreater.MakeDirectory(srcFilePath);

                String mainJavaFilePath = srcFilePath + "\\Main.java";
                fileCreater.createEmptyFile(mainJavaFilePath);
            }
        }
    }
}
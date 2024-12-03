package FileCreater;
import java.io.IOException;
import java.io.File;
import java.nio.file.Paths;
import java.nio.file.Path;

public class FileCreator {
    final private String rootFolderPath = FindRootFolderPath();

    public FileCreator(){}

    public String GetRootFilePath() {
        return this.rootFolderPath;
    }

    private String FindRootFolderPath() {
        try {
            return new java.io.File(".").getCanonicalPath();
        } catch (IOException e) {
            System.out.println("Couldn't resolve the current path, closing program");
            System.exit(0);
            return null;
        }
    }

    public Path GetAdventOfCodePath(int year, int day, int part) {
        return FindAdventOfCodePath(year, day, part);
    }

    private Path FindAdventOfCodePath(int year, int day, int part) {
        try {
            return Paths.get("").toAbsolutePath().resolve("src/AdventOfCode/y" + year + "/Day" + day + "/Part" + part);
        } catch (Exception e) {
            System.out.println("Couldn't resolve the current path, closing program");
            System.exit(0);
            return null;
        }
    }

    public Path GetAdventOfCodeInputPath(int year, int day, int part) {
        return FindAdventOfCodeInputPath(year, day, part);
    }

    private Path FindAdventOfCodeInputPath(int year, int day, int part) {
        try {
            return Paths.get("").toAbsolutePath().resolve("src/AdventOfCode/y" + year + "/Day" + day + "/Part" + part + "/input.txt");
        } catch (Exception e) {
            System.out.println("Couldn't resolve the current path, closing program");
            System.exit(0);
            return null;
        }
    }

    public void MakeDirectory(String path) {
        File folder = new File(path);
        if (!folder.exists()) {
            boolean success = folder.mkdir();
            if (success) {
                System.out.println("Folder created: " + path);
            } else {
                System.out.println("Failed to create folder: " + path);
            }
        } else {
            System.out.println("That file already exists at path: " + path);
        }
    }

    public void CreateEmptyFile(String filePath) {
        try {
            File file = new File(filePath);
            boolean created = file.createNewFile();
            if (created) {
                System.out.println("Created empty file: " + filePath);
            } else {
                System.out.println("File already exists: " + filePath);
            }
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }
    }
}
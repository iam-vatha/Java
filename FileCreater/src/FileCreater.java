import java.io.IOException;
import java.io.File;

public class FileCreater {
    private String path = FindFilePath();

    public FileCreater(){};

    public String GetFilePath() {

        return this.path;
    }

    private String FindFilePath() {
        try {
            return new java.io.File(".").getCanonicalPath();
        } catch (IOException e) {
            System.out.println("Couldn't resolve the current path, closing program");
            System.exit(0);
            return null; //only present for the compiler
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

    public void createEmptyFile(String filePath) {
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
package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * class to read the contents in the file
 */
public final class FileUtils {
    /**
     * read the contents in the file
     * @param filePath send the filePath as the param to get the contents from the file
     * @return list of strings (all the lines in the file)
     * @throws IOException
     */
    public static List<String> getFileContents(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }

    private FileUtils() {
    }
}

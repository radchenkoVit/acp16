package store.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StringUtils {
    public static String loadFileIntoString(String filePath) throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath, new String[0])));
    }
}

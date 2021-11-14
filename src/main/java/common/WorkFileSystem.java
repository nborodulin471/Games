package common;

import java.io.*;
import java.util.List;

public class WorkFileSystem {

    public static void createFile(List<String> pathNames, StringBuilder log, String path) {
        try {
            for (String str : pathNames) {
                File file = new File(path + str);
                if (file.createNewFile())
                    log.append(String.format("Файл %s создан\n", str));
            }
        } catch (IOException e) {
            log.append(e.getMessage());
        }
    }

    public static void createDirectory(List<String> pathNames, StringBuilder log, String path) {
        for (String str : pathNames) {
            File dir = new File(path + str);
            if (dir.mkdir())
                log.append(String.format("Директория %s создана\n", str));
        }
    }
}

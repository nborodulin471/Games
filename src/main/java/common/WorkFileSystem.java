package common;

import java.io.*;
import java.util.List;

public class WorkFileSystem {

    public static boolean createFile(List<String> pathNames, StringBuilder log, String path) {
        boolean res = true;
        try {
            for (String str : pathNames) {
                File file = new File(path + str);
                if (file.createNewFile())
                    log.append(String.format("Файл %s создан\n", str));
            }
        } catch (IOException e) {
            res = false;
            log.append(e.getMessage());
        }
        return res;
    }

    public static boolean createDirectory(List<String> pathNames, StringBuilder log, String path) {
        boolean res = true;
        try {
            for (String str : pathNames) {
                File dir = new File(path + str);
                if (dir.mkdir())
                    log.append(String.format("Директория %s создана\n", str));
            }
        } catch (Exception e) {
            res = false;
            log.append(e.getMessage());
        }
        return res;
    }
}

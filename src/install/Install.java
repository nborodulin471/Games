package install;

import java.io.*;
import java.util.*;

public class Install {

    private static String path = "/home/nick/games";
    private static StringBuilder log = new StringBuilder("");

    public static void main(String[] args) {
        // 1. В папке Games создайте несколько директорий: src, res, savegames, temp.
        createDirectory(Arrays.asList("/src", "/res", "/savegames", "/temp"));
        // 2. В каталоге src создайте две директории: main, test.
        createDirectory(Arrays.asList("/src/main", "/main/test"));
        // 3. В подкаталоге main создайте два файла: Installation.java, Utils.java.
        createFile(Arrays.asList("/src/main/Installation.java", "/src/main/Utils.java"));
        // 4. В каталог res создайте три директории: drawables, vectors, icons.
        createDirectory(Arrays.asList("/res/drawables", "/res/vectors", "/res/icons"));
        // 5. В директории temp создайте файл temp.txt.
        createFile(Arrays.asList("/temp/temp.txt"));
        // * Создание лога
        writeLog();
    }

    private static void writeLog() {
        try (FileWriter writer = new FileWriter(path + "/temp/temp.txt", true)) {
            writer.write(log.toString());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createFile(List<String> pathNames) {
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

    private static void createDirectory(List<String> pathNames) {
        for (String str : pathNames) {
            File dir = new File(path + str);
            if (dir.mkdir())
                log.append(String.format("Директория %s создана\n", str));
        }
    }

}



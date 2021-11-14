package install;

import common.WorkFileSystem;

import java.io.*;
import java.util.*;

public class Install {

    private static String path;
    private static StringBuilder log = new StringBuilder("");

    public static void main(String[] args) {

        path = "/home/nick/games/";

        // 1. В папке Games создайте несколько директорий: src, res, savegames, temp.
        WorkFileSystem.createDirectory(Arrays.asList("/src", "/res", "/savegames", "/temp"), log, path);
        // 2. В каталоге src создайте две директории: main, test.
        WorkFileSystem.createDirectory(Arrays.asList("/src/main", "/main/test"), log, path);
        // 3. В подкаталоге main создайте два файла: Installation.java, Utils.java.
        WorkFileSystem.createFile(Arrays.asList("/src/main/Installation.java", "/src/main/Utils.java"), log, path);
        // 4. В каталог res создайте три директории: drawables, vectors, icons.
        WorkFileSystem.createDirectory(Arrays.asList("/res/drawables", "/res/vectors", "/res/icons"), log, path);
        // 5. В директории temp создайте файл temp.txt.
        WorkFileSystem.createFile(Arrays.asList("/temp/temp.txt"), log, path);
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
}




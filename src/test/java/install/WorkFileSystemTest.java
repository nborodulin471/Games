package install;

import common.WorkFileSystem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class WorkFileSystemTest {

    static StringBuilder log;
    static String path;
    static List<String> pathNames;

    @BeforeAll
    static void init() {
        log = new StringBuilder();
        path = "/home/nick/games/";
    }

    @Test
    void testCreateFile() {
        WorkFileSystem.createFile(Arrays.asList("test.txt"), log, path);
    }

    @Test
    void testCreateDirectory() {
        WorkFileSystem.createDirectory(Arrays.asList("/test", "/test1"), log, path);
    }

    @Test
    void testCreateFile_nullArgument_throwsException() {
        assertThrows(Exception.class, () -> {
            WorkFileSystem.createFile(null, null, null);
        });
    }
}

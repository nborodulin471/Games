package install;

import common.WorkFileSystem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WorkFileSystemTest {

    static StringBuilder log;
    static String path;
    static List<String> pathNames;

    @BeforeAll
    static void init() {
        log = new StringBuilder();
        // на лекции про мокито сказали, что так тестировать не надо. Т.к это внешняя зависимость
        // к сожалению, осознал это когда уже отправил на проверку))
        // вопрос: тогда в контексте данной домашки создание файлов вообще тестировать не надо?
        path = "/home/nick/games/";
    }

    @Test
    void testCreateFile() {
       boolean res = WorkFileSystem.createFile(Arrays.asList("test.txt"), log, path);
       assertTrue(res);
    }

    @Test
    void testCreateDirectory() {
        boolean res = WorkFileSystem.createDirectory(Arrays.asList("/test", "/test1"), log, path);
        assertTrue(res);
    }

    @Test
    void testCreateFile_nullArgument_throwsException() {
        assertThrows(Exception.class, () -> {
            WorkFileSystem.createFile(null, null, null);
        });
    }
}

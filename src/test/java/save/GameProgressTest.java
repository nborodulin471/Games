package save;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameProgressTest {

    static GameProgress progress;

    @BeforeAll
    static void init(){
        progress = new GameProgress(100, 1, 1, 0);
    }

    @Test
    void testGameProgress_createObj(){
        assertNull(progress);
    }

}
package Framework;

import base.Configuration;
import base.Mode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JUnitTestCLIFramework {
    protected static Configuration conf;

    @BeforeAll
    static void setUp() {
        String[] args = new String[]{"-K", "10", "-P"};
        conf = CLI.configuration(args);
        System.out.println(conf);
    }

    @Test
    void testAlpha() {
        assertEquals(0.85, conf.alpha);
    }

    @Test
    void testEpsilon() {
        assertEquals(-1.0, conf.epsilon);
    }

    @Test
    void testIndice() {
        assertEquals(10, conf.indice);
    }

    @Test
    void testMode() {
        Assertions.assertEquals(Mode.PLEINE, conf.mode);
    }

}

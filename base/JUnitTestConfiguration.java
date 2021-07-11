package base;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class JUnitTestConfiguration {
    protected static Configuration conf;

    @BeforeAll
    static void setUp() {
        String[] args = new String[]{"-K", "10", "-A", ".90", "-K", "20", "-P" ,"-K" ,"30" ,"-C"};
        conf = CLIClassique.configuration(args);
        System.out.println(conf);
    }

    @Test
    void testAlpha() {
        assertEquals(0.9, conf.alpha);
    }

    @Test
    void testEpsilon() {
        assertEquals(-1.0, conf.epsilon);
    }

    @Test
    void testIndice() {
        assertEquals(30, conf.indice);
    }

    @Test
    void testMode() {
        assertEquals(Mode.CREUSE, conf.mode);
    }

}

package it.fox.app.yaml;

import it.fox.app.App;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SnakeYAMLtest {

    @Test
    public void snakeTestOne() throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        InputStream res = App.class.getResourceAsStream("/lexerCommand.yaml");
        System.out.println(res);
        ResourceLexerYAML resourceLexerYAML = new ResourceLexerYAML();
        boolean n;
        if (res == null) {
            n = false;
        } else {
            n = true;
        }
        assertTrue(n);
    }
}

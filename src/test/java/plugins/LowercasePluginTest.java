package plugins;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LowercasePluginTest {

    protected LowercasePlugin lowercasePlugin;

    @Before
    public void init() {
        lowercasePlugin = new LowercasePlugin();
    }

    @Test
    public void testDescription() {
        assertEquals("En minuscule", lowercasePlugin.getDescription());
    }

    @Test
    public void testDoAction() {
        assertEquals("test", lowercasePlugin.doAction("Test"));
    }
}
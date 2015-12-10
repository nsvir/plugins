package plugins;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CaesarsCode1PluginTest {
    protected CaesarsCode1Plugin caesarsCode1Plugin;

    @Before
    public void init() {
        caesarsCode1Plugin = new CaesarsCode1Plugin();
    }

    @Test
    public void testDescription() {
        assertEquals("Code Cesar 1", caesarsCode1Plugin.getDescription());
    }

    @Test
    public void testDoActionSimple() {
        assertEquals("bcd", caesarsCode1Plugin.doAction("abc"));
    }

    @Test
    public void testDoActionWithEndAlphabet() {
        assertEquals("zab", caesarsCode1Plugin.doAction("yza"));
    }
}
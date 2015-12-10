package plugins;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CaesarsCode13PluginTest {
    protected CaesarsCode13Plugin caesarsCode13Plugin;

    @Before
    public void init() {
        caesarsCode13Plugin = new CaesarsCode13Plugin();
    }

    @Test
    public void testDescription() {
        assertEquals("Code Cesar 13", caesarsCode13Plugin.getDescription());
    }

    @Test
    public void testDoActionSimple() {
        assertEquals("nop", caesarsCode13Plugin.doAction("abc"));
    }

    @Test
    public void testDoActionWithEndAlphabet() {
        assertEquals("lmn", caesarsCode13Plugin.doAction("yza"));
    }
}

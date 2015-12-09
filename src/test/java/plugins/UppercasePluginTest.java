package plugins;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UppercasePluginTest {

    protected UppercasePlugin uppercasePlugin;

    @Before
    public void init() {
        uppercasePlugin = new UppercasePlugin();
    }

    @Test
    public void testDescription() {
        assertEquals("En majuscule", uppercasePlugin.getDescription());
    }

    @Test
    public void testDoAction() {
        assertEquals("TEST", uppercasePlugin.doAction("Test"));
    }
}
package plugins;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeleteVowelsTest {

    protected DeleteVowelsPlugin deleteVowelsPlugin;

    @Before
    public void init() {
        deleteVowelsPlugin = new DeleteVowelsPlugin();
    }

    @Test
    public void testDescription() {
        assertEquals("Supprime voyelles", deleteVowelsPlugin.getDescription());
    }

    @Test
    public void testDoAction() {
        assertEquals("Hll Wrld", deleteVowelsPlugin.doAction("Hello World"));
    }
}

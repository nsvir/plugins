package files;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class PluginFilterTest {

    protected PluginFilter pluginFilter;

    @Before
    public void init() {
        pluginFilter = new PluginFilter();
    }

    @Test
    public void testWithDirectoryDoesntExist() {
        boolean response = pluginFilter.accept(new File("./anything"), "test");
        assertFalse(response);
    }

    @Test
    public void testWithNotAClassFile() {
        boolean response = pluginFilter.accept(new File("./src/main/java/files"), "PluginFilter.java");
        assertFalse(response);
    }

    @Test
    public void testWithARealClassFile() {
        boolean response = pluginFilter.accept(new File("./dropins"), "LowercasePlugin.class");
        assertTrue(response);
    }
}
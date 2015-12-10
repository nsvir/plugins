package files;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class PluginFinderTest {

    protected PluginFinder pluginFinder;

    @Before
    public void init() {
        pluginFinder = new PluginFinder(new File("./dropins"));
    }

    @Test
    public void testStartTimer() throws Exception {
        assertFalse(this.pluginFinder.getTimer().isRunning());
        this.pluginFinder.startTimer();
        assertTrue(this.pluginFinder.getTimer().isRunning());
    }

    @Test
    public void testStopTimer() throws Exception {
        assertFalse(this.pluginFinder.getTimer().isRunning());
        this.pluginFinder.startTimer();
        assertTrue(this.pluginFinder.getTimer().isRunning());
        this.pluginFinder.stopTimer();
        assertFalse(this.pluginFinder.getTimer().isRunning());
    }
}
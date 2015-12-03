package main.files;

import java.io.File;

public class PluginFinder {
    protected File directory;
    PluginFilter pluginFilter;

    public PluginFinder (File directory) {
        this.directory = directory;
        this.pluginFilter = new PluginFilter();
    }

    public File[] getClassFiles() {
        return this.directory.listFiles(this.pluginFilter);
    }
}

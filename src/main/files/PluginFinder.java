package main.files;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PluginFinder implements ActionListener {
    protected File directory;
    PluginFilter pluginFilter;

    public PluginFinder (File directory) {
        this.directory = directory;
        this.pluginFilter = new PluginFilter();
    }

    public File[] getClassFiles() {
        return this.directory.listFiles(this.pluginFilter);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

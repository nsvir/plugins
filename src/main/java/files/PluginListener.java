package main.java.files;

import java.io.File;
import java.util.EventListener;

public interface PluginListener extends EventListener {
    public void insertPlugin(File file);
    public void deletePlugin(File file);
}

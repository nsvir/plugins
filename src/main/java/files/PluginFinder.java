package files;

import plugins.Plugin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;
import javax.swing.Timer;

public class PluginFinder extends Observable implements ActionListener {
    protected File directory;
    protected PluginFilter pluginFilter;
    protected Set<File> foundFiles;
    protected Timer timer;

    public PluginFinder (File directory) {
        this.directory = directory;
        this.pluginFilter = new PluginFilter();
        this.foundFiles = new HashSet<File>();
        this.timer = new Timer(1000, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Set<File> files = this.getClassFiles();
        this.checkForNewPlugins(files);
        this.checkForOldPlugins(files);
    }

    public void startTimer(){
        this.timer.start();
    }

    public void stopTimer(){
        this.timer.stop();
    }

    public Set<File> getClassFiles() {
        Set<File> classFiles = new HashSet<File>();
        for (File file: this.directory.listFiles()) {
            if(this.pluginFilter.accept(directory, file.getName())) {
                classFiles.add(file);
            }
        }
        return classFiles;
    }

    public void checkForNewPlugins(Set<File> checkFiles) {
        for (File file: checkFiles) {
            if (!this.foundFiles.contains(file)) {
                System.out.println("New file " + file.getName());
                this.foundFiles.add(file);
                Class<?> c = null;
                Plugin plugin = null;
                try {
                    c =  Class.forName("plugins." + file.getName().substring(0, file.getName().length() - 6));
                    plugin = (Plugin) c.getConstructor().newInstance();
                } catch(Exception e) {
                    e.printStackTrace();
                }
                setChanged();
                notifyObservers(plugin);
            }
        }
    }

    public void checkForOldPlugins(Set<File> checkFiles) {
        for (File file: this.foundFiles) {
            if(!checkFiles.contains(file)) {
                this.foundFiles.remove(file);
                System.out.println("Old file " + file.getName());
                setChanged();
                notifyObservers(file);
            }
        }
    }

    public File getDirectory() {
        return directory;
    }

    public PluginFilter getPluginFilter() {
        return pluginFilter;
    }

    public Set<File> getFoundFiles() {
        return foundFiles;
    }

    public Timer getTimer() {
        return timer;
    }

}

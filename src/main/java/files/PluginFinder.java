package files;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;
import javax.swing.Timer;

/**
 * This class represents the main of the application
 *
 * @author Damien SAUVALLE, Laurent THIEBAULT, Amélie MULEBECQ, Nicolas SVIRCHEVSKY
 */
public class PluginFinder extends Observable implements ActionListener {
    protected File directory;
    protected PluginFilter pluginFilter;
    protected Set<File> foundFiles;
    protected Timer timer;

    /**
     * Constructor of PluginFinder
     *
     * @param directory the directory of the PluginFinder
     */
    public PluginFinder (File directory) {
        this.directory = directory;
        this.pluginFilter = new PluginFilter();
        this.foundFiles = new HashSet<File>();
        this.timer = new Timer(1000, this);
    }

    /**
     * This function is called on each iteration of the PluginFinder's timer
     *
     * @param e the event captured
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Set<File> files = this.getPluginFiles();
        this.checkForNewPlugins(files);
        this.checkForOldPlugins(files);
    }

    /**
     * This function is called when we want to start the timer of the PluginFinder
     */
    public void startTimer(){
        this.timer.start();
    }

    /**
     * This function is called when we want to stop the timer of the PluginFinder
     */
    public void stopTimer(){
        this.timer.stop();
    }

    /**
     * This function is called when we want to get Plugin Files into the directory of the PluginFinder
     *
     * @return a Set of Plugin files
     */
    public Set<File> getPluginFiles() {
        Set<File> classFiles = new HashSet<File>();
        for (File file: this.directory.listFiles()) {
            if(this.pluginFilter.accept(directory, file.getName())) {
                classFiles.add(file);
            }
        }
        return classFiles;
    }

    /**
     * This function is called when we want to check for new Plugins on each iteration of the timer
     *
     * @param checkFiles the files to check
     */
    public void checkForNewPlugins(Set<File> checkFiles) {
        for (File file: checkFiles) {
            if (!this.foundFiles.contains(file)) {
                System.out.println("New file " + file.getName());
                this.foundFiles.add(file);
                setChanged();
                notifyObservers();
            }
        }
    }

    /**
     * This function is called when we want to check for old Plugins on each iteration of the timer
     *
     * @param checkFiles the files to check
     */
    public void checkForOldPlugins(Set<File> checkFiles) {

        for (Iterator<File> iterator = this.foundFiles.iterator(); iterator.hasNext();){
            File file = iterator.next();
            if(!checkFiles.contains(file)) {
                iterator.remove();
                System.out.println("Old file " + file.getName());
                setChanged();
                notifyObservers();
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

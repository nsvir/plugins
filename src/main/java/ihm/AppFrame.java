package ihm;

import files.PluginFinder;
import plugins.Plugin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

/**
 * This class represents the frame of the application
 *
 * @author Damien SAUVALLE, Laurent THIEBAULT, Amélie MULEBECQ, Nicolas SVIRCHEVSKY
 */
public class AppFrame extends JFrame implements Observer {

    protected static final int WIDTH = 600;
    protected static final int HEIGHT = 400;

    protected PluginFinder pluginFinder;

    protected JTextArea textArea;
    protected JMenuBar menuBar;
    protected JMenu tools;
    protected List<JMenuItem> toolsMenuItems;

    /**
     * Constructor of the AppFrame
     *
     * @param directory the directory where plugins are
     */
    public AppFrame(File directory) {
        this.pluginFinder = new PluginFinder(directory);
        this.configureTheFrame();
        this.setComponentsOfTheFrame();
        this.pluginFinder.startTimer();
        this.pluginFinder.addObserver(this);
    }

    /**
     * This function is called when we create the components of the frame
     */
    public void setComponentsOfTheFrame() {
        // Add a text area
        this.textArea = new JTextArea();
        this.add(textArea);
        // Setting menu
        this.menuBar = new JMenuBar();
        this.tools = new JMenu();
        tools.setText("Outils");
        menuBar.add(tools);
        this.setJMenuBar(menuBar);
        this.toolsMenuItems = new ArrayList<JMenuItem>();
    }

    /**
     * This function is called when we configure the frame (title, size, dimensions...)
     */
    public void configureTheFrame() {
        // Set the title of the frame
        this.setTitle("Plugins");
        // Set the size of the frame
        this.setSize(WIDTH, HEIGHT);
        // Set the frame in the center of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    /**
     * This function is called when we want to create a Plugin with a File accepted by the PluginFilter
     *
     * @param file the file found
     * @return the Plugin created
     */
    protected Plugin createPlugin(File file){
        Class<?> c = null;
        Plugin plugin = null;
        try {
            c =  Class.forName("plugins." + file.getName().substring(0, file.getName().length() - 6));
            plugin = (Plugin) c.getConstructor().newInstance();
        } catch(Exception e) {
            e.printStackTrace();
            return null;
        }
        return plugin;
    }

    /**
     * This function is called when an observable notify the AppFrame
     *
     * @param o an observable
     * @param arg the arg of the observable
     */
    @Override
    public void update(Observable o, Object arg) {
        this.toolsMenuItems.clear();
        this.tools.removeAll();

        /*
            TODO: En 2 observers
            1 pour ajouter
            1 pour supprimer
         */


        for (File f: this.pluginFinder.getFoundFiles()){
            final Plugin plugin = this.createPlugin(f);
            JMenuItem toolsMenuItem = new JMenuItem();
            toolsMenuItem.setText(plugin.getDescription());
            toolsMenuItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textArea.setText(plugin.doAction(textArea.getText()));
                }
            });
            this.toolsMenuItems.add(toolsMenuItem);
            this.tools.add(toolsMenuItem);
        }
    }
}

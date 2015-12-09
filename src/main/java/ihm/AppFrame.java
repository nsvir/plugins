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

public class AppFrame extends JFrame implements Observer {

    protected static final int WIDTH = 600;
    protected static final int HEIGHT = 400;

    protected PluginFinder pluginFinder;

    protected JTextArea textArea;
    protected JMenuBar menuBar;
    protected JMenu tools;
    protected List<JMenuItem> toolsMenuItems;

    public AppFrame(File directory) {
        this.pluginFinder = new PluginFinder(directory);

        // Set the title of the frame
        this.setTitle("Plugins");
        // Set the size of the frame
        this.setSize(WIDTH, HEIGHT);

        // Set the frame in the center of the screen
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

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

        // Configure the PluginFinder
        this.pluginFinder.startTimer();
        this.pluginFinder.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        JMenuItem toolsMenuItem = new JMenuItem();
        Plugin plugin = (Plugin) arg;
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

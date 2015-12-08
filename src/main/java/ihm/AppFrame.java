package ihm;


import files.PluginFinder;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class AppFrame extends JFrame {

    protected static final int WIDTH = 600;
    protected static final int HEIGHT = 400;

    protected PluginFinder pluginFinder;

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
        JTextArea textArea = new JTextArea();
        this.add(textArea);

        JMenuBar menuBar = new JMenuBar();

        JMenu tools = new JMenu();
        tools.setText("Tools");

        JMenuItem uppercase = new JMenuItem();
        uppercase.setText("En majuscule");

        tools.add(uppercase);
        menuBar.add(tools);

        this.setJMenuBar(menuBar);

        this.pluginFinder.startTimer();
    }
}

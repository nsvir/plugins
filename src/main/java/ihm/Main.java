package ihm;

import java.io.File;

/**
 * This class represents the main of the application
 *
 * @author Damien SAUVALLE, Laurent THIEBAULT, Amélie MULEBECQ, Nicolas SVIRCHEVSKY
 */
public class Main {
    public static void main(String[] args) {
        File directory = new File("./dropins");
        if (!directory.exists() || !directory.isDirectory()){
            System.out.println("Directory ./dropins missing");
            System.exit(0);
        }
        AppFrame frame = new AppFrame(directory);
        frame.setVisible(true);
    }
}

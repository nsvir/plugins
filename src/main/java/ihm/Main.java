package ihm;

import java.io.File;

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

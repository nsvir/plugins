package main.ihm;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File directory = new File("./dropins");
        AppFrame frame = new AppFrame(directory);
        frame.setVisible(true);
    }
}

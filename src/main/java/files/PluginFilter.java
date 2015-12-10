package files;

import java.io.File;
import java.io.FilenameFilter;

/**
 * This class represents a filter to verify if it's a Plugin
 *
 * @author Damien SAUVALLE, Laurent THIEBAULT, Amélie MULEBECQ, Nicolas SVIRCHEVSKY
 */
public class PluginFilter implements FilenameFilter {

    /**
     * This function is called when we want to know if the file is a Plugin
     *
     * @param dir the directory
     * @param name the name of the file
     * @return true if it's a Plugin
     */
    @Override
    public boolean accept(File dir, String name) {
        Class<?> c;
        Object instance;

        // Check if the directory exists
        if (!dir.exists()) {
            System.err.println("Directory doesn't exist : " + dir.getName());
            return false;
        }

        // Get the file
        File fichier = new File(dir.getPath() + File.separator + name);

        // Check if it's a .class file
        if (!fichier.getAbsolutePath().endsWith(".class")) {
            return false;
        }

        // Get the Class
        try {
            c = Class.forName("plugins." + name.substring(0, name.length() - 6));
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found" + fichier.getName());
            return false;
        }

        // Check if constructor is not null
        try {
            if (c.getConstructor() == null) {
                System.err.println("Constructor is null" + fichier.getName());
                return false;
            }

            // Create an instance with the constructor
            instance = c.getConstructor().newInstance();

            // Check if it's a Plugin
            if (!(instance instanceof plugins.Plugin)) {
                System.err.println("The class doesn't implement Plugin" + fichier.getName());
                return false;
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}

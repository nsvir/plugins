package files;

import java.io.File;
import java.io.FilenameFilter;

public class PluginFilter implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {
        Class<?> c;
        Object instance;

        if (!dir.exists()) {
            System.err.println("Directory doesn't exist : " + dir.getName());
            return false;
        }

        File fichier = new File(dir.getPath() + File.separator + name);

        if (!fichier.getAbsolutePath().endsWith(".class")) {
            System.err.println("The file is not a .class" + fichier.getName());
            return false;
        }

        try {
            c = Class.forName("plugins." + name.substring(0, name.length() - 6));

        } catch (ClassNotFoundException e) {
            System.err.println("Class not found" + fichier.getName());
            return false;
        }

        try {
            if (c.getConstructor() == null) {
                System.err.println("Constructor is null" + fichier.getName());
                return false;
            }

            instance = c.getConstructor().newInstance();

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

package main.java.plugins;

public class LowercasePlugin implements Plugin {

    @Override
    public String getDescription() {
        return "En minuscule";
    }

    @Override
    public String doAction(String text) {
        return text.toLowerCase();
    }
}

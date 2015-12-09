package main.java.plugins;

public interface Plugin {
    public String getDescription();
    public String doAction(String text);
}

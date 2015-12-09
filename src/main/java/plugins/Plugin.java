package plugins;

public interface Plugin {
    public String getDescription();
    public String doAction(String text);
}

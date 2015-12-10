package plugins;

/**
 * This interface represents a Plugin of the application
 *
 * @author Damien SAUVALLE, Laurent THIEBAULT, Amélie MULEBECQ, Nicolas SVIRCHEVSKY
 */
public interface Plugin {
    /**
     * This function is called when we want to know the label of a Plugin
     *
     * @return the description of the Plugin
     */
    public String getDescription();

    /**
     * This function is called when we want to transform the text with the Plugin
     *
     * @param text the initial text
     * @return the text transformed by the Plugin
     */
    public String doAction(String text);
}

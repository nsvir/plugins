package plugins;

/**
 * This class represents the LowercasePlugin to set the text in lowercase
 *
 * @author Damien SAUVALLE, Laurent THIEBAULT, Amélie MULEBECQ, Nicolas SVIRCHEVSKY
 */
public class LowercasePlugin implements Plugin {

    /**
     * This function is called when we want to know the label of a Plugin
     *
     * @return the description of the Plugin
     */
    @Override
    public String getDescription() {
        return "En minuscule";
    }

    /**
     * This function is called when we want to transform the text in lowercase
     *
     * @return the text transformed by the Plugin
     */
    @Override
    public String doAction(String text) {
        return text.toLowerCase();
    }
}

package plugins;

/**
 * This class represents the UppercasePlugin to set the text in uppercase
 *
 * @author Damien SAUVALLE, Laurent THIEBAULT, Amélie MULEBECQ, Nicolas SVIRCHEVSKY
 */
public class UppercasePlugin implements Plugin {

    /**
     * This function is called when we want to know the label of a Plugin
     *
     * @return the description of the Plugin
     */
    @Override
    public String getDescription() {
        return "En majuscule";
    }

    /**
     * This function is called when we want to transform the text in uppercase
     *
     * @return the text transformed by the Plugin
     */
    @Override
    public String doAction(String text) {
        return text.toUpperCase();
    }
}

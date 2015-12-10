package plugins;

/**
 * This class represents the DeleteVowelsPlugin to change the text without vowels
 *
 * @author Damien SAUVALLE, Laurent THIEBAULT, Amélie MULEBECQ, Nicolas SVIRCHEVSKY
 */
public class DeleteVowelsPlugin implements Plugin {

    /**
     * This function is called when we want to know the label of a Plugin
     *
     * @return the description of the Plugin
     */
    @Override
    public String getDescription() {
        return "Supprime voyelles";
    }

    /**
     * This function is called when we want to transform the text without vowels
     *
     * @return the text transformed by the Plugin
     */
    @Override
    public String doAction(String text) {
        return text.replaceAll("a|e|i|o|u|y|A|E|I|O|U|Y", "");
    }
}

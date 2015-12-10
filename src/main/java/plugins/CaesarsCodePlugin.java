package plugins;

/**
 * This class represents the CaesarsCode1Plugin to change the text with the Caesar's code with a shift precised in the constructor
 *
 * @author Damien SAUVALLE, Laurent THIEBAULT, Amélie MULEBECQ, Nicolas SVIRCHEVSKY
 */
public class CaesarsCodePlugin implements Plugin {
    protected int shift;

    public CaesarsCodePlugin() {
        this.shift = 1;
    }

    public CaesarsCodePlugin(int shift) {
        this.shift = shift;
    }

    /**
     * This function is called when we want to know the label of a Plugin
     *
     * @return the description of the Plugin
     */
    @Override
    public String getDescription() {
        return "Code Cesar " + this.shift;
    }

    /**
     * This function is called when we want to transform the text with the Caesar's code
     *
     * @return the text transformed by the Plugin
     */
    @Override
    public String doAction(String text) {
        String response = "";
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isLetter(c)) {
                if (Character.isLowerCase(c)) {
                    c = (char) ('a' + (((c - 'a') + this.shift) % 26));
                } else {
                    c = (char) ('A' + (((c - 'A') + this.shift) % 26));
                }
            }
            response = response + c;
        }
        return response;
    }
}

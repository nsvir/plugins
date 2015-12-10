package plugins;

/**
 * Created by lauthieb on 10/12/2015.
 */
public class DeleteVowelsPlugin implements Plugin {

    @Override
    public String getDescription() {
        return "Supprime voyelles";
    }

    @Override
    public String doAction(String text) {
        return text.replaceAll("a|e|i|o|u|y|A|E|I|O|U|Y", "");
    }
}

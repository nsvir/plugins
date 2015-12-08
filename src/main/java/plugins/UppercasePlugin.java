package plugins;

public class UppercasePlugin implements Plugin {

    @Override
    public String getDescription() {
        return "En majuscule";
    }

    @Override
    public String doAction(String text) {
        return text.toUpperCase();
    }
}

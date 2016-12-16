package ua.training.textParser;

import ua.training.textParser.control.Control;
import ua.training.textParser.control.TextParserControl;
import ua.training.textParser.model.Model;
import ua.training.textParser.model.TextParserModel;
import ua.training.textParser.view.TextParserView;
import ua.training.textParser.view.View;

/**
 * Class represents main class where the program starts
 *
 * @author Taras Lazoryk
 */
public class Main {
    public static void main(String[] args) {

        //initialization of components
        View view = new TextParserView();
        Model model = new TextParserModel();
        Control control = new TextParserControl(model, view);

        //run
        control.processUser();
    }
}

package ua.training.textParser.view;

/**
 * Class TextParserView stands for view in MVC pattern.
 * It is created to communicate with user.
 * View implementation.
 *
 * @author Taras Lazoryk
 */
public class TextParserView implements View {

	/**
	 * This method prints a string.  
	 * 
	 * @param message The String to be printed.
	 */
    @Override
    public void printMessage(String message) {
        System.out.println(message);
    }
}

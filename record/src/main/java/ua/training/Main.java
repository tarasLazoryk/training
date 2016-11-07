package ua.training;

/**
 * Main class. It runs the game.
 * 
 *@author Taras Lazoryk
 */
public class Main 
{
    public static void main( String[] args )
    {
    	//Initialization
    	Model model = new Model();
    	View view = new View();
		Controller controller = new Controller(model, view);
		//Run
		controller.processUser();
    }
}
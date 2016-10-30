package ua.training;

/**
 * Main class. It runs the game.
 * 
 *@version 1.0 30 Oct 2016
 *@author Taras Lazoryk
 */
public class Main {
	public static void main(String[] args) {
		//Initialization
		Model model = new Model();
		View view = new View();
		Controller controller = new Controller(model, view);
		//Run 
		controller.playGame();
	}
}

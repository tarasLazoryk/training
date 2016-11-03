package ua.playjava;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Controller class. It expresses for controller in MVC pattern.
 * 
 * @version 1.0 30 Oct 2016
 * @author Taras Lazoryk
 *
 */
public class Controller {	
	private Model model = new Model();
	private View view = new View();
	private ArrayList<Integer> tryList = new ArrayList<Integer>();

	//constructor
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;

	}

	/** 
	 * Check if value from scanner is integer, or not
	 * If it is not, ask to input new value 
	 */
	public int inputIntValue(Scanner sc) {
		while (!sc.hasNextInt()) {
			view.printWithBounds(View.WRONG_INPUT_INT_DATA, 
								model.getMinValue(), model.getMaxValue());
			sc.next();
		}
		return sc.nextInt();
	}
	
	/** 
	 * Check if value from scanner is in bounds, or not
	 * If it is not, ask to input new value 
	 */
	public int isValueInBounds(Scanner sc) {
		int userValue = inputIntValue(sc);
		
		while (!model.isInBounds(userValue)) {
			view.printWithBounds(View.WRONG_INPUT_INT_DATA, model.getMinValue(),
								model.getMaxValue());
			userValue = inputIntValue(sc);
		}
		
		tryList.add(userValue);
		return userValue;
	}
	
	/** 
	 * Ask user to input integer number which lies in bounds,
	 * check with isValueInBounds() and inputIntValue() methods
	 * When user guess, write the result
	 */
	public void playGame() {
		Scanner sc = new Scanner(System.in);
		
		view.printWithBounds(View.INPUT_INT_DATA, model.getMinValue(), 
							model.getMaxValue());
		model.setUserValue(isValueInBounds(sc));

		while (!model.isEqualToProgramValue(model.getUserValue())) {
			if (model.isBiggerThenProgramValue(model.getUserValue())) {
				view.printWithBounds(View.BIGGER_VALUE, model.getMinValue(),
									model.getMaxValue());
				model.setUserValue(isValueInBounds(sc));
			} else {
				view.printWithBounds(View.SMALLER_VALUE, model.getMinValue(), 
									model.getMaxValue());
				model.setUserValue(isValueInBounds(sc));
			}
		}
		
		view.print(View.CORRECT_VALUE);
		view.printStatistic(tryList);
	}
}

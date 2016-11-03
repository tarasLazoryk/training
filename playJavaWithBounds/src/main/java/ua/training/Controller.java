package ua.training;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Controller class. It expresses controller in MVC pattern.
 * 
 * @version 1.0 30 Oct 2016
 * @author Taras Lazoryk
 *
 */
public class Controller {
	Model model = new Model();
	View view = new View();
	// constructor
	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;

	}

	/**
	 * The main method, which asks user to type value in the bounds, until user
	 * doesn't guess the number, or until he typed word "exit" - which will stop
	 * the program.
	 */
	public void playGame() {
		Scanner sc = new Scanner(System.in);
		setBoundaries(sc);
		//model.setBoundaries(GlobalConstants.MIN_VALUE, GlobalConstants.MAX_VALUE);

		model.setSecretValue(model.getLowerBoundary(), model.getUpperBoundary());
		view.print(GlobalConstants.EXIT_CONDITION_MESSAGE);
		while (!model.checkValue(checkIsInputValueInBounds(sc))) {
		}

		view.print(GlobalConstants.CORRECT_VALUE);
		view.printStatistic(model.getTryList());
	}

	/**
	 * Check is the value typed by user via scanner is a number or not It will
	 * ask user to write a number until he does it, or until he would write
	 * "exit" - in this case the program will be stopped.
	 * 
	 * @param sc - the scanner from which value is gotten
	 * @return integer value.
	 */
	public int inputIntValueWithScanner(Scanner sc) {
		String scannerValue = "";
		if(model.getLowerBoundary() == model.getUpperBoundary()){
			view.print(GlobalConstants.INPUT_INT_DATA);
		} else {
			view.print(GlobalConstants.INPUT_INT_DATA_BETWEEN 
					+ model.getLowerBoundary() + GlobalConstants.AND 
					+ model.getUpperBoundary() + GlobalConstants.EQUALS);			
		}	
		scannerValue = sc.next();
		while (true) {
			while (!checkStringForInt(scannerValue)) {
				if (scannerValue.equals(GlobalConstants.EXIT_VALUE)) {
					System.exit(0);
				} else {
					if(model.getLowerBoundary() == model.getUpperBoundary()){
						view.print(GlobalConstants.WRONG_INPUT_INT_DATA);
					} else {
						view.print(GlobalConstants.WRONG_INPUT_INT_DATA_BETWEEN 
								+ model.getLowerBoundary() + GlobalConstants.AND
								+ model.getUpperBoundary() + GlobalConstants.EQUALS);			
					}	
					scannerValue = sc.next();
				}

			}
			return Integer.parseInt(scannerValue);
		}
	}

	/**
	 * Asks to write the value which lies in the bounds. Takes values from the
	 * scanner, and will ask to write a value in the bounds until user does it.	 * 
	 * @param sc - the scanner from which value is gotten.
	 * @return return value which lies in the bounds.
	 */
	public int checkIsInputValueInBounds(Scanner sc) {
		int value = inputIntValueWithScanner(sc);
		while (value <= model.getLowerBoundary() || value >= model.getUpperBoundary()) {

			view.print(GlobalConstants.WRONG_BOUNDARIES_INT_DATA 
					+ model.getLowerBoundary() + GlobalConstants.AND 
					+ model.getUpperBoundary() + GlobalConstants.EQUALS);
			value = inputIntValueWithScanner(sc);
		}
		return value;
	}
	
	/**
	 * Asks user to write lower and upper boundaries of the interval
	 * to the scanner. It will ask to write boundaries until used wouldn't
	 * do it correctly. Upper boundary must be bigger then lower.
	 *  
	 * @param sc - scanner from which data is gotten.
	 * @return returns true if lower boundary is smaller then upper.
	 */
	public boolean setBoundaries(Scanner sc){
		int lowerBoundary = 0;
		int upperBoundary = 0;
		view.print(GlobalConstants.TYPE_LOWER_BOUNDARY);
		lowerBoundary = inputIntValueWithScanner(sc);
		view.print(GlobalConstants.TYPE_UPPER_BOUNDARY);
		upperBoundary = inputIntValueWithScanner(sc);
		while(lowerBoundary >= upperBoundary){
			view.print(GlobalConstants.INCORECT_BOUNDARIES);
			view.print(GlobalConstants.TYPE_LOWER_BOUNDARY);
			lowerBoundary = inputIntValueWithScanner(sc);
			view.print(GlobalConstants.TYPE_UPPER_BOUNDARY);
			upperBoundary = inputIntValueWithScanner(sc);
			
		}
		model.setBoundaries(lowerBoundary, upperBoundary);
		return true;	
		
	}

	/**
	 * Checks is the string can be converted into the integer. 
	 * 
	 * @param string - string to be checked.
	 * @return return true if string can be converted and false if it is not.
	 */
	public boolean checkStringForInt(String string) {
		try {
			Integer.parseInt(string);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}

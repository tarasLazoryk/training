package ua.training;

import java.util.ArrayList;

/**
 * View class. It expresses view in MVC pattern.
 * 
 * @version 1.0 30 Oct 2016
 * @author Taras Lazoryk
 *
 */
public class View {
	/**
	 * This method prints a string.  
	 * @param message - The String to be printed.
	 */
	public void print(String message) {
		System.out.println(message);
	}	
	/**
	 * This method prints every element of ArrayList<Integer> in new line. 
	 * It prints it in form: <Number of element> "try was" <Value of element>
	 * and then terminate the line. 
	 * @param tryList - The ArrayList<Integer> to be printed.
	 */
	public void printStatistic(ArrayList<Integer> tryList) {
		System.out.println(GlobalConstants.TRIES_AMOUNT + tryList.size());
		for (int i = 0; i < tryList.size(); i++) {
			System.out.println(i + 1 + GlobalConstants.TRY_WAS + tryList.get(i));
		}

	}

}

package ua.playjava;

import java.util.ArrayList;

/**
 * View class. It expresses for view in MVC pattern.
 * 
 * @version 1.0 30 Oct 2016
 * @author Taras Lazoryk
 *
 */
public class View {
	// text constants
	public static final String INPUT_INT_DATA = "Write INT value between ";
	public static final String WRONG_INPUT_INT_DATA = "Wrong input data. Write INt value between ";
	public static final String BIGGER_VALUE = "Yours value is bigger then mine. Write INT value between ";
	public static final String SMALLER_VALUE = "Yours value is smaller then mine. Write INT value between ";
	public static final String CORRECT_VALUE = "Congratulations you guessed!!";
	public static final String TRIES_AMOUNT = "Amount of tries = ";
	public static final String AND = " and ";
	public static final String EQUALS = " = ";
	public static final String TRY_WAS = " try was ";
	
	public void print(String message) {
		System.out.println(message);
	}

	public void printWithBounds(String message, int minValue, int maxValue) {
		System.out.println(message + minValue + AND + maxValue + EQUALS);
	}

	public void printStatistic(ArrayList<Integer> tryList) {
		System.out.println(TRIES_AMOUNT + tryList.size());
		for (int i = 0; i < tryList.size(); i++) {
			System.out.println(i + 1 + TRY_WAS + tryList.get(i));
		}

	}

}

package ua.training.view;

/**
 * View class. It expresses view in MVC pattern.
 * 
 * @author Taras Lazoryk
 *
 */
public class View {
	public final static String FREIGHT_CARRIAGE = "Freight carriage: ";
	public final static String SORTED_CARRIAGES = "Train with sorted carriages: ";
	public final static String UNSORTED_CARRIAGES = "Train with unsorted carriages: ";
	public final static String AMOUNT_OF_PLACES = "Summary amount of places in carriages: ";
	public final static String PASSENGER_CARRIAGES_IN_BOUNDS = "Passenger carriages in bounds: ";
	
	/**
	 * This method prints a string.  
	 * @param message - The String to be printed.
	 */
	public void printMessage(String message) {
		System.out.println(message);
	}
}

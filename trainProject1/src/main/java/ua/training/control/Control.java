package ua.training.control;

import java.util.ArrayList;
import java.util.List;

import ua.training.control.init.InitCarriages;
import ua.training.model.entity.carriages.ComfortClass;
import ua.training.model.entity.carriages.FreightCarriage;
import ua.training.model.entity.carriages.PassangerCarriage;
import ua.training.model.entity.carriages.PassangerCarriagesComparator;
import ua.training.model.entity.carriages.RailwayCarriage;
import ua.training.model.entity.locomotive.Locomotive;
import ua.training.model.entity.locomotive.MotorType;
import ua.training.model.entity.train.Train;
import ua.training.view.View;

/**
 * Control class. It expresses controller in MVC pattern.
 * 
 * @author Taras Lazoryk
 *
 */
public class Control {

	/**
	 * Reference to model part
	 *
	 * @see Model
	 */
	private Train model;

	/**
	 * Reference to view part
	 *
	 * @see View
	 */
	private View view;

	/**
	 * Constructor
	 *
	 * @param model reference to model
	 * @param view reference to view
	 */
	public Control(Train model, View view) {
		this.model = model;
		this.view = view;
	}

	public void processUser() {
		/*train instance initialization*/
		Locomotive locomotive = new Locomotive(MotorType.Electric, 5, 10.,10.);
		List<RailwayCarriage> railwayCarriages = new ArrayList<RailwayCarriage>();
		railwayCarriages = InitCarriages.getRailwayCarriagesList();
		model = new Train(5, locomotive, railwayCarriages);
		List<PassangerCarriage> sortedList = model.sort(new PassangerCarriagesComparator<PassangerCarriage>());
		view.printMessage(View.SORTED_CARRIAGES + sortedList);
		view.printMessage(View.UNSORTED_CARRIAGES + model.getPassangerCarriages());
		
		view.printMessage(View.PASSENGER_CARRIAGES_IN_BOUNDS 
						+ model.getPassangerCarriagesInBounds(0, 50));
		
		view.printMessage(View.AMOUNT_OF_PLACES + model.getSummaryAmountOfPlaces());

	}
	
	/**
	 * Checks if ComfortClass contains inputed value.
	 * 
	 * @param value - Value to be inputed.
	 * @return true if ComfortClass consists value
	 * and false if not
	 */
	public boolean checkComfortClass(String value) {
		try {
			ComfortClass.valueOf(value);
			return true;
		} catch (IllegalArgumentException ex) {
			return false;
		}
	}
	
	/**
	 * Checks if MotorType contains inputed value.
	 * 
	 * @param value - Value to be inputed.
	 * @return true if MotorType consists value
	 * and false if not
	 */
	public boolean checkMotorType(String value) {
		try {
			MotorType.valueOf(value);
			return true;
		} catch (IllegalArgumentException ex) {
			return false;
		}
	}
	/**
	 * Checks if inputed value is bigger then 0.
	 * 
	 * @param amount - value to be inputed.
	 * @return true if inputed value is bigger then 0
	 * and false if not
	 */
	public boolean checkIfAmountIsPositive(int amount) {
		return amount > 0;
	}

	/**
	 * Checks if inputed value can be converted to int.
	 * 
	 * @param inputValue - value to be inputed.
	 * @return true if it can be converted
	 * false if it is not.
	 */
	public boolean checkIsInputInteger(String inputValue) {
		try {
			Integer.parseInt(inputValue);
		} catch (Exception e) {
			return false;
		}
		return true;

	}

}

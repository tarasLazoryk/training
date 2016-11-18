package ua.training.control;

import java.util.ArrayList;
import java.util.List;

import ua.training.model.Model;
import ua.training.model.entity.carriages.ComfortClass;
import ua.training.model.entity.carriages.FreightCarriage;
import ua.training.model.entity.carriages.PassangerCarriage;
import ua.training.model.entity.carriages.RailwayCarriage;
import ua.training.model.entity.locomotive.Locomotive;
import ua.training.model.entity.locomotive.MotorType;
import ua.training.model.entity.train.Train;
import ua.training.view.View;

/**
 * Controller class. It expresses controller in MVC pattern.
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
	private Model model;

	/**
	 * Reference to view part
	 *
	 * @see View
	 */
	private View view;

	/**
	 * Constructor
	 *
	 * @param model
	 *            reference to model
	 * @param view
	 *            reference to view
	 */
	public Control(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	public void processUser() {

		Locomotive locomotive = new Locomotive(MotorType.Electric);
		List<RailwayCarriage> railwayCarriages = new ArrayList<>();
		railwayCarriages.add(new PassangerCarriage("FirstClass"));
		railwayCarriages.add(new PassangerCarriage("FirstClass"));
		railwayCarriages.add(new PassangerCarriage("SecondClass"));
		railwayCarriages.add(new PassangerCarriage("ThirdClass"));
		railwayCarriages.add(new PassangerCarriage("ThirdClass"));
		railwayCarriages.add(new FreightCarriage(200));
		railwayCarriages.add(new PassangerCarriage("SecondClass"));
		railwayCarriages.add(new FreightCarriage(100));
		/* Inizialization of train instance */
		Train train = new Train(5, locomotive, railwayCarriages);

		view.printMessage(View.UNSORTED_CARRIAGES + train);
		train.sort();
		view.printMessage(View.UNSORTED_CARRIAGES + train);
		view.printMessage(View.PASSENGER_CARRIAGES_IN_BOUNDS + train.getPassangerCarriagesInBounds(0, 50));
		view.printMessage(View.AMOUNT_OF_PLACES + train.getSummaryAmountOfPlaces());

	}

	public boolean checkComfortClass(String value) {
		ComfortClass comfortClass;
		try {
			comfortClass = ComfortClass.valueOf(value);
			return true;
		} catch (IllegalArgumentException ex) {
			return false;
		}
	}

	public boolean checkMotorType(String value) {
		MotorType motorType;
		try {
			motorType = MotorType.valueOf(value);
			return true;
		} catch (IllegalArgumentException ex) {
			return false;
		}
	}

	public boolean checkIfAmountIsPositive(int amount) {
		return amount > 0;
	}

	public boolean checkIsInputInteger(String inputValue) {
		try {
			Integer.parseInt(inputValue);
		} catch (Exception e) {
			return false;
		}
		return true;

	}

}

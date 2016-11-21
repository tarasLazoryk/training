package ua.training.model.entity.carriages;

/**
 * ComfortClass represent possible comfort class
 * of the passenger carriage.
 * 
 * @author taras
 *
 */
public enum ComfortClass {

	FirstClass(18), SecondClass(36), ThirdClass(54);

	/**
	 * Amount of places accroding to comfort class.
	 */
	private final int amountOfPlaces;

	private ComfortClass(int amountOfPlaces) {
		this.amountOfPlaces = amountOfPlaces;
	}

	public int getAmountOfPlaces() {
		return amountOfPlaces;
	}
		
}

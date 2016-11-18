package ua.training.model.entity.carriages;

public enum ComfortClass {

	FirstClass(18), SecondClass(36), ThirdClass(54);

	private final int amountOfPlaces;

	private ComfortClass(int amountOfPlaces) {
		this.amountOfPlaces = amountOfPlaces;
	}

	public int getAmountOfPlaces() {
		return amountOfPlaces;
	}

}

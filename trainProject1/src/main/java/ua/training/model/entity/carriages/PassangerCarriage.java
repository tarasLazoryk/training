package ua.training.model.entity.carriages;

/**
 * PassangerCarriage represent passanger carriage
 * 
 * @author taras
 *
 */
public class PassangerCarriage extends RailwayCarriage {

	/**
	 * Amount of places for people.
	 */
	private int amountOfPlaces;

	/**
	 * Comfort class of the carriage.
	 */
	private ComfortClass comfortType;

	public PassangerCarriage(int amountOfWheelPairs, double weight, String comfortType) {
		super(amountOfWheelPairs, weight);
		this.amountOfPlaces = ComfortClass.valueOf(comfortType).getAmountOfPlaces();
		this.comfortType = ComfortClass.valueOf(comfortType);
	}

	public PassangerCarriage(int amountOfWheelPairs, double weight, ComfortClass comfortType) {
		super(amountOfWheelPairs, weight);
		this.amountOfPlaces = comfortType.getAmountOfPlaces();
		this.comfortType = comfortType;
	}

	public int getAmountOfPlaces() {
		return amountOfPlaces;
	}

	public ComfortClass getComfortType() {
		return comfortType;
	}

	public void setAmountOfPlaces(int amountOfPlaces) {
		this.amountOfPlaces = amountOfPlaces;
	}

	public void setComfortType(ComfortClass comfortType) {
		this.comfortType = comfortType;
	}

	public void setComfortType(String comfortType) {
		this.comfortType = ComfortClass.valueOf(comfortType);
	}

	@Override
	public String toString() {
		return "PassangerCarriage [amountOfPlaces=" + amountOfPlaces 
				+ ", comfortType=" + comfortType + ", amountOfWheelPairs=" 
				+ getAmountOfWheelPairs() + ", weight=" + getWeight() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amountOfPlaces;
		result = prime * result + ((comfortType == null) ? 0 : comfortType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PassangerCarriage other = (PassangerCarriage) obj;
		if (amountOfPlaces != other.amountOfPlaces)
			return false;
		if (comfortType != other.comfortType)
			return false;
		return true;
	}

}

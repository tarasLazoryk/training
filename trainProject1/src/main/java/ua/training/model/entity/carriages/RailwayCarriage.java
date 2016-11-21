package ua.training.model.entity.carriages;

/**
 * RailwayCarriage expresse railway carriage
 * 
 * @author taras
 *
 */
public abstract class RailwayCarriage {

	/**
	 * expresses amount of pairs of wheels on the carriage
	 */
	private int amountOfWheelPairs;

	/**
	 * expresses weight on the carriage
	 */
	private double weight;

	public RailwayCarriage(int amountOfWheelPairs, double weight) {
		this.amountOfWheelPairs = amountOfWheelPairs;
		this.weight = weight;
	}

	public int getAmountOfWheelPairs() {
		return amountOfWheelPairs;
	}

	public void setAmountOfWheelPairs(int amountOfWheelPairs) {
		this.amountOfWheelPairs = amountOfWheelPairs;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public abstract int getAmountOfPlaces();

	@Override
	public String toString() {
		return "RailwayCarriage [amountOfWheelPairs=" + amountOfWheelPairs 
				+ ", weight=" + weight + "]";
	}

}

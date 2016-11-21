package ua.training.model.entity.locomotive;

/**
 * Represent the locomotive
 * 
 * @author taras
 *
 */
public class Locomotive {

	/**
	 * Type of the motor.
	 */
	private MotorType motorType;
	
	/**
	 * expresses amount of pairs of wheels on the carriage
	 */
	private int amountOfWheelPairs;
	
	/**
	 * expresses the maximum possible speed for locomotive
	 */
	private double maxSpeed;
	
	/**
	 * expresses weight on the locomotive
	 */
	private double weight;

	public Locomotive(MotorType motorType, int amountOfWheelPairs, 
						double maxSpeed, double weight) {
		this.motorType = motorType;
		this.amountOfWheelPairs = amountOfWheelPairs;
		this.maxSpeed = maxSpeed;
		this.weight = weight;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public void setMotorType(MotorType motorType) {
		this.motorType = motorType;
	}

	public void setMotorType(String motorType) {
		this.motorType = MotorType.valueOf(motorType);
	}

	public int getAmountOfWheelPairs() {
		return amountOfWheelPairs;
	}

	public void setAmountOfWheelPairs(int amountOfWheelPairs) {
		this.amountOfWheelPairs = amountOfWheelPairs;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public MotorType getMotorType() {
		return motorType;
	}

	@Override
	public String toString() {
		return "Locomotive [motorType=" + motorType + ", amountOfWheelPairs=" 
				+ amountOfWheelPairs + ", maxSpeed=" + maxSpeed + ", weight=" 
				+ weight + "]";
	}
	
}

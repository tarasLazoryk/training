package ua.training.model.entity.locomotive;

/**
 * Represent the locomotive
 * @author taras
 *
 */
public class Locomotive {
	
	/**
	 * Type of the motor.
	 */
	private MotorType motorType;

	public Locomotive(MotorType motorType) {
		this.motorType = motorType;
	}

	public MotorType getMotorType() {
		return motorType;
	}

	public void setMotorType(MotorType motorType) {
		this.motorType = motorType;
	}

	public void setMotorType(String motorType) {
		this.motorType = MotorType.valueOf(motorType);
	}

}

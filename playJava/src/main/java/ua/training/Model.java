package ua.training;

import java.util.Random;

/**
 * Model class. It expresses for model in MVC pattern.
 * 
 * @version 1.0 30 Oct 2016
 * @author Taras Lazoryk
 *
 */
public class Model {
	
	/**MAX_VALUE expreses maximum possible value */
	public static final int MAX_VALUE = 100;
	
	/**MIN_VALUE expreses minimum possible value */
	public static final int MIN_VALUE = 0;
	private int maxValue;
	private int minValue;
	
	/**programValue expreses value created by program, which user must guess */
	private int programValue;
	
	/**userValue expreses value which typed user */
	private int userValue;

	//constructor
	public Model() {
		minValue = MIN_VALUE;
		maxValue = MAX_VALUE;
		programValue = createRandomValue();
	}

	public int getMinValue() {
		return minValue;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public int getUserValue() {
		return this.userValue;
	}

	public void setUserValue(int userValue) {
		this.userValue = userValue;
	}

	public void setMaxValue(int maxValue) {
		if (this.maxValue > maxValue) {
			this.maxValue = maxValue;
		}
	}

	public void setMinValue(int minValue) {
		if (this.minValue < minValue) {
			this.minValue = minValue;
		}

	}

	private int createRandomValue() {
		Random random = new Random();
		
		return random.nextInt(maxValue + 1 - minValue) + minValue;
	}

	public boolean isEqualToProgramValue(int userValue) {
		return userValue == this.programValue;
	}

	public boolean isBiggerThenProgramValue(int userValue) {
		if (userValue > this.programValue) {
			this.maxValue = userValue - 1;
			return true;
		} else {
			this.minValue = userValue + 1;
			return false;
		}
	}

	public boolean isInBounds(int userValue) {
		return !((userValue > maxValue) || (userValue < minValue));
	}

}

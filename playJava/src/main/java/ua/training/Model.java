package ua.training;

import java.util.ArrayList;
import java.util.Random;

/**
 * Model class. It expresses model in MVC pattern.
 * 
 * @version 1.0 30 Oct 2016
 * @author Taras Lazoryk
 *
 */
public class Model {
	
	/**
	 * Expresses upper boundary of the interval.
	 */	
	private int upperBoundary;
	
	/**
	 * Expresses lower boundary of the interval.
	 */
	private int lowerBoundary;
	
	/**
	 * Expresses secret value, which is created randomly
	 * and which user must to guess.
	 */
	private int secretValue;
	
	/**
	 * Contains list of all users tries to guess the secret value.
	 */
	private ArrayList<Integer> tryList = new ArrayList<Integer>();
	
	/**
	 * checkValue checks is the integer value equals to secretValue, or not.
	 * If it is - returns true, and add this value to tryList.
	 * If not - checks is the value bigger or smaller then secret value.
	 * If it is bigger then secretValue - upperBoundary assigns value,
	 * add this value to tryList and return false.
	 * If it is smaller then secretValue - loweBoundary assigns value,
	 * add this value to tryList and return false.		
	 * @param value - the integer value to be checked.
	 * @return true if value is equal to secretValue and false if it is not.
	 */
	public boolean checkValue (int value){
        if (value == secretValue){
        	tryList.add(value);
            return true;
        } else if (value > secretValue){
            upperBoundary = value;
            tryList.add(value);
        } else {
            lowerBoundary = value;
            tryList.add(value);
        }
      return false;
    }
	
	public int getUpperBoundary() {
		return upperBoundary;
	}
	
	public ArrayList<Integer> getTryList(){
		return tryList;
	}
	public int getLowerBoundary() {
		return lowerBoundary;
	}
	
	public int getSecretValue(){
		return secretValue;
	}
	/**
	 * Sets the boundaries of the interval.
	 * @param lowerBoundary - the lower boundary to be set.
	 * @param upperBoundary - the upper boundary to be set.
	 */
	public void setBoundaries(int lowerBoundary, int upperBoundary) {
		this.lowerBoundary = lowerBoundary;
		this.upperBoundary = upperBoundary;
	}
	
	/**
	 * 
	 * Sets the value of secretValue, between lower boundary and upper boundary of the interval.
	 *
	 * @param lowerBoundary - the lower boundary to be used.
	 * @param upperBoundary - the upper boundary to be used.
	 */
	public void setSecretValue(int lowerBoundary, int upperBoundary){
		Random random = new Random();
		
		secretValue = random.nextInt(upperBoundary - lowerBoundary - 2 ) + lowerBoundary + 1;
	}
}

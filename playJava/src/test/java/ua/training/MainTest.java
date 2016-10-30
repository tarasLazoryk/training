package ua.playjava;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ua.playjava.Controller;
import ua.playjava.Model;
import ua.playjava.View;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * MainTest class. It is used for testing the program.
 * 
 * @version 1.0 30 Oct 2016
 * @author Taras Lazoryk
 *
 */
public class MainTest {
	
	/** MINIMAL_DEFLECTION expresses the minimal deflection. 
	 * It is using to create values which are guaranted lieing in bounds, or out of bounds.  	 
	 * */
	public static final int MINIMAL_DEFLECTION = 1; 
	private Model model;
	private View view;
	private Controller controller;

	@Before
	public void initialize() {
		model = new Model();
		view = new View();
		controller = new Controller(model, view);
	}

	@Test
	public void testInputIntValueWithCorrectValue() {
		byte[] byteMessage = ("" + model.getMinValue() + 
							MINIMAL_DEFLECTION).getBytes();
		ByteArrayInputStream input = new ByteArrayInputStream(byteMessage);
		
		System.setIn(input);
		Scanner sc = new Scanner(System.in);
		int inputValue = controller.inputIntValue(sc);
		assertEquals(model.getMinValue() + MINIMAL_DEFLECTION, inputValue);

	}

	@Test(expected = NoSuchElementException.class)
	public void testInputIntValueWithIncorrectValue() {
		byte[] byteMessage = "Text".getBytes();
		ByteArrayInputStream input = new ByteArrayInputStream(byteMessage);
		
		System.setIn(input);
		Scanner sc = new Scanner(System.in);
		int inputValue = controller.inputIntValue(sc);
	}

	@Test(expected = NullPointerException.class)
	public void testInputIntValueWithotScanner() {
		int inputValue = controller.inputIntValue(null);
	}

	@Test
	public void testIsValueInBoundsWithCorrectValue() {
		byte[] byteMessage = ("" + model.getMinValue() + 
							MINIMAL_DEFLECTION).getBytes();
		ByteArrayInputStream input = new ByteArrayInputStream(byteMessage);
		System.setIn(input);
		Scanner sc = new Scanner(System.in);
		int correctValue = controller.isValueInBounds(sc);
		assertEquals(model.getMinValue() + MINIMAL_DEFLECTION, correctValue);
	}

	@Test(expected = NoSuchElementException.class)
	public void testIsValueInBoundsWithIncorrectValue() {
		byte[] byteMessage = ("" + model.getMaxValue() + MINIMAL_DEFLECTION).getBytes();
		ByteArrayInputStream in = new ByteArrayInputStream(byteMessage);
		System.setIn(in);
		Scanner sc = new Scanner(System.in);
		int correctValue = controller.isValueInBounds(sc);
	}

	@Test(expected = NullPointerException.class)
	public void testIsValueInBoundsWithoutScanner() {
		int correctValue = controller.isValueInBounds(null);
	}

	@Test
	public void testIsBiggerThenProgramValue() {
		int biggerValue = model.getMaxValue() + MINIMAL_DEFLECTION;
		int smallerValue = 0;
		
		assertTrue(model.isBiggerThenProgramValue(biggerValue));
		assertFalse(model.isBiggerThenProgramValue(smallerValue));
	}

	@Test
	public void testIsEqualToProgramValue() {
		int notEqualValue = model.getMaxValue() + MINIMAL_DEFLECTION;
		boolean isEqual = false;
		
		assertFalse(model.isEqualToProgramValue(notEqualValue));			
		for (int i = model.getMinValue(); i < model.getMaxValue(); i++) {
			if (model.isEqualToProgramValue(i)) {
				isEqual = true;
			}
		}
		assertTrue(isEqual);
	}

	@Test
	public void testIsInBound() {
		int notInBoundValue = model.getMaxValue() + MINIMAL_DEFLECTION;
		int inBoundValue = model.getMaxValue() - MINIMAL_DEFLECTION;
		
		assertFalse(model.isInBounds(notInBoundValue));
		assertTrue(model.isInBounds(inBoundValue));
	}
	
	
	@Test
	public void testSetMaxValue() {
		int oldMaxValue = model.getMaxValue();
		//input value which won't change the maxValue
		model.setMaxValue(model.getMaxValue() + MINIMAL_DEFLECTION);
		assertEquals(oldMaxValue, model.getMaxValue());
		//input value which will change the maxValue
		oldMaxValue = model.getMaxValue();
		model.setMaxValue(model.getMaxValue() - MINIMAL_DEFLECTION);
		assertNotEquals(oldMaxValue, model.getMaxValue());
	}

	@Test
	public void testSetMinValue() {
		int oldMinValue = model.getMinValue();
		//input value which won't change the minValue
		model.setMinValue(model.getMinValue() - MINIMAL_DEFLECTION);
		assertEquals(oldMinValue, model.getMinValue());
		//input value which will change the minValue
		oldMinValue = model.getMinValue();
		model.setMinValue(model.getMinValue() + MINIMAL_DEFLECTION);
		assertNotEquals(oldMinValue, model.getMinValue());
	}

	@Test
	public void testSetUserValue() {
		int userValue = model.getMinValue() + MINIMAL_DEFLECTION;
		
		model.setUserValue(userValue);
		assertEquals(userValue, model.getUserValue());
	}

}

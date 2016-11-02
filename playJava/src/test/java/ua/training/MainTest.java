package ua.training;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ua.training.Controller;
import ua.training.Model;
import ua.training.View;

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
	public void testSetSecretNumber() throws Exception {
		int lowerBoundary = -100;
		int upperBoundary = 100;
		int iterations = 10000;
		
		for (int i = 0; i < iterations; i++) {
			model.setSecretValue(lowerBoundary, upperBoundary);
			assertTrue((lowerBoundary < model.getSecretValue()) && (model.getSecretValue() < upperBoundary));
		}
	}
}

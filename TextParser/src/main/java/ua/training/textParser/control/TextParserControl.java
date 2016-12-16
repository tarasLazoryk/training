package ua.training.textParser.control;

import ua.training.textParser.model.Model;
import ua.training.textParser.view.View;

import java.io.IOException;
import java.util.Scanner;

/**
 * Class which controls the main process.
 * Control implementation.
 *
 * @author Taras Lazoryk
 */
public class TextParserControl implements Control {
	
	/**
	 * Path to the file, which will be read.
	 */
	private static final String FILE_PATH = "D:\\Study\\trainingProjects\\training\\TextParser\\input.txt";
	/**
	 * Reference to model part
	 *
	 */
	private Model model;

	/**
	 * Reference to view part
	 *
	 */
	private View view;

	public TextParserControl(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	/**
	 * Control processUser() realization
	 */
	@Override
	public void processUser() {
		System.out.println(View.INPUT_PATH_TO_THE_FILE + FILE_PATH);
		try {
			ScannerAdapter sc = new ScannerAdapter(new Scanner(System.in));
			int amountOfCharacters = inputAmountOfCharacters(sc);
			String data = model.getText(FILE_PATH);
			view.printMessage(View.EDITED_TEXT_MESSAGE);
			view.printMessage(model.processText(data));
			view.printMessage(model.getWordsWithLettersAmount(amountOfCharacters).toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method which is used to input amount of letters.
	 * It will ask user to write value, until he do it correctly.
	 * 
	 * @param sc Scanner.
	 * @return   int value.
	 */
	public int inputAmountOfCharacters(ScannerAdapter sc) {
		view.printMessage(View.INPUT_AMOUNT_OF_LETTERS);
		while (true) {
			String value = sc.next();
			if (checkStringForInt(value)) {
				return Integer.parseInt(value);
			} else {
				view.printMessage(View.INCORRECT_VALUE);
			}
		}
	}

	/**
	 * Method checks if inputed string value can be converted
	 * to int.
	 * 
	 * @param value  string to be checked
	 * @return true if value can be checked and false
	 * if it is not.
	 */
	public boolean checkStringForInt(String value) {
		try {
			 Integer.parseInt(value);
			return true;
		} catch (Exception e) {
			return false;
		}

	}
}

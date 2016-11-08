package ua.training;

import java.util.Scanner;

/**
 * RecordController controls the process of record filling.
 * 
 * @author taras
 *
 */
public class RecordController {
	View view = new View();

	// constructor
	public RecordController(View view) {
		this.view = view;
	}
	
	/**
	 * Method which ask to input correct data. 
	 * Write a rule every time user make a mistake.
	 * By Using checkInput check if the input is correct.
	 * 
	 * @param Sc scanner
	 * @param Regex regular expression
	 * @param Message message with a rule.
	 * @return correct value
	 */
	public String inputData(Scanner sc, String regex, String message) {
		view.print(message);
		String input = sc.nextLine();
		while (!checkInput(regex, input)) {
			view.print(message);
			input = sc.nextLine();
		}
		return input;
	}
	
	/**
	 * Method, which ask user to write yes or no. Made specially to ask 
	 * does user have second mobile number
	 * 
	 * @param Sc scanner
	 * @return return true if user input yes, and false if no.
	 */
	public boolean userCheckInput(Scanner sc) {
		return inputData(sc, GlobalConstants.REG_FOR_YES_OR_NO, GlobalConstants.INPUT_YES_OR_NO).equals("yes");
	}

	/**
	 * Method which check the value with regular expression.
	 * 
	 * @param regex regular expression
	 * @param input message which user inputs
	 * @return true if value is correct, and false if it is not
	 */
	public boolean checkInput(String regex, String input) {
		return input.matches(regex);
	}
	/**
	 * Method which controls input of all data.
	 * 
	 * @return record object.
	 */
	public Record inputDataWithScanner() {
		Record record = new Record();
		String secondMobilePhoneNumber;
		Scanner sc = new Scanner(System.in);
		String lastName = inputData(sc, Record.REG_FOR_NAME, GlobalConstants.INPUT_LAST_NAME);
		String firstName = inputData(sc, Record.REG_FOR_NAME, GlobalConstants.INPUT_FIRST_NAME);
		String secondName = inputData(sc, Record.REG_FOR_NAME, GlobalConstants.INPUT_SECOND_NAME);
		String nickname = inputData(sc, Record.REG_FOR_NICKNAME, GlobalConstants.INPUT_NICKNAME);
		String comment = inputData(sc, Record.REG_FOR_COMMENT, GlobalConstants.INPUT_COMMENT);
		String group = inputData(sc, generateRegForGroups(), generateMessageForGroups());
		String homePhoneNumber = inputData(sc, Record.REG_FOR_HOME_PHONE_NUMBER,
				GlobalConstants.INPUT_HOME_PHONE_NUMBER);
		String mobilePhoneNumber = inputData(sc, Record.REG_FOR_MOBILE_PHONE_NUMBER,
				GlobalConstants.INPUT_MOBILE_PHONE_NUMBER);
		if (userCheckInput(sc)) {
			secondMobilePhoneNumber = inputData(sc, Record.REG_FOR_MOBILE_PHONE_NUMBER,
					GlobalConstants.INPUT_SECOND_MOBILE_PHONE_NUMBER);
		} else {
			secondMobilePhoneNumber = null;
		}
		String email = inputData(sc, Record.REG_FOR_EMAIL, GlobalConstants.INPUT_EMAIL);
		String skype = inputData(sc, Record.REG_FOR_SKYPE, GlobalConstants.INPUT_SKYPE);
		String index = inputData(sc, Record.REG_FOR_INDEX, GlobalConstants.INPUT_INDEX);
		String city = inputData(sc, Record.REG_FOR_CITY, GlobalConstants.INPUT_CITY);
		String street = inputData(sc, Record.REG_FOR_STREET, GlobalConstants.INPUT_STREET);
		String houseNumber = inputData(sc, Record.REG_FOR_HOUSE_NUMBER, GlobalConstants.INPUT_HOUSE_NUMBER);
		String appartamentNumber = inputData(sc, Record.REG_FOR_APPARTAMENT_NUMBER,
				GlobalConstants.INPUT_APPARTAMENT_NUMBER);
		String inputDate = inputData(sc, Record.REG_FOR_DATE, GlobalConstants.INPUT_DATE_OF_LAST_RECORD);
		String changeDate = inputData(sc, Record.REG_FOR_DATE, GlobalConstants.INPUT_DATE_OF_CHANGE);
		record.setRecordValues(lastName, firstName, secondName, nickname, comment, group, homePhoneNumber,
				mobilePhoneNumber, secondMobilePhoneNumber, email, skype, inputDate, changeDate, index, city, street,
				houseNumber, appartamentNumber);
		return record;

	}
	
	/**
	 * generates regular expression for groups.
	 * 
	 * @return string regular expression
	 */
	public String generateRegForGroups() {
		StringBuilder result = new StringBuilder();
		result.append("(");
		for (Groups Group : Groups.values()) {
			result.append(Group + "|");
		}
		result.deleteCharAt(result.length() - 1);
		result.append(")");
		return result.toString();
	}
	
	/**
	 * generates input message with a rule for groups
	 * 
	 * @return input messase.
	 */
	public String generateMessageForGroups() {
		StringBuilder result = new StringBuilder();
		result.append(GlobalConstants.INPUT_GROUP);
		for (Groups Group : Groups.values()) {
			result.append(Group + ",");
		}
		result.deleteCharAt(result.length() - 1);
		result.append(".");
		return result.toString();
	}
}

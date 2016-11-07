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
	public String inputData(Scanner Sc, String Regex, String Message) {
		view.print(Message);
		String input = Sc.nextLine();
		while (!checkInput(Regex, input)) {
			view.print(Message);
			input = Sc.nextLine();
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
	public boolean userCheckInput(Scanner Sc) {
		return inputData(Sc, GlobalConstants.REG_FOR_YES_OR_NO, GlobalConstants.INPUT_YES_OR_NO).equals("yes");
	}

	/**
	 * Method which check the value with regular expression.
	 * 
	 * @param Regex regular expression
	 * @param Message message which user inputs
	 * @return true if value is correct, and false if it is not
	 */
	public boolean checkInput(String Regex, String input) {
		return input.matches(Regex);
	}
	/**
	 * Method which controls input of all data.
	 * 
	 * @return record object.
	 */
	public Record inputDataWithScanner() {
		Record record = new Record();
		String SecondMobilePhoneNumber;
		Scanner Sc = new Scanner(System.in);
		String LastName = inputData(Sc, record.REG_FOR_NAME, GlobalConstants.INPUT_LAST_NAME);
		String FirstName = inputData(Sc, record.REG_FOR_NAME, GlobalConstants.INPUT_FIRST_NAME);
		String SecondName = inputData(Sc, record.REG_FOR_NAME, GlobalConstants.INPUT_SECOND_NAME);
		String Nickname = inputData(Sc, record.REG_FOR_NICKNAME, GlobalConstants.INPUT_NICKNAME);
		String Comment = inputData(Sc, record.REG_FOR_COMMENT, GlobalConstants.INPUT_COMMENT);
		String Group = inputData(Sc, generateRegForGroups(), generateMessageForGroups());
		String HomePhoneNumber = inputData(Sc, record.REG_FOR_HOME_PHONE_NUMBER,
				GlobalConstants.INPUT_HOME_PHONE_NUMBER);
		String MobilePhoneNumber = inputData(Sc, record.REG_FOR_MOBILE_PHONE_NUMBER,
				GlobalConstants.INPUT_MOBILE_PHONE_NUMBER);
		if (userCheckInput(Sc)) {
			SecondMobilePhoneNumber = inputData(Sc, record.REG_FOR_MOBILE_PHONE_NUMBER,
					GlobalConstants.INPUT_SECOND_MOBILE_PHONE_NUMBER);
		} else {
			SecondMobilePhoneNumber = null;
		}
		String Email = inputData(Sc, record.REG_FOR_EMAIL, GlobalConstants.INPUT_EMAIL);
		String Skype = inputData(Sc, record.REG_FOR_SKYPE, GlobalConstants.INPUT_SKYPE);
		String Index = inputData(Sc, record.REG_FOR_INDEX, GlobalConstants.INPUT_INDEX);
		String City = inputData(Sc, record.REG_FOR_CITY, GlobalConstants.INPUT_CITY);
		String Street = inputData(Sc, record.REG_FOR_STREET, GlobalConstants.INPUT_STREET);
		String HouseNumber = inputData(Sc, record.REG_FOR_HOUSE_NUMBER, GlobalConstants.INPUT_HOUSE_NUMBER);
		String AppartamentNumber = inputData(Sc, record.REG_FOR_APPARTAMENT_NUMBER,
				GlobalConstants.INPUT_APPARTAMENT_NUMBER);
		String InputDate = inputData(Sc, record.REG_FOR_DATE, GlobalConstants.INPUT_DATE_OF_LAST_RECORD);
		String ChangeDate = inputData(Sc, record.REG_FOR_DATE, GlobalConstants.INPUT_DATE_OF_CHANGE);
		record.setRecordValues(LastName, FirstName, SecondName, Nickname, Comment, Group, HomePhoneNumber,
				MobilePhoneNumber, SecondMobilePhoneNumber, Email, Skype, InputDate, ChangeDate, Index, City, Street,
				HouseNumber, AppartamentNumber);
		return record;

	}
	
	/**
	 * generates regular expression for groups.
	 * 
	 * @return string regular expression
	 */
	public String generateRegForGroups() {
		StringBuilder Result = new StringBuilder();
		Result.append("(");
		for (Groups Group : Groups.values()) {
			Result.append(Group + "|");
		}
		Result.deleteCharAt(Result.length() - 1);
		Result.append(")");
		return Result.toString();
	}
	
	/**
	 * generates input message with a rule for groups
	 * 
	 * @return Input messase.
	 */
	public String generateMessageForGroups() {
		StringBuilder Result = new StringBuilder();
		Result.append(GlobalConstants.INPUT_GROUP);
		for (Groups Group : Groups.values()) {
			Result.append(Group + ",");
		}
		Result.deleteCharAt(Result.length() - 1);
		Result.append(".");
		return Result.toString();
	}
}

package ua.training;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Record expresses a record about one user.
 * 
 * @author taras
 *
 */
public class Record {

	public static final String DATE_FORMAT = "dd/MM/yyyy";
	public static final String REG_FOR_NAME = "^[A-Z][a-z]+$";
	public static final String REG_FOR_LAST_NAME = "^[A-Z][a-z]+$";
	public static final String REG_FOR_SECOND_NAME = "^[A-Z][a-z]+$";
	public static final String REG_FOR_NICKNAME = "^[a-zA-Z][A-Za-z0-9_]{5,14}$";
	public static final String REG_FOR_SKYPE = "^[a-zA-Z][a-zA-Z0-9_\\-\\,\\.]{5,31}$";
	public static final String REG_FOR_MOBILE_PHONE_NUMBER = "^\\(\\d{3}\\)-\\d{3}-\\d\\d\\d\\d$";
	public static final String REG_FOR_HOME_PHONE_NUMBER = "^\\d{3}-\\d\\d-\\d\\d$";
	public static final String REG_FOR_COMMENT = "^.*$";
	public static final String REG_FOR_EMAIL = "^([a-z0-9_-]+)*[a-z0-9_-]+@[a-z0-9]+(\\.[a-z0-9]+)*\\.[a-z]{1,6}$";
	public static final String REG_FOR_INDEX = "^[0-9]+{5}$";
	public static final String REG_FOR_STREET = "^([A-Z][a-z]+\\s)*[A-Z][a-z]+\\s(street|square|road)$";
	public static final String REG_FOR_HOUSE_NUMBER = "^\\d{1,3}(/\\d{1,3}){0,1}$";
	public static final String REG_FOR_APPARTAMENT_NUMBER = "^\\d{1,3}$";
	public static final String REG_FOR_DATE = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)\\d\\d$";
	public static final String REG_FOR_CITY = "^[A-Z][a-z]+([-][A-Z][a-z])*$";	
	public static final String BUILDING = "building";
	public static final String COMA = ",";
	public static final String APP = "app.";
	public static final String SPACE = " ";
	public static final String DOT = ".";

	private String lastName;
	private String firstName;
	private String secondName;
	private String allName;
	private String nickname;
	private String comment;
	private Groups userGroup;
	private String homeTelephoneNumber;
	private String mobileTelephoneNumber;
	private String secondMobileTelephoneNumber;
	private String email;
	private String skype;
	private Adress userAdress;
	private String fullAdress;
	private LocalDate inputDate;
	private LocalDate changeDate;
	
	/**
	 * Sets all the values of the record.
	 * 
	 * @param lastName expresses last name of the person.
	 * @param firstName expresses first name of the person.
	 * @param secondName expresses second name of the person.
	 * @param nickname expresses nickname of the person.
	 * @param comment a comment which user can write.
	 * @param userGroup group which follows user.
	 * @param homeTelephoneNumber home phone number.
	 * @param mobileTelephoneNumber First mobile phone of number.
	 * @param secondMobileTelephoneNumber Second mobile phone of number.
	 * @param email users Email.
	 * @param skype users skype.
	 * @param inputDate Date when the last record was inputed. In string form.
	 * @param changeDate Date when the last was one of the records edited. In string form.
	 * @param index expresses index.
	 * @param city expresses city where person lives.
	 * @param street expresses street where person lives.
	 * @param houseNumber expresses persons number of the House.
	 * @param appartamentNumber expresses persons appartament number;
	 */
	public void setRecordValues(String lastName, String firstName, String secondName, 
			String nickname, String comment, String userGroup, 
			String homeTelephoneNumber, String mobileTelephoneNumber,
			String secondMobileTelephoneNumber, String email, String skype, 
			String inputDate, String changeDate, String index, String city, 
			String street, String houseNumber, String appartamentNumber) {

		this.lastName = lastName;
		this.firstName = firstName;
		this.secondName = secondName;
		setAllName(firstName, secondName, lastName);
		this.nickname = nickname;
		this.comment = comment;
		this.userGroup = Groups.valueOf(userGroup);
		this.homeTelephoneNumber = homeTelephoneNumber;
		this.mobileTelephoneNumber = mobileTelephoneNumber;
		this.secondMobileTelephoneNumber = secondMobileTelephoneNumber;
		this.email = email;
		this.skype = skype;
		this.userAdress = new Adress(index, city, street, houseNumber, appartamentNumber);
		setFullAdress(index, city, street, houseNumber, appartamentNumber);
		setInputDate(inputDate);
		setChangeDate(changeDate);
	}
	/**
	 * Create from all three parts of the name one record, which
	 * contains last name and first letters of the first and second named.
	 * 
	 * @param firstName First Name
	 * @param secondName Second Name
	 * @param lastName Last Name
	 */
	public void setAllName(String firstName, String secondName, String lastName) {
		this.allName = lastName + SPACE + firstName.substring(0, 1) + DOT 
					+ secondName.substring(0, 1) + DOT;
	}
	
	/**
	 * Creates from all parts of adress one record, which contains
	 * Index, city, street,House number and appartament number.
	 * 
	 * @param index index.
	 * @param vity city.
	 * @param street street.
	 * @param houseNumber number of house.
	 * @param appartamentNumber number of appartament.
	 */
	public void setFullAdress(String index, String city, String street, 
							String houseNumber, String appartamentNumber) {
		StringBuilder fullAdressStringBuilder = new StringBuilder();
		fullAdressStringBuilder.append(index);
		fullAdressStringBuilder.append(COMA);
		fullAdressStringBuilder.append(city);
		fullAdressStringBuilder.append(COMA);
		fullAdressStringBuilder.append(street);
		fullAdressStringBuilder.append(COMA);
		fullAdressStringBuilder.append(BUILDING);
		fullAdressStringBuilder.append(houseNumber);
		fullAdressStringBuilder.append(COMA);
		fullAdressStringBuilder.append(APP);
		fullAdressStringBuilder.append(appartamentNumber);
		this.fullAdress = fullAdressStringBuilder.toString();
	}

	/**
	 * Set the date when the last record was added. Converts data from 
	 * string to LocalDate. Throws DateTimeException
	 * 
	 * @param inputDate input date in string form.
	 * @throws dateTimeException the exception to be thrown, 
	 * when data is incorect	 
	 */	
	public void setInputDate(String inputDate) throws DateTimeException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
		this.inputDate = LocalDate.parse(inputDate, formatter);

	}
	
	/**
	 * Set the date when ine of the records was last edited. Converts data from 
	 * string to LocalDate. Throws DateTimeException
	 * 
	 * @param changeDate input date in string form.
	 * @throws dateTimeException the exception to be thrown, 
	 * when data is incorect	 
	 */
	public void setChangeDate(String changeDate) throws DateTimeException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
		this.changeDate = LocalDate.parse(changeDate, formatter);
	}

	public String getSecondMobileTelephoneNumber() {
		return secondMobileTelephoneNumber;
	}

	public void setSecondMobileTelephoneNumber(String secondMobileTelephoneNumber) {
		this.secondMobileTelephoneNumber = secondMobileTelephoneNumber;
	}

	@Override
	public String toString() {
		return "Record [LastName=" + lastName + ", FirstName=" + firstName + ", SecondName=" + secondName + ", AllName="
				+ allName + ", Nickname=" + nickname + ", Comment=" + comment + ", Group=" + userGroup
				+ ", HomeTelephoneNumber=" + homeTelephoneNumber + ", MobileTelephoneNumber=" + mobileTelephoneNumber
				+ ((getSecondMobileTelephoneNumber() != null)
						? ", SecondMobileTelephoneNumber=" + getSecondMobileTelephoneNumber() : "")
				+ ", Email=" + email + ", Skype=" + skype + ", UserAdress=" + userAdress.toString() + ", FullAdress="
				+ fullAdress + ", InputDate=" + inputDate + ", ChangeDate=" + changeDate + "]";
	}

}

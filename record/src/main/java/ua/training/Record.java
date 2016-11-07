package ua.training;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

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

	private String LastName;
	private String FirstName;
	private String SecondName;
	private String AllName;
	private String Nickname;
	private String Comment;
	private Groups UserGroup;
	private String HomeTelephoneNumber;
	private String MobileTelephoneNumber;
	private String SecondMobileTelephoneNumber;
	private String Email;
	private String Skype;
	private Adress UserAdress;
	private String FullAdress;
	private LocalDate InputDate;
	private LocalDate ChangeDate;
	
	/**
	 * Sets all the values of the record.
	 * 
	 * @param LastName expresses last name of the person.
	 * @param FirstName expresses first name of the person.
	 * @param SecondName expresses second name of the person.
	 * @param Nickname expresses nickname of the person.
	 * @param Comment a comment which user can write.
	 * @param UserGroup group which follows user.
	 * @param HomeTelephoneNumber home phone number.
	 * @param MobileTelephoneNumber First mobile phone of number.
	 * @param SecondMobileTelephoneNumber Second mobile phone of number.
	 * @param Email users Email.
	 * @param Skype users skype.
	 * @param InputDate Date when the last record was inputed. In string form.
	 * @param ChangeDate Date when the last was one of the records edited. In string form.
	 * @param Index expresses index.
	 * @param City expresses city where person lives.
	 * @param Street expresses street where person lives.
	 * @param HouseNumber expresses persons number of the House.
	 * @param AppartamentNumber expresses persons appartament number;
	 */
	public void setRecordValues(String LastName, String FirstName, String SecondName, 
			String Nickname, String Comment, String UserGroup, 
			String HomeTelephoneNumber, String MobileTelephoneNumber,
			String SecondMobileTelephoneNumber, String Email, String Skype, 
			String InputDate, String ChangeDate, String Index, String City, 
			String Street, String HouseNumber, String AppartamentNumber) {

		this.LastName = LastName;
		this.FirstName = FirstName;
		this.SecondName = SecondName;
		setAllName(FirstName, SecondName, LastName);
		this.Nickname = Nickname;
		this.Comment = Comment;
		this.UserGroup = Groups.valueOf(UserGroup);
		this.HomeTelephoneNumber = HomeTelephoneNumber;
		this.MobileTelephoneNumber = MobileTelephoneNumber;
		this.SecondMobileTelephoneNumber = SecondMobileTelephoneNumber;
		this.Email = Email;
		this.Skype = Skype;
		this.UserAdress = new Adress(Index, City, Street, HouseNumber, AppartamentNumber);
		setFullAdress(Index, City, Street, HouseNumber, AppartamentNumber);
		setInputDate(InputDate);
		setChangeDate(ChangeDate);
	}
	/**
	 * Create from all three parts of the name one record, which
	 * contains last name and first letters of the first and second named.
	 * 
	 * @param FirstName First Name
	 * @param SecondName Second Name
	 * @param LastName Last Name
	 */
	public void setAllName(String FirstName, String SecondName, String LastName) {
		this.AllName = LastName + SPACE + FirstName.substring(0, 1) + DOT 
					+ SecondName.substring(0, 1) + DOT;
	}
	
	/**
	 * Creates from all parts of adress one record, which contains
	 * Index, city, street,House number and appartament number.
	 * 
	 * @param Index index.
	 * @param City city.
	 * @param Street street.
	 * @param HouseNumber number of house.
	 * @param AppartamentNumber number of appartament.
	 */
	public void setFullAdress(String Index, String City, String Street, 
							String HouseNumber, String AppartamentNumber) {
		StringBuilder FullAdressStringBuilder = new StringBuilder();
		FullAdressStringBuilder.append(Index);
		FullAdressStringBuilder.append(COMA);
		FullAdressStringBuilder.append(City);
		FullAdressStringBuilder.append(COMA);
		FullAdressStringBuilder.append(Street);
		FullAdressStringBuilder.append(COMA);
		FullAdressStringBuilder.append(BUILDING);
		FullAdressStringBuilder.append(HouseNumber);
		FullAdressStringBuilder.append(COMA);
		FullAdressStringBuilder.append(APP);
		FullAdressStringBuilder.append(AppartamentNumber);
		this.FullAdress = FullAdressStringBuilder.toString();
	}

	/**
	 * Set the date when the last record was added. Converts data from 
	 * string to LocalDate. Throws DateTimeException
	 * 
	 * @param InputDate input date in string form.
	 * @throws DateTimeException the exception to be thrown, 
	 * when data is incorect	 * 
	 */	
	public void setInputDate(String InputDate) throws DateTimeException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
		this.InputDate = LocalDate.parse(InputDate, formatter);

	}
	
	/**
	 * Set the date when ine of the records was last edited. Converts data from 
	 * string to LocalDate. Throws DateTimeException
	 * 
	 * @param ChangeDate input date in string form.
	 * @throws DateTimeException the exception to be thrown, 
	 * when data is incorect	 
	 */
	public void setChangeDate(String ChangeDate) throws DateTimeException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
		this.ChangeDate = LocalDate.parse(ChangeDate, formatter);
	}

	public String getSecondMobileTelephoneNumber() {
		return SecondMobileTelephoneNumber;
	}

	public void setSecondMobileTelephoneNumber(String secondMobileTelephoneNumber) {
		SecondMobileTelephoneNumber = secondMobileTelephoneNumber;
	}

	@Override
	public String toString() {
		return "Record [LastName=" + LastName + ", FirstName=" + FirstName + ", SecondName=" + SecondName + ", AllName="
				+ AllName + ", Nickname=" + Nickname + ", Comment=" + Comment + ", Group=" + UserGroup
				+ ", HomeTelephoneNumber=" + HomeTelephoneNumber + ", MobileTelephoneNumber=" + MobileTelephoneNumber
				+ ((getSecondMobileTelephoneNumber() != null)
						? ", SecondMobileTelephoneNumber=" + getSecondMobileTelephoneNumber() : "")
				+ ", Email=" + Email + ", Skype=" + Skype + ", UserAdress=" + UserAdress.toString() + ", FullAdress="
				+ FullAdress + ", InputDate=" + InputDate + ", ChangeDate=" + ChangeDate + "]";
	}

}

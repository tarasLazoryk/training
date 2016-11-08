package ua.training;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * RecordBook represent record book.
 * @author taras
 *
 */
public final class RecordBook extends Date {
	
	String firstName;
	String lastName;
	String secondName;
	String telephoneNumber;

	public RecordBook() {
		super();
	}

	public RecordBook(Date birthdatDate, String firstName, String lastName, String secondName, String telephoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.secondName = secondName;
		this.telephoneNumber = telephoneNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}
	
	/**
	 * Returns amount of days to the birthday.
	 *  
	 * @return returns amount of days to the birthday.
	 */
	public int getDaysUntilBirthday() {
		Calendar c = new GregorianCalendar();
		int subOfDates = getDayOfTheYearNumber(c.get(Calendar.YEAR), getMonth(), getDay())
				- getDayOfTheYearNumber(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DATE));
		if (subOfDates > 0) {
			return subOfDates;
		} else {
			if (isYearIntercalary(c.get(Calendar.YEAR))) {
				if (getMonth() <= 2) {
					return getYearDaysAmount(c.get(Calendar.YEAR)) + subOfDates;
				} else {
					return getYearDaysAmount(c.get(Calendar.YEAR) + 1) + subOfDates;
				}

			} else if (isYearIntercalary(c.get(Calendar.YEAR) + 1)) {
				if (c.get(Calendar.MONTH) + 1 > 2) {
					return getYearDaysAmount(c.get(Calendar.YEAR) + 1) + subOfDates;
				} else {
					return getYearDaysAmount(c.get(Calendar.YEAR)) + subOfDates;
				}
			} else {
				return getYearDaysAmount(c.get(Calendar.YEAR)) + subOfDates;
			}
		}

	}

	@MyAnnotation
	@Override
	public String toString() {
		return "RecordBook [birthdatDate=" + super.toString() + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", secondName=" + secondName + ", telephoneNumber=" + telephoneNumber + "]";
	}

}

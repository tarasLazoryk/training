package ua.training;

/**
 * Class Date represents date.
 * 
 * @author taras
 *
 */
public class Date {
			
	private int day;
	private int month;
	private int year;

	public Date() {
	}

	public Date(int day, int month, int year) {
		setYear(year);
		setMonth(month);
		setDay(day);
	}
	
	@MyAnnotation
	public int getDay() {
		return day;
	}

	@MyAnnotation
	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}
	
	/**
	 * Checks is the year intercalary or not.
	 * 
	 * @param year year to be checked. 
	 * @return true if the year is intercalary and 
	 * false if not.
	 */
	public boolean isYearIntercalary(int year) {
		return (year % 4) == 0;
	}
	
	/**
	 * Checks is the year bigger then 0.
	 * If yes - sets year inputed value;
	 * 
	 * @param year input value.
	 */
	public void setYear(int year) {
		if (year > 0) {
			this.year = year;
		}
	}
	
	/**
	 * Checks if the month inputed by user is bigger then 0, and less then 13.
	 * If yes - sets month inputed value. 
	 * 
	 * @param month input value.
	 */
	public void setMonth(int month) {
		if ((month > 0) && (month < 13)) {
			this.month = month;
		}
	}
	
	/**
	 * Checks if inputed by user value is bigger then 0, and less then amount days in the month.
	 * 
	 * @param day input value.
	 */
	public void setDay(int day) {
		if ((day > 0) && (day < getMonthDaysAmount(this.month, this.year))) {
			this.day = day;
		}
	}
	
	/**
	 * Checks if the year is intercalary. If it is returns amount of days in the month
	 * when the year is intercalary. If it is not - return amount of days in the month
	 * when the year is not intercalary.
	 * 
	 * @param month number of month.
	 * @param year year to be checked.
	 * @return amount of days in the inputed by user month.
	 */
	private int getMonthDaysAmount(int month, int year) {
		if (isYearIntercalary(year)) {
			return Month.getIntercalaryYearDaysAmountByMonthNumber(month);
		} else {
			return Month.getDaysAmountByMonthNumber(month);
		}

	}
	
	/**
	 * Returns number of the day in the year. The first day is 1.01,
	 * and the last one 31.12. Also checks if the year is intercalary.
	 * 
	 * @param year year to be checked.
	 * @param monthNumber number of month.
	 * @param dayNumber number of day in the month.
	 * @return number of day in the year.
	 */
	public int getDayOfTheYearNumber(int year, int monthNumber, int dayNumber) {
		int dayOfTheYearNumber = 0;
		for (Month month : Month.values()) {
			if (month.getMonthNumber() < monthNumber) {
				dayOfTheYearNumber += getMonthDaysAmount(month.getMonthNumber(), year);
			}
		}
		dayOfTheYearNumber += dayNumber;
		return dayOfTheYearNumber;
	}
	
	/**
	 * Checks if the year is intercalary and
	 * Returns amount of days in the year.
	 * 
	 * @param year year to be checked.
	 * @return amount of days in the year.
	 */
	public int getYearDaysAmount(int year) {
		int dayOfTheYearNumber = 0;
		for (Month month : Month.values()) {
			dayOfTheYearNumber += getMonthDaysAmount(month.getMonthNumber(), year);
		}
		return dayOfTheYearNumber;
	}

	@Override
	public String toString() {
		return " day=" + day + ", month=" + month + ", year=" + year;
	}
}

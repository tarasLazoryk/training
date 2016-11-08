package ua.training;

/**
 * Enumeration which contains Months,
 * number of month in the year, amount of days 
 * in intercalary year and not.
 * 
 * @author taras
 *
 */
public enum Month {
	JANUARY(1, 31, 31), 
	FEBRUARY(2, 28, 29), 
	MARCH(3, 31, 31), 
	APRIL(4, 30, 30), 
	MAY(5, 31, 31), 
	JUNE(6, 30, 30), 
	JULY(7, 31, 31), 
	AUGUST(8, 31, 31), 
	SEPTEMBER(9, 30, 30), 
	OCTOBER(10, 31, 31), 
	NOVEMBER(11, 30, 30), 
	DECEMBER(12, 31, 31);

	private final int monthNumber;
	private final int daysAmount;
	private final int intercalaryYearDaysAmount;

	Month(int monthNumber, int daysAmount, int intercalaryYearDaysAmount) {
		this.monthNumber = monthNumber;
		this.daysAmount = daysAmount;
		this.intercalaryYearDaysAmount = intercalaryYearDaysAmount;
	}

	int getMonthNumber() {
		return monthNumber;
	}

	int getDaysAmount() {
		return daysAmount;
	}

	int getIntercalaryYearDaysAmount() {
		return intercalaryYearDaysAmount;
	}
	
	/**
	 * Returns amount of days in the month 
	 * which has inputed by user month number.
	 * Amount of days will be for not intercalary year; 
	 * 
	 * @param monthNumber number to be inputed.
	 * @return returns amount of days, if there no month
	 * with inputed monthNumber returns 0;
	 */
	static int getDaysAmountByMonthNumber(int monthNumber) {
		for (Month month : Month.values()) {
			if (month.getMonthNumber() == monthNumber) {
				return month.getDaysAmount();
			}
		}
		return 0;
	}

	/**
	 * Returns amount of days in the month 
	 * which has inputed by user month number.
	 * Amount of days will be for intercalary year; 
	 * 
	 * @param monthNumber number to be inputed.
	 * @return returns amount of days, if there no month
	 * with inputed monthNumber returns 0;
	 */
	static int getIntercalaryYearDaysAmountByMonthNumber(int monthNumber) {
		for (Month month : Month.values()) {
			if (month.getMonthNumber() == monthNumber) {
				return month.getIntercalaryYearDaysAmount();
			}
		}
		return 0;
	}

}

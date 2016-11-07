package ua.training;
/**
 * GlobalConstants is an Interface which contains all Global constants.
 * 
 * @author taras
 *
 */
public interface GlobalConstants {
	String INPUT_FIRST_NAME = "Input your first name. You can use only letters, the first one must be upper case. "; 
	String INPUT_LAST_NAME = "Input your last name. You can use only letters, the first one must be upper case. "; 
	String INPUT_SECOND_NAME = "Input your second name.  You can use only letters, the first one must be upper case. "; 
	String INPUT_NICKNAME = "Input your Nickname. It must start with a letter, then you can use, letters, numbers and \"_\". It must be from 6 to 14 symbols. "; 
	String INPUT_COMMENT = "Write your comment."; 
	String INPUT_GROUP = "Write your group. Choose from these :"; 
	String INPUT_HOME_PHONE_NUMBER = "Input your home telephone number. It must look like \"555-55-55\" ";
	String INPUT_MOBILE_PHONE_NUMBER = "Input your mobile telephone number. It must look like \"(555)-555-5555\" ";
	String INPUT_SECOND_MOBILE_PHONE_NUMBER = "Input your second mobile telephone number. It must look like \"(555)-555-5555\" ";
	String INPUT_EMAIL = "Input your E-mail. You can use numbers, lower case letters, \"_\" and \"-\". Then must go \"@\" and domain name, which can contain with 2 and more parts, separated by dot. For example \"99myemail@kpi.tef.ua\"";
	String INPUT_SKYPE = "Input your Skype. It must start with a letter, then you can use numbers, letters,\"-\", \", \", \".\", \"_\". It must be from 6 to 30 symbols.";
	String INPUT_INDEX = "Input your index. It must contain from 5 numbers.";
	String INPUT_CITY = "Input name of your city. ";
	String INPUT_STREET = "Input name of your street. Street name must begin with upper case letter. And after street name you must write street, square or road";
	String INPUT_HOUSE_NUMBER = "Input number of your house. It can look like \"999\" or \"999/999\". Numbers can be from 0 to 999";
	String INPUT_APPARTAMENT_NUMBER = "Input number of you appartament. It can be from 0 to 999";
	String INPUT_DATE_OF_CHANGE = "Input date when the record book was changed at last. It must look like DD//MM//YYYY";
	String INPUT_DATE_OF_LAST_RECORD = "Input date when the last record in the record book was added. It must look like DD//MM//YYYY";
	String INPUT_YES_OR_NO = "Input \'yes\' if you want to write your second mobile phone number, and \'no\' if not. ";
	String REG_FOR_YES_OR_NO = "^(yes|no)$";
}


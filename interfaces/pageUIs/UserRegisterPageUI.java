package pageUIs;

public class UserRegisterPageUI {
		public static final String GENDERMALE_RADIO="//input[@id='gender-male']";
		public static final String FIRST_NAME="//input[@id='FirstName']";
		public static final String LAST_NAME="//input[@id='LastName']";
		public static final String DAY_DROPDOWN="//select[@name='DateOfBirthDay']";
		public static final String MONTH_DROPDOWN="//select[@name='DateOfBirthMonth']";
		public static final String YEAR_DROPDOWN="//select[@name='DateOfBirthYear']";
		public static final String EMAIL_TEXTBOX="//input[@id='Email']";
		public static final String COMPANY_TEXTBOX="//input[@id='Company']";	
		public static final String PASSWORD_TEXTBOX="//input[@id='Password']";
		public static final String CONFIRM_PASSWORD_TEXTBOX="//input[@id='ConfirmPassword']";
		public static final String REGISTER_BUTTON="//button[@id='register-button']";
		public static final String REGISTER_MESSAGE_SUCCESS="//div[@class='result']";
		public static final String LOGOUT_LINK="//a[@class='ico-logout']";
		
		public static final String FRISTNAME_ERROR="//span[@id='FirstName-error']";
		public static final String LASTNAME_ERROR="//span[@id='LastName-error']";
		public static final String EMAIL_ERROR="//span[@id='Email-error']";
		public static final String PASSWORD_ERROR="//span[@id='Password-error']";
		public static final String CONFIRM_PASSWORD_ERROR="//span[@id='ConfirmPassword-error']";
		public static final String EMAIL_EXIST_ERROR="//div[@class='message-error validation-summary-errors']//li";
		public static final String PASSWORD_UNDER6_ERROR1="//span[@id='Password-error']//p";
		public static final String PASSWORD_UNDER6_ERROR2="//span[@id='Password-error']//li";
		
}

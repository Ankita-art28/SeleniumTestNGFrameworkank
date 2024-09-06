package Resources;

public class storeData {

	public static String firstName="John";
	public static String lastName="Wick";
	
	
	public static String regExpectedText="Your Account Has Been Created!";
	
	public static String telephone="1234567890";
	public static String password="user43";
	public static String confirmPassword="user43";
	public static String incorrectPassword="kalndsjkfn";
	//Storing Expected result for all the classrs
	
	public static String reisterExpectedsucessURL="https://naveenautomationlabs.com/opencart/index.php?route=account/success";
	public static String firstNameErrorExpectedresult="First Name must be between 1 and 32 characters!";
	public static String lastNameErrorExpectedresult="Last Name must be between 1 and 32 characters!";
	public static String emailErrorExpectedresult="E-Mail Address does not appear to be valid!";
	public static String telephoneErrorExpectedresult="Telephone must be between 3 and 32 characters!";
	public static String passwordErrorExpectedresult="Password must be between 4 and 20 characters!";
	public static String privacyPolicyErrorExpectedresult="Warning:You must agree to the Privacy Policy!";
	
	//String expected data for login
			
			public static String LoginExpectedURL=	"https://naveenautomationlabs.com/opencart/index.php?route=account/account";	
	public static String LogoutExpectedConfirmationtext="Account Logout";
	public static String LoginFailedExpectedText="Warning: No match for E-Mail Address and/or Password.";	
			
}

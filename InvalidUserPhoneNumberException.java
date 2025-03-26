package gadgetStore;

//this exception is for the user phone number
public class InvalidUserPhoneNumberException extends Exception {
	public InvalidUserPhoneNumberException(String phoneNumber) {
		super("Your phone number cannot have any text or symbols. And it has to be 11 digits. " + phoneNumber +"\n");
	}
}

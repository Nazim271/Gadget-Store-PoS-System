package gadgetStore;

//this exception is for the invalid admin ID
public class InvalidAdminIdException extends Exception {
	public InvalidAdminIdException(int id) {
		super("No Admin of this id : " + id + " has been found. Provide the correct ID.");
	}
}


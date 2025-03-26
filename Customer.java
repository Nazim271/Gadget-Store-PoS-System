package gadgetStore;


public class Customer {
	private String customerName;
	private int customerId;
	private String customerPhoneNumber;
	
	public Customer(String customerName, int customerId, String customerPhoneNumber) {
		this.customerName = customerName;
		this.customerId = customerId;
		this.customerPhoneNumber = customerPhoneNumber;
	}
	
	//getting customerName
	public String getCustomerName() {
		return customerName;
	}
	
	//setting customerName
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	//getting customerId
	public int getCustomerId() {
		return customerId;
	}

	//setting customerId
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	//getting customerPhoneNumber
	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}
	
	//setting customerPhoneNumber
	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}
	
	@Override
	public String toString() {
		return "Customer Name = " + customerName +
				"\nCustomer ID = " + customerId + 
				"\nCustomer PhoneNumber = " + customerPhoneNumber;
	}
	
}


package gadgetStore;

public class Gadget {
	
	private String gadgetName;
	private String gadgetId;
	private double gadgetPrice;
	private boolean stock;
	
	//for the Admin
	public Gadget(String gadgetName, String gadgetId, double gadgetPrice, boolean stock) {
		this.gadgetName = gadgetName;
		this.gadgetId = gadgetId;
		this.gadgetPrice = gadgetPrice;
		this.stock = stock;
	}
	
	//for the user
	public Gadget(String gadgetName, String gadgetId, double gadgetPrice) {
		this.gadgetName = gadgetName;
		this.gadgetId = gadgetId;
		this.gadgetPrice = gadgetPrice;
	}
	
	//getting gadgetName
	public String getGadgetName() {
		return gadgetName;
	}

	//setting gadgetName
	public void setGadgetName(String gadgetName) {
		this.gadgetName = gadgetName;
	}
	
	//getting gadgetId
	public String getGadgetId() {
		return gadgetId;
	}
	
	//setting gadgetId
	public void setGadgetId(String gadgetId) {
		this.gadgetId = gadgetId;
	}
	
	//getting gadgetPrice
	public double getGadgetPrice() {
		return gadgetPrice;
	}
	
	//setting gadgetPrice
	public void setGadgetPrice(double gadgetPrice) {
		this.gadgetPrice = gadgetPrice;
	}
	
	//getting stock
	public boolean isStock() {
		return stock;
	}
	
	//setting stock
	public void setStock(boolean stock) {
		this.stock = stock;
	}
	
	//returns a String for the value of stock
	public String inStock() {
		if( stock == false) {
			return "NO";
		}
		
		return "YES";
	}
	
	public String toString() {
		return "Product Name : " + gadgetName
			  +"\nProduct ID : " + gadgetId
			  +"\nProduct Price : $ " + gadgetPrice
			  +"\nIn Stock : " + inStock() + "\n\n";
	}
}


package gadgetStore;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import javax.swing.JOptionPane;


//*************FOR THE USER******************* 
public class Cart extends Gadget implements RegisterNewCustomer,DiscountProvider{
	
	double percentage = 0;
	
	//for an Admin to showcase the gadgets
	public Cart(String productName, String productId, double productPrice, boolean stock) {
		super(productName, productId, productPrice, stock);
	}
	
	//for a user for gadgets
	public Cart(String productName, String productId, double productPrice) {
		super(productName, productId, productPrice);
	}
	
	Customer customer;
	ArrayList<Gadget> gadgets = new ArrayList<>();//this is to store the cart items for a user
	static ArrayList<Customer> customerList = new ArrayList<>();// to store the customer list...admin can also have the access of it
		
	//for the user to add any gadget in his cart
	public void addGadget(Gadget gadget) {
		
		//checks to see if the gadget can be added if the gadgetId is given correctly from the PoS class
		if(gadgets.add(gadget)) {
			JOptionPane.showMessageDialog(null, gadget.getGadgetName() + " added to cart.");
		}
		
		//else prints this...if the given gadgetId is wrong from the PoS class
		else JOptionPane.showMessageDialog(null, "No gadget of that id is found!");

    }
	
	//for the user to remove any gadget from their cart
	public void removeGadget(Gadget gadget) {
		
		//checks to see if the gadget is removable if the gadgetId is given correctly from the PoS class
		if (gadgets.remove(gadget)) {
			JOptionPane.showMessageDialog(null,"Your request has been placed!\n" + gadget.getGadgetName() + "removed from cart.");			
        }
		
		else {
			//else prints this for the wrong gadgetID
			JOptionPane.showMessageDialog(null, gadget.getGadgetName() + " not found in cart.");
        }
	}
	
	
	//for the user to clear every gadget from their cart
	public void clearCart() {
		gadgets.clear();
		JOptionPane.showMessageDialog(null, "The cart has been cleared.");
	}
	
	// to return all the gadgets from the carts
	public ArrayList<Gadget> getCartItems() {
		return gadgets;
	}
	
	// returns the whole price of their cart with or without discount
	public double getTotalPrice() {
		
		double totalPrice = 0;
        for (Gadget item : gadgets) {
            totalPrice += item.getGadgetPrice();
        }
        
        totalPrice *= (1 - percentage / 100);
        return totalPrice;
    }
	
	@Override
	 public String toString() {
        StringBuilder cartDetails = new StringBuilder();

        cartDetails.append("Items in Cart:\n");
        for (Gadget gadget : gadgets) {
            cartDetails.append("- ").append(gadget.getGadgetName()).append(": $").append(gadget.getGadgetPrice()).append("\n");
        }
        cartDetails.append("Total Price: $").append(getTotalPrice()).append("\n")
                   .append("Including ").append(percentage).append("% discount");
        return cartDetails.toString();
    }

	@Override
	// this methods helps a user to create a new account
	public void register() throws InvalidUserPhoneNumberException{
		String name = "",  number = "";
		
		try {
			name = JOptionPane.showInputDialog(null,"Enter your name : ");
		}	catch(InputMismatchException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		number = JOptionPane.showInputDialog(null, "Enter your phone number : ");		
		if(number.length() < 11 || number.length() > 11) {
			throw new InvalidUserPhoneNumberException(number);
		}
		
		Random rand = new Random();
		int id = rand.nextInt(1000);
		
		JOptionPane.showMessageDialog(null, "Your ID will be : " + id);
		
		customer = new Customer(name, id, number);
		customerList.add(customer);
    }
	
	@Override
	//returns the percentage
	public double applyDiscount(double percentage) {
		return this.percentage = percentage;

	}	
	
	//this method is for the user to check if they already have an existing account
	public void checkCustomer() {
		int id = 0;
		
		try {
			String idInput = JOptionPane.showInputDialog(null,"Enter the id to check : ");
			id = Integer.parseInt(idInput);
		}	catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		for( Customer x : customerList ) {
			if( id == x.getCustomerId()) {
				JOptionPane.showMessageDialog(null, x);
			}
		}
		
	}

}


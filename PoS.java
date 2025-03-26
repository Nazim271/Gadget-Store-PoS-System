package gadgetStore;

import javax.swing.JOptionPane;

public class PoS {

    public static void main(String[] args) {
        Cart cart = new Cart("", "", 0);
        Admin admin = new Admin("", "", 0, false);

        while (true) {
            String mainInput = JOptionPane.showInputDialog(null,
                    "Press\n" +
                    "    1. As an ADMIN\n" +
                    "    2. As a USER\n" +
                    "    3. To EXIT\n" +
                    "\nEnter your option:", "Main Menu", JOptionPane.PLAIN_MESSAGE);
            int mainOption = Integer.parseInt(mainInput);

            if (mainOption == 1) {
                while (true) {
                    String adminInput = JOptionPane.showInputDialog(null,
                            "Press\n" +
                            "    1. To add gadgets in stock\n" +
                            "    2. To remove gadgets in stock\n" +
                            "    3. To update availability of a product\n" +
                            "    4. To see the customer list\n" +
                            "    5. To see the whole stock\n" +
                            "    6. To Go Back to Main Menu\n" +
                            "\nEnter your option:", "Admin Menu", JOptionPane.PLAIN_MESSAGE);
                    int adminOption = Integer.parseInt(adminInput);

                    if (adminOption == 6) {
                        break; // Exit to main menu
                    }

                    try {
                        if (adminOption == 1) {
                            Admin.addItemToStock();
                        } else if (adminOption == 2) {
                            Admin.removeItemFromStock();
                        } else if (adminOption == 3) {
                            Admin.updateAvailability();
                        } else if (adminOption == 4) {
                            admin.checkAllExistingCustomer();
                        } else if (adminOption == 5) {
                            Admin.stockDetails();
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid option. Please choose among the options!");
                        }
                    } catch (InvalidAdminIdException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                }
            } else if (mainOption == 2) {
                while (true) {
                    String userInput = JOptionPane.showInputDialog(null,
                            "Press\n" +
                            "    1. To Register A New Account\n" +
                            "    2. To Check Existing Customer Account\n" +
                            "    3. To Add Product to Cart\n" +
                            "    4. To Remove Product from Cart\n" +
                            "    5. To Apply Discount\n" +
                            "    6. To View Cart Details\n" +
                            "    7. To See Store Details\n" +
                            "    8. To Go Back to Main Menu\n" +
                            "\nEnter your option:", "User Menu", JOptionPane.PLAIN_MESSAGE);
                    int userOption = Integer.parseInt(userInput);

                    if (userOption == 8) {
                        break; // Exit to main menu
                    }

                    if (userOption == 1) {
                        try {
                            cart.register();
                        } catch (InvalidUserPhoneNumberException e) {
                            JOptionPane.showMessageDialog(null, e.getMessage());
                        }
                    } else if (userOption == 2) {
                        cart.checkCustomer();
                    }
                    
                    else if (userOption == 3) {
                    	
                    	String idIn = JOptionPane.showInputDialog(null, "Enter your customer id to make a purchase");
                    	int id = Integer.parseInt(idIn);
                    	
                    	for( Customer customer : Cart.customerList) {
                    		if( id == customer.getCustomerId()) {
                    			JOptionPane.showMessageDialog(null, "You are registered as a customer. You may proceed.");
                                String quantityIn = JOptionPane.showInputDialog(null, "Enter the quantity : ");
                                int quantity = Integer.parseInt(quantityIn);

                                for (int i = 0; i < quantity; i++) {
                                    String gadgetIDIn = JOptionPane.showInputDialog(null, "Enter the product id : ");
                                    for (Gadget x : Admin.stock) {
                                        if (gadgetIDIn.equals(x.getGadgetId())) {
                                        	if(x.isStock() == true) {
                                        		Gadget gadget = new Gadget(x.getGadgetName(), gadgetIDIn, x.getGadgetPrice());
                                        		cart.addGadget(gadget);
                                        		break;
                                        	}
                                        	else {
                                        		JOptionPane.showMessageDialog(null, "Cannot add the gadget. " + x.getGadgetName() + " is not in stock");
                                        	}
                                        }
                                        	else{
                                        		JOptionPane.showMessageDialog(null, "No product of that id has been found!");
                                        		break;
                                        	}
                                   
                                    }
                                }
                		
                    		}
                    		
                    		else {
                    			JOptionPane.showMessageDialog(null, "No user of that id is found! Procvide the correct id or create a new account!");
                    			break;
                    		}
                        }
                    } else if (userOption == 4) {
                    	String idIn = JOptionPane.showInputDialog(null, "Enter your customer id to remove a gadget");
                    	int id = Integer.parseInt(idIn);
                    	
                    	for( Customer customer : Cart.customerList) {
                    		if( id == customer.getCustomerId()) {
                    			JOptionPane.showMessageDialog(null, "You are registered as a customer. You may proceed.");
                    			String idToRemoveIn = JOptionPane.showInputDialog(null, "\nEnter Product ID to remove: ");
                    			for (Gadget gadget : cart.getCartItems()) {
                    				if (gadget.getGadgetId().equals(idToRemoveIn)) {
                    					cart.removeGadget(gadget);
                    					break;
                    				}
                    			}
                    		}
                    		else {
                    			JOptionPane.showMessageDialog(null, "No user of that id is found! Procvide the correct id or create a new account!");
                    			break;
                    		}
                    	}
                    } else if (userOption == 5) {
                        String adminIdInput = JOptionPane.showInputDialog(null, "For Access provide your admin id :");
                        int adminId = Integer.parseInt(adminIdInput);

                        if (adminId != Admin.adminId) {
                            JOptionPane.showMessageDialog(null, "There is no ID: " + adminId + ". Please provide the correct ID.", "Failure", JOptionPane.ERROR_MESSAGE);
                        } else {
                            String discountIn = JOptionPane.showInputDialog(null, "\nEnter discount : ");
                            double discount = Double.parseDouble(discountIn);
                            cart.applyDiscount(discount);
                            JOptionPane.showMessageDialog(null, "Discount applied.");
                        }
                    } else if (userOption == 6) {
                        JOptionPane.showMessageDialog(null, cart.toString());
                    } else if (userOption == 7) {
                        Admin.stockDetails();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid option. Please choose among the options!");
                    }
                }
            } else if (mainOption == 3) {
                JOptionPane.showMessageDialog(null, "Exiting...");
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid option. Please choose among the options!");
            }
        }
    }
}

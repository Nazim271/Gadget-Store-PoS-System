package gadgetStore;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Admin extends Cart {

    public Admin(String productName, String productId, double productPrice, boolean stock) {
        super(productName, productId, productPrice, stock);
    }

    static String adminName = "ADMIN";
    static int adminId = 1111;
    static ArrayList<Gadget> stock = new ArrayList<>();//to store the added store gadgets

    // No need for these static Scanner instances anymore

    public static void addItemToStock() throws InvalidAdminIdException {
        int adminId = 0;
        try {
            String adminIdInput = JOptionPane.showInputDialog(null, "For Access provide your admin id:");
            adminId = Integer.parseInt(adminIdInput);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return;
        }

        if (adminId != Admin.adminId)
            throw new InvalidAdminIdException(adminId);

        String quantityInput = JOptionPane.showInputDialog(null, "Enter the quantity:");
        int quantity = Integer.parseInt(quantityInput);

        for (int i = 0; i < quantity; i++) {
            String gadgetName = JOptionPane.showInputDialog(null, "Enter the product name to add to stock:");            
            String gadgetIDInput = JOptionPane.showInputDialog(null, "Enter the product id:");
            
            String gadgetPriceInput = JOptionPane.showInputDialog(null, "Enter the product price:");
            double gadgetPrice = Double.parseDouble(gadgetPriceInput);
            
            String stockAvailabilityInput = JOptionPane.showInputDialog(null, "Stock availability? (true/false):");
            boolean stockAvailability = Boolean.parseBoolean(stockAvailabilityInput);
            
            Gadget gadget = new Gadget(gadgetName, gadgetIDInput, gadgetPrice, stockAvailability);
            stock.add(gadget);
        }
    }

    public static void removeItemFromStock() throws InvalidAdminIdException {
        int adminId = 0;
        try {
            String adminIdInput = JOptionPane.showInputDialog(null, "For Access provide your admin id:");
            adminId = Integer.parseInt(adminIdInput);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return;
        }

        if (adminId != Admin.adminId)
            throw new InvalidAdminIdException(adminId);

        String productIdInput = JOptionPane.showInputDialog(null, "Enter the product id to remove:");

        for (Gadget x : stock) {
            if (productIdInput.equals(x.getGadgetId())) {
                stock.remove(x);
                JOptionPane.showMessageDialog(null, x.getGadgetName() + " removed from Stock");
                break;
            }
        }
    }

    public static void updateAvailability() throws InvalidAdminIdException {
        int adminId = 0;
        try {
            String adminIdInput = JOptionPane.showInputDialog(null, "For Access provide your admin id:");
            adminId = Integer.parseInt(adminIdInput);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return;
        }

        if (adminId != Admin.adminId)
            throw new InvalidAdminIdException(adminId);

        String productIdInput = JOptionPane.showInputDialog(null, "Enter product id to update availability:");
        //int productId = Integer.parseInt(productIdInput);

        for (Gadget x : stock) {
            if (productIdInput.equals(x.getGadgetId())) {
                String changeStatInput = JOptionPane.showInputDialog(null, "Change stock availability for " + x.getGadgetName() + " (true/false):");
                boolean changeStat = Boolean.parseBoolean(changeStatInput);
                x.setStock(changeStat);
                JOptionPane.showMessageDialog(null, "Stock availability for " + x.getGadgetName() + " has been changed.");
                break;
            }
        }
    }

    public static void stockDetails() {
        for (Gadget x : stock) {
        	 JOptionPane.showMessageDialog(null, x.toString());
        }
       
    }

    public void checkAllExistingCustomer() throws InvalidAdminIdException {
        int adminId = 0;
        try {
            String adminIdInput = JOptionPane.showInputDialog(null, "For Access provide your admin id :");
            adminId = Integer.parseInt(adminIdInput);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return;
        }

        if (adminId != Admin.adminId)
            throw new InvalidAdminIdException(adminId);

        for (Customer customer : Cart.customerList) {    
        	JOptionPane.showMessageDialog(null, customer.toString());
        }
    }
}

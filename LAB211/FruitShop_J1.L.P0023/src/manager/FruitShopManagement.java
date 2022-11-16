/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manager;

import java.util.ArrayList;
import java.util.Hashtable;
import model.Fruit;
import validate.CheckInput;

/**
 *
 * @author leeng
 */
public class FruitShopManagement {

    ArrayList<Fruit> fruits = new ArrayList<>();
    Hashtable<String, ArrayList<Fruit>> orders = new Hashtable<>();

    /**
     * This function displays menu
     *
     * @param menu to display
     */
    public void displayMenu(String menu) {
        System.out.println(menu);
    }

    /**
     * This function to input new fruit information, add to the fruit list and
     * display All Fruits created
     *
     * @param fruitCreateSuccessful
     * @param fruitIdExist
     */
    public void createNewFruit(String fruitCreateSuccessful, String fruitIdExist) {
//        fruits.add(new Fruit(1, "Apple", 2, 10, "VN"));
//        fruits.add(new Fruit(2, "Banana", 3, 10, "VN"));
//        fruits.add(new Fruit(3, "Orange", 5, 10, "VN"));
        while (true) {
            int fruitId = CheckInput.getInt("Enter Fruit ID:",
                    "Fruit Id is Empty", "Invalid Fruit Id input", 1, Integer.MAX_VALUE);
            if (getFruitById(fruitId) == null) {
                String fruitName = CheckInput.getString("Enter Fruit Name: ", "Fruit Name is empty", "^[a-zA-Z]+$", "Invalid Fruit Name input");
                double price = CheckInput.getDouble("Enter Fruit Price: ", "Price is out of range", "Invalid Price", 0, Double.MAX_VALUE);
                int quantity = CheckInput.getInt("Enter Fruit Quantity:", "Quantity is Empty", "Invalid Quantity input", 1, Integer.MAX_VALUE);
                String origin = CheckInput.getString("Enter Fruit Origin: ", "Origin is empty", "^[a-zA-Z ]+$", "Invalid Origin input");
                fruits.add(new Fruit(fruitId, fruitName, price, quantity, origin));
                System.out.println(fruitCreateSuccessful);
                if (!checkInputYesNo()) {
                    return;
                }
            } else {
                System.out.println(fruitIdExist);
            }
        }
    }

    /**
     * This function to display list order 
     */
    public void viewOrder() {
        if (orders.isEmpty()) {
            System.out.println("No Orders");
            return;
        }
        for (String name : orders.keySet()) {
            System.out.println("Customer: " + name);
            ArrayList<Fruit> listOrder = orders.get(name);
            displayListOrder(listOrder);
        }
    }
    
    /**
     * This function to let user choose item fruit from the fruit list and input 
     * customer name
     */
    public void shopForBuyer() {
        ArrayList<Fruit> listOrder = new ArrayList<>();
        while (true) {
            int item = displayFruitList();
            if (item == -1) {
                System.out.println("Out Of Stock");
                return;
            }
            Fruit fruit = getFruit(item);
            System.out.println("You selected:" + fruit.getFruitName());
            int quantity = CheckInput.getInt("Please input quantity: ", "Out of quantity", "Valid quantity", 0, fruit.getQuantity());
            fruit.setQuantity(fruit.getQuantity() - quantity);

            Fruit fruitInOrder = checkFruitInOrder(listOrder, fruit.getFruitId());
            if (fruitInOrder != null) {
                fruitInOrder.setQuantity(fruitInOrder.getQuantity() + quantity);
            } else {
                if (quantity != 0) {
                    listOrder.add(new Fruit(fruit.getFruitId(),
                            fruit.getFruitName(), fruit.getPrice(),
                            quantity, fruit.getOrigin()));
                }
            }
            if (!checkInputYesNo()) {
                break;
            }
        }
        if (listOrder.isEmpty()) {
            System.out.println("No Orders");
        } else {
            displayListOrder(listOrder);
            String name = CheckInput.getString("Enter Name: ", "Name is empty", "^[a-zA-Z ]+$", "Invalid Name input");
            orders.put(name, listOrder);
        }
    }
    
    /**
     * This function get fruit from list which quantity is available
     * @param item  item is fruit from the available list
     * @return      null value if there are no item in stock
     */
    public Fruit getFruit(int item) {
        int count = 0;
        for (Fruit fruit : fruits) {
            if (fruit.getQuantity() != 0) {
                count++;
            }
            if (item == count) {
                return fruit;
            }
        }
        return null;
    }

    /**
     * This function to check user want to continue to input
     *
     * @return true value when input is match with "Y" or "YES"
     */
    public boolean checkInputYesNo() {
        String input = CheckInput.getString("Do you want to continue (Y/N)?",
                "Input is empty", "^(YES|Y)|(NO|N)+$", "Invalid Input");
        return input.equalsIgnoreCase("YES") || input.equalsIgnoreCase("Y");
    }
    
    /**
     * This function print format list fruit which is available and let user 
     * choose from the list
     * @return 
     */
    public int displayFruitList() {
        int countItem = 0;
        if (fruits.isEmpty()) {
            return -1;
        }
        for (Fruit fruit : fruits) {
            if (fruit.getQuantity() != 0) {
                countItem++;
                if (countItem == 1) {
                    System.out.printf("%-10s%-19s%-14s%-16s\n", "| ++ Item ++ ",
                            "| ++ Fruit Name ++ ", "| ++ Origin ++ ", "| ++ Price ++ |");
                }
                System.out.printf("%6d%12s%20s%23.0f$\n", countItem,
                        fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
            }
        }
        if (countItem == 0) {
            return -1;
        }
        int item = CheckInput.getInt("Enter Item: ", "Item out of range", "Invalid Input", 1, countItem);
        return item;
    }
    
    /**
     * This function return a fruit if available in stock
     * @param listOrder order list
     * @param id        id of fruit
     * @return          null if there r no fruit available
     */
    public Fruit checkFruitInOrder(ArrayList<Fruit> listOrder, int id) {
        for (Fruit fruit : listOrder) {
            if (fruit.getFruitId() == (id)) {
                return fruit;
            }
        }
        return null;
    }
    
    /**
     * this function get fruit with fruit id
     * @param fruitId   id of fruit
     * @return          null if can not get fruit with id
     */
    public Fruit getFruitById(int fruitId) {
        for (Fruit fruit : fruits) {
            if (fruitId == fruit.getFruitId()) {
                return fruit;
            }
        }
        return null;
    }
    
    /**
     * This function display format fruit list with sum of total product 
     * @param listOrder
     */
    public void displayListOrder(ArrayList<Fruit> listOrder) {
        double total = 0;
        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");
        for (Fruit fruit : listOrder) {
            System.out.printf("%15s%15d%15.0f$%15.0f$\n", fruit.getFruitName(),
                    fruit.getQuantity(), fruit.getPrice(),
                    fruit.getPrice() * fruit.getQuantity());
            total += fruit.getPrice() * fruit.getQuantity();
        }
        System.out.println("Total: " + total);
    }

}

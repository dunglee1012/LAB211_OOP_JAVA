/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;
import java.util.Hashtable;
import manager.FruitShopManagement;
import model.Fruit;
import model.Order;
import validate.CheckInput;

/**
 *
 * @author leeng
 */
public class Main {

    public static void main(String[] args) {
        FruitShopManagement manager = new FruitShopManagement();

        while (true) {
            manager.displayMenu("FRUIT SHOP MANAGEMENT\n"
                    + "         1. Create Fruit\n"
                    + "         2. View Orders\n"
                    + "         3. Shopping (for buyer)\n"
                    + "         4. Exit");
            int choice = CheckInput.getInt(" (Please choose 1 to create product,"
                    + " 2 to view order, 3 for shopping, 4 to Exit program).",
                    "Choice in range from 1 to 4", "Wrong choice input", 1, 4);
            switch(choice){
                case 1:
                    manager.createNewFruit("Fruit Created Successful","Fruit Id exist");
                    break;
                case 2:
                    manager.viewOrder();
                    break;
                case 3:
                    manager.shopForBuyer();
                    break;
                case 4:
                    System.exit(0);
            }
        }

    }
}

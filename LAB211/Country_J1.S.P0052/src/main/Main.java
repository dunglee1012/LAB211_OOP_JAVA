/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.ArrayList;
import management.ManageEastAsiaCountries;
import model.Country;
import validate.CheckInput;

/**
 *
 * @author leeng
 */
public class Main {

    public static void main(String[] args) {
        ManageEastAsiaCountries manager = new ManageEastAsiaCountries();
        ArrayList<Country> listCountry = new ArrayList<>();
        while (true) {
            manager.displayMenu("                       Menu                        \n"
                    + "=====================================================================\n"
                    + "1. Input the information of 11 countries in East Asia\n"
                    + "2. Display information of countries you’ve just input\n"
                    + "3. Search information of countries by user-entered name\n"
                    + "4. Displays the names of countries sorted name in ascending order\n"
                    + "5. Exit\n"
                    + "=====================================================================");
            int choice = CheckInput.getInt(
                    "Enter your choice",
                    "Choice input range from 1 - 5",
                    "Enter positive integer", 1, 5);
            switch (choice) {
                case 1:
                    manager.addCountryInformation(listCountry);
                    break;
                case 2:
                    manager.getRecentlyEnteredInformation(listCountry);
                    break;
                case 3:
                    manager.searchInformationByName(listCountry);
                    break;
                case 4:
                    manager.sortInformationByAscendingOrder(listCountry);
                    break;
                case 5:
                    System.exit(0);
            }
        }

    }
}

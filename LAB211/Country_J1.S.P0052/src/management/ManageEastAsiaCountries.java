/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package management;

import java.util.ArrayList;
import model.Country;
import validate.CheckInput;


/**
 *
 * @author leeng
 */
public class ManageEastAsiaCountries {

    public void displayMenu(String menu) {
        System.out.println(menu);
    }

    public void addCountryInformation(ArrayList<Country> listCountry) {
        String countryCode = CheckInput.getString("Enter code of country: ",
                "Input can not empty", "^[A-Z]+$", "Please enter valid code");
        if (!countryCodeExist(listCountry,countryCode)) {
            String countryName = CheckInput.getString("Enter name of country: ",
                    "Input can not empty", "^[A-Za-z ]+$", "Please enter valid name");
            double totalArea = CheckInput.getDouble("Enter total Area: ",
                    "Area out of range", "Please enter valid total Area", 0, Double.MAX_VALUE);
            String countryTerrain = CheckInput.getString("Enter terrain of country: ",
                    "Input can not empty", "^[A-Za-z ]+$", "Please enter valid terrain");
            listCountry.add(new Country(countryTerrain, countryCode, countryName, totalArea));
            System.out.println("Country Information Added");
        } else {
            System.out.println("Country Code Exist");
        }

    }

    public void getRecentlyEnteredInformation(ArrayList<Country> listCountry) {
        if (listCountry == null) {
            System.out.println("No Country Info");
        }
        System.out.printf("%-10s%-25s%-20s%-25s\n",
                "ID", "Name", "Total Area", "Terrain");
        for (Country country : listCountry) {
            country.display();
        }

    }

    public void searchInformationByName(ArrayList<Country> listCountry) {
        String searchCountryName = CheckInput.getString("Enter name of country: ",
                "Input can not empty", "^[A-Za-z ]+$", "Please enter valid name");
        for (Country country : listCountry) {
            if (country.getCountryName().equalsIgnoreCase(searchCountryName)) {
                country.display();
            }
        }
    }

    public void sortInformationByAscendingOrder(ArrayList<Country> listCountry) {
        System.out.printf("%-10s%-25s%-20s%-25s\n",
                "ID", "Name", "Total Area", "Terrain");
        
    }

    public boolean countryCodeExist(ArrayList<Country> listCountry,String countryCode) {
        for (Country country : listCountry) {
            if (country.getCountryCode().equalsIgnoreCase(countryCode)) {
                return true;
            }
        }
        return false;
    }
}

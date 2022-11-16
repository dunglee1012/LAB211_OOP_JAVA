package Main;


import Validate.CheckInput;
import EmployeeManagement.EmployeeManagement;
import Model.Employee;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class Main {

    public static void main(String[] args) {
        EmployeeManagement employees = new EmployeeManagement();
        List<Employee> listEmployees = new ArrayList<>();
        while (true) {
            employees.displayMenu("Main menu\n"
                    + "1.   Add Employees\n"
                    + "2.   Update Employees\n"
                    + "3.   Remove Employees\n"
                    + "4.   Search Employees\n"
                    + "5.   Sort Employees by Salary\n"
                    + "6.   Exit");
            int option = CheckInput.getInt("Enter your options: ","Option is empty", "Option invalid", 1, 6);
            switch (option) {
                case 1:
                    employees.AddEmployee(listEmployees);
                    break;
                case 2:
                    employees.UpdateEmployeeById(listEmployees);
                    break;
                case 3:
                    employees.RemoveEmployeeById(listEmployees);
                    break;
                case 4:
                    employees.SearchEmployeesByName(listEmployees);
                    break;
                case 5:
                    employees.SortEmployeeBySalary(listEmployees);
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }

}

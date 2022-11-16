package EmployeeManagement;

import Validate.CheckInput;
import Model.Employee;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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
public class EmployeeManagement {
    
    /**
     * This function to input employee information and add to employee list
     * 
     * @param listEmployees employee list
     */
    public void AddEmployee(List<Employee> listEmployees) {
//        listEmployees.add(new Employee(1, "A", "B", "0123456789", "dung@gmail.com", "HN", 10/12/2001, "Male", 10000, "HN"));
        int id = CheckInput.getInt("Enter Id: ", "Id is empty", "Id invalid", 1, Integer.MAX_VALUE);
        //add new employee information if id is not existed
        if (checkIdExist(id, listEmployees) == null) {
            String firstName = CheckInput.getString("Enter first name: ", "First Name is Empty", "^[a-zA-Z ]+$", "First Name Invalid");
            String lastName = CheckInput.getString("Enter last name: ", "Last Name is Empty", "^[a-zA-Z ]+$", "Last Name Invalid");
            String phone = CheckInput.getString("Enter phone: ", "Phone is empty", "0\\d{9}+$", "Phone Invalid");
            String email = CheckInput.getString("Enter email: ", "Email is empty", "^[a-zA-Z]\\w*@(\\w+[.])+\\w+$", "Email Invalid");
            String address = CheckInput.getString("Enter address: ", "Address is empty", "[a-zA-Z -]+$", "Address Invalid");
            Date dob = CheckInput.getDate("Enter Dob: ", "Date is empty", "\\d{1,2}[/]\\d{1,2}[/]\\d{4}", "Dob invalid");
            String sex = CheckInput.getString("Enter sex: ", "Sex is empty", "^Male|Female", "Sex Invalid");
            double salary = CheckInput.getDouble("Enter Salary: ", "Salary is out of range", "Salary Invalid", 0, Double.MAX_VALUE);
            String agency = CheckInput.getString("Enter Agency: ", "Agency is empty", "[a-zA-Z]+$", "Agency Invalid");

            listEmployees.add(new Employee(id, firstName, lastName, phone, email, address, dob, sex, salary, agency));
            System.out.println("Add New Employee Successful ");
        } else {
            System.out.println("Employee Id Exist");
        }

    }
    
    /**
     * This function choose to update employee information base on id and update to employee list
     * 
     * @param listEmployees employee list
     */
    public void UpdateEmployeeById(List<Employee> listEmployees) {
        int id = CheckInput.getInt("Enter Id: ", "Id is empty", "Id invalid", 1, Integer.MAX_VALUE);
        if (checkIdExist(id, listEmployees) != null) {
            System.out.println("Employee id exist, continue to update");
            int newId = CheckInput.getInt("Enter Id: ", "Id is empty", "Id invalid", 1, Integer.MAX_VALUE);
            Employee employee = checkIdExist(newId, listEmployees);
            if (employee != null) {
                System.out.println("Employee Id Exist, try again");
            } else {
                while (true) {
                    int option = CheckInput.getInt("----- Option to update ------\n"
                            + "1. Update First Name\n"
                            + "2. Update Last Name\n"
                            + "3. Update Phone\n"
                            + "4. Update Email\n"
                            + "5. Update Address\n"
                            + "6. Update DoB\n"
                            + "7. Update Sex\n"
                            + "8. Update Salary\n"
                            + "9. Update Agency\n", "Option out of range", "Choice invalid", 1, 9);
                    switch (option) {
                        //Update First Name
                        case 1:
                            String firstName = CheckInput.getString("Enter first name: ", "First Name is Empty", "^[a-zA-Z ]+$", "First Name Invalid");
                            employee.setFirstName(firstName);
                            break;
                        //Update Last Name
                        case 2:
                            String lastName = CheckInput.getString("Enter last name: ", "Last Name is Empty", "^[a-zA-Z ]+$", "Last Name Invalid");
                            employee.setLastName(lastName);
                            break;
                        //Update Phone
                        case 3:
                            String phone = CheckInput.getString("Enter phone: ", "Phone is empty", "0\\d{9}+$", "Phone Invalid");
                            employee.setPhone(phone);
                            break;
                        //Update Email
                        case 4:
                            String email = CheckInput.getString("Enter email: ", "Email is empty", "^[a-zA-Z]\\w*@(\\w+[.])+\\w+$", "Email Invalid");
                            employee.setEmail(email);
                            break;
                        //Update Address
                        case 5:
                            String address = CheckInput.getString("Enter address: ", "Address is empty", "[a-zA-Z -]+$", "Address Invalid");
                            employee.setAddress(address);
                            break;
                        //Update Dob
                        case 6:
                            Date dob = CheckInput.getDate("Enter Dob: ", "Date is empty", "\\d{1,2}[/]\\d{1,2}[/]\\d{4}", "Dob invalid");
                            employee.setDob(dob);
                            break;
                        //Update Sex
                        case 7:
                            String sex = CheckInput.getString("Enter sex: ", "Sex is empty", "^Male|Female", "Sex Invalid");
                            employee.setSex(sex);
                            break;
                        //Update Salary
                        case 8:
                            double salary = CheckInput.getDouble("Enter Salary: ", "Salary is out of range", "Salary Invalid", 0, Double.MAX_VALUE);
                            employee.setSalary(salary);
                            break;
                        //Update Agency
                        case 9:
                            String agency = CheckInput.getString("Enter Agency: ", "Agency is empty", "[a-zA-Z]+$", "Agency Invalid");
                            employee.setAgency(agency);
                            break;
                    }
                    System.out.println("Employee Information Updated");
                    String answer = CheckInput.getString("Do you want to continue update? [Y/N]", "Answer is empty", "[YN]", "Invalid answer , try again");
                    if (answer.equals("N")) {
                        break;
                    }
                }
            }
        } else {
            System.out.println("Employee Id not Exist");
        }
    }
    
    /**
     * This function to remove employee information
     * 
     * @param listEmployees employee list
     */
    public void RemoveEmployeeById(List<Employee> listEmployees) {
        int id = CheckInput.getInt("Enter Id: ", "Id is empty", "Id invalid", 1, Integer.MAX_VALUE);
        Employee employee = checkIdExist(id, listEmployees);
        if (employee == null) {
            System.out.println("No Information found");
        } else {
            listEmployees.remove(employee);
            System.out.println("Delete Employee Information");
        }
    }
    
    /**
     * This function to search employee information by inputed name
     * 
     * @param listEmployees employee list
     */
    public void SearchEmployeesByName(List<Employee> listEmployees) {
        String name = CheckInput.getString("Enter first name: ", "First Name is Empty", "^[a-zA-Z ]+$", "First Name Invalid");
        System.out.println("--------- Search Result ---------");

        boolean isExist = false;
        //loop access the employee list
        for (Employee employee : listEmployees) {
            String fullName = employee.getFirstName() + " " + employee.getLastName();
            //if Full name matched with inputed name to search, display 
            if (fullName.contains(name)) {
                //if isExist value is false , display header then change to true
                if (!isExist) {
                    System.out.format("%-20s%-20s%-20s%-20s%-30s%-20s%-20s%-20s%-20s%-20s\n",
                            "ID", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
                }
                isExist = true;
                System.out.println(employee);
            }
        }
        if (!isExist) {
            System.out.println("Employee information not Found");
        }
    }
    
    /**
     * This function display sorted employee information by salary 
     * 
     * @param listEmployees employee list
     */
    public void SortEmployeeBySalary(List<Employee> listEmployees) {
        System.out.println("------Sort Employee by Salary-------");
        //If list is empty display notify
        if (listEmployees.isEmpty()) {
            System.out.println("List is empty");
            //List is not empty display Employee inforamtion sorted by salary
        } else {
            //Sort in order employee salary by compare 
            Collections.sort(listEmployees, new Comparator<Employee>() {
                @Override
                public int compare(Employee employee1, Employee employee2) {
                    return Double.compare(employee1.getSalary(), employee2.getSalary());
                }
            });
            System.out.format("%-20s%-20s%-20s%-20s%-30s%-20s%-20s%-20s%-20s%-20s\n",
                    "ID", "First Name", "Last Name", "Phone", "Email", "Address", "DOB", "Sex", "Salary", "Agency");
            display(listEmployees);
        }
    }
    
    /**
     * This function display employee information
     * 
     * @param listEmployees employee list
     */
    public void display(List<Employee> listEmployees) {
        //loop access to the list to display employee information
        for (Employee employee : listEmployees) {
            System.out.println(employee);
        }
    }
    
    /**
     * This function return null value if can not find employee information by id
     *
     * @param id            id to compare in employee list
     * @param listEmployees employee list
     * @return              null value
     */
    public Employee checkIdExist(int id, List<Employee> listEmployees) {
        for (Employee employee : listEmployees) {
            if (id == employee.getId()) {
                return employee;
            }
        }
        return null;
    }

    /**
     * This function display menu
     *
     * @param menu  menu to display
     */
    public void displayMenu(String menu) {
        System.out.println(menu);

    }
}

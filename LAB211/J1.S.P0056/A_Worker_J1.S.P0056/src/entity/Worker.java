/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import constant.IConstant;
import java.util.List;
import util.Validation;

/**
 *
 * @author FPT SHOP
 */
public class Worker {

    private String id;
    private String name;
    private int age;
    private int salary;
    private String workLocation;

    public Worker() {
    }

    public Worker(String id, String name, int age, int salary, String workLocation) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocation = workLocation;
    }

    public String getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getWorkLocation() {
        return workLocation;
    }

    private boolean exist(List<Worker> list, String id) {
        for (Worker w : list) {
            if (w.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;    
    }
    
    private String getId(List<Worker> list) {
        do {
            String ID = Validation.getString(
                    "Enter ID:",
                    "Invalid ID",
                    IConstant.REGEX_ID);
            if (exist(list, ID)) {
                System.out.println("ID is exist, try again,");
            } else {
                return ID;
            }
        } while (true);
    }

    public void create(List<Worker> list) {
        this.id = getId(list);
        this.name = Validation.getString(
                "Enter name:",
                "Name not valid",
                IConstant.REGEX_NAME);
        this.age = Validation.getInt(
                "Enter age: ",
                "Not valid input, enter again:",
                "Age must from 18 to 50",
                18,50);
        this.salary = Validation.getInt(
                "Enter salary: ",
                "Salary must be number",
                "Salary must greater than 0",
                1, Integer.MAX_VALUE);
        this.workLocation = Validation.getString(
                "Enter work location:",
                "Location not valid",
                IConstant.REGEX_WORK_LOCATION);
    }
    
    public void print() {
        System.out.println(id + " " + name + " " + salary);
    }

}

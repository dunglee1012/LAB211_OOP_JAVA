/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utility;

import constant.IConstant;
import java.util.List;
import validate.Validate;

/**
 *
 * @author leeng
 */
public class Worker {

    private String code;
    private String name;
    private int age;
    private int salary;
    private String workLocation;

    public Worker() {
    }

    public Worker(String code, String name, int age, int salary, String workLocation) {
        this.code = code;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.workLocation = workLocation;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public void setWorkLocation(String workLocation) {
        this.workLocation = workLocation;
    }
    

    /**
     * Input new Worker information
     *
     * @param code input code
     */
    public void inputData(String code) {
        this.code = code;
        this.name = Validate.getString(
                "Enter Name: ", "Name Invalid",
                IConstant.REGEX_NAME);
        this.age = Validate.getInt(
                "Enter Age: ", "Age out of range", "Invalid Age",
                IConstant.REGEX_MIN_AGE, IConstant.REGEX_MAX_AGE);
        this.salary = Validate.getInt(
                "Enter Salary: ", "Salary out of range", "Invalid Salary",
                IConstant.REGEX_MIN_SALARY, IConstant.REGEX_MAX_SALARY);
        this.workLocation = Validate.getString(
                "Enter Work Location: ", "Work Location Invalid",
                IConstant.REGEX_WORK_LOCATION);
        
    }

    public void display() {
        System.out.println(code + " " + name + " " + salary);
    }

}

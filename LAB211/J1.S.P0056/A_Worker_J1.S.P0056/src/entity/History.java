/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


/**
 *
 * @author FPT SHOP
 */
public class History {
    private String id;
    private String name;
    private int age;
    private int salary;
    private String status;
    private String date;

    public History() {
    }

    public History(String id, String name, int age, int salary, String status, String date) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.status = status;
        this.date = date;
    }
    
    public void display() {
        System.out.printf("%-5s%-15s%-5d%-10d%-10s%-20s\n", id, name, age, salary,status, date);
    }
}

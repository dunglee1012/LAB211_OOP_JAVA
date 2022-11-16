/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Asus
 */
public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();
        while (true) {
            displayMenu();
            int choose = Validation.getInt("Please choice one option:", "Choice invalid", 1, 3);
            switch (choose) {
                case 1:
                    manager.normalCalculator();
                    break;
                case 2:
                    manager.bmiCalculator();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }

        }
    }

    public static void displayMenu() {
        System.out.println("====== Calculator Program ======\n"
                + "1. Normal Calculator\n"
                + "2. BMI Calculator\n"
                + "3. Exit");
    }
}

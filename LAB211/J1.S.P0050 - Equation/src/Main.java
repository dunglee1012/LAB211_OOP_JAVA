/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Asus
 */
public class Main {
    public static void main(String[] args) {
        Calculator cal = new Calculator();
        while(true){
            displayMenu();
            int option = Validation.getInt("Please choice one option: ", "Choice invalid", 1, 3);
            switch(option){
                case 1:
                    cal.calSupelativeEquation();
                    break;
                case 2:
                    cal.calQuadraticEquation();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("========= Equation Program =========\n"
                + "1. Calculate Superlative Equation\n"
                + "2. Calculate Quadratic Equation\n"
                + "3. Exit");
    }
    
}

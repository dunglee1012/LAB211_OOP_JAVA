/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Asus
 */
public class Calculator {

    public boolean checkOdd(double n) {
        return n % 2 != 0;
        //return n % 2 == 1;
    }

    public boolean checkEven(double n) {
        return n % 2 == 0;
    }

    public boolean checkSquareNumber(double n) {
        return Math.sqrt(n) * Math.sqrt(n) == n;
    }

    public void calSupelativeEquation() {
        double a = Validation.getDouble("Enter A: ", "Please input number", -Double.MAX_VALUE, Double.MAX_VALUE);
        double b = Validation.getDouble("Enter B ", "Please input number", -Double.MAX_VALUE, Double.MAX_VALUE);

        double x = -b / a;
        System.out.printf("Solution x = %.3f\n", +x);
        //SO LE
        System.out.print("Number is Odd:");
        if (checkOdd(a)) {
            System.out.print(a + " ");
        }
        if (checkOdd(b)) {
            System.out.print(b + " ");
        }
        if (checkOdd(x)) {
            System.out.print(x + " "); 
        }

        //SO CHAN
        System.out.print("Number is Even: ");
        if (checkEven(a)) {
            System.out.print(a + " ");
        }
        if (checkEven(b)) {
            System.out.print(b + " ");
        }
        if (checkEven(x)) {
            System.out.print(x + " ");
        }
        //SO CHINH PHUONG
        System.out.println("Number is Perfect Square:");
        if (checkSquareNumber(a)) {
            System.out.println(a + " ");
        }
        if (checkSquareNumber(b)) {
            System.out.println(b + " ");
        }
        if (checkSquareNumber(x)) {
            System.out.println(x + " ");
        }
    }

    public void calQuadraticEquation() {
        double a = Validation.getDouble("Enter A: ", "Please input number", -Double.MAX_VALUE, Double.MAX_VALUE);
        double b = Validation.getDouble("Enter B ", "Please input number", -Double.MAX_VALUE, Double.MAX_VALUE);
        double c = Validation.getDouble("Enter C: ", "Please input number", -Double.MAX_VALUE, Double.MAX_VALUE);

        double delta = b * b - 4 * a * c;
        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
        double x2 = (-b - Math.sqrt(delta)) / (2 * a);

        System.out.println("Soulution: x1 = " + x1 + " and x2 = " + x2);
        //SO LE
        System.out.println("Odd Number(s):");
        if (checkOdd(a)) {
            System.out.println(a);
        }
        if (checkOdd(b)) {
            System.out.println(b);
        }
        if (checkOdd(c)) {
            System.out.println(c);
        }
        if (checkOdd(x1)) {
            System.out.println(x1);
        }
        if (checkOdd(x2)) {
            System.out.println(x2);
        }
        //SO CHAN
        System.out.println("Number is Even:");
        if (checkEven(a)) {
            System.out.println(a);
        }
        if (checkEven(b)) {
            System.out.println(b);
        }
        if (checkEven(c)) {
            System.out.println(c);
        }
        if (checkEven(x1)) {
            System.out.println(x1);
        }
        if (checkEven(x2)) {
            System.out.println(x2);
        }
        //SO CHINH PHUONG
        System.out.println("Number is Perfect Square:");
        if (checkSquareNumber(a)) {
            System.out.println(a);
        }
        if (checkSquareNumber(b)) {
            System.out.println(b);
        }
        if (checkSquareNumber(c)) {
            System.out.println(c);
        }
        if (checkSquareNumber(x1)) {
            System.out.println(x1);
        }
        if (checkSquareNumber(x2)) {
            System.out.println(x2);
        }
    }

}

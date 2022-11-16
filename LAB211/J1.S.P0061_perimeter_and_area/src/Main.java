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
        System.out.println("=====Calculator Shape Program=====");
        Rectangle rectangle = inputRectangle();
        Circle circle = inputCircle();
        Triangle trigle = inputTriangle();

        display(trigle, rectangle, circle);
    }

    private static Rectangle inputRectangle() {
        double width = Validation.getDouble("Please input side width of Rectangle:", "Input invalid, try again", Double.MIN_VALUE, Double.MAX_VALUE);
        double length = Validation.getDouble("Please input length of Rectangle:", "Input invalid, try again", Double.MIN_VALUE, Double.MAX_VALUE);
        return new Rectangle(width, length);

    }

    private static Circle inputCircle() {
        double radius = Validation.getDouble("Please input radius of Circle:", "Input invalid, try again", Double.MIN_VALUE, Double.MAX_VALUE);
        return new Circle(radius);
    }

    private static Triangle inputTriangle() {
        double sideA = Validation.getDouble("Please input sideA of Triangle:", "Input invalid, try again", Double.MIN_VALUE, Double.MAX_VALUE);
        double sideB = Validation.getDouble("Please input sideB of Triangle:", "Input invalid, try again", Double.MIN_VALUE , Double.MAX_VALUE);
        double sideC = Validation.getDouble("Please input sideC of Triangle:", "Input invalid, try again", Double.MIN_VALUE , Double.MAX_VALUE);
        return new Triangle(sideA, sideB, sideC);
    }

    private static void display(Triangle triangle, Rectangle rectangle, Circle circle) {
        rectangle.printResult();
        circle.printResult();
        triangle.printResult();
    }

}

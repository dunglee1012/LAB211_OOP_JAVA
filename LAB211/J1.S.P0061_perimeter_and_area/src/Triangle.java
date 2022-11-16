/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Asus
 */
public class Triangle extends Shape{
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle() {
    }

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double getArea() {
        double p = (sideA + sideB + sideC) / 200;
        return Math.sqrt(p * (p-sideA) * (p-sideB) * (p-sideC));
    }

    @Override
    public double getPerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public void printResult() {
        System.out.println("-----Triangle-----");
        System.out.println("Side A: " + this.sideA);
        System.out.println("Side B: " + this.sideB);
        System.out.println("Side C: " + this.sideC);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }
    
    
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Asus
 */
public class Manager {

    public double inputNumber() {
        System.out.println("Enter number: ");
        double number = Validation.checkInputDouble();
        return number;
    }

    public void normalCalculator() {
        System.out.println("---- Normal Calculator -----");
        System.out.println("Enter number: ");
        double memory = Validation.checkInputDouble();
        while (true) {
            String operator = Validation.getOperator
        ("Enter Operator: ", "Please input (+, -, *, /, ^)");
            //a+b
            if (operator.equalsIgnoreCase("+")) {
                memory += inputNumber();
                System.out.println("Memory:" + memory);
                //a-b
            } else if (operator.equalsIgnoreCase("-")) {
                memory -= inputNumber();
                System.out.println("Memory:" + memory);
                //a*b
            } else if (operator.equalsIgnoreCase("*")) {
                memory *= inputNumber();
                System.out.println("Memory:" + memory);
                //a/b
            } else if (operator.equalsIgnoreCase("/")) {
                memory /= inputNumber();
                System.out.println("Memory:" + memory);
                //a^b
            } else if (operator.equalsIgnoreCase("^")) {
                memory = Math.pow(memory, inputNumber());
                System.out.println("Memory:" + memory);
                //result
            } else if (operator.equalsIgnoreCase("=")) {
                System.out.println("Result: " + memory);
                return;
            }
        }
    }

    public String bmiStatus(double bmi) {
        if(bmi < 19){
            return "UNDER-STANDARD";
        }else if(bmi >= 19 && bmi < 25){
            return "STANDARD";
        }else if(bmi >= 25 && bmi < 30){
            return "OVERWEIGHT";
        }else if(bmi >= 30 && bmi < 40){
            return "FAT - should lose weight";
        }else{
            return "VERY FAT - should lose weight immediately";
        }
    }

    public void bmiCalculator() {
        System.out.println("----- BMI Calculator -----");
        System.out.println("Enter Weight(kg): ");
        double weight = Validation.checkBMInumber();
        System.out.println("Enter Height(cm): ");
        double height = Validation.checkBMInumber();
        double bmi = weight *10000 / (height * height);
        System.out.printf("BMI number:  %.2f\n\n", bmi);
        System.out.println("BMI Status: " +bmiStatus(bmi));
    }

}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Asus
 */
public class Validation {

    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int getInt(String msg, String err, int min, int max) {
        while (true) {
            try {
                //display the message
                System.out.println(msg);
                int num;
                num = Integer.parseInt(br.readLine());
                //if the number satisfied in the range from min to max
                if (min <= num && num <= max) {
                    return num;
                //else alert to input number in range from min to max
                } else {
                    System.out.println("Number in range from [" + min + " - " + max + "]");
                }
            } catch (IOException | NumberFormatException ex) {
                System.out.println(err);
            }
        }
    }
    
    public static double checkInputDouble(){
        while (true) {
            try {
                double num;
                num = Double.parseDouble(br.readLine());
                return num;
            }catch (IOException e) {
                System.out.println("Number invalid, Enter again");
            }
        }
    }
    
    public static double checkBMInumber() {
        while (true) {
            try {
                double num;
                num = Double.parseDouble(br.readLine());
                return num;
            } catch (IOException | NumberFormatException ex) {
                System.out.println("BMI is digit");
            }
        }
    }
    
    public static String getOperator(String msg, String err) {
        while (true) {
            try {
                System.out.println(msg);
                String str = br.readLine();
                if (str.equalsIgnoreCase("+") || str.equalsIgnoreCase("-")
                    || str.equalsIgnoreCase("*") || str.equalsIgnoreCase("/")
                    || str.equalsIgnoreCase("^") || str.equalsIgnoreCase("=")) {
                    return str;
                }
            } catch (IOException ex) {
                System.out.println(err);
            }
           
        }
    }

}

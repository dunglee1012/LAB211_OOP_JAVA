
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
    
    public static double getDouble(String msg, String err, double min, double max) {
        while (true) {
            try {
                //display the message
                System.out.println(msg);
                double num;
                num = Double.parseDouble(br.readLine());
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
}

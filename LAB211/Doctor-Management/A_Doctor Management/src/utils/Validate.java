/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;
import java.util.Scanner;

/**
 * Function to check valid input
 *
 * @author leeng
 */
public class Validate {

    private static final Scanner SCANNER = new Scanner(System.in);

    private Validate() {

    }

    /**
     * Returns the valid integer number scanned from input
     *
     * @param messageInfo               the message to be printed instructing 
     *                                  the user to input
     * @param messageErrorInvalidChoice display when user enter wrong number
     *                                  format
     * @param messageErrorOutOfChoice   display when number input out of range
     * @param min                       minium value of input number
     * @param max                       maxium value of input number
     * @return valid integer number
     */
    public static int getInt(
            String messageInfo,
            String messageErrorInvalidChoice,
            String messageErrorOutOfChoice,
            int min, int max) {
        int inputNumber;
        while (true) {
            try {
                System.out.println(messageInfo);
                inputNumber = Integer.parseInt(SCANNER.nextLine());
                if (min <= inputNumber && inputNumber <= max) {
                    return inputNumber;
                }
                System.err.println(messageErrorOutOfChoice);
            } catch (NumberFormatException ex) {
                System.err.println(messageErrorInvalidChoice);
            }
        }
    }

    /**
     * Return a valid Double number scanned from input
     *
     * @param requireMessage           is String user enter an double number
     * @param errorMessageOutOfRange   is String notice user when an double number
     *                                 out of given range
     * @param errorMessagenumberFormat is String user enter wrong number format
     * @param min                      is minium value of input number
     * @param max                      is maxium value of input number
     * @return the valid double
     */
    public static double getDouble(String requireMessage,
            String errorMessageOutOfRange,
            String errorMessagenumberFormat,
            double min,
            double max) {
        Scanner scanner = new Scanner(System.in);
        double num;
        while (true) {
            try {
                System.out.println(requireMessage);
                num = Double.parseDouble(scanner.nextLine());
                if (min <= num && num <= max) {
                    return num;
                }
                System.err.println(errorMessageOutOfRange);
            } catch (NumberFormatException ex) {
                System.err.println(errorMessagenumberFormat);
            }
        }
    }

    /**
     * Returns the valid string scanned from the input.
     *
     * @param messageInfo  the message to be printed 
     *                     instructing the user to input
     * @param messageError the message will be printed if the input does not
     *                     match the regular expression
     * @param REGEX        the pattern to test String is valid or not
     * @return the valid string value
     */
    public static String getString(
            String messageInfo,
            String messageError,
            final String REGEX) {
        do {
            System.out.println(messageInfo);
            String str = SCANNER.nextLine();
            if (str.matches(REGEX)) {
                return str;
            }
            System.err.println(messageError);
        } while (true);
    }

}

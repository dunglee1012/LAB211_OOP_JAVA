/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Scanner;

/**
 *
 * @author FPT SHOP
 */
public class Validation {

    /**
     * This function used to check an integer must be greater than given min
     * value and less than or equal given max value
     *
     * @param requireMessage           is String user enter an integer number
     * @param erroroMessageOutOfRange  is String notice user enter an integer
     *                                 number out of given range
     * @param errorMessageNumberFormat is String user enter wrong number format
     * @param min                      is minimum number element of array
     * @param max                      is maximum value of integer
     * @return the integer value which greater than given min value and less
     * than or equal given max value.
     */
    public static int getInt(
            String requireMessage,
            String erroroMessageOutOfRange,
            String errorMessageNumberFormat,
            int min, int max
    ) {
        Scanner scanner = new Scanner(System.in);
        int num;
        do {
            try {
                System.out.println(requireMessage);
                num = Integer.parseInt(scanner.nextLine());
                if (num >= min && num <= max) {
                    return num;
                }
                System.out.println(erroroMessageOutOfRange);
            } catch (NumberFormatException e) {
                System.out.println(errorMessageNumberFormat);
            }
        } while (true);
    }


    /**
     * Return input string from keyboard
     * @param messageInfo   message info
     * @param messageError  message error
     * @param REGEX         the pattern to test String is valid or not
     * @return the String value
     */
    public static String getString(String messageInfo, String messageError,
            final String REGEX) {
        do {
            System.out.println(messageInfo);
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            if (str.matches(REGEX)) {
                return str;
            }
            System.out.println(messageError);
        } while (true);
    }

}

package Validate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author leeng
 */
public class CheckInput {

    /**
     * This function user to check and return an valid integer
     *
     * @param requireMessage            is String user enter an integer number
     * @param errorMessageOutOfRange    is String notice user when an integer
     *                                  number out of given range
     * @param errorMessagenumberFormat  is String user enter wrong number format
     * @param min                       is minium value of input number
     * @param max                       is maxium value of input number
     * @return                          the valid integer
     */
    public static int getInt(String requireMessage,
            String errorMessageOutOfRange,
            String errorMessagenumberFormat,
            int min,
            int max) {
        Scanner scanner = new Scanner(System.in);
        int num;
        while (true) {
            try {
                System.out.println(requireMessage);
                num = Integer.parseInt(scanner.nextLine());
                if (min <= num && num <= max) {
                    return num;
                } else {
                    System.err.println(errorMessageOutOfRange);
                }
            } catch (NumberFormatException ex) {
                System.err.println(errorMessagenumberFormat);
            }
        }
    }

    /**
     * This function user to check and return an valid String
     *
     * @param requireMessage    is String user enter String
     * @param emptyString       is notice when input is empty
     * @param regex             to check input String match regex or not
     * @param invalidString     notice when input String is not valid
     * @return                  the valid String
     */
    public static String getString(String requireMessage,
            String emptyString,
            String regex,
            String invalidString) {
        Scanner scanner = new Scanner(System.in);
        String inputString;
        while (true) {
            try {
                System.out.println(requireMessage);
                inputString = scanner.nextLine();
                if (inputString.isEmpty()) {
                    System.err.println(emptyString);
                } else if (inputString.matches(regex)) {
                    return inputString;
                }
                System.err.println(invalidString);
            } catch (NumberFormatException ex) {
                System.err.println(invalidString);
            }
        }
    }

    /**
     * This function user to check and return an valid double
     *
     * @param requireMessage            is String user enter an double number
     * @param errorMessageOutOfRange    is String notice user when an double number
     *                                  out of given range
     * @param errorMessagenumberFormat  is String user enter wrong number format
     * @param min                       is minium value of input number
     * @param max                       is maxium value of input number
     * @return                          the valid double
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
     * This function user to check and return an valid date
     * 
     * @param requireMessage    is String user enter an date
     * @param emptyDate         is empty input
     * @param regex             to check with input date if valid
     * @param invalidDate       is invalid input date
     * @return                  the valid date
     */
    public static Date getDate(String requireMessage, String emptyDate, String regex, String invalidDate) {
        String inputDate;
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println(requireMessage);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            inputDate = scanner.nextLine();
            if (inputDate.isEmpty()) {
                System.err.println(emptyDate);
            } else if (inputDate.matches(regex)) {
                try {
                    Date date = dateFormat.parse(inputDate);
                    return date;
                } catch (ParseException ex) {
                    System.err.println(invalidDate);
                }

            }

        }
    }
}

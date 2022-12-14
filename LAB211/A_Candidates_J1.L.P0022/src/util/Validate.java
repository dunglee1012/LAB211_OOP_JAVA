/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import constant.IConstant;
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
     * Returns the valid string phone number scanned from the input.
     *
     * @param messageInfo the message to be printed instructing the user to
     * input
     * @param messageErrorInvalid the message will be printed if the String does
     * not contain a parsable integer
     * @param messageErrorMaxLength the message will be printed if the String
     * does not satisfy the maximum length
     * @param REGEX the pattern to test String is valid or not
     * @return the valid string phone number scanned from the input
     * @throws NumberFormatException if the String does not contain a parsable
     * int
     */
    public static String getPhoneNumber(
            String messageInfo,
            String messageErrorInvalid,
            String messageErrorMaxLength,
            final String REGEX
    ) {

        while (true) {
            System.out.println(messageInfo);
            String str = SCANNER.nextLine();

            if (str.matches(REGEX)) {
                if (str.length() == IConstant.PHONE_NUMBER_LENGTH) {
                    return str;
                } else {
                    System.out.println(messageErrorMaxLength);
                }
            } else {
                System.out.println(messageErrorInvalid);
            }

        }
    }

    /**
     * Returns the valid integer number scanned from input
     *
     * @param messageInfo the message to be printed instructing the user to
     * input
     * @param messageErrorInvalidChoice display when user enter wrong number
     * format
     * @param messageErrorOutOfChoice display when number input out of range
     * @param min minium value of input number
     * @param max maxium value of input number
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
     * Returns the valid string scanned from the input.
     *
     * @param messageInfo the message to be printed instructing the user to
     * input
     * @param messageError the message will be printed if the input does not
     * match the regular expression
     * @param REGEX the pattern to test String is valid or not
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

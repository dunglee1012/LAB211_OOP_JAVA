/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import constant.IConstant;

/**
 *
 * @author leeng
 */
public class Helper {
    /**
     * Display Menu
     * @param menu to display
     */
    public static void displayMenu(String menu) {
        System.out.println(menu);
    }
    
     /**
     * Returns Boolean value if user want to continue.
     *
     * @param message the message to be printed instructing the user to input
     * @return Boolean value
     */
    public static boolean isContinue(String message) {
        String isContinue = Validate.getString(message, "Only Yy or Nn", IConstant.YES_NO);
        return isContinue.equalsIgnoreCase("y");
    }
}

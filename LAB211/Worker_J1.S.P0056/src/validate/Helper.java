/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validate;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author leeng
 */
public class Helper {

    /**
     * Show worker management menu
     *
     * @param menu menu to display
     */
    public static void workerMenu(String menu) {
        System.out.println(menu);
    }

    public static String getCurrentDate(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return dateFormat.format(date);
    }

}

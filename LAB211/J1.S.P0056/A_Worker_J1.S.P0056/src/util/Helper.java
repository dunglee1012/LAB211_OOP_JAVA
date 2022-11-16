/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import constant.IConstant;

/**
 *
 * @author FPT SHOP
 */
public class Helper {
    private Helper() {
        
    }

    /**
     * Show worker management menu
     */
    public static void workerMenu() {
        System.out.println("1. Add a worker.");
        System.out.println("2. Increase salary for Worker.");
        System.out.println("3. Decrease salary for Worker.");
        System.out.println("4. Display information salary.");
        System.out.println("5. Exit");
    }
    
    public static String getCurrentDate(String x) {
        DateFormat dateFormat = new SimpleDateFormat(x);
        Calendar calendar = Calendar.getInstance(); 
        return dateFormat.format(calendar.getTime());
    }
}

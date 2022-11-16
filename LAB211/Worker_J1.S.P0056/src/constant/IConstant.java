/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constant;

/**
 *
 * @author leeng
 */
public interface IConstant {

    String REGEX_CODE = "^W\\s\\d";
    String REGEX_NAME = "^[a-zA-Z ]+$";
    
    String SALARY_UP = "UP";
    String SALARY_DOWN = "DOWN";
    
    int REGEX_MIN_SALARY = 0;
    int REGEX_MAX_SALARY = Integer.MAX_VALUE;
    
    int REGEX_MIN_AGE = 1;
    int REGEX_MAX_AGE = Integer.MAX_VALUE;
    
    String REGEX_WORK_LOCATION = "^[a-zA-Z0-9 ]+$";
}

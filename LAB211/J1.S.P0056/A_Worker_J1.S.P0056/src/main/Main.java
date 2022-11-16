/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import bo.WorkerBO;
import constant.IConstant;
import static constant.IConstant.REGEX_ID;
import entity.History;
import entity.Worker;
import java.util.ArrayList;
import java.util.List;
import util.Helper;
import util.Validation;

/**
 *
 * @author FPT SHOP
 */
public class Main {

    public static void main(String[] args) {
        List<Worker> listWorker = new ArrayList<>();
        List<History> listHistory = new ArrayList<>();
        WorkerBO workerBO = new WorkerBO(listWorker, listHistory);
        int choice;
        do {
            Helper.workerMenu();
            choice = Validation.getInt(
                    "Enter your choice:",
                    "Not valid input",
                    "Choice must from 1 to 5",
                    1, 5);
            switch (choice) {
                case 1: {
                    workerBO.addWorker();
                    System.out.println("-------------------");
                    break;
                }
                case 2: {
                    String code = Validation.getString(
                            "Enter code: ",
                            "Not valid code",
                            REGEX_ID
                    );
                    int amount = Validation.getInt(
                            "Enter amount to increase:",
                            "Amount must be number",
                            "Amount must greater than 0",
                            1, Integer.MAX_VALUE);
                    
                    workerBO.changeSalary(IConstant.UP, amount, code, "yyyy/MM/dd");
                    System.out.println("-------------------");
                    break;
                }
                case 3: {
                    int amount = Validation.getInt(
                            "Enter amount to decrease:",
                            "Amount must be number",
                            "Amount must greater than 0",
                            1, Integer.MAX_VALUE);
                    String code = Validation.getString(
                            "Enter code: ",
                            "Not valid code",
                            REGEX_ID
                    );
                    workerBO.changeSalary(IConstant.DOWN, amount, code, "yyyy/MM/dd");
                    System.out.println("-------------------");
                    break;
                }
                case 4: {
                    workerBO.printHistory();
                    System.out.println("-------------------");
                    break;
                }
                case 5: {
                    System.exit(0);
                    break;
                }
            }
        } while (choice != 5);
    }
}

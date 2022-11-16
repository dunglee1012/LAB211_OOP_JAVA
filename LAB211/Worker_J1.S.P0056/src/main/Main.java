/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import bo.WorkerBO;
import constant.IConstant;
import java.util.ArrayList;
import java.util.List;
import utility.History;
import utility.Worker;
import validate.Helper;
import validate.Validate;

/**
 *
 * @author leeng
 */
public class Main {

    public static void main(String[] args) {
        List<Worker> listWorker = new ArrayList<>();
        List<History> listHistory = new ArrayList<>();
        WorkerBO workerBO = new WorkerBO(listWorker, listHistory);
        while (true) {
            Helper.workerMenu("======== Worker Management =========\n"
                    + "1. Add Worker\n"
                    + "2. Up salary\n"
                    + "3. Down salary\n"
                    + "4. Display Information salary\n"
                    + "5. Exit");
            int choice = Validate.getInt(
                    "Enter your choice:",
                    "Choice out of range",
                    "Invalid choice",
                    1, 5);

            switch (choice) {
                case 1: {
                    String code = Validate.getString(
                            "Enter Code: ", "Invalid Code",
                            IConstant.REGEX_CODE);
                    workerBO.addWorker("Code Add Success","Code EXIST",code);
                    break;
                }

                case 2: {
                    String code = Validate.getString(
                            "Enter Code: ", "Invalid Code",
                            IConstant.REGEX_CODE);
                    int amount = Validate.getInt(
                            "Enter Salary: ",
                            "Salary out of range",
                            "Salary is invalid",
                            IConstant.REGEX_MIN_SALARY,
                            IConstant.REGEX_MAX_SALARY);
                    workerBO.changeSalary(listWorker, listHistory,
                            code, amount, IConstant.SALARY_UP, "yyyy/MM/dd");
                    break;
                }
                case 3: {
                    String code = Validate.getString(
                            "Enter Code: ", "Invalid Code",
                            IConstant.REGEX_CODE);
                    int amount = Validate.getInt(
                            "Enter Salary: ",
                            "Salary out of range",
                            "Salary is invalid",
                            IConstant.REGEX_MIN_SALARY,
                            IConstant.REGEX_MAX_SALARY);
                    workerBO.changeSalary(listWorker, listHistory,
                            code, amount, IConstant.SALARY_DOWN, "yyyy/MM/dd");
                    break;
                }

                case 4:
                    workerBO.printHistory();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}

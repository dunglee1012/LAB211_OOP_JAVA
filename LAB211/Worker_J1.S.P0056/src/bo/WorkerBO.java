/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import constant.IConstant;
import java.util.List;
import utility.History;
import utility.Worker;
import validate.Helper;

/**
 *
 * @author leeng
 */
public class WorkerBO {

    private List<Worker> listWorker;
    private List<History> listHistory;

    public WorkerBO(List<Worker> listWorker, List<History> listHistory) {
        this.listWorker = listWorker;
        this.listHistory = listHistory;
    }

    /**
     * Add a new Worker
     *
     * @param code input code
     * @param messCodeAddSuccess message Add Success
     * @param messCodeExist message notify Code Exist
     */
    public void addWorker(String messCodeAddSuccess, String messCodeExist, String code) {
        Worker worker = new Worker();
        if (getIndexOfWorker(code) == -1) {
            worker.inputData(code);
            listWorker.add(worker);
            System.out.println(messCodeAddSuccess);
        } else {
            System.out.println(messCodeExist);
        }

    }

    /**
     * Increase salary of a worker
     *
     * @param listWorker Worker List
     * @param listHistory History List
     * @param status status to UP or DOWN salary
     * @param amount amount to change salary
     * @param code code of worker want to find
     * @param format Date format
     */
    public void changeSalary(List<Worker> listWorker, List<History> listHistory,
            String code, int amount, String status, String format) {
        if (getIndexOfWorker(code) != -1) {
            Worker worker = new Worker();
            int currentSalary = worker.getSalary();
            if (status.equalsIgnoreCase(IConstant.SALARY_UP)) {
                worker.setSalary(amount + currentSalary);
            }
            if (status.equalsIgnoreCase(IConstant.SALARY_DOWN)) {
                worker.setSalary(amount - currentSalary);
            }
            History history = new History(
                    worker.getCode(),
                    worker.getName(),
                    worker.getAge(),
                    worker.getSalary(),
                    status,
                    Helper.getCurrentDate(format));
            listHistory.add(history);
        } else {
            System.out.println("Code Not Exist");
        }
    }

    /**
     * Display all worker have been adjusted salary by worker code
     *
     */
    public void printHistory() {
        System.out.println(
                "--------------------Display Information Salary-----------------------");
        for (History history : listHistory) {
            history.display();
        }

    }

    /**
     * Get index of worker by code.
     *
     * @return null
     */
    private int getIndexOfWorker(String code) {
        for (int i = 0; i < listWorker.size(); i++) {
            if (listWorker.get(i).getCode().equals(code)) {
                return i;
            }
        }
        return -1;
    }

}

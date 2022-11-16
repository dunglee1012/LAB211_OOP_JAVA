/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import constant.IConstant;
import entity.History;
import entity.Worker;
import java.util.List;
import util.Helper;

/**
 *
 * @author FPT SHOP
 */
public class WorkerBO implements IConstant {

    private List<Worker> listWorker;
    private List<History> listHistory;

    public WorkerBO(List<Worker> listWorker, List<History> listHistory) {
        this.listWorker = listWorker;
        this.listHistory = listHistory;
    }

    /**
     * Add new Worker
     */
    public void addWorker() {
        Worker worker = new Worker();
        worker.create(listWorker);
        listWorker.add(worker);

    }

    /**
     * Increase salary of a worker
     *
     * @param status     status to UP or DOWN salary
     * @param amount     amount to change salary
     * @param code       code of worker want to find
     * @param dateFormat format of the date
     */
    public void changeSalary(String status, int amount, String code, String dateFormat) {
        if (listWorker.isEmpty()) {
            System.out.println("list empty");
        } else {
            printListWorker();
            Worker worker = searchWorkerByCode(code);
            if (worker == null) {
                System.out.println("Not exist worker.");
            } else {
                int salaryCurrent = worker.getSalary();
                if (status.equals(IConstant.UP)) {
                    worker.setSalary(salaryCurrent + amount);
                }
                if (status.equals(IConstant.DOWN)) {
                    worker.setSalary(salaryCurrent - amount);
                }
                History history = new History(
                        worker.getId(), worker.getName(), worker.getAge(),
                        worker.getSalary(), status, Helper.getCurrentDate(dateFormat));
                listHistory.add(history);
            }
        }
    }

    /**
     * To print all worker have been adjusted salary by worker code.
     */
    public void printHistory() {
        if (listWorker.isEmpty()) {
            System.out.println("List empty");
        } else {
            System.out.println("-------------------Display information salary-------------------");

            for (int i = 0; i < listWorker.size(); i++) {
                listWorker.get(i).print();
            }
            System.out.println("-------------------Display History salary-------------------");
            System.out.printf("%-5s%-15s%-5d%-10d%-10s%-20s\n", "id", "Name",
                    "Age", "Salary", "Status", "Date");
            for (int i = 0; i < listHistory.size(); i++) {
                listHistory.get(i).display();
            }
        }
    }

    /**
     * To print list worker
     */
    public void printListWorker() {
        for (Worker w : listWorker) {
            w.print();
        }
    }

    /**
     * To search a worker by code
     *
     * @param code code of worker want to find
     * @return the worker with code
     */
    public Worker searchWorkerByCode(String code) {
        for (Worker worker : listWorker) {
            if (code.equalsIgnoreCase(worker.getId())) {
                return worker;
            }
        }
        return null;
    }
}

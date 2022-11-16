
import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Asus
 */
public class TaskManagement {

    public int addTask(ArrayList<Task> listTasks, int id) {
        System.out.println("-----------Add Task-----------");
        String requirementName = GetInput.getString("Enter requirement name: ", "Name invalid", "^[a-zA-Z ]+$");
        int taskTypeId = GetInput.getInt("Task Type: ", "Task type invalid", 1, 4);
        Date date = GetInput.getDate("Date: ", "Date invalid", "dd-MM-yyyy");
        double from = GetInput.getDouble("From: ", "From [8.0 - 17.5]", 8.0, 17.5);
        double to = GetInput.getDouble("To: ", "To [ " + from + " - 17.5 ]", from, 17.5);
        String assign = GetInput.getString("Assignee: ", "Assignee invalid", "^[a-zA-Z ]+$");
        String review = GetInput.getString("Review: ", "Review invalid", "^[a-zA-Z ]+$");

        boolean isExist = checkTaskDuplicate(date, assign, to, from, listTasks);
        //check value of variable exist
        if (isExist) {
            System.out.println("Task Duplicate");
        } else {
            Task newTask = new Task(id, taskTypeId, requirementName, date, from, to, assign, review);
            listTasks.add(newTask);
            id++;
            System.out.println("Add Task Successful");
        }
        return id;

    }

    public void deleteTask(ArrayList<Task> listTasks) {
        if (listTasks.isEmpty()) {
            System.out.println("List task is empty");
            return;
        } else {
            System.out.println("---------Del Task---------");
            int indexInList = -1;
            int Taskid = GetInput.getInt("ID: ", "Task id is out of range!", 1, Integer.MAX_VALUE);
            //access each element of arraylist
            for (Task task : listTasks) {
                //compare inputed taskId with taskId in the list
                if (task.getTaskid() == Taskid) {
                    indexInList = listTasks.indexOf(task);
                }
            }
            //check indexInList Exist, delete index
            if (indexInList != -1) {
                listTasks.remove(indexInList);
                System.out.println("Delete successful");
            } else {
                System.out.println("Id is not exist");
            }
        }
    }

    public void displayTask(ArrayList<Task> taskList) {
        if (taskList.isEmpty()) {
            System.out.println("List task is empty");
        } else {
            System.out.println
        ("----------------------------Task-------------------------------------");
            System.out.format
        ("%-7s%-20s%-12s%-15s%-7s%-15s%-15s\n", "Id", "Name",
                "Task Type", "Date", "Time", "Assignee", "Reviewer");
            for(Task task : taskList){
                System.out.println(task);
            }
        }

    }

    public boolean checkTaskDuplicate(Date date, String assign, double planTo, double planFrom, ArrayList<Task> listTasks) {
        boolean isExist = false;
        //loop access to each element in list
        for (Task task : listTasks) {
            //compare date in list with date inputed
            //compare assignee in list with assignee inputed
            if (date.equals(task.getDate()) && assign.equals(task.getAssign())) {
                //if input Task To smaller than Task From exist in the list
                //if input Task From bigger than Task To exist in the list return false value
                if ((planTo < task.getPlanFrom()) || planFrom > task.getPlanTo()) {
                    isExist = false;
                    //else return true
                } else {
                    isExist = true;
                    break;
                }
            }
        }
        return isExist;
    }

}

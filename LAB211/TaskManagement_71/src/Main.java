
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
public class Main {

    public static void main(String[] args) {
        TaskManagement task = new TaskManagement();
        ArrayList<Task> taskList = new ArrayList<>();
        int id =1;
        //displayMenu
        while (true) {
            displayMenu();
            //Enter Option
            int option = GetInput.getInt("Enter Your Option: ", "Option [1 - 4]", 1, 4);
            switch (option) {
                //Option 1: Add New Task
                case 1:
                    id = task.addTask(taskList, id);
                    break;
                //Option 2: Delete Task by ID
                case 2:
                    task.deleteTask(taskList);
                    break;
                //Option 3: Display Task
                case 3:
                    task.displayTask(taskList);
                    break;
                //Option 4: Exit the program
                case 4:
                    System.exit(0);
                    break;
            }
        }

    }

    private static void displayMenu() {
        System.out.println("========= Task program =========\n"
                + "*    Add Task\n"
                + "*    Delete task\n"
                + "*    Display Task\n"
                + "*    exit");
    }
}

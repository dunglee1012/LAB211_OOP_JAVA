
import java.io.Serializable;
import java.text.SimpleDateFormat;
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
public class Task implements Serializable {

    private int Taskid;
    private int taskTypeId;
    private String requirementName;
    private Date date;
    private double planFrom;
    private double planTo;
    private String assign;
    private String review;

    public Task() {
    }

    public Task(int Taskid, int taskTypeId, String requirementName, Date date, double planFrom, double planTo, String assign, String review) {
        this.Taskid = Taskid;
        this.taskTypeId = taskTypeId;
        this.requirementName = requirementName;
        this.date = date;
        this.planFrom = planFrom;
        this.planTo = planTo;
        this.assign = assign;
        this.review = review;
    }

    public int getTaskid() {
        return Taskid;
    }

    public void setTaskid(int Taskid) {
        this.Taskid = Taskid;
    }

    public int getTaskTypeId() {
        return taskTypeId;
    }

    public void setTaskTypeId(int taskTypeId) {
        this.taskTypeId = taskTypeId;
    }

    public String getRequirementName() {
        return requirementName;
    }

    public void setRequirementName(String requirementName) {
        this.requirementName = requirementName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    @Override
    public String toString() {
        double time = planTo - planFrom;
        String planTime = String.format("%.1f", time);
        String result = String.format("%-7d%-20s%-12s%-15s%-7s%-15s%-15s", 
                Taskid, requirementName, taskTypeId,
                new SimpleDateFormat("dd-MM-yyyy").format(date), planTime, assign, review);
        return result;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import constant.IConstant;
import utils.Validate;

/**
 *
 * @author kien
 */
public class Doctor {

    private String code;
    private String name;
    private String specialization;
    private int availability;

    /**
     * Constructor.
     */
    public Doctor() {
    }

    public Doctor(String code, String name, String specialization, int availability) {
        this.code = code;
        this.name = name;
        this.specialization = specialization;
        this.availability = availability;
    }

    public String getCode() {
        return code;
    }

    public void setId(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    /**
     * To display information of doctor.
     */
    public void displayDoctor() {
        System.out.printf("%-7s%-25s%-30s%-20s\n",
                code, name, specialization, availability);
    }

    /**
     * Input data from key board.
     *
     * @param code code of doctor.
     */
    public void inputData(String code) {
        this.code = code;
        this.name = Validate.getString(
                "Enter Name: ",
                "Name Invalid",
                IConstant.REGEX_DOCTOR_NAME);
        this.specialization = Validate.getString(
                "Enter Specialization: ",
                "Specialization Invalid",
                IConstant.REGEX_DOCTOR_SPECIAL);
        this.availability = Validate.getInt(
                "Enter Availability: ",
                "Availability Invalid",
                "Availability out of range",
                IConstant.MIN_AVAILABLE,
                IConstant.MAX_AVAILABLE);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import constant.IConstant;
import entity.Doctor;
import java.util.ArrayList;
import java.util.List;
import utils.Validate;

/**
 *
 * @author kien
 */
public class DoctorBO {

    public List<Doctor> listDoctor;

    public DoctorBO(List<Doctor> listDoctor) {
        this.listDoctor = listDoctor;
    }

    /**
     * Add an doctor into listDoctor.Input data of doctor from keyboard. Code
     * must be not duplicate.
     *
     * @param code
     */
    public void addDoctor(String code) {
        Doctor doctor = new Doctor();
        if (getIndexOfDoctor(code) == -1) {
            doctor.inputData(code);
            listDoctor.add(doctor);
            System.out.println("Added successfully.");
        }else{
            System.out.println("Doctor code is duplicate.");
        }
        

    }

    /**
     * Get index of doctor by code.
     *
     * @return index of Doctor in listDoctor if it's exist, and -1 when no
     * doctor has the same code as the one passed in.
     */
    private int getIndexOfDoctor(String code) {
        for (int i = 0; i < listDoctor.size(); i++) {
            if (listDoctor.get(i).getCode().equals(code)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Update doctor by code.
     *
     * @param code input code
     */
    public void updateDoctor(String code) {
        int index = getIndexOfDoctor(code);
        if (index >= 0) {
            listDoctor.get(index).setName(Validate.getString(
                "Enter New Name: ",
                "Name Invalid",
                IConstant.REGEX_DOCTOR_NAME));
            listDoctor.get(index).setSpecialization(Validate.getString(
                "Enter New Specialization: ",
                "Specialization Invalid",
                IConstant.REGEX_DOCTOR_SPECIAL));
            listDoctor.get(index).setAvailability(Validate.getInt(
                "Enter New Availability: ",
                "Availability Invalid",
                "Availability out of range",
                IConstant.MIN_AVAILABLE,
                IConstant.MAX_AVAILABLE));
        } else {
            System.out.println("Updated fail.");
        }
    }

    /**
     * Remove doctor by code.If code exist -> removed successfully.
     *
     * @param code
     */
    public void removeDoctorbyCode(String code) {
        int index = getIndexOfDoctor(code);
        if (index >= 0) {
            listDoctor.remove(index);
            System.out.println("Removed successfully.");
        } else {
            System.out.println("Removed fail.");
        }
    }

    /**
     * Search doctor by name.
     *
     * @param name Search Name
     * @return Searched doctor list
     */
    public List<Doctor> searchDoctorByName(String name) {
        List<Doctor> resultSearch = new ArrayList<>();
        for (int i = 0; i < listDoctor.size(); i++) {
            if (listDoctor.get(i).getName().contains(name)) {
                resultSearch.add(listDoctor.get(i));
            }
        }
        return resultSearch;
    }

    /**
     * Print out all doctor in listDoctor.
     *
     * @param list a list
     */
    public void displayListDoctor(List<Doctor> list) {
        System.out.println("--------- Display ---------");
        System.out.printf("%-7s%-25s%-30s%-20s\n", "Code", "Name", " Specialization", "Availability");
        for (Doctor doctor : list) {
            doctor.displayDoctor();
        }
    }

}

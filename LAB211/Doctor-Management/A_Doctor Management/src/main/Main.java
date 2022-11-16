/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import constant.IConstant;
import entity.Doctor;
import java.util.ArrayList;
import java.util.List;
import bo.DoctorBO;
import utils.Validate;

/**
 *
 * @author kien
 */
public class Main {

    public static void main(String[] args) {
        List<Doctor> doctorList = new ArrayList<>();
        DoctorBO doctorBO = new DoctorBO(doctorList);
        while (true) {
            System.out.println("========= Doctor Management =========");
            System.out.println("1. Add doctor");
            System.out.println("2. Update doctor");
            System.out.println("3. Delete doctor");
            System.out.println("4. Search doctor");
            System.out.println("5. Exit");

            int choice = Validate.getInt(
                    "Enter Choice: ",
                    "Choice Invalid", "Choice out of range", 1, 5);
            switch (choice) {
                case 1: {
                    System.out.println("--------- ADD Doctor ---------");
                    String code = Validate.getString(
                            "Enter Code: ",
                            "Code Invalid",
                            IConstant.REGEX_DOCTOR_CODE);
                    doctorBO.addDoctor(code);
                    break;
                }
                case 2: {
                    doctorBO.displayListDoctor(doctorList);
                    System.out.println("--------- UPDATE Doctor ---------");
                    String code = Validate.getString(
                            "Enter Doctor Code to UPDATE: ",
                            "Code Invalid",
                            IConstant.REGEX_DOCTOR_CODE);
                    doctorBO.updateDoctor(code);
                    break;
                }
                case 3: {
                    System.out.println("--------- REMOVE Doctor ---------");
                    doctorBO.displayListDoctor(doctorList);
                    String code = Validate.getString(
                            "Enter Code: ",
                            "Code Invalid",
                            IConstant.REGEX_DOCTOR_CODE);
                    doctorBO.removeDoctorbyCode(code);
                    break;
                }
                case 4:
                    System.out.println("--------- SEARCH Doctor ---------");
                    String name = Validate.getString(
                            "Enter Search Name",
                            "Name invalid", IConstant.REGEX_DOCTOR_NAME);
//                    doctorBO.searchDoctorByName(name);
                    doctorBO.displayListDoctor(doctorBO.searchDoctorByName(name));
                    break;
                case 5:
                    return;
            }

        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import constant.IConstant;
import java.util.List;
import util.Validate;

/**
 *
 * @author leeng
 */
public class Candidate {

    private int id;
    private String firstName;
    private String lastName;
    private String dob;
    private String address;
    private String phone;
    private String email;
    private int candidateType;

    public Candidate() {
    }

    public Candidate(int id, String firstName, String lastName,
            String dob, String address, String phone, String email, int candidateType) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.candidateType = candidateType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(int candidateType) {
        this.candidateType = candidateType;
    }
    
    public String getFullName(){
        String fullname = getFirstName() +" " +getLastName();
        return fullname;
    }

    /**
     * Display Candidate List
     * 
     */
    public void displayCandidate() {
        System.out.printf("%-7s%-25s%-30s%-20s%-20s%-20d\n",
                getFullName(), dob, address, phone, email, candidateType);
    }

    /**
     * Return valid integer Id
     */
    private int getCandidateId(List<Candidate> listCandidate) {
        while (true) {
            int candidateId = Validate.getInt(
                    "Enter Candidate Id: ",
                    "Candidate Id Invalid",
                    "Id out of range",
                    IConstant.MIN_CANDIDATE_ID, IConstant.MAX_CANDIDATE_ID);
            if (indexId(listCandidate, candidateId) == -1) {
                return candidateId;
            } else {
                System.err.println("Id Exist, try again");
            }
        }
    }

    public int indexId(List<Candidate> listCandidate, int id) {
        for (int index = 0; index < listCandidate.size(); index++) {
            if (listCandidate.get(index).getId() == id) {
                return index;
            }
        }
        return -1;
    }

    /**
     * Input new Candidate information
     *
     * @param LIST_CANDIDATE candidate list
     * @param candidateType
     */
    public void createNewCandidate(List<Candidate> LIST_CANDIDATE,int candidateType) {
        this.id = getCandidateId(LIST_CANDIDATE);
        this.firstName = Validate.getString(
                "Enter First Name: ",
                "First Name Invalid",
                IConstant.REGEX_CANDIDATE_NAME);
        this.lastName = Validate.getString(
                "Enter Last Name: ",
                "Last Name Invalid",
                IConstant.REGEX_CANDIDATE_NAME);
        this.dob = Validate.getString(
                "Enter DOB: ",
                "DOB Invalid",
                IConstant.REGEX_DATE);
        this.address = Validate.getString(
                "Enter Address: ",
                "Address Invalid",
                IConstant.REGEX_ADDRESS);
        this.phone = Validate.getPhoneNumber(
                "Enter Phone Number",
                "Number Invalid",
                "Phone length out of range",
                IConstant.REGEX_NUMBER);
        this.candidateType = candidateType;
        this.email = Validate.getString(
                "Enter Email: ",
                "Email invalid",
                IConstant.REGEX_EMAIL);
    }

}

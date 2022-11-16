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
public class InternCandidate extends Candidate {

    private String majors;
    private String semester;
    private String universityName;

    public InternCandidate() {
    }

    public InternCandidate(String majors, String semester, String universityName) {
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public InternCandidate(int id, String firstName, String lastName,
            String dob, String address, String phone, String email,
            int candidateType, String majors, String semester, String universityName) {
        super(id, firstName, lastName, dob, address, phone, email, candidateType);
        this.majors = majors;
        this.semester = semester;
        this.universityName = universityName;
    }

    public String getMajors() {
        return majors;
    }

    public void setMajors(String majors) {
        this.majors = majors;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    /**
     * Input new Candidate information
     *
     * @param LIST_CANDIDATE candidate list
     * @param candidateType
     */
    public void createInternCandidate(List<Candidate> LIST_CANDIDATE,int candidateType) {
        super.createNewCandidate(LIST_CANDIDATE, candidateType);
        this.majors = Validate.getString(
                "Enter Major: ",
                "Major Invalid",
                IConstant.REGEX_MAJORS);
        this.semester = Validate.getString(
                "Enter Semester: ",
                "Last Name Invalid",
                IConstant.REGEX_CANDIDATE_NAME);
        this.universityName = Validate.getString(
                "Enter University Name: ",
                "University Name Invalid",
                IConstant.REGEX_UNIVERSITY_NAME);
    }

    

}

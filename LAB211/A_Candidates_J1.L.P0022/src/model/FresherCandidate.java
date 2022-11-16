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
public class FresherCandidate extends Candidate {

    private String graduration_date;
    private String graduation_rank;
    private String education;

    public FresherCandidate(String graduration_date, String graduation_rank, String education) {
        this.graduration_date = graduration_date;
        this.graduation_rank = graduation_rank;
        this.education = education;
    }

    public FresherCandidate(int id, String firstName, String lastName, String dob,
            String address, String phone, String email, int candidateType,
            String graduration_date, String graduation_rank, String education) {
        super(id, firstName, lastName, dob, address, phone, email, candidateType);
        this.graduration_date = graduration_date;
        this.graduation_rank = graduation_rank;
        this.education = education;
    }

    public String getGraduation_rank() {
        return graduation_rank;
    }

    public void setGraduation_rank(String graduation_rank) {
        this.graduation_rank = graduation_rank;
    }

    public FresherCandidate() {
    }

    public String getGraduration_date() {
        return graduration_date;
    }

    public void setGraduration_date(String graduration_date) {
        this.graduration_date = graduration_date;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

//    private String graduration_date;
//    private String graduation_rank;
//    private String education;
    /**
     * Input new Experience Candidate information
     *
     * @param LIST_CANDIDATE candidate list
     */
    public void createFresherCandidate(List<Candidate> LIST_CANDIDATE, int candidateType) {
        super.createNewCandidate(LIST_CANDIDATE, candidateType);
        this.graduration_date = Validate.getString(
                "Enter graduration_date: ",
                "graduration_date Invalid",
                IConstant.REGEX_DATE);
        int rank = Validate.getInt(
                "Enter Graduation Rank: ",
                "Graduation Rank invalid",
                "Graduation Rank out of range",
                IConstant.MIN_GRADURATION_RANK,
                IConstant.MAX_GRADURATION_RANK);
        switch (rank) {
            case 1:
                this.graduation_rank = IConstant.GRADUATION_RANK_EXELLENCE;
            case 2:
                this.graduation_rank = IConstant.GRADUATION_RANK_GOOD;
            case 3:
                this.graduation_rank = IConstant.GRADUATION_RANK_FAIR;
            case 4:
                this.graduation_rank = IConstant.GRADUATION_RANK_POOR;
        }
        this.education = Validate.getString(
                "Enter education: ",
                "education Invalid",
                IConstant.REGEX_EDUCATION);
    }

    

}

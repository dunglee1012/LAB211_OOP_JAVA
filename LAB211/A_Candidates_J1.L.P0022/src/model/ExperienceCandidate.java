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
public class ExperienceCandidate extends Candidate {

    private int expInYear;
    private String proSkill;

    public ExperienceCandidate() {
    }

    public ExperienceCandidate(int expInYear, String proSkill) {
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public ExperienceCandidate(int id, String firstName, String lastName,
            String dob, String address, String phone, String email,
            int candidateType, int expInYear, String proSkill) {
        super(id, firstName, lastName, dob, address, phone, email, candidateType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    /**
     * Input new Experience Candidate information
     *
     * @param LIST_CANDIDATE candidate list
     * @param candidateType
     */
    public void createExperienceCandidate(List<Candidate> LIST_CANDIDATE,int candidateType) {
        super.createNewCandidate(LIST_CANDIDATE,candidateType);
        this.expInYear = Validate.getInt(
                "Enter Experience Year: ",
                "Invalid Experience Year",
                "Experience Year out of range",
                IConstant.MIN_EXP_IN_YEAR,
                IConstant.MAX_EXP_IN_YEAR);
        this.proSkill = Validate.getString(
                "Enter Professional Skill: ",
                "Professional Skill Invalid",
                IConstant.REGEX_PROFESSIONAL_SKILL);
    }
}

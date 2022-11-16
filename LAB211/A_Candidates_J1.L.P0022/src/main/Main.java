/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import bo.CandidateBO;
import constant.IConstant;
import java.util.ArrayList;
import java.util.List;
import model.Candidate;
import util.Helper;
import util.Validate;

/**
 *
 * @author leeng
 */
public class Main {

    public static void main(String[] args) {

        List<Candidate> listCandidate = new ArrayList();
        CandidateBO candidateBO = new CandidateBO(listCandidate);

        while (true) {
            Helper.displayMenu("CANDIDATE MANAGEMENT SYSTEM\n"
                    + "1. Experience\n"
                    + "2. Fresher\n"
                    + "3. Internship\n"
                    + "4. Searching\n"
                    + "5. Exit\n");

            int choice = Validate.getInt(
                    "Enter your choice:",
                    "Choice out of range",
                    "Invalid choice",
                    1, 5);

            switch (choice) {
                case 1:
                    System.out.println("===== Create Experience Candidate =====");
                    candidateBO.createCandidate(IConstant.CANDIDATE_TYPE_EXPERIENCE);
                    System.out.println("===== CREATE SUCCESSFUL =====");
                    break;
                case 2:
                    System.out.println("===== Create Fresher Candidate =====");
                    candidateBO.createCandidate(IConstant.CANDIDATE_TYPE_FRESHER);
                    System.out.println("===== CREATE SUCCESSFUL =====");
                    break;
                case 3:
                    System.out.println("===== Create Intern Candidate =====");
                    candidateBO.createCandidate(IConstant.CANDIDATE_TYPE_INTERNSHIP);
                    System.out.println("===== CREATE SUCCESSFUL =====");
                    break;
                case 4:
                    System.out.println("--------- SEARCH CANDIDATE ---------");
                    candidateBO.displayAllCandidate();
                    String searchName = Validate.getString(
                            "Enter Search Name: ",
                            "Search Name invalid",
                            IConstant.REGEX_SEARCH_NAME);
                    int type = Validate.getInt("Enter type: ",
                            "Invalid type", "Type out of range", 1, 3);
                    candidateBO.displayListCandidate(candidateBO.searchCandidate(searchName,type));
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.util.ArrayList;
import java.util.List;
import model.Candidate;
import model.ExperienceCandidate;
import model.FresherCandidate;
import model.InternCandidate;
import util.Helper;

/**
 *
 * @author leeng
 */
public class CandidateBO {

    private List<Candidate> listCandidate;

    public CandidateBO(List<Candidate> listCandidate) {
        this.listCandidate = listCandidate;
    }

    /**
     * Search Candidate by input name and type then display
     *
     * @param searchName input search name
     * @return Searched candidate List
     */
    public List<Candidate> searchCandidate(String searchName, int type) {
        List<Candidate> resultSearch = new ArrayList<>();
        for (int i = 0; i < listCandidate.size(); i++) {
            if (listCandidate.get(i).getFullName().contains(searchName) && 
                    listCandidate.get(i).getCandidateType() == type) {
                resultSearch.add(listCandidate.get(i));
            }
        }
        return resultSearch;
    }

    public void displayListCandidate(List<Candidate> list) {
        System.out.println("--------- Display ---------");
        System.out.printf("%-7s%-25s%-30s%-20s%-20s%-20s\n",
                "Full Name", "DOB", "Address", "Phone", "Email", "Type");
        for (Candidate candidate : list) {
            candidate.displayCandidate();
        }
    }

    /**
     * Display all the candidates
     *
     */
    public void displayAllCandidate() {
        System.out.println("            Experience Candidate            \n"
                + "============================================\n");
        for (Candidate candidate : listCandidate) {
            if (candidate instanceof ExperienceCandidate) {
                System.out.println(candidate.getFirstName()
                        + " " + candidate.getLastName());
            }
        }
        System.out.println("            Fresher Candidate            \n"
                + "============================================\n");
        for (Candidate candidate : listCandidate) {
            if (candidate instanceof FresherCandidate) {
                System.out.println(candidate.getFirstName()
                        + " " + candidate.getLastName());
            }
        }
        System.out.println("            Intern Candidate            \n"
                + "============================================\n");
        for (Candidate candidate : listCandidate) {
            if (candidate instanceof InternCandidate) {
                System.out.println(candidate.getFirstName()
                        + " " + candidate.getLastName());
            }
        }

    }

    /**
     * Function to create new candidate base on how good they are
     *
     * @param candidateType candidate type
     */
    public void createCandidate(int candidateType) {
        do {
            ExperienceCandidate expCan = new ExperienceCandidate();
            InternCandidate internCan = new InternCandidate();
            FresherCandidate fresherCan = new FresherCandidate();
            switch (candidateType) {
                case 1:
                    
                    expCan.createExperienceCandidate(listCandidate,candidateType);
                    listCandidate.add(expCan);
                    break;
                case 2:
                    
                    fresherCan.createFresherCandidate(listCandidate,candidateType);
                    listCandidate.add(fresherCan);
                    break;
                case 3:
                    internCan.createInternCandidate(listCandidate,candidateType);
                    break;
            }
        } while (Helper.isContinue("Continue to create Candidate? (Y/N)"));
    }

}

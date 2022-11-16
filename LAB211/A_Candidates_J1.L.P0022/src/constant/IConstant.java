/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package constant;

/**
 *
 * @author leeng
 */
public interface IConstant {
    int CANDIDATE_TYPE_EXPERIENCE = 1;
    int CANDIDATE_TYPE_FRESHER = 2;
    int CANDIDATE_TYPE_INTERNSHIP = 3;

    int MIN_CANDIDATE_ID = 1;
    int MAX_CANDIDATE_ID = Integer.MAX_VALUE;

    String REGEX_CANDIDATE_NAME = "^[a-zA-Z ]+$";

    String REGEX_EMAIL = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/="
            + "?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-"
            + "\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:"
            + "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*"
            + "[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.)"
            + "{3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:"
            + "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\"
            + "[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";

    String REGEX_DATE
            = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|"
            + "(?:(?:29|30)(\\/|-|\\.)"
            + "(?:0?[1,3-9]|1[0-2])\\2))"
            + "(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$"
            + "|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)"
            + "?(?:0[48]|[2468][048]|[13579][26])|"
            + "(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]"
            + "|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])"
            + "|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    int PHONE_NUMBER_LENGTH = 10;

    String REGEX_NUMBER = "^\\d+$";

    String REGEX_ADDRESS = "^[a-zA-Z ]+$";

    int MIN_CANDIDATE_TYPE = 1;
    int MAX_CANDIDATE_TYPE = 3;

    String YES_NO = "^[yYnN]$";

    int MIN_EXP_IN_YEAR = 0;
    int MAX_EXP_IN_YEAR = 100;

    String REGEX_PROFESSIONAL_SKILL = "^[a-zA-Z ]+$";

    int MIN_GRADURATION_RANK = 1;
    int MAX_GRADURATION_RANK = 4;

    String REGEX_EDUCATION = "^[a-zA-Z ]+$";

    String REGEX_MAJORS = "^[a-zA-Z ]+$";

    String REGEX_SEMESTER = "^[a-zA-Z ]+$";

    String REGEX_UNIVERSITY_NAME = "^[a-zA-Z ]+$";

    String REGEX_SEARCH_NAME = "^[a-zA-Z ]+$";
    
    String GRADUATION_RANK_EXELLENCE = "Exellence";
    String GRADUATION_RANK_GOOD = "Good";
    String GRADUATION_RANK_FAIR = "Fair";
    String GRADUATION_RANK_POOR = "Poor";
    
}

package com.example.freshershub;
public class Internship_detail {
    private String internshipPos;
    private String internshipMode;
    private String internshipOrgName;
    private String internshipStartMonth;
    private String internshipStartYear;
    private String internshipEndMonth;
    private String getInternshipEndYear;

    public String getInternshipPos() {
        return internshipPos;
    }

    public String getInternshipMode() {
        return internshipMode;
    }

    public String getInternshipOrgName() {
        return internshipOrgName;
    }

    public String getInternshipStartMonth() {
        return internshipStartMonth;
    }

    public String getInternshipStartYear() {
        return internshipStartYear;
    }

    public String getInternshipEndMonth() {
        return internshipEndMonth;
    }

    public String getGetInternshipEndYear() {
        return getInternshipEndYear;
    }

    public String getInternshipDescription() {
        return internshipDescription;
    }

    public Internship_detail(String internshipPos, String internshipMode, String internshipOrgName, String internshipStartMonth, String internshipStartYear, String internshipEndMonth, String getInternshipEndYear, String internshipDescription) {
        this.internshipPos = internshipPos;
        this.internshipMode = internshipMode;
        this.internshipOrgName = internshipOrgName;
        this.internshipStartMonth = internshipStartMonth;
        this.internshipStartYear = internshipStartYear;
        this.internshipEndMonth = internshipEndMonth;
        this.getInternshipEndYear = getInternshipEndYear;
        this.internshipDescription = internshipDescription;
    }

    private String internshipDescription;


}

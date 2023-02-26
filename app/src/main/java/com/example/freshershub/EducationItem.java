package com.example.freshershub;

public class EducationItem {
    private String qualification;
    private String passingYear;
    private String specialization;
    private String college_name;
    private String percent;

    public EducationItem(String qualification,String passingYear, String specialization, String college_name, String percent) {
        this.qualification = qualification;
        this.passingYear = passingYear;
        this.specialization = specialization;
        this.college_name = college_name;
        this.percent = percent;

    }

    public String getQualification() {
        return qualification;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getCollege_name() {
        return college_name;
    }

    public String getPercent() {
        return percent;
    }

    public String getPassingYear() {
        return passingYear;
    }
}

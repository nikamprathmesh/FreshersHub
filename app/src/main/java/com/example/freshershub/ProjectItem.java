package com.example.freshershub;

public class ProjectItem {
    private String projectTitle;
    private String projectDomain;
    private String projectDescription;

    public String getProjectTitle() {
        return projectTitle;
    }

    public String getProjectDomain() {
        return projectDomain;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public ProjectItem(String projectTitle, String projectDomain, String projectDescription) {
        this.projectTitle = projectTitle;
        this.projectDomain = projectDomain;
        this.projectDescription = projectDescription;
    }
}

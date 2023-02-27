package com.example.freshershub;

public class AssistantTpoItem {
    private String getAssistantDeptName;
    private String assistantTpoName;
    private String assistantTpoDesignation;
    private String assistantTpoWorkMail;
    private String assistantTpoPersonalMail;
    private String assistantTpoContactNo;

    public AssistantTpoItem(String getAssistantDeptName, String assistantTpoName, String assistantTpoDesignation, String assistantTpoWorkMail, String assistantTpoPersonalMail, String assistantTpoContactNo) {
        this.getAssistantDeptName = getAssistantDeptName;
        this.assistantTpoName = assistantTpoName;
        this.assistantTpoDesignation = assistantTpoDesignation;
        this.assistantTpoWorkMail = assistantTpoWorkMail;
        this.assistantTpoPersonalMail = assistantTpoPersonalMail;
        this.assistantTpoContactNo = assistantTpoContactNo;
    }

    public String getGetAssistantDeptName() {
        return getAssistantDeptName;
    }

    public String getAssistantTpoName() {
        return assistantTpoName;
    }

    public String getAssistantTpoDesignation() {
        return assistantTpoDesignation;
    }

    public String getAssistantTpoWorkMail() {
        return assistantTpoWorkMail;
    }

    public String getAssistantTpoPersonalMail() {
        return assistantTpoPersonalMail;
    }

    public String getAssistantTpoContactNo() {
        return assistantTpoContactNo;
    }
}

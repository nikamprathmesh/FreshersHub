package com.example.freshershub;

public class AchievementItem {
    private  String achievementTitle;
    private  String achievementIssuer;
    private  String achievementIssueDate;

    public AchievementItem(String achievementTitle, String achievementIssuer, String achievementIssueDate, String achievementDescription) {
        this.achievementTitle = achievementTitle;
        this.achievementIssuer = achievementIssuer;
        this.achievementIssueDate = achievementIssueDate;
        this.achievementDescription = achievementDescription;
    }

    public String getAchievementTitle() {
        return achievementTitle;
    }

    public String getAchievementIssuer() {
        return achievementIssuer;
    }

    public String getAchievementIssueDate() {
        return achievementIssueDate;
    }

    public String getAchievementDescription() {
        return achievementDescription;
    }

    private  String achievementDescription;
}

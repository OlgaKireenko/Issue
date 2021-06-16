package ru.netology.domain;

public class Issue {
    private int id;
    private boolean statusIssue;
    private String author;
    private String label;
    private String assignee;
    //private Set<String> assignee  = new HashSet;

    public Issue() {
    }


    public Issue(int id, boolean statusIssue, String author, String label, String assignee) {
        this.id = id;
        this.statusIssue = statusIssue;
        this.author = author;
        this.label = label;
        this.assignee = assignee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStatusIssue() {
        return statusIssue;
    }

    public void setStatusIssue(boolean statusIssue) {
        this.statusIssue = statusIssue;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id=" + id +
                ", statusIssue=" + statusIssue +
                ", author='" + author + '\'' +
                ", label='" + label + '\'' +
                ", assignee='" + assignee + '\'' +
                '}';
    }
}




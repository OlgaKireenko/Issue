package ru.netology.manager;

import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class IssueManager {


    private IssueRepository repository;

    public IssueManager(IssueRepository repository) {
        this.repository = repository;
    }

    public void add(Issue item) {
        repository.save(item);

    }

    public List<Issue> getOpenedIssue() {
        List<Issue> result = new ArrayList<>(0);
        for (Issue issue : repository.getAll()) {
            if (issue.isStatusIssue()) {
                result.add(issue);
            }

        }
        return result;
    }

    public List<Issue> getClosedIssue() {
        List<Issue> result = new ArrayList<>(0);
        for (Issue issue : repository.getAll()) {
            if (!issue.isStatusIssue()) {
                result.add(issue);
            }
        }
        return result;
    }

    //ФИЛЬТР по Автору///////////////////
    public List<Issue> filterBy(String author) {
        List<Issue> result = new ArrayList<>(0);
        //List<Issue> result = new ArrayList<>();

        for (Issue issue : repository.getAll()) {

            if (matchesAuthor(issue, author) == true) {
                result.add(issue);
            }
        }
        return result;
    }

    public boolean matchesAuthor(Issue issue, String author) {

        if (issue.getAuthor().contains(author)) { // проверим есть ли поисковое слово в данных об авторе
            return true;
        }
        return false;
    }
    ////////Фильтр по Тэгу//////////////////

    public List<Issue> filterByLabel(String label) {
        List<Issue> result = new ArrayList<>(0);
        //List<Issue> result = new ArrayList<>();

        for (Issue issue : repository.getAll()) {

            if (matchesLabel(issue, label) == true) {
                result.add(issue);
            }
        }
        return result;
    }

    public boolean matchesLabel(Issue issue, String label) {

        if (issue.getLabel().contains(label)) { // проверим есть ли поисковое слово в данных об авторе
            return true;
        }
        return false;
    }

    ////////Фильтр по назначению//////////////////
    public List<Issue> filterByAssignee(String assignee) {
        List<Issue> result = new ArrayList<>(0);
        //List<Issue> result = new ArrayList<>();

        for (Issue issue : repository.getAll()) {

            if (matchesAssignee(issue, assignee) == true) {
                result.add(issue);
            }
        }
        return result;
    }

    public boolean matchesAssignee(Issue issue, String assignee) {

        if (issue.getAssignee().contains(assignee)) { // проверим есть ли поисковое слово в данных об авторе
            return true;
        }
        return false;
    }

    public List<Issue> getIssueByPredicate(Predicate<Issue> filter) {

        ArrayList<Issue> result = new ArrayList<>();
        for (Issue issue : repository.getAll()) {
            if (filter.test(issue)) {
                result.add(issue);
            }
        }
        return result;

    }

    public List<Issue> getIssueByAuthor(String author) {

        return getIssueByPredicate(issue -> issue.getAuthor().contains(author));
    }

    public List<Issue> getIssueByLabel(String label) {

        return getIssueByPredicate(issue -> issue.getLabel().contains(label));
    }

    public List<Issue> getIssueByAssignee(String assignee) {

        return getIssueByPredicate(issue -> issue.getAssignee().contains(assignee));
    }


    public void openByID(int id) {

        for (Issue issue : repository.getAll()) {
            if (issue.getId() == id) {
                issue.setStatusIssue(true);
            }
        }

    }

    public void closeByID(int id) {

        for (Issue issue : repository.getAll()) {
            if (issue.getId() == id) {
                issue.setStatusIssue(false);
            }
        }

    }


}








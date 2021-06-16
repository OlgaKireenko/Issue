package ru.netology.repository;

import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IssueRepository {
    private List<Issue> items = new ArrayList<>();

    public List<Issue> getAll() {
        return items;
    }

    public void save(Issue item) {

        items.add(item);
    }


    public Issue findById(int id) {
        for (Issue item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public void removeByID(int id) {

        items.removeIf(issue -> issue.getId() == id);

    }

    public void addAll(List<Issue> items) {

        this.items.addAll(items);
    }

    public void removeAll(Collection<Issue> items) {

        this.items.removeAll(items);
    }


}

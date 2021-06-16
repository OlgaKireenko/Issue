package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.repository.IssueRepository;

import java.util.List;
import java.util.Set;

class IssueManagerTest {


    private IssueRepository repository = new IssueRepository();

    private IssueManager manager = new IssueManager(repository);

    @BeforeEach
    public void setUp() {

        Set<String> assignee = Set.of("Ivanov", "Petrov", "Sidorov");
        Set<String> author = Set.of("Boss", "Student", "Junior");

        Issue first1 = new Issue(1, true, "Boss", "1", "Ivanov");
        Issue second2 = new Issue(2, false, "Student", "2", "Petrov");
        Issue third3 = new Issue(3, true, "Junior", "3", "Sidorov");
        Issue fourth4 = new Issue(4, false, "Student", "2", "Ivanov");
        Issue fifth5 = new Issue(5, true, "Boss", "1", "Petrov");

        manager.add(first1);
        manager.add(second2);
        manager.add(third3);
        manager.add(fourth4);
        manager.add(fifth5);


    }


    @Test
    void shouldShowFilterByAuthorIssue() {


        //System.out.println(repository.getItems());
        System.out.println(manager.filterBy("Boss"));

    }

    @Test
    void shouldShowFilterByStatusOpened() {


        System.out.println(manager.getOpenedIssue());

    }

    @Test
    void shouldShowFilterByStatusClosed() {


        System.out.println(manager.getClosedIssue());

    }


    @Test
    void shouldShowFilterByLabel() {


        System.out.println(manager.filterByLabel("2"));

    }

    @Test
    void shouldShowFilterByAssignee() {


        System.out.println(manager.filterByAssignee("Ivanov"));

    }

    @Test
    public void shouldFilterByAuthorWithPredicate() {

        List<Issue> issueByAuthor = manager.getIssueByAuthor("Student");
        System.out.println("Issue with author = " + issueByAuthor.size());

    }

    @Test
    public void shouldSetStatusByID() {

        manager.openByID(2);
        System.out.println("Test1" + manager.getOpenedIssue());

        manager.closeByID(1);
        System.out.println("Test2" + manager.getClosedIssue());
    }

    @Test
    public void shouldFilterByLabelWithPredicate() {

        List<Issue> issueByLabel = manager.getIssueByLabel("1");
        System.out.println("Issue with author = " + issueByLabel);
    }

    @Test
    public void shouldFilterByAssigneeWithPredicate() {

        List<Issue> issueByAssignee = manager.getIssueByAssignee("Petrov");
        System.out.println("Issue with author = " + issueByAssignee);
    }
}


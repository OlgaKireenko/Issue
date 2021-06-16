import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class Main {

public static void main(String[]args){

    Set<String>issues = new HashSet<>();
        issues.add("Ivanov");
        issues.add("Petrov");
        issues.add("Sidorov");

    System.out.println(issues);
//filterBy(issues, S);
    System.out.println();
    }

    public static void filterBy(Set<String>issues, Predicate<String> condition){

        for(String issue: issues) {
            if (condition.test(issue))
                System.out.println(issues);
            
        }
    }
}

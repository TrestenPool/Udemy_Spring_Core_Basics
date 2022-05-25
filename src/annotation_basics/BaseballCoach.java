package annotation_basics;

import bean_scopes.Coach;
import org.springframework.stereotype.Component;

@Component("coach1")
public class BaseballCoach implements Coach {
    // constructor
    public BaseballCoach() {
    }

    @Override
    public String getDailyWorkout(){
        return "Spend 30 minutes on batting practice";
    }
}

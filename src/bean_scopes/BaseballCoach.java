package bean_scopes;

import Dependency_Injection.FortuneService;

public class BaseballCoach implements Coach {
    private String key;

    // constructor
    public BaseballCoach() {
    }

    @Override
    public String getDailyWorkout(){
        return "Spend 30 minutes on batting practice";
    }

    // getters and setters for the field
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}

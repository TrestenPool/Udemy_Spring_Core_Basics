package bean_scopes;

import Dependency_Injection.FortuneService;

public class BaseballCoach implements Coach {
    private String key;

    // constructor
    public BaseballCoach() {
    }

    // init method
    public void init(){
        System.out.println("init() method called");
    }

    // cleanup method
    public void cleanup(){
        System.out.println("cleanup() method called");
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

package annotation_basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach {
    private Fortune fortune;

    // constructor
    @Autowired
    public BaseballCoach(@Qualifier("happyFortune") Fortune fortune) {
        this.fortune = fortune;
    }

    @Override
    public String getDailyWorkout(){
        return "Spend 30 minutes on batting practice";
    }

    @Override
    public String getDailyFortune() {
        return this.fortune.getDailyFortune();
    }
}

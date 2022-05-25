package annotation_basics.setter_injection;

import annotation_basics.Coach;
import annotation_basics.Fortune;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    private Fortune fortune;

    @Override
    public String getDailyWorkout() {
        return "Go work on your backhand";
    }

    @Override
    public String getDailyFortune() {
        return this.fortune.getDailyFortune();
    }

    @Autowired
    public void setFortune(@Qualifier("madFortune")  Fortune fortune) {
        this.fortune = fortune;
    }

    public Fortune getFortune() {
        return fortune;
    }
}

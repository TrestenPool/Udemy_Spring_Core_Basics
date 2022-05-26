package javac_code_configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("baseballCoach")
public class BaseballCoach implements Coach {
    FortuneService fortuneService;

    @Autowired
    public BaseballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout(){
        return "Spend 30 minutes on batting practice";
    }

    @Override
    public String getDailyFortune() {
        return this.fortuneService.getFortune();
    }
}

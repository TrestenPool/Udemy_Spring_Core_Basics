package annotation_basics;

import org.springframework.stereotype.Component;

@Component
public class MadFortune implements Fortune{
    @Override
    public String getDailyFortune() {
        return "What the heck are you doing, get off of my field!!";
    }
}

package annotation_basics;

import org.springframework.stereotype.Component;

@Component
public class HappyFortune implements Fortune{
    @Override
    public String getDailyFortune() {
        return "You are doing great, keep it up!!";
    }
}

package javac_code_configuration;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "You are doing great, keep it up";
    }
}

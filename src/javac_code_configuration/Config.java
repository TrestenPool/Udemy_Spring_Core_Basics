package javac_code_configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public FortuneService happyFortuneService(){
        HappyFortuneService happyFortuneService = new HappyFortuneService();
        return happyFortuneService;
    }

    @Bean
    public FortuneService harshFortuneService(){
        HarshFortuneService harshFortuneService = new HarshFortuneService();
        return harshFortuneService;
    }

    @Bean
    public Coach baseballCoach(){
        BaseballCoach baseballCoach = new BaseballCoach(harshFortuneService());
        return baseballCoach;
    }

}

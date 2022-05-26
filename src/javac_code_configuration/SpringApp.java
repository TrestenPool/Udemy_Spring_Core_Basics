package javac_code_configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        BaseballCoach baseballCoach = context.getBean("baseballCoach", BaseballCoach.class);

        System.out.println(baseballCoach.getDailyWorkout());
        System.out.println(baseballCoach.getDailyFortune());
    }
}

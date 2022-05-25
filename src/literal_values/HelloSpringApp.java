package literal_values;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

    public static void main(String[] args) {
        // load the spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BaseballCoach coach = context.getBean("baseballCoach", BaseballCoach.class);

        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getTeamName() + " "  + coach.getEmailAddress());

        // close the context
        context.close();
    }
}

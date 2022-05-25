package annotation_basics;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {
    public static void main(String[] args) {
        // reference to the appcontext file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotation_basics-applicationContext.xml");

        // retrieve the bean
        Coach coach = context.getBean("baseballCoach", Coach.class);

        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());

        // close the appcontext file
        context.close();
    }
}

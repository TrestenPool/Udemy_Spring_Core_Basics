package annotation_basics;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {
    public static void main(String[] args) {
        // reference to the appcontext file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("annotation_basics-applicationContext.xml");

        // retrieve the bean
        BaseballCoach coach = context.getBean("coach1", BaseballCoach.class);

        System.out.println(coach.getDailyWorkout());

        // close the appcontext file
        context.close();
    }
}

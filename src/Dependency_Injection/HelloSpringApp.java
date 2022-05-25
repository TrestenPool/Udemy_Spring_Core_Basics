package Dependency_Injection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

    public static void main(String[] args) {
        // load the spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // retrieve bean from spring container
        Coach headCoach1 = context.getBean("headCoach", Coach.class);
        Coach headCoach2 = context.getBean("headCoach2", Coach.class);

        // call head coach 1 methods
        System.out.println(headCoach1.getDailyWorkout());
        System.out.println(headCoach1.getDailyFortune() + "\n");

        // call head coach 2 methods
        System.out.println(headCoach2.getDailyWorkout());
        System.out.println(headCoach2.getDailyFortune());

        // close the context
        context.close();
    }
}

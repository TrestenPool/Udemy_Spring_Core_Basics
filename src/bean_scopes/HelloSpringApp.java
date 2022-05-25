package bean_scopes;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

    public static void main(String[] args) {
        // load the spring config file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean_scope-applicationContext.xml");

        BaseballCoach coach1 = context.getBean("coach1", BaseballCoach.class);
        BaseballCoach coach2 = context.getBean("coach1", BaseballCoach.class);

        coach1.setKey("tiger");
        coach2.setKey("monkey");

        System.out.println("coach 1 key = " + coach1.getKey());
        System.out.println("coach 2 key = " + coach2.getKey());

        // close the context
        context.close();
    }
}

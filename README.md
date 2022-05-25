# Udemy Spring Tutorial
This repo is for referencing back on Spring topics learned in the spring tutorial I learned on https://www.udemy.com/course/spring-hibernate-tutorial/
This repo separated different topics into different packages.

### XML Configuration
---

#### Configuring Java Beans
:open_file_folder:javaBeans

We have a Coach interface with a simple getDailyWorkout() that the different coaches implement.

<img src="https://github.com/TrestenPool/Udemy_Spring_Tutorial/blob/main/Screenshots/structure.png?raw=true" width="200">


First configure the bean in the applicationContext.xml

<img src="https://github.com/TrestenPool/Udemy_Spring_Tutorial/blob/main/Screenshots/java_bean.png?raw=true" width="425">

Then load the spring config file with:

`ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");`

Retrieving the bean with 

`Coach coach = context.getBean("myCoach", Coach.class);`

And finally close the config file pointer with 

`context.close();`

<img src="https://github.com/TrestenPool/Udemy_Spring_Tutorial/blob/main/Screenshots/javaBean_spring_app.png?raw=true" width="425" height="200">

---
#### Dependency Injection
:open_file_folder:dependencyInjection

We have added a dependency being an object that implements the FortuneService interface. The FortuneService interface has one method `getFortune()` Two classes implement the interface being HappyFortuneService and HarshFortuneService. The Coach interface now has a method called `getDailyFortune()` that will call the private field fortuneService and print out its fortune.

In the applicationContext.xml we have created the dependency as **myFortuneService** we specify what kind of fortune through the class field
We then create the bean **myCoach** and use `<constructor-arg>` to pass in the dependency bean we have created above.

<img src="https://github.com/TrestenPool/Udemy_Spring_Tutorial/blob/main/Screenshots/dependencyInjectino_appContext.png?raw=true" width="425" height="200">

And same as before we can call the methods on our coach object just like normal having spring inject the dependency for us. In this case since we are using the constructor to have spring wire in the dependency, this is called **Constructor Injection**.

<img src="https://github.com/TrestenPool/Udemy_Spring_Tutorial/blob/main/Screenshots/dependencyInjection_spring_app.png?raw=true" width="425" height="200">

---


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
#### Dependency Injection (Constructor injection)
:open_file_folder:dependencyInjection

We have added a dependency being an object that implements the FortuneService interface. The FortuneService interface has one method `getFortune()` Two classes implement the interface being HappyFortuneService and HarshFortuneService. The Coach interface now has a method called `getDailyFortune()` that will call the private field fortuneService and print out its fortune.

In the applicationContext.xml we have created the dependency as **myFortuneService** we specify what kind of fortune through the class field
We then create the bean **myCoach** and use `<constructor-arg>` to pass in the dependency bean we have created above.

<img src="https://github.com/TrestenPool/Udemy_Spring_Tutorial/blob/main/Screenshots/dependencyInjectino_appContext.png?raw=true" width="425" height="200">

And same as before we can call the methods on our coach object just like normal having spring inject the dependency for us. In this case since we are using the constructor to have spring wire in the dependency, this is called **Constructor Injection**.

<img src="https://github.com/TrestenPool/Udemy_Spring_Tutorial/blob/main/Screenshots/dependencyInjection_spring_app.png?raw=true" width="425" height="200">

---

#### Dependency Injection (Setter injection)
:open_file_folder:dependencyInjection

In order to use setter based injection simply have a setter method in the Track Coach class:

<img src="https://github.com/TrestenPool/Udemy_Spring_Tutorial/blob/main/Screenshots/dependencyInjection_trackCoach.png?raw=true" width="450">

To inject the dependency via the setter method we use `<property name="fortuneService" ref="headCoach2_fortune" />`

<img src="https://github.com/TrestenPool/Udemy_Spring_Tutorial/blob/main/Screenshots/dependencyInjection_appcontext.png?raw=true" height="400">

---

#### Injecting literal Values

If we wanted to inject literal values we would just use `<property>` tag with the `value` attribute specifying the value of the literal value shown below.

<img src="https://github.com/TrestenPool/Udemy_Spring_Tutorial/blob/main/Screenshots/injecting_literal_values.png?raw=true">

---

#### Injecting values from a properties file
:open_file_folder:dependencyInjection

A .properties file was created named `sport.properties` in the same directory as the `applicationContext.xml` file

<img src="https://github.com/TrestenPool/Udemy_Spring_Tutorial/blob/main/Screenshots/sportsproperties_file.png?raw=true">

The sport.properties follows a basic syntax of `objectName.propertyName=somevalue`

<img src="https://github.com/TrestenPool/Udemy_Spring_Tutorial/blob/main/Screenshots/pic2.png?raw=true">

In order to reference the .properties file from the applicationContext.xml the following line is needed to make the reference to it
`<context:property-placeholder location="sport.properties"/>`

And to assign a value is easy as: `value="${team.email}"`

<img src="https://github.com/TrestenPool/Udemy_Spring_Tutorial/blob/main/Screenshots/pic1.png?raw=true">

---

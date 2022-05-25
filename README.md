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

#### Bean Scope (singleton vs prototype)
:open_file_folder: bean_scope

:page_facing_up: bean_scope-applicationContext.xml

> By default if you do not specify the `scope` attribute in the bean property it wil default to **singleton**. The singleton bean scope means that everytime a request to the spring container is made for a bean it will return a reference to the same object as before. The other bean scope is **prototype**. The protoype bean scope means that every time a reqest for a bean is made to the spring container it will create a new instance of the bean and return it. 

> In this example we have a private variable called **key** in the BaseballCoach class that is only accessible via its getters and setters. If we leave the bean scope as singleton and make two references to the same object and try to change the values of each of those reference objects. It will just leave it as the last one who tried to change the key property as seen in the example.

> As you can both coach1 and coach2 come up with the same key **monkey** because coach2 changed it last.

<img src="https://github.com/TrestenPool/Udemy_Spring_Tutorial/blob/main/Screenshots/singleton_scope.png?raw=true">


>If we tried to the same test with the scope as **prototype** we will see both objects having different values for the key because they point to different object entirely

<img src="https://github.com/TrestenPool/Udemy_Spring_Tutorial/blob/main/Screenshots/prototype_scope.png?raw=true">

---

#### Bean Init and Destroy methods 
:open_file_folder: bean_scope

:page_facing_up: bean_scope-applicationContext.xml

> When configuring your beans in the .xml file, you have the option to add a **init-method** & **destroy-method**.
>> The **init-method** is invoked when the spring container first creates the bean, and the **destroy-method** is called when the **Spring Container** is shutting down.
> These methods can have any access modifer ex. `public, private, protected`. These methods are specified during the configuration of the bean. An example of the execution can be seen below

<img src="https://github.com/TrestenPool/Udemy_Spring_Tutorial/blob/main/Screenshots/beanLifecyle.png?raw=true">

:warning: Be Aware that the scope for the bean has to be **singleton** in order for the destroy method to be invoked. Meaning that the **destroy-method does not work if the bean scope is prototype**

---

### Spring Annotations
---

#### Basics About Annotations
> Pros
> + Less Code
> + Minimizes XML Configuration

> Cons
> + Harder to manage since it is not defined in one location like the applicationContext.xml file
> + Requires component scanning meaning it has to scan your entire project for components.

> Development Process 
> 1. Enable *recursive* component scanning in the Spring Config File 
>> ` <context:compent-scan base-package="com.cib599.springDemo"\> `
> 2. Add the **@Component** Annotation to your java classes
>> ``` 
>> @Component("coach1")
>> public class BaseballCoach implements Coach{
>>  @Override
>>  public String getDailyWorkout(){
>>    return "Got hit off of the Tee.";
>>  }
>> }
>> ```
>> If no bean ID is provided in this case **coach1** in @Component("coach1"), then Spring will create a bean with the default name of the class in camelCase. So in this case it would've been **baseballCoach**.
> 3. Retrieve bean from the Spring Container
>> `BaseballCoach coach = context.getBean("coach1", BaseballCoach.class);`

--- 

#### Constructor Injection & @Qualifer keyword
> In this example we have the BaseballCoach having a constructor that takes in a Fortune. If there was only one fortune bean that we would not have to use the @Qualifer keyword. But since there are more than one class that implements the **Fortune** interface we have to specify in the BaseballCoach constructor the qualifying bean to be injected. In this case it is **`@Qualifer("happyFortune")`**
> <img src="https://github.com/TrestenPool/Udemy_Spring_Tutorial/blob/main/Screenshots/pic3.png?raw=true">

---

#### Setter Injection & @Qualifer keyword
> Similiarily to the example above the coach has a fortune field. We are able to inject the dependency into the setter method by using the **@Autowired** keyword above the setter method. Also since there are two classes that implement the Fortune interface `HappyFortune and MadFortune`, we have to use the **@Qualifer()** keyword along with the beanID as the parameters in order to inject the correct dependency.

> :bulb:: It does not have to be named setFortune(), but any method name with the `@Autowired` keyword above it.

> <img src="https://github.com/TrestenPool/Udemy_Spring_Tutorial/blob/main/Screenshots/pic4.png?raw=true">

---

#### Field Injection (Java Reflection)
> We can inject dependencies by setting field values on your class directly (even private fields)
> This is accomplished by using **Java Reflection**

> ```
> public class TennisCoach implements Coach{
>   @Autowired
>   private Fortune fortune;
>
>   public TennisCoach(){ }
>   
>   //no need for setter and getter methods
> }
> ```
> There is no need for setter/getter methods because spring will inject the dependency for us to use!

---

#### Bean Scope with Annotations
> As with xml, we can also specify the bean scope with annotations. All you have to do is specify the bean scope with the **`@Scope()`** annotations under the **`@Component`** annotation.

> Example:
> ```
>@Component
>@Scope("singleton")
>public class BaseballCoach implements Coach{
> // class info
>}

---

#### Bean LifeCycle with Annotations (@PostConstruct & @PreDestroy)
> Similiar to the init-method and destroy-method in the xml configuration of the lifecycle of the bean we can also specify certain methods to run at the creation of the spring bean and at the end of the beans life.

> These two annotations are **`@PostConstruct & @PreDestroy`**

> Example:
> ```
> @Component
> public class BaseballCoach implements Coach {
> 
>   // invoked after creation
>   @PostConstruct
>   public void drawupBattingOrder(){}
>   .
>   .
>   .
>   // invoked right before bean is destroyed
>   @PreDestroy
>   public void yellAtPlayers(){}
> }
> ```
> 💡Note:
> + The methods can have any access modifer
> + since you cannot capture the value, typically only void is used for the return type
> + the method cannot accept any arguments. The methods should not take in any arguments.
> + If a bean has a scope of **prototype** the **@PreDestroy** annotation will not be invoked. Since Spring does **NOT** manage the complete lifecylce of a prototype bean.

---

### Spring Configuration with Java Code
---

#### Steps in order to configure spring with only java code
1. Create a Java class and annotate as: **`@Configuration`** and add component scanning support: **`@ComponentScan`**

```
@Configuration
@ComponentScan("annotation_basics")
public class SportConfig {
  // do other config here
}
```

2. Read Spring Java configuration class 
 
`AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);`

3. Retrieve bean from Spring Container

`Coach coach = context.getBean("baseballCoach", Coach.class);`

---

#### 

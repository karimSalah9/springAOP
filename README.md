# springAOP
One of the key components of Spring Framework is the Aspect Oriented Programming (AOP) framework.
Aspect Oriented Programming entails breaking down program logic into distinct parts called so-called concerns.
The functions that span multiple points of an application are called cross-cutting concerns.
These cross-cutting concerns are conceptually separate from the application's business logic. 
There are various common good examples of aspects such as logging, auditing,
declarative transactions, security, caching, etc.
The key unit of modularity in OOP is the class,
whereas in AOP the unit of modularity is the aspect.
Dependency Injection helps you decouple your application objects from each other,
while AOP helps you decouple cross-cutting concerns from the objects that they affect.
AOP is like triggers in programming languages such as Perl, .NET, Java, and others.
Spring AOP module lets interceptors intercept an application. For example,
when a method is executed, you can add extra functionality before or after the method execution.


Aspect Oriented Programming Core Concepts
Before we dive into the implementation of Spring AOP implementation, we should understand the core concepts of AOP.

Aspect: An aspect is a class that implements enterprise application concerns that cut across multiple classes, such as transaction management. Aspects can be a normal class configured through Spring XML configuration or we can use Spring AspectJ integration to define a class as Aspect using @Aspect annotation.
Join Point: A join point is a specific point in the application such as method execution, exception handling, changing object variable values, etc. In Spring AOP a join point is always the execution of a method.
Advice: Advices are actions taken for a particular join point. In terms of programming, they are methods that get executed when a certain join point with matching pointcut is reached in the application. You can think of Advices as Struts2 interceptors or Servlet Filters.
Pointcut: Pointcut is expressions that are matched with join points to determine whether advice needs to be executed or not. Pointcut uses different kinds of expressions that are matched with the join points and Spring framework uses the AspectJ pointcut expression language.
Target Object: They are the object on which advices are applied. Spring AOP is implemented using runtime proxies so this object is always a proxied object. What is means is that a subclass is created at runtime where the target method is overridden and advice are included based on their configuration.
AOP proxy: Spring AOP implementation uses JDK dynamic proxy to create the Proxy classes with target classes and advice invocations, these are called AOP proxy classes. We can also use CGLIB proxy by adding it as the dependency in the Spring AOP project.
Weaving: It is the process of linking aspects with other objects to create the advised proxy objects. This can be done at compile time, load time or at runtime. Spring AOP performs weaving at the runtime.
AOP Advice Types
Based on the execution strategy of advice, they are of the following types.

Before Advice: These advices runs before the execution of join point methods. We can use @Before annotation to mark an advice type as Before advice.
After (finally) Advice: An advice that gets executed after the join point method finishes executing, whether normally or by throwing an exception. We can create after advice using @After annotation.
After Returning Advice: Sometimes we want advice methods to execute only if the join point method executes normally. We can use @AfterReturning annotation to mark a method as after returning advice.
After Throwing Advice: This advice gets executed only when join point method throws exception, we can use it to rollback the transaction declaratively. We use @AfterThrowing annotation for this type of advice.
Around Advice: This is the most important and powerful advice. This advice surrounds the join point method and we can also choose whether to execute the join point method or not. We can write advice code that gets executed before and after the execution of the join point method. It is the responsibility of around advice to invoke the join point method and return values if the method is returning something. We use @Around annotation to create around advice methods.
The points mentioned above may sound confusing but when we will look at the implementation of Spring AOP, things will be more clear. Let’s start creating a simple Spring project with AOP implementations. Spring provides support for using AspectJ annotations to create aspects and we will be using that for simplicity. All the above AOP annotations are defined in org.aspectj.lang.annotation package.

Spring Tool Suite provides useful information about the aspects, so I would suggest you use it. If you are not familiar with STS, I would recommend you to have a look at Spring MVC Tutorial where I have explained how to use it.

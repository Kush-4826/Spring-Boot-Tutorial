package org.example;

import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println( "Hello World!" );

        System.out.println("--------------------------------------------------------------------");
        System.out.println("(Accessing Bean using Type Example)");
//        Accessing the bean based on the type of the bean
        Laptop laptop = context.getBean(Laptop.class);
        laptop.compile();

        System.out.println("--------------------------------------------------------------------");
        System.out.println("(Accessing Bean using name Example)");
//        Accessing the bean based on the name of the bean
        Desktop desktop2 = context.getBean("com1", Desktop.class);
        desktop2.compile();

        System.out.println("--------------------------------------------------------------------");
        System.out.println("(Prototype Scope Example)");
        Desktop desktop3 = context.getBean(Desktop.class);
        desktop3.compile();

        System.out.println("--------------------------------------------------------------------");
        System.out.println("(Autowiring Example)");
        Alien alien = context.getBean(Alien.class);
        System.out.println("Age: " + alien.getAge());
        alien.code();
    }
}

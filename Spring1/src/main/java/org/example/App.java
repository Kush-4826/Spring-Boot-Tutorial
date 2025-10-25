package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws InterruptedException {

        // Creating a context from XML based configurations.
        // All the beans that are mentioned in the spring.xml file, will be created
        // while we fetch the context itself.
        // getBean() will just get the reference of that object and return it...
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println( "Hello World!" );

        Alien alien = (Alien)context.getBean("alien");
        alien.code();
    }
}

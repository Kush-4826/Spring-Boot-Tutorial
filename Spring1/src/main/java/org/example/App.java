package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        // Creating a context from XML based configurations.
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        System.out.println( "Hello World!" );
        Alien alien = (Alien)context.getBean("alien");
        alien.code();
    }
}

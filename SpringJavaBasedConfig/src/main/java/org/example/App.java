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

//        Accessing the bean based on the type of the bean
        Desktop desktop = context.getBean(Desktop.class);
        desktop.compile();

//        Accessing the bean based on the name of the bean
        Desktop desktop2 = context.getBean("com1", Desktop.class);
        desktop2.compile();
    }
}

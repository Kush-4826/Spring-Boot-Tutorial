package com.example.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDemo2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootDemo2Application.class, args);

//        System.out.println("hello, world..!!");

        // TIPNormal way of coding in which we create the objects of classes
        // and manage these objects.

        // Now this code gives an error, because manually created object of Alien does not have the Laptop object
        // initialized...
//        Alien alien = new Alien();
//        alien.code();

        // But now we are using spring framework and we want spring to manage the
        // objects. we want spring to create the object for this class and give
        // it to me

        /*
        Directly trying to get the bean of Alien class will result in this exception
        in thread "main" org.springframework.beans.factory.NoSuchBeanDefinitionException: No qualifying bean of type 'com.example.app.Alien' available
        to avoid this exception, we need to add the @Component annotation above the Alien class.
        This annotation makes sure that the spring framework knows that this class is a bean
         */

        Laptop laptop = context.getBean(Laptop.class);
        laptop.compile();

        Alien alien2 = context.getBean(Alien.class);
        alien2.code();
	}
}

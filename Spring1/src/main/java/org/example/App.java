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
        // while we fetch the context itself. (This is true only for the beans with singleton scope)
        // getBean() will just get the reference of that object and return it...
        // All the beans that are defined with prototype scope are created when the getBean() is called...
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        System.out.println( "Hello World!" );

        System.out.println("-------------------------------------------------------------");
        Alien alien = (Alien)context.getBean("alien");
        // The setAge will change the age for both the alien and alien1 references, if the
        // bean scope is set to singleton. As the internal object remains the same.
        // But as soon as the scope is changed to prototype, the alien and alien1 references
        // point to 2 different objects..!!
        alien.setAge(30);
        System.out.println(alien.getAge());
        alien.code();

        System.out.println("-------------------------------------------------------------");
        System.out.println("(Constructor Injection Example)");
        Alien alien1 = (Alien)context.getBean("alien1");
        System.out.println(alien1.getAge());
        alien1.code();

        System.out.println("-------------------------------------------------------------");
        System.out.println("(Interface Example)");
        Alien alien2 = (Alien)context.getBean("alien2");
        System.out.println(alien2.getAge());
        alien2.code();

        System.out.println("-------------------------------------------------------------");
        System.out.println("(Autowiring Example)");
        Alien alien3 = (Alien)context.getBean("alien3");
        System.out.println(alien3.getAge());
        alien3.code();
    }
}

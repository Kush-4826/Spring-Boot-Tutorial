package org.example.config;

import org.example.Alien;
import org.example.ComputerSystem;
import org.example.Desktop;
import org.example.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

/**
 * Adding the @ComponentScan Annotation tells the spring framework to check all the classes
 * that have the @Component annotation in the given package. All the classes with the
 * @Component Annotation will be automatically managed as beans by the Spring framework
 * Because of this, i need not define any beans in the config class...
 */
@Configuration
@ComponentScan("org.example")
public class AppConfig {

    /**
     * The name of the method becomes the name of the bean.....
     * @return
     */
//    @Bean
//    @Primary
//    @Scope("prototype")
//    public Laptop laptop() {
//        return new Laptop();
//    }

    /**
     * Another way of defining the name of the bean is to pass it as argument
     * to the @Bean annotation
     * @return
     */
//    @Bean(name = {"com1", "desktop1"})
//    public Desktop getDesktop() {
//        return new Desktop();
//    }

    /**
     * The @Autowired argument will automatically try to connect one of the beans of the matching
     * type to this argument. Since the type here is ComputerSystem, any of the beans of the
     * implementation of ComputerSystem interface will be wired.
     * Here the primary Bean of ComputerSystem implementation is Laptop, so it gets wired...
     * @param computer
     * @return
     */
//    @Bean
//    public Alien alien(@Autowired ComputerSystem computer) {
//        Alien alien = new Alien();
//        // Setter Injection....
//        alien.setAge(30);
//        alien.setComputerSystem(computer);
//        return alien;
//    }
}

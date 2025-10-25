package org.example.config;

import org.example.Alien;
import org.example.Desktop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    /**
     * The name of the method becomes the name of the bean.....
     * @return
     */
    @Bean
    @Primary
    @Scope("prototype")
    public Desktop desktop() {
        return new Desktop();
    }

    /**
     * Another way of defining the name of the bean is to pass it as argument
     * to the @Bean annotation
     * @return
     */
    @Bean(name = {"com1", "desktop1"})
    public Desktop getDesktop() {
        return new Desktop();
    }

    @Bean
    public Alien alien() {
        Alien alien = new Alien();
        // Setter Injection....
        alien.setAge(30);
        alien.setComputerSystem(desktop());
        return alien;
    }
}

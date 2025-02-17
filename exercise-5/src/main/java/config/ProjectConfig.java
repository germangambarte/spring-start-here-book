package config;

import main.Parrot;
import main.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectConfig {
    @Bean
    Parrot parrot() {
        var p = new Parrot();
        p.setName("Pajarito");
        return p;
    }

    @Bean
    Person person() {
        var p = new Person();
        p.setName("Germán");
        p.setParrot(parrot());
        return p;
    }
}

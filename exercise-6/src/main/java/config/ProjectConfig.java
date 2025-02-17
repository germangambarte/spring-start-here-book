package config;

import main.Parrot;
import main.Person;
import org.springframework.context.annotation.Bean;

public class ProjectConfig {
    @Bean
    Parrot parrot(){
        var parrot = new Parrot();
        parrot.setName("Pajarito");
        return parrot;
    }

    @Bean
    Person person(Parrot parrot){
        var person = new Person();
        person.setName("Germán");
        person.setParrot(parrot);
        return person;
    }
}

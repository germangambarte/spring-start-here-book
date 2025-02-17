package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        var person = context.getBean(Person.class);
        var parrot = context.getBean(Parrot.class);

        System.out.println("Person: " + person.getName());
        System.out.println("Parrot: " + parrot.getName());
        System.out.println("Person's parrot: " + person.getParrot());
    }
}

package main;

import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        Parrot x = new Parrot();
        x.setName("Pajarito x");

        Supplier<Parrot> parrotSupplier = () -> x;
        context.registerBean("parrotx", Parrot.class, parrotSupplier);

        Parrot parrotFromContext = context.getBean(Parrot.class);
        System.out.println(parrotFromContext.getName());
    }
}

package main;


import config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        Parrot p = context.getBean(Parrot.class);
        String x = context.getBean(String.class);
        int y = context.getBean(Integer.class);

        System.out.println(p.getName());
        System.out.println(x);
        System.out.println(y);
    }
}

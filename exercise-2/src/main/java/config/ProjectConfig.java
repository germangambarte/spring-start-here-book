package config;

import main.Parrot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ProjectConfig {
    @Bean()
    @Primary
    Parrot parrot1() {
        var p = new Parrot();
        p.setName("Pajarito 1");
        return p;
    }

    @Bean(name = "Pajarito 2")
    Parrot parrot2() {
        var p = new Parrot();
        p.setName("Pajarito 2");
        return p;
    }

    @Bean(name = "Pajarito 3")
    Parrot parrot3() {
        var p = new Parrot();
        p.setName("Pajarito 3");
        return p;
    }
}

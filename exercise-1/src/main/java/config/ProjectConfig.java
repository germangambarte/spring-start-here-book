package config;

import main.Parrot;
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
    String string(){
        return "Holis";
    }
    @Bean
    int integer(){
        return 42;
    }
}

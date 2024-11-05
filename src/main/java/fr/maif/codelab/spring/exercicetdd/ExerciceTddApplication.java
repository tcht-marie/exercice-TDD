package fr.maif.codelab.spring.exercicetdd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan(basePackages = {"fr.maif.codelab.spring.exercicetdd.repositories"})
public class ExerciceTddApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExerciceTddApplication.class, args);
    }

}

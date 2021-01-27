package entity_person;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(PersonRepository repository) {
        repository.save(new Person("First", 50));
        repository.save(new Person("Second", 100));

        return args -> {
            System.out.println("Uploaded 2 people");
            System.out.println(repository.findAll());
        };
    }
}

package kg.attractor.micro.util;


import kg.attractor.micro.model.Post;
import kg.attractor.micro.repository.PostRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

@Configuration
public class PreloadDatabaseWithData {

    @Bean
    CommandLineRunner initDatabase(PostRepo repository) {

        repository.deleteAll();

        return (args) -> Stream.of(posts())
                .peek(System.out::println)
                .forEach(repository::save);
    }

    private Post[] posts() {
        return new Post[]{
                new Post("Desert", "Desert.jpg"),
                new Post("Jellyfish", "Jellyfish.jpg"),
                new Post("Hydrangeas", "Hydrangeas.jpg"),
                new Post("Koala", "Koala.jpg"),
                new Post("Chrysanthemum", "Chrysanthemum.jpg")};
    }
}
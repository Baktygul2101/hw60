package kg.attractor.micro.repository;

import kg.attractor.micro.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepo extends CrudRepository<Post, String> { }

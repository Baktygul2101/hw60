package kg.attractor.micro.repository;

import kg.attractor.micro.model.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, String> {
}

package kg.attractor.micro.repository;

import kg.attractor.micro.model.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, String> {
   /* public void deleteAllBy(String id, String email);

    public Iterable<User> findAll(Sort sort);
    public User findByName(String name);
    public User findByEmail(String email);

    boolean existsByEmail(String email);
    public Optional<User> findByUsername(String name);*/
}
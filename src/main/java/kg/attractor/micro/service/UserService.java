package kg.attractor.micro.service;



import kg.attractor.micro.model.User;
import kg.attractor.micro.repository.CommentRepository;
import kg.attractor.micro.repository.PostRepo;
import kg.attractor.micro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private CommentRepository commentRepo;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PostRepo postRepo;



 /*   public List<User> getUserList() {
        List<User> result = new ArrayList<>();
        userRepo.findAll().forEach(result::add);
        return result;
    }
    public User setUser(String name, String email, String password) {
        return userRepo.save(new User(name,email,password));
    }

    public Iterable<User> getUsers() { return userRepo.findAll(); }

    public Iterable<User> getName(String name) {
        return (Iterable<User>) userRepo.findByName(name);
    }


    public boolean existsEmail(String email) {
        return userRepo.existsByEmail(email);
    }

    public void removePostById(String id) {
        postRepo.deleteById(id);
    }*/

}

package kg.attractor.micro.controller;

import kg.attractor.micro.model.*;
import kg.attractor.micro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepo;

 /*   @DeleteMapping("/user/{id}")
    public User deleteUser(@PathVariable String id) {
        User user = userRepo.findById(id).orElse(new User());
        userRepo.deleteById(id);

        return user;
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id) {
        User user = userRepo.findById(id).orElse(new User());

        return user;
    }
*/
}

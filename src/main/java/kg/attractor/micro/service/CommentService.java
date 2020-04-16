package kg.attractor.micro.service;


import kg.attractor.micro.repository.CommentRepository;
import kg.attractor.micro.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class CommentService {
    private final CommentRepository commentRepo;
    private final UserRepository userRepo;

    public CommentService(CommentRepository commentRepo,UserRepository userRepo) {
        this.commentRepo = commentRepo;
        this.userRepo=userRepo;
    }


}

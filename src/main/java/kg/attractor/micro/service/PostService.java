package kg.attractor.micro.service;


import kg.attractor.micro.model.CandidatePercentVote;
import kg.attractor.micro.model.Post;
import kg.attractor.micro.repository.PostRepo;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PostService {
    private final PostRepo repository;

    public PostService(PostRepo repository) {
        this.repository = repository;
    }

    private static int calculatePercent(double votes, int totalVotes) {
        if (totalVotes == 0) {
            return 0;
        }

        if (votes == 0) {
            return 0;
        }

        return (int) ((votes / totalVotes) * 100);
    }

    public void voteFor(String candidateId) {
        var c = repository.findById(candidateId).orElse(Post.EMPTY);
        c.like();
        repository.save(c);
    }

    public Post getById(String candidateId) {
        return repository.findById(candidateId).orElse(Post.EMPTY);
    }

    private int getTotalVotes() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .mapToInt(Post::getLikes)
                .sum();
    }

    public int calculatePercentForOne(Post candidate) {
        var totalVotes = getTotalVotes();
        var votes = candidate.getLikes();

        return calculatePercent(votes, totalVotes);
    }

    public List<CandidatePercentVote> candidatesWithVotes() {
        var total = getTotalVotes();
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(c -> CandidatePercentVote.make(c, calculatePercent(c.getLikes(), total)))
                .sorted(Comparator.comparingInt(CandidatePercentVote::getLikes).reversed())
                .collect(Collectors.toList());
    }
}

package kg.attractor.micro.model;

public class CandidatePercentVote {
    private final String name;

    public String getName() {
        return name;
    }

    public String getPhoto() {
        return photo;
    }

    private final String photo;
    private final Integer likes;

    public CandidatePercentVote(Post post, Integer likes) {
        this.name = post.getName();
        this.photo = post.getPhoto();
        this.likes = likes;
    }

    public static CandidatePercentVote make(Post post, Integer votes) {
        return new CandidatePercentVote(post, votes);
    }

    public Integer getLikes() {
        return likes;
    }
}

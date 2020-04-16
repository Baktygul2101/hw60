package kg.attractor.micro.controller;

import kg.attractor.micro.model.Post;
import kg.attractor.micro.repository.PostRepo;
import kg.attractor.micro.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
public class PostController {
    private final PostService service;
    private final PostRepo repository;

    public PostController(PostRepo repository, PostService service) {
        this.repository = repository;
        this.service = service;
    }

    @GetMapping
    public String root(Model model) {
        model.addAttribute("posts", repository.findAll());
        return "posts";
    }

    @GetMapping("/post")
    public String rootGet(Model model) {
        return "addpost";
    }

    @PostMapping("/post")
    public String rootSave(@RequestParam("name") String name,
                           @RequestParam("photo") MultipartFile photo) throws IOException {
        String path = "../images";
        File photoFile = new File(path + "/" + photo.getOriginalFilename());
        FileOutputStream os = new FileOutputStream(photoFile);
        os.write(photo.getBytes());
        os.close();

        Post post = new Post(name, photo.getOriginalFilename());
        repository.save(post);

        return "success";
    }

    @GetMapping("/like")
    public String handleVotes(Model model) {
        model.addAttribute("posts", service.candidatesWithVotes());
        return "likes";
    }

    @GetMapping("/thankyou/{postId}")
    public String handleThankYou(@PathVariable String postId, Model model) {
        var post = service.getById(postId);
        model.addAttribute("post", post);
        model.addAttribute("likes", service.calculatePercentForOne(post));

        return "thankyou";
    }

    @PostMapping("/like")
    @ResponseStatus(HttpStatus.SEE_OTHER)
    public String handleRegisterVote(@RequestParam(defaultValue = "--no-value--") String postId) {
        service.voteFor(postId);
        return "redirect:/thankyou/" + postId;
    }

    @GetMapping("/demo")
    public String demo(Model model) {
        return "demo";
    }

    @PostMapping("/demo/post")
    public String postDemo(@RequestParam("login") String login, @RequestParam("password") String password) {
        System.out.println(login);
        System.out.println(password);
        return "redirect:/demo/";
    }

    @GetMapping("/image/{name}")
    @ResponseBody
    public ResponseEntity<byte[]> getImage(@PathVariable("name") String name) {
        String path = "../images";
        try {
            InputStream is = new FileInputStream(new File(path) + "/" + name);
            return ResponseEntity
                    .ok()
                    .contentType(name.toLowerCase().contains(".png")?MediaType.IMAGE_PNG:MediaType.IMAGE_JPEG)
                    .body(StreamUtils.copyToByteArray(is));
        } catch (Exception e) {
            InputStream is = null;
            try {
                is = new FileInputStream(new File(path) + "/" + name);
                return ResponseEntity
                        .ok()
                        .contentType(name.toLowerCase().contains(".png")?MediaType.IMAGE_PNG:MediaType.IMAGE_JPEG)
                        .body(StreamUtils.copyToByteArray(is));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping(value = "/image2/{name}", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] getImage2(@PathVariable("name") String name) {
        String path = "../images";
        try {
            InputStream is = new FileInputStream(new File(path) + "/" + name);
            return StreamUtils.copyToByteArray(is);
        } catch (Exception e) {
            InputStream is = null;
            try {
                is = new FileInputStream(new File(path) + "/" + name);
                return StreamUtils.copyToByteArray(is);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/posts")
    @ResponseBody
    public Iterable<Post> getCandidateList() {
        return repository.findAll();
    }

}

package com.survivingcodingbootcamp.blog.controller;

//import com.survivingcodingbootcamp.blog.model.Hashtag;
//import com.survivingcodingbootcamp.blog.model.Post;
//import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.storage.repository.PostRepository;
//import com.survivingcodingbootcamp.blog.storage.TopicStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/posts")
public class PostController {
    private PostRepository postRepo;
//    private TopicRepository topicRepo;

    public PostController(PostRepository postRepo) {
        this.postRepo = postRepo;
//        this.topicRepo = topicRepo
    }

    @GetMapping("/{id}")
    public String displaySinglePost(@PathVariable long id, Model model) {
        model.addAttribute("post", postRepo.findById(id).get());
        return "single-post-template";
    }

//    @PostMapping("/addPost")
//    public String addPostToTopic(@RequestParam String title, @RequestParam String topicId, @RequestParam String author, @RequestParam String content){
//        Long id = Long.parseLong(topicId);
//        Topic addTopic = topicStorage.retrieveSingleTopic(id);
//        Post addedPost = new Post(title, addTopic, author, content);
//        postStorage.save(addedPost);
//        topicStorage.addPostToTopic(id, addedPost);
//        return "redirect:/";
//    }

}

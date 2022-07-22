package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.Repository.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hashtags")
public class HashtagController {
    private HashtagRepository hashtagRepository;
    private PostRepository postRepository;

    private HashtagController(HashtagRepository hashtagRepository, PostRepository postRepository) {
        this.hashtagRepository = hashtagRepository;
        this.postRepository = postRepository;
    }

    @GetMapping("/{id}")
    public String showSingleHashtag(@PathVariable long id, Model model) {
        model.addAttribute("hashtag", hashtagRepository.retrieveHashtagById());
        return "single-hashtags-template";
    }

    @GetMapping("")
    public String showAllHashtags(Model model) {
        model.addAttribute("hashtags", hashtagRepository.retrieveAllHashtags());
        return "all-hashtags-template";
    }

    @PostMapping("/hashtag/post/{id}")
    public String showPostsInHashtag(Model model, @PathVariable long id) {
        model.addAttribute("post", postRepository.retrievePostById(id));
        model.addAttribute("allHashtags", hashtagRepository.retrieveAllHashtags());
        model.addAttribute("postInHash", postRepository.retrieveAllPosts());
        return "single-hashtag-template";
    }

    @PostMapping
    public String addHashtag(@RequestParam String newHashtag, @RequestParam Long postId) {
        Hashtag addedHashtag;
        if (newHashtag.length() > 0) {
            Hashtag existingHashtag = hashtagRepository.findHashtagByName(newHashtag);
            if (existingHashtag == null) {
                addedHashtag = new Hashtag(newHashtag);
                hashtagRepository.save(addedHashtag);
            } else {
                addedHashtag = existingHashtag;
            }

            Post post = postRepository.retrievePostById(postId);
            if (!post.hasHashtag(addedHashtag)) {
                post.addHashtag(addedHashtag);
                postRepository.save(post);
            }

            addedHashtag.addPost(post);
            hashtagRepository.save(addedHashtag);
        }
        return "redirect:/posts/" + postId;
    }
}


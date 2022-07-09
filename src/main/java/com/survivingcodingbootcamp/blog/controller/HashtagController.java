package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.storage.PostStorage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hashtags")
public class HashtagController {
    private HashtagStorage hashtagStorage;
    private PostStorage postStorage;

    private HashtagController(HashtagStorage hashtagStorage, PostStorage postStorage) {
        this.hashtagStorage = hashtagStorage;
        this.postStorage = postStorage;
    }

    @GetMapping("/{id}")
    public String showSingleHashtag(@PathVariable long id, Model model) {
        model.addAttribute("hashtag", hashtagStorage.retrieveHashtagById());
        return "single-hashtags-template";
    }

    @GetMapping("")
    public String showAllHashtags(Model model) {
        model.addAttribute("hashtags", hashtagStorage.retrieveAllHashtags());
        return "all-hashtags-template";
    }

    @PostMapping("/hashtag/post/{id}")
    public String showPostsInHashtag(Model model, @PathVariable long id) {
        model.addAttribute("post", postStorage.retrievePostById(id));
        model.addAttribute("allHashtags", hashtagStorage.retrieveAllHashtags());
        model.addAttribute("postInHash", postStorage.retrieveAllPosts());
        return "single-hashtag-template";
    }

    @PostMapping
    public String addHashtag(@RequestParam String newHashtag, @RequestParam Long postId) {
        Hashtag addedHashtag;
        if (newHashtag.length() > 0) {
            Hashtag existingHashtag = hashtagStorage.findHashtagByName(newHashtag);
            if (existingHashtag == null) {
                addedHashtag = new Hashtag(newHashtag);
                hashtagStorage.save(addedHashtag);
            } else {
                addedHashtag = existingHashtag;
            }

            Post post = postStorage.retrievePostById(postId);
            if (!post.hasHashtag(addedHashtag)) {
                post.addHashtag(addedHashtag);
                postStorage.save(post);
            }

            addedHashtag.addPost(post);
            hashtagStorage.save(addedHashtag);
        }
        return "redirect:/posts/" + postId;
    }
}


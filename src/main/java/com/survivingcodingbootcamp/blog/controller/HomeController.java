package com.survivingcodingbootcamp.blog.controller;

import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.Repository.TopicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController{
    private TopicRepository topicRepository;

    public HomeController(TopicRepository topicRepository){
        this.topicRepository = topicRepository;
    }

    @GetMapping("/")
    public String displayHomePage(Model model){
        model.addAttribute("topics", topicRepository.retrieveAllTopics());
        return "home-template";
    }
}

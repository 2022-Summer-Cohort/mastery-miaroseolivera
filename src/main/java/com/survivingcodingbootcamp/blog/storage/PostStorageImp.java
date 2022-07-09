package com.survivingcodingbootcamp.blog.storage;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.storage.repository.PostRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PostStorageImp implements PostStorage{
    //interface or class????
    @Resource
    private PostRepository postRepo;

    public PostStorageImp(PostRepository postRepo){
        this.postRepo = postRepo;
    }

    @Override
    public Iterable<Post> retrieveAllPosts(){
        return postRepo.findAll();
    }

    @Override
    public Post retrievePostById(long id){
        return postRepo.findById(id).get();
    }

    @Override
    public void save(Post postToAdd){
        postRepo.save(postToAdd);
    }}

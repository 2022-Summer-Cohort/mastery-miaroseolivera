package com.survivingcodingbootcamp.blog;

import com.survivingcodingbootcamp.blog.model.Hashtag;
import com.survivingcodingbootcamp.blog.model.Post;
import com.survivingcodingbootcamp.blog.model.Topic;
import com.survivingcodingbootcamp.blog.Repository.PostRepository;
import com.survivingcodingbootcamp.blog.Repository.TopicRepository;
import com.survivingcodingbootcamp.blog.Repository.repository.HashtagRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class Populator implements CommandLineRunner {

    private TopicRepository topicRepository;
    private PostRepository postRepository;
    private HashtagRepository hashtagRepository;


    public Populator(TopicRepository topicRepository, PostRepository postRepository, HashtagRepository hashtagRepository) {

        this.topicRepository = topicRepository;
        this.postRepository = postRepository;
        this.hashtagRepository = hashtagRepository;
    }

    @Override
    public void run(String...args)throws Exception{
        Hashtag bootCamp = new Hashtag("#bootCamp");
        hashtagRepository.save(bootCamp);
        Hashtag imposterSyndromeIsReal = new Hashtag("#mvcHurtsMyBrain");
        hashtagRepository.save(mvcHurtsMyBrain);
        Hashtag learningJava = new Hashtag("#Java");
        hashtagRepository.save(Java);
        Hashtag oOP = new Hashtag("#HTML");
        hashtagRepository.save(HTML);
        Hashtag tddIsAnnoying = new Hashtag("#CSS");
        hashtagRepository.save(CSS);
        Hashtag hardWorkPaysOff = new Hashtag("#studyBuddy");
        hashtagRepository.save(studyBuddy);

//  POSTS---------------------------------------------------------------------------------------------------------

        Topic topic1 = new Topic("Tutoring");
        topicRepository.save(topic1);
        Post post1 = new Post("Take Advantage of Tutoring!", topic1,"Tohru Honda","Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
                "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id " +
                "est laborum.",studyBuddy,bootCamp,Java);
        postRepository.save(post1);

        Post post2 = new Post("What Even Is MVC???", topic1, "Peter Parker","Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
                "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id " +
                "est laborum.",bootCamp,mvcHurtsMyBrain,studyBuddy);
        postRepository.save(post2);

        Post post3 = new Post("HTML", topic1, "Fermin Olivera","Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
                "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id " +
                "est laborum.",bootCamp,HTML);
        postRepository.save(post3);


        Topic topic2 = new Topic("CSS");
        topicRepository.save(topic2);
        Post post4 = new Post("I love to make things look pretty :)",topic2,"Mia Olivera","Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
                "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id " +
                "est laborum.",CSS,bootCamp);
        postRepository.save(post4);

        Topic topic3 = new Topic("Meat and Taters");
        topicRepository.save(topic3);
        Post post5 = new Post("a little bit of everything",topic3,"John Mayer","Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
                "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id " +
                "est laborum.",learningJava,bootCamp,hardWorkPaysOff);
        postRepository.save(post5);

        Topic topic4 = new Topic("Concatenation???");
        topicRepository.save(topic4);
        Post post6 = new Post("Think of a cat",topic4,"Kyo Sohma","Lorem ipsum dolor sit amet, consectetur " +
                "adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim" +
                " veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis " +
                "aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. " +
                "Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id " +
                "est laborum.",Java,bootCamp,studyBuddy);
        postRepository.save(post6);
    }
}
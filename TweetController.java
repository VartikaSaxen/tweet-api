package com.api.TweeterDemo_1;
import java.util.List;

import org.apache.tomcat.util.descriptor.web.ContextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TweetController {
    @Autowired
    private TweetService tweetService;

    @GetMapping("/search")
    public List<Tweet> searchTweets(@RequestParam String query) {
        return tweetService.searchTweets(query);
    }

    @GetMapping("/user/{screenName}")
    public List<Tweet> getUserTweets(@PathVariable String screenName) {
        return tweetService.getUserTweets(screenName);
    }
}


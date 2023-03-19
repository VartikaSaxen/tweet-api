package com.api.TweeterDemo_1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TweetService {
    @Autowired
    private Twitter twitter;

    public List<Tweet> searchTweets(String query) {
        SearchParameters searchParameters = new SearchParameters(query);
        searchParameters.count(10);
        searchParameters.resultType(SearchParameters.ResultType.RECENT);
        searchParameters.lang("en");

        return twitter.searchOperations().search(searchParameters).getTweets();
    }

    public List<Tweet> getUserTweets(String screenName) {
        return twitter.timelineOperations().getUserTimeline(screenName);
    }
}

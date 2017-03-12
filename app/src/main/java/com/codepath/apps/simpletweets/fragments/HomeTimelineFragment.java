package com.codepath.apps.simpletweets.fragments;

import android.os.Bundle;

import com.codepath.apps.simpletweets.TwitterApplication;
import com.codepath.apps.simpletweets.TwitterClient;
import com.codepath.apps.simpletweets.models.Tweet;

import java.util.List;

import static com.activeandroid.Cache.clear;
import static java.util.Collections.addAll;

/**
 * Created by YichuChen on 3/12/17.
 */

public class HomeTimelineFragment extends TweetListFragment {
    private TwitterClient client;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = TwitterApplication.getRestClient();
        populateWithLatestTweets();
    }

    @Override
    public void populateWithLatestTweets() {
        client.getHomeTimeline(new TwitterClient.TimelineResponseHandler() {
            @Override
            public void onSuccess(List<Tweet> tweets) {
                clear();
                addAll(tweets);
                showLatest();
            }

            @Override
            public void onFailure(Throwable error) {
                logError(error);
            }
        });
    }

    @Override
    public void populateWithOlderTweets(Long oldestTweetId) {
        client.getOlderHomeTimeline(new TwitterClient.TimelineResponseHandler() {
            @Override
            public void onSuccess(List<Tweet> tweets) {
                addAll(tweets.isEmpty() ? tweets : tweets.subList(1, tweets.size()));
            }

            @Override
            public void onFailure(Throwable error) {
                logError(error);
            }
        }, oldestTweetId);
    }

    private void logError(Throwable error) {
        Log.d("HOME_TIMELINE", "Failed to retrieve tweets", error);
    }

}

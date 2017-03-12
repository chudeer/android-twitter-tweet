package com.codepath.apps.simpletweets.fragments;

import android.os.Bundle;

import com.codepath.apps.simpletweets.TwitterApplication;
import com.codepath.apps.simpletweets.TwitterClient;
import com.codepath.apps.simpletweets.models.Tweet;

import java.util.List;

import static com.activeandroid.Cache.clear;

/**
 * Created by YichuChen on 3/10/17.
 */

public class SearchFragment extends TweetListFragment {
    private TwitterClient client;
    private String query;
    private Long maxId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = TwitterApplication.getRestClient();
        query = getArguments().getString(com.codepath.apps.twitter.constants.Extras.QUERY);
        populateWithLatestTweets();
    }

    public static SearchFragment newInstance(String query) {
        SearchFragment fragmentSearch = new SearchFragment();
        Bundle args = new Bundle();
        args.putString(com.codepath.apps.twitter.constants.Extras.QUERY, query);
        fragmentSearch.setArguments(args);
        return fragmentSearch;
    }

    @Override
    public void populateWithLatestTweets() {
        client.searchTweets(query, new TwitterClient.SearchResultsResponseHandler() {
            @Override
            public void onSuccess(SearchResults searchResults) {
                List<Tweet> tweets = searchResults.getTweets();
                maxId = searchResults.getMetaData().getMaxId();
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
        client.searchOlderTweets(new TwitterClient.SearchResultsResponseHandler() {
            @Override
            public void onSuccess(SearchResults searchResults) {
                List<Tweet> tweets = searchResults.getTweets();
                maxId = searchResults.getMetaData().getMaxId();
                addAll(tweets.isEmpty() ? tweets : tweets.subList(1, tweets.size()));
            }

            @Override
            public void onFailure(Throwable error) {
                logError(error);
            }
        }, query, maxId);
    }

    private void logError(Throwable error) {
        Log.d("SEARCH", "Failed to retrieve tweets", error);
    }

}

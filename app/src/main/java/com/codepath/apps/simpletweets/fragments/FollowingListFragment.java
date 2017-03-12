package com.codepath.apps.simpletweets.fragments;

import android.os.Bundle;
import android.util.Log;

import com.codepath.apps.simpletweets.TwitterApplication;
import com.codepath.apps.simpletweets.TwitterClient;
import com.codepath.apps.simpletweets.models.TwitterUser;
import com.codepath.apps.simpletweets.constants.Extras;
import com.codepath.apps.simpletweets.models.TwitterUser;
import com.codepath.apps.simpletweets.models.UserListResults;
import java.util.List;

import static com.activeandroid.Cache.clear;

/**
 * Created by YichuChen on 3/10/17.
 */

public class FollowingListFragment extends UserListFragment {
    private TwitterClient client;
    private Long userId;
    private Long nextCursor;

    public static FollowingListFragment newInstance(Long userId) {
        FollowingListFragment fragment = new FollowingListFragment();
        Bundle args = new Bundle();
        args.putLong(com.codepath.apps.twitter.constants.Extras.USER_ID, userId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = TwitterApplication.getRestClient();
        userId = getArguments().getLong(com.codepath.apps.twitter.constants.Extras.USER_ID);
        populateWithUsers();
    }

    @Override
    public void populateWithUsers() {
        populateWithUsers(userId);
    }

    public void populateWithUsers(Long userId) {
        this.userId = userId;
        client.getFollowingList(userId, new TwitterClient.UserListResponseHandler() {
            @Override
            public void onSuccess(UserListResults userListResults) {
                nextCursor = userListResults.getNextCursor();
                clear();
                addAll(userListResults.getUsers());
                showLatest();
            }

            @Override
            public void onFailure(Throwable error) {
                logError(error);
            }
        });
    }

    @Override
    public void populateWithMoreUsers() {
        client.getFollowingList(userId, nextCursor, new TwitterClient.UserListResponseHandler() {
            @Override
            public void onSuccess(UserListResults userListResults) {
                nextCursor = userListResults.getNextCursor();
                List<TwitterUser> users = userListResults.getUsers();
                addAll(users.isEmpty() ? users : users.subList(1, users.size()));
            }

            @Override
            public void onFailure(Throwable error) {
                logError(error);
            }
        });
    }

    private void logError(Throwable error) {
        Log.d("FOLLOWING_LIST", "Failed to retrieve following list", error);
    }
}

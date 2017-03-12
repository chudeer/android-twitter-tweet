package com.codepath.apps.simpletweets.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by YichuChen on 3/12/17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class Relationship {
    private FriendshipSource source;

    public FriendshipSource getSource() {
        return source;
    }
}


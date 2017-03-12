package com.codepath.apps.simpletweets.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by YichuChen on 3/10/17.
 */


@JsonIgnoreProperties(ignoreUnknown = true)
public class FriendshipSource {
    private Long id;
    private boolean following;
    @JsonProperty("followed_by")
    private boolean followedBy;

    public Long getId() {
        return id;
    }

    public boolean isFollowing() {
        return following;
    }

    public boolean isFollowedBy() {
        return followedBy;
    }
}

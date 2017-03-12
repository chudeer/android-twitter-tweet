package com.codepath.apps.simpletweets.models;

/**
 * Created by YichuChen on 3/10/17.
 */



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserListResults {
    @JsonProperty("previous_cursor")
    private Long previousCursor;
    @JsonProperty("next_cursor")
    private Long nextCursor;
    private List<TwitterUser> users;

    public Long getPreviousCursor() {
        return previousCursor;
    }

    public Long getNextCursor() {
        return nextCursor;
    }

    public List<TwitterUser> getUsers() {
        return users;
    }
}

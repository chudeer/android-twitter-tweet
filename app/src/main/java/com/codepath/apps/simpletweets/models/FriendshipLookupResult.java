package com.codepath.apps.simpletweets.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by YichuChen on 3/10/17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class FriendshipLookupResult {
    private Relationship relationship;

    public Relationship getRelationship() {
        return relationship;
    }
}

package com.codepath.apps.simpletweets.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by YichuChen on 3/12/17.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchMetaData {
    @JsonProperty("max_id")
    private Long maxId;
    @JsonProperty("since_id")
    private Long sinceId;
    private int count;

    public Long getMaxId() {
        return maxId;
    }

    public Long getSinceId() {
        return sinceId;
    }

    public int getCount() {
        return count;
    }
}

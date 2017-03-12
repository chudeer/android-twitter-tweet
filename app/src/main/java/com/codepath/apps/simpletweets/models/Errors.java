package com.codepath.apps.simpletweets.models;

/**
 * Created by YichuChen on 3/5/17.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Errors {
    private List<ErrorMessage> errors;

    public List<ErrorMessage> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorMessage> errors) {
        this.errors = errors;
    }
}

package com.codepath.apps.simpletweets.listeners;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.codepath.apps.simpletweets.R;
import com.codepath.apps.simpletweets.models.Tweet;

public interface OnTweetReplyClickListener {

    void onTweetReplyClick(Tweet tweet);

}

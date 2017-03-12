package com.codepath.apps.simpletweets.listeners;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.codepath.apps.simpletweets.R;
import com.codepath.apps.simpletweets.models.TwitterUser;

public interface OnUserProfileClickListener {

    void onUserProfileClick(TwitterUser user);

}

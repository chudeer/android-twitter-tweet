package com.codepath.apps.simpletweets.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.codepath.apps.simpletweets.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.codepath.apps.simpletweets.R;
import com.codepath.apps.simpletweets.constants.Extras;
import com.codepath.apps.simpletweets.fragments.SearchFragment;

public class SearchActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        String query = getIntent().getStringExtra(Extras.QUERY);
        if (savedInstanceState == null) {
            populateSearchResults(query);
        }
    }

    private void populateSearchResults(String query) {
        SearchFragment fragmentSearch = SearchFragment.newInstance(query);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flContainer, fragmentSearch);
        ft.commit();
    }

    @Override
    protected void showAuthenticatedUserProfile() {
        Intent intent = new Intent(SearchActivity.this, ProfileActivity.class);
        intent.putExtra(Extras.USER_ID, authenticatedUser.getId());
        startActivity(intent);
    }

    @Override
    protected void showSearchResults(String query) {
        populateSearchResults(query);
    }

    @Override
    protected String getTag() {
        return "SEARCH";
    }

    @Override
    public void showLatestHomeTimelineTweets() {
        startActivity(new Intent(this, TimelineActivity.class));
    }

}

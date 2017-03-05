package com.codepath.apps.simpletweets;

import android.content.Context;

/*
 * This is the Android application itself and is used to configure various settings
 * including the image cache in memory and on disk. This also adds a singleton
 * for accessing the relevant rest client.
 *
 *     RestClient client = RestApplication.getRestClient();
 *     // use client to send requests to API
 *
 */
public class TwitterApplication extends com.activeandroid.app.Application {
	private static Context context;

	@Override
	public void onCreate() {
		super.onCreate();
		TwitterApplication.context = this;
	}

	public static com.codepath.apps.twitter.TwitterClient getRestClient() {
		return (com.codepath.apps.twitter.TwitterClient) com.codepath.apps.twitter.TwitterClient.getInstance(com.codepath.apps.twitter.TwitterClient.class, TwitterApplication.context);
	}
}
/**
* Copyright (C) 2012-2015 Remco Beugels
* 
* Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
* 
* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
* 
* THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package com.remcob00.cordova.youtube;

import android.app.Activity;
import android.content.Intent;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeStandalonePlayer;

import java.util.ArrayList;
import java.util.List;

public class YouTube extends CordovaPlugin {
	
	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		cordova.setActivityResultCallback(YouTube.this);

		if(action.equals("playVideo")) {
			if(args.length() == 2) {
				Intent youtubeIntent = YouTubeStandalonePlayer.createVideoIntent(cordova.getActivity(), args.getString(0), args.getString(1));
				cordova.startActivityForResult(this, youtubeIntent, 2300010);

				return true;
			}
			else if(args.length() == 5) {
				Intent youtubeIntent = YouTubeStandalonePlayer.createVideoIntent(cordova.getActivity(), args.getString(0), args.getString(1), args.getInt(2), args.getBoolean(3), args.getBoolean(4));
				cordova.startActivityForResult(this, youtubeIntent, 2300010);

				return true;
			}
			else {
				return false;
			}
		}
		else if(action.endsWith("playPlaylist")) {
			if(args.length() == 2) {
				Intent youtubeIntent = YouTubeStandalonePlayer.createPlaylistIntent(cordova.getActivity(), args.getString(0), args.getString(1));
				cordova.startActivityForResult(this, youtubeIntent, 2300010);

				return true;
			}
			else if(args.length() == 6) {
				Intent youtubeIntent = YouTubeStandalonePlayer.createPlaylistIntent(cordova.getActivity(), args.getString(0), args.getString(1), args.getInt(2), args.getInt(3), args.getBoolean(4), args.getBoolean(5));
				cordova.startActivityForResult(this, youtubeIntent, 2300010);

				return true;
			}
			else {
				return false;
			}
		}
		else if(action.endsWith("playVideos")) {
			List<String> videos = new ArrayList<String>();

			for(int i = 0; i < args.getJSONArray(1).length(); i++) {
				videos.add(args.getJSONArray(1).getString(i));
			}

			if(args.length() == 2) {
				Intent youtubeIntent = YouTubeStandalonePlayer.createVideosIntent(cordova.getActivity(), args.getString(0), videos);
				cordova.startActivityForResult(this, youtubeIntent, 2300010);

				return true;
			}
			else if(args.length() == 6) {
				Intent youtubeIntent = YouTubeStandalonePlayer.createVideosIntent(cordova.getActivity(), args.getString(0), videos, args.getInt(2), args.getInt(3), args.getBoolean(4), args.getBoolean(5));
				cordova.startActivityForResult(this, youtubeIntent, 2300010);

				return true;
			}
			else {
				return false;
			}
		}

		return false;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);

		if(requestCode == 23100010 && resultCode != Activity.RESULT_OK) {
			YouTubeInitializationResult result = YouTubeStandalonePlayer.getReturnedInitializationResult(intent);

			if(result.isUserRecoverableError()) {
				result.getErrorDialog(cordova.getActivity(), 0).show();
			}
		}
	}
}
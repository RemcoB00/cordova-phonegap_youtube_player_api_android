# Cordova / Phonegap YouTube Android Player API plugin
Developed by [Remco Beugels](http://remcobeugels.com/)

## Installation
### Automatic installation with npm
* Navigate to the main folder of your Cordova / Phonegap app.
* Run the following command:
```
npm install remcob00-cordova-youtube-android-player-api
```
That's all, the plugin is now succesfully added to your app!
### Manual installation
* Download the [latest release](https://github.com/RemcoB00/cordova-phonegap_youtube_player_api_android/releases/latest) of this plugin.
* Download the YouTube Android Player API library [here](https://developers.google.com/youtube/android/player/downloads/) from the Google Developers site.
* Unzip this file and copy the `libs/YouTubeAndroidPlayerApi.jar` file to the `src/android` folder from the plugin.
* Navigate to the main folder of your Cordova / Phonegap app.
* Run the following command:
```
cordova plugin add /PATH_FROM_THE_PLUGIN_FOLDER
```
The plugin is now succesfully manual added to your app!

## How to use
### Setting the api key
The YouTube Android Player API requires an api key, you can find the instructions to register an api key [here](https://developers.google.com/youtube/android/player/register). You need to set the api key, before you can play a video, with the following JavaScript code:
```
window.youtube.init("YOUR_API_KEY");
```

### Play a single video
You can use the following JavaScript code to play a single YouTube video:
```
window.youtube.playVideo("YOUTUBE_VIDEO_ID");
```
You can also add the start time in milliseconds (number), auto play (boolean) and lightbox mode (boolean) parameters:
```
window.youtube.playVideo("YOUTUBE_VIDEO_ID", START_TIME, AUTO_PLAY, LIGHTBOX_MODE);
```

### Play a playlist
You can use the following JavaScript code to play a YouTube playlist:
```
window.youtube.playPlaylist("YOUTUBE_PLAYLIST_ID");
```
You can also add the start index (number), start time in milliseconds (number), auto play (boolean) and lightbox mode (boolean) parameters:
```
window.youtube.playPlaylist("YOUTUBE_PLAYLIST_ID", START_INDEX, START_TIME, AUTO_PLAY, LIGHTBOX_MODE);
```

### Play multiple videos
You can use the following JavaScript code to play multiple YouTube videos:
```
window.youtube.playVideos(["YOUTUBE_VIDEO_ID", "YOUTUBE_VIDEO_ID", "YOUTUBE_VIDEO_ID"]);
```
You can also add the start index (number), start time in milliseconds (number), auto play (boolean) and lightbox mode (boolean) parameters:
```
window.youtube.playVideos(["YOUTUBE_VIDEO_ID", "YOUTUBE_VIDEO_ID", "YOUTUBE_VIDEO_ID"], START_INDEX, START_TIME, AUTO_PLAY, LIGHTBOX_MODE);
```

### Example
You can find a full example of the plugin in [example.html](https://github.com/RemcoB00/cordova-phonegap_youtube_player_api_android/blob/master/example.html).

## Changelog
#### 2.0.1 - 2.0.6 (20/06/2015)
* Npm automatic installation bug fixes.

#### 2.0.0 (20/06/2015)
* Completely rewritten for the newest version of Cordova / Phonegap.
* Playlist support.
* Custom start time, auto play and lightbox mode support.

#### 1.0.0 (29/12/2012)
* First release.

## Support
If you want to thank me for developing this plugin you can buy me a coffee via [PayPal](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=PYNGRKPD4YTEJ).

## License
Copyright (C) 2012-2015 Remco Beugels

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

var exec = require('cordova/exec');

module.exports = {
	apiKey: null,

	init: function(apiKey) {
		this.apiKey = apiKey;
	},

	playVideo: function(videoId, time, autoPlay, lightboxMode) {
		if(this.apiKey == null) {
        	console.log("The YouTube API key is not set with youtube.init().");
        	return;
        }

		if(typeof videoId !== "string") {
			console.log("No YouTube video id is given.");
			return;
		}

		var options = [this.apiKey, videoId];

		if(typeof time === "number" && time >= 0 && time%1 == 0 && typeof autoPlay === "boolean" && typeof lightboxMode === "boolean") {
			options.push(time, autoPlay, lightboxMode);
		}

		exec(null, null, "youtube", "playVideo", options);
	},

	playPlaylist: function(playlistId, startIndex, time, autoPlay, lightboxMode) {
		if(this.apiKey == null) {
        	console.log("The YouTube API key is not set with youtube.init().");
        	return;
        }

        if(typeof playlistId !== "string") {
        	console.log("No YouTube playlist video id is given.");
        	return;
        }

        var options = [this.apiKey, playlistId];

        if(typeof startIndex === "number" && startIndex >= 0 && startIndex%1 == 0 && typeof time === "number" && time >= 0 && time%1 == 0 && typeof autoPlay === "boolean" && typeof lightboxMode === "boolean") {
        	options.push(startIndex, time, autoPlay, lightboxMode);
        }

        exec(null, null, "youtube", "playPlaylist", options);
	},

	playVideos: function(videos, startIndex, time, autoPlay, lightboxMode) {
		if(this.apiKey == null) {
        	console.log("The YouTube API key is not set with youtube.init().");
        	return;
        }

        if(!Array.isArray(videos)) {
        	console.log("No list with YouTube ids is given.");
        	return;
        }

        var options = [this.apiKey, videos];

        if(typeof startIndex === "number" && startIndex >= 0 && startIndex%1 == 0 && typeof time === "number" && time >= 0 && time%1 == 0 && typeof autoPlay === "boolean" && typeof lightboxMode === "boolean") {
        	options.push(startIndex, time, autoPlay, lightboxMode);
       	}

       	exec(null, null, "youtube", "playVideos", options);
	}
}
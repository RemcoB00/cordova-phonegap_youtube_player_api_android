var http = require("https");
var AdmZip = require("adm-zip");

console.log("Installing the Cordova / Phonegap YouTube Android Player API");

console.log("Downloading the YouTube Android Player API library from the YouTube developer site...");

http.get("https://developers.google.com/youtube/android/player/downloads/YouTubeAndroidPlayerApi-1.2.1.zip", function(response) {
	var data = [];
	var dataLength = 0;
	
	response.on('data', function(chunk) {
		data.push(chunk);
		dataLength += chunk.length;
	});
	
	response.on('end', function() {
		console.log("Unzipping the YouTube Android Player API library...");
		
		var buffer = new Buffer(dataLength);
		
		for(var i = 0, length = data.length, position = 0; i < length; i++) {
			data[i].copy(buffer, position);
			position += data[i].length;
		}
		
		var zip = new AdmZip(buffer);
		var zipEntries = zip.getEntries();
		
		zip.extractEntryTo("libs/YouTubeAndroidPlayerApi.jar", "src/android", false, true);
		
		console.log("The YouTube Android Player API library is loaded successfully!");
	});
});
/**
 * 
 * Cordova / Phonegap YouTube Embed API Plugin
 * Remco Beugels (RemcoB00) 2012
 *
 */

var YouTube = function() {};
            
YouTube.prototype.show = function(content, success, fail) {
    return cordova.exec( function(args) {
        success(args);
    }, function(args) {
        fail(args);
    }, 'YouTube', '', [content]);
};

if(!window.plugins) {
    window.plugins = {};
}
if (!window.plugins.youtube) {
    window.plugins.youtube = new YouTube();
}

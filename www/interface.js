window.SoftInputMode = {
    set: function(value) { cordova.exec(function() {}, console.log, "SoftInputMode", "set", [value]); }
};
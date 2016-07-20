var log = function(val) {
    console.log(val);
}

module.exports = {
    get: function(callback) { cordova.exec(callback, callback, "SoftInputMode", "get", [])},
    set: function(value) { cordova.exec(log, log, "SoftInputMode", "set", [value]); }
};
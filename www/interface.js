var log = function(val) {
    console.log(val);
}

module.exports = {
    set: function(value) { cordova.exec(log, log, "SoftInputMode", "set", [value]); }
};
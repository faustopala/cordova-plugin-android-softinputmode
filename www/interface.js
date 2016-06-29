module.exports = {
    set: function(value) { cordova.exec(console.log, console.log, "SoftInputMode", "set", [value]); }
};
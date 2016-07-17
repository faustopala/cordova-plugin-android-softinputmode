# cordova-plugin-android-softinputmode

This plugin lets you change the [android:windowSoftInputMode property](https://developer.android.com/guide/topics/manifest/activity-element.html#wsoft) at runtime.

Currently only `adjustPan`, `adjustResize` and `adjustNothing` values are supported.

## Example
After the `deviceready` event:

` window.SoftInputMode.set('adjustNothing')`
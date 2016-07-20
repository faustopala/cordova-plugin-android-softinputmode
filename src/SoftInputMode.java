package dk.sculpto.plugin;

import android.app.Activity;
import android.view.WindowManager;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * This class echoes a string called from JavaScript.
 */
public class SoftInputMode extends CordovaPlugin {
	private String softInputMode;

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if(action.equals("set")) {
			String value = args.getString(0);
			this.set(value, callbackContext);
			return true;
		} else if(action.equals("get")) {
			if(softInputMode != null)
				callbackContext.success(softInputMode);
			else callbackContext.error("Not set");
			return true;
		}
		return false;
	}

	private void set(String value, final CallbackContext callbackContext) {
		final int mode;
		if(value.equals("adjustNothing"))
			mode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING;
		else if(value.equals("adjustResize"))
			mode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE;
		else if(value.equals("adjustPan"))
			mode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN;
		else {
			callbackContext.error("Invalid mode");
			return;
		}

		softInputMode = value;

		final Activity activity = cordova.getActivity();
		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {
				activity.getWindow().setSoftInputMode(mode);
				callbackContext.success("Success");

			}
		});
	}
}
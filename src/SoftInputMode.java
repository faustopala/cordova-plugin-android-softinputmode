package dk.sculpto.plugin;

import android.view.WindowManager;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

/**
 * This class echoes a string called from JavaScript.
 */
public class SoftInputMode extends CordovaPlugin {

	@Override
	public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		if (action.equals("set")) {
			String value = args.getString(0);
			this.set(value, callbackContext);
			return true;
		}
		return false;
	}

	private void set(String value, CallbackContext callbackContext) {
		int mode = 0;
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

		cordova.getActivity().getWindow().setSoftInputMode(mode);
		callbackContext.success();
	}
}
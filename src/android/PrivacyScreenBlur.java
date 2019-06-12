package cordova.plugin.privacy.screen.blur;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaWebView;

import android.view.Window;
import android.view.WindowManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * This class echoes a string called from JavaScript.
 */
public class PrivacyScreenBlur extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }

    @Override
    public void onPause(boolean multitasking) {
      Window window = this.cordova.getActivity().getWindow();
      window.setFlags(WindowManager.LayoutParams.FLAG_SECURE,WindowManager.LayoutParams.FLAG_SECURE);
      super.onPause(multitasking);
    }
  
    @Override
    public void onResume(boolean multitasking) {
      Window window = this.cordova.getActivity().getWindow();
      window.clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
      super.onResume(multitasking);
    }
}

package fr.hack_my_domain.wifi.hotspot.on.charge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;

public class WifiApmReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        assert action != null;
        if ("android.net.wifi.WIFI_AP_STATE_CHANGED".equals(action)) {
            checkWifi(context);
        }
    }

    public void checkWifi(Context context) {
        if (!ApManager.isApOn(context)) {
            MainActivity.activityManager.wifiIsOff();
            makeText(context, "MainActivity.activityManager.wifiIsOff()", LENGTH_SHORT).show();
        } else {
            MainActivity.activityManager.wifiIsOn();
            makeText(context, "MainActivity.activityManager.wifiIsOn()", LENGTH_SHORT).show();
        }
    }
}

package fr.hack_my_domain.wifi.hotspot.on.charge;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;
import static fr.hack_my_domain.wifi.hotspot.on.charge.ApManager.configApState;
import static fr.hack_my_domain.wifi.hotspot.on.charge.ApManager.isApOn;

public class PlugInControlReceiver extends BroadcastReceiver {
    private Context myContext;

    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        myContext = context;

        makeText(myContext, "onReceive(Context context, Intent intent)", LENGTH_SHORT).show();

        assert action != null;
        if (action.equals(Intent.ACTION_POWER_CONNECTED)) {
            // Do something when power connected
            if (startWifiHotspot()) {
                makeText(myContext, "startWifiHotspot()", LENGTH_SHORT).show();
            }
        } else if (action.equals(Intent.ACTION_POWER_DISCONNECTED)) {
            // Do something when power disconnected
            if (stopWifiHotspot()) {
                makeText(myContext, "stopWifiHotspot()", LENGTH_SHORT).show();
            }
        }
    }

    private boolean startWifiHotspot() {
        /* MainActivity.this */
        // Check Ap state :boolean
        // Change Ap state :boolean
        return isApOn(myContext) || configApState(myContext);
    }

    private boolean stopWifiHotspot() {
        /* MainActivity.this */
        // Check Ap state :boolean
        // Change Ap state :boolean
        return !isApOn(myContext) || configApState(myContext);
    }
}
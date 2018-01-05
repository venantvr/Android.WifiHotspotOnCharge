package fr.hack_my_domain.wifi.hotspot.on.charge;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

class ActivityManager {

    private MainActivity activity;

    ActivityManager(Context context) {
        activity = (MainActivity) context;
    }

    void wifiIsOn() {
        activity.getWindow().getDecorView().setBackgroundColor(Color.GREEN);
        activity.getWindow().findViewById(R.id.imageViewEnabled).setVisibility(View.VISIBLE);
        activity.getWindow().findViewById(R.id.imageViewDisabled).setVisibility(View.INVISIBLE);
    }

    void wifiIsOff() {
        activity.getWindow().getDecorView().setBackgroundColor(Color.RED);
        activity.getWindow().findViewById(R.id.imageViewEnabled).setVisibility(View.INVISIBLE);
        activity.getWindow().findViewById(R.id.imageViewDisabled).setVisibility(View.VISIBLE);
    }
}

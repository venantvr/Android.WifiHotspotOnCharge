package fr.hack_my_domain.wifi.hotspot.on.charge;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {

    static final int ACTION_MANAGE_WRITE_SETTINGS_REQUEST = 1;

    @SuppressLint("StaticFieldLeak")
    static ActivityManager activityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityManager = new ActivityManager(MainActivity.this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Settings.System.canWrite(MainActivity.this)) {
                // Do stuff here
                // if (startWifiHotspot()) getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                makeText(MainActivity.this, "Settings.System.canWrite(MainActivity.this))", Toast.LENGTH_SHORT).show();

            } else {
                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                intent.setData(Uri.parse("package:" + this.getPackageName()));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivityForResult(intent, ACTION_MANAGE_WRITE_SETTINGS_REQUEST);
            }
        }

        new WifiApmReceiver().checkWifi(MainActivity.this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == ACTION_MANAGE_WRITE_SETTINGS_REQUEST) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                makeText(MainActivity.this, "onActivityResult(int requestCode, int resultCode, Intent data)", Toast.LENGTH_SHORT).show();
            }
        }
    }
}

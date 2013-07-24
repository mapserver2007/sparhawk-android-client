package com.mapserver.sparhawk;

import android.app.Activity;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    /** ロケーション */
    private LocationController location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 位置情報を取得
        LocationManager manager = (LocationManager) getSystemService(LOCATION_SERVICE);
        location = new LocationController(manager);
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("sparhawk", "resume");
        location.update();
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("sparhawk", "pause");
        location.remove();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void onCurrentLocation(View view) {
        TextView text = (TextView) findViewById(R.id.textView1);
        text.setText("kita-");
    }

}

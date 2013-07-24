package com.mapserver.sparhawk;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.content.Context;

public class LocationController {
    /** ロケーションマネージャ */
    private LocationManager manager;
    /** ロケーションリスナー */
    private LocationListener listener;
    
    public LocationController(LocationManager manager) {
        // TODO LocationManagerをInject？
        this.manager = manager;
        listener = new LocationListener() {
            
            public void onProviderEnabled(String provider) {
                
            }
            
            public void ProviderDisabled(String provider) {
                
            }
            
            public void onStatusChanged(String provider, int status, Bundle extras) {
                
            }

            @Override
            public void onLocationChanged(Location location) {
                Log.i("sparhawk", String.valueOf(location.getLongitude()));
                Log.i("sparhawk", String.valueOf(location.getLatitude()));
            }

            @Override
            public void onProviderDisabled(String arg0) {
                // TODO 自動生成されたメソッド・スタブ
                
            }
        };
    }
    
    public void update() {
        // TODO 距離の設定は画面上から取れるようにする
        manager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, listener);
    }
    
    public void remove() {
        manager.removeUpdates(listener);
    }
    


}

package com.example.workers;

import android.app.Application;
import android.os.Build;

import com.example.workers.network.TLSSocketFactory;

import javax.net.ssl.HttpsURLConnection;

public class MyApplication extends Application {

    @Override
    public void onCreate()
    {
        super.onCreate();
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            HttpsURLConnection.setDefaultSSLSocketFactory(new TLSSocketFactory());
        }

    }
}

package com.happy.screenshot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ScreenShotListenManager screenShotListenManager = ScreenShotListenManager.newInstance(this);
        screenShotListenManager.setListener(new ScreenShotListenManager.OnScreenShotListener() {
            @Override
            public void onShot(String imagePath) {
                System.out.println(imagePath);
            }
        });
        screenShotListenManager.startListen();
    }
}

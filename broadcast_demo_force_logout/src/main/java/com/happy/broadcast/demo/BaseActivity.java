package com.happy.broadcast.demo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AlertDialog;

/**
 * Created by zhonglongquan on 2017/4/7.
 */

public class BaseActivity extends Activity {

    private LocalBroadcastManager localBroadcastManager;

    private LogoutReceiver logoutReceiver;

    private IntentFilter intentFilter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        intentFilter = new IntentFilter("com.happy.demo.action.logout");
    }

    @Override
    protected void onResume() {
        if (logoutReceiver == null) {
            logoutReceiver = new LogoutReceiver();
            /*localBroadcastManager.*/
            registerReceiver(logoutReceiver, intentFilter);
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (logoutReceiver != null) {
            /*localBroadcastManager.*/
            unregisterReceiver(logoutReceiver);
            logoutReceiver = null;
        }
    }

    class LogoutReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(final Context context, Intent intent) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setCancelable(false);
            builder.setTitle("提示");
            builder.setMessage("您在异地登陆，本次强制退出，请重新登陆");
            builder.setPositiveButton("我知道了", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                    Intent loginIntent = new Intent(context, LoginActivity.class);
                    startActivity(loginIntent);
                    finish();
                }

            });
            builder.show();
        }

    }

}

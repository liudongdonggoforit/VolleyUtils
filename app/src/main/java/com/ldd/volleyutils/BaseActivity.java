package com.ldd.volleyutils;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by Mr.liu
 * On 2016/7/11
 * At 18:00
 * VolleyUtils
 */
public class BaseActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

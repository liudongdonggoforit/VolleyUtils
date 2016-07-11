package com.ldd.volleyutils.volley;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.ldd.volleyutils.ApplicationTest;

/**
 * Created by Mr.liu
 * On 2016/7/11
 * At 18:10
 * VolleyUtils
 */
public class RequestManager {
    public static RequestQueue mRequestQueue = Volley.newRequestQueue(ApplicationTest.getContext());

    public RequestManager() {
    }

    /**
     *
     * @param url
     * @param tag
     * @param listener
     */
    public static void get(String url,Object tag,RequestListener listener){

    }
}

package com.ldd.volleyutils.volley;

import com.android.volley.VolleyError;

/**
 * Created by Mr.liu
 * On 2016/7/11
 * At 18:07
 * VolleyUtils
 */
public interface RequestListener {
    void requestSuccess(String json);
    void requestError(VolleyError error);
}

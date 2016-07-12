package com.ldd.volleyutils.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ldd.volleyutils.ApplicationTest;
import com.ldd.volleyutils.BaseActivity;
import com.ldd.volleyutils.R;
import com.ldd.volleyutils.models.Weather;
import com.ldd.volleyutils.volley.IRequest;
import com.ldd.volleyutils.volley.RequestJsonListener;
import com.ldd.volleyutils.volley.RequestListener;
import com.ldd.volleyutils.volley.RequestParams;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";
    private String url  = "http://web.juhe.cn:8080/environment/air/cityair?city=北京&key=9d25833f2ab6a86e5517ddff60b9aa7d";
    private String url2 = "http://service.mantoto.com//Json/GetWeather.aspx";
    private String url3 = "http://web.juhe.cn:8080/environment/air/cityair";
    private Weather weather;
    RequestQueue requestQueue = Volley.newRequestQueue(ApplicationTest.getContext());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView city = (TextView) findViewById(R.id.city);
//        RequestParams params = new RequestParams();
////        params.put("cityname","北京");
//        params.put("city","%E5%8C%97%E4%BA%AC");
//        params.put("key","9d25833f2ab6a86e5517ddff60b9aa7d");
        IRequest.get(MainActivity.this, url, new RequestListener() {
            @Override
            public void requestSuccess(String json) {
                city.setText(json);
            }

            @Override
            public void requestError(VolleyError error) {
                city.setText(error.getMessage());
                Log.i(TAG,"请求错误："+error.getMessage());
                Toast.makeText(MainActivity.this,"请求出错："+error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
//        IRequest.post(MainActivity.this, url2, params, new RequestListener() {
//            @Override
//            public void requestSuccess(String json) {
//                city.setText(json);
//            }
//
//            @Override
//            public void requestError(VolleyError error) {
//                city.setText(error.getMessage());
//                Log.i(TAG,"请求错误："+error.getMessage());
//                Toast.makeText(MainActivity.this,"请求出错："+error.getMessage(),Toast.LENGTH_SHORT).show();
//            }
//        });

        StringRequest request = new StringRequest(Request.Method.POST, url2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                city.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                city.setText(error.getMessage());
                Log.i(TAG, "请求错误：" + error.getMessage());
                Toast.makeText(MainActivity.this,"请求出错："+error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put("cityname","北京");
                return map;
            }
        };
        requestQueue.add(request);
    }
}

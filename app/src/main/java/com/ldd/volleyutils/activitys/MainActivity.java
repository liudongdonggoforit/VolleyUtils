package com.ldd.volleyutils.activitys;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
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

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;
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
    private String postUrl = "http://192.168.0.20:8080/PetM-WebApi/";
    TextView city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        city = (TextView) findViewById(R.id.city);
        Button post = (Button) findViewById(R.id.post);
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                try {
                    jsonPost();
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                post();
//                getJson();
            }
        });
    }

    private void post() {
       RequestParams params= new RequestParams();
        params.put("telnumber","13120256827");
//        params.put("inputnumber","password");
        IRequest.post(MainActivity.this, postUrl + "/UserActivate", params, new RequestListener() {
            @Override
            public void requestSuccess(String json) {
                city.setText(json);
            }

            @Override
            public void requestSuccess(JSONObject json) {

            }

            @Override
            public void requestError(VolleyError error) {
                city.setText(error.getMessage());
            }
        });
    }

    private void jsonPost() {
//        Map<String,String> map = new HashMap<String,String>();
//        map.put("cityname","北京");
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("telnumber", "15045412899");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        IRequest.post2(MainActivity.this, postUrl + "/UserActivate", jsonObject, new RequestListener() {
            @Override
            public void requestSuccess(String json) {

            }

            @Override
            public void requestSuccess(JSONObject json) {
                city.setText(json.toString());
            }

            @Override
            public void requestError(VolleyError error) {
                Log.e(TAG, error.getMessage(), error);
                city.setText(error.getMessage());
                Log.i(TAG, "请求错误：" + error.getMessage());
                Toast.makeText(MainActivity.this, "请求出错：" + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getJson() {
      IRequest.get(MainActivity.this, postUrl + "login-mobile/18600795635", new RequestListener() {
          @Override
          public void requestSuccess(String json) {
              city.setText(json);
          }

          @Override
          public void requestSuccess(JSONObject json) {

          }

          @Override
          public void requestError(VolleyError error) {
              city.setText(error.getMessage());
          }
      });
    }
}

package com.oshimamasara.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

public class MainActivity extends AppCompatActivity {
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tvHttp);
        Ion.with(getApplicationContext()).load("https://api.rss2json.com/v1/api.json?rss_url=http://rss.nytimes.com/services/xml/rss/nyt/Science.xml").asString().setCallback(new FutureCallback<String>() {
            @Override
            public void onCompleted(Exception e, String result) {

                tv.setText(result);
            }
        });


    }
}

package com.wzc.lottiedemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
// https://mp.weixin.qq.com/s/LrkZtDZY3SE8IUQ-x1hsmQ
// http://airbnb.io/lottie/
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         findViewById(R.id.btn_xml).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this, XmlActivity.class) );
             }
         });
         findViewById(R.id.btn_programmatical_res_raw).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this, ProgrammaticalRawActivity.class) );
             }
         });
         findViewById(R.id.btn_programmatical_network).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this, ProgrammaticalNetworkActivity.class) );
             }
         });
         findViewById(R.id.btn_cache_animations).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this, CachingAnimationsActivity.class) );
             }
         });
         findViewById(R.id.btn_animation_listener).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this, AnimationListenerActivity.class) );
             }
         });
    }
}

package com.wzc.lottiedemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.JsonReader;
import android.util.Log;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;

import java.io.IOException;
import java.io.StringReader;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @author wzc
 * @date 2018/5/8
 */
public class ProgrammaticalNetworkActivity extends AppCompatActivity {
    private static final String TAG = ProgrammaticalNetworkActivity.class.getSimpleName();
    private LottieAnimationView mLottieAnimationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmatical_network);

        mLottieAnimationView = findViewById(R.id.lottie_animation_view);
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://www.lottiefiles.com/download/1891")
                .build();
        Call call = okHttpClient.newCall(request);


        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "onFailure: ", e);
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String string = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        JsonReader jsonReader = new JsonReader(new StringReader(string));
                        mLottieAnimationView.setAnimation(jsonReader);
                        mLottieAnimationView.setRepeatCount(LottieDrawable.INFINITE);
                        mLottieAnimationView.setRepeatMode(LottieDrawable.RESTART);
                        mLottieAnimationView.playAnimation();
                    }
                });
            }
        });

    }
}

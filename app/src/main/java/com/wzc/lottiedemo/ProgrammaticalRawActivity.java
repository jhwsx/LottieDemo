package com.wzc.lottiedemo;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.airbnb.lottie.LottieAnimationView;

/**
 * @author wzc
 * @date 2018/5/8
 */
public class ProgrammaticalRawActivity extends AppCompatActivity {
    private static final String TAG = ProgrammaticalRawActivity.class.getSimpleName();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programmatical_raw);
        // 解析动画是异步的，完成解析后，才会开始渲染。
        LottieAnimationView lottieAnimationView = findViewById(R.id.lottie_animation_view);
        // app:lottie_rawRes="@raw/splashy_loader"
        lottieAnimationView.setAnimation(R.raw.play_fill_loader);
//        lottieAnimationView.setMinFrame(5);
//        lottieAnimationView.setMaxFrame(10);
        lottieAnimationView.addAnimatorUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float progress = (float) animation.getAnimatedValue();
//                progress =  animation.getAnimatedFraction();
                Log.d(TAG, "onAnimationUpdate: progress = " + progress);
            }
        });
        lottieAnimationView.playAnimation();

    }
}

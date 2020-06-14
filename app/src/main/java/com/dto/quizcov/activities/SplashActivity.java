package com.dto.quizcov.activities;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.dto.quizcov.R;

public class SplashActivity extends AppCompatActivity {
    ImageView imageView2;
    Animation fromtop;
    Animation frombuttom;
    TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,QuizDashboardActivity.class);
                finish();
                startActivity(intent);
            }
        },4000);
        imageView2 = findViewById(R.id.imageView2);
        fromtop = AnimationUtils.loadAnimation(this,R.anim.fromtop);
        imageView2.setAnimation(fromtop);
        textView4 =findViewById(R.id.textView4);
        frombuttom = AnimationUtils.loadAnimation(this,R.anim.frombuttom);
        textView4.setAnimation(frombuttom);

    }
}

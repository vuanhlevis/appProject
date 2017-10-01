package com.example.nhem.test;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class StartApp extends AppCompatActivity implements View.OnClickListener {
    ImageView icon_bad;
    ImageView icon_awful;
    ImageView icon_meh;
    ImageView icon_good;
    ImageView icon_rad;
    public static Boolean isHappy = true ;

    Animation animation;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_app);

        animation = AnimationUtils.loadAnimation(this,R.anim.anim1);
        animation.setDuration(2000);

        icon_rad = (ImageView) findViewById(R.id.iv_rad);
        icon_rad.setOnClickListener(this);
        icon_rad.setAnimation(animation);


        icon_good = (ImageView) findViewById(R.id.iv_good);
        icon_good.setOnClickListener(this);
        animation.setDuration(200);
        icon_good.setAnimation(animation);

        icon_meh = (ImageView) findViewById(R.id.iv_meh);
        icon_meh.setOnClickListener(this);
        animation.setDuration(200);
        icon_meh.setAnimation(animation);


        icon_bad = (ImageView) findViewById(R.id.iv_bad);
        icon_bad.setOnClickListener(this);
        animation.setDuration(200);
        icon_bad.setAnimation(animation);


        icon_awful = (ImageView) findViewById(R.id.iv_awful);
        icon_awful.setOnClickListener(this);
        animation.setDuration(200);
        icon_awful.setAnimation(animation);

    }

    public void shareElementTransition(ImageView imageView) {
        Pair[] pair = new Pair[1];
        pair[0] = new Pair<View, String>(imageView, "fell_tab2App");
        String name;

        if (imageView == icon_bad) {
            name = "icon_bad";
        } else if (imageView == icon_awful) {
            name = "icon_awful";
        }else if (imageView == icon_good) {
            name = "icon_good";
        } else if (imageView == icon_meh) {
            name = "icon_meh";
        }else name = "icon_rad";


        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pair);
        Intent intent = new Intent(StartApp.this, Tab2_status.class);

        intent.putExtra("image", name);
        startActivity(intent, options.toBundle());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_bad:
                shareElementTransition(icon_bad);
                isHappy = false;
                break;


            case R.id.iv_awful:
                shareElementTransition(icon_awful);
                isHappy = false;
                break;

            case R.id.iv_good:
                shareElementTransition(icon_good);
                break;

            case R.id.iv_rad:
                shareElementTransition(icon_rad);
                break;

            case R.id.iv_meh:
                shareElementTransition(icon_meh);
                break;

        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

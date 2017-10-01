package com.example.nhem.test;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.util.Log;
import android.util.Pair;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by vuanh on 9/26/2017.
 */

public class Tab2_status extends AppCompatActivity implements View.OnClickListener {

    Icon_status icon_love;
    Icon_status icon_family;
    Icon_status icon_work;
    Icon_status icon_passion;
    Icon_status icon_friend;


    ImageView iv_feel;
    String tmp;

    ImageButton ib_back;
    ImageButton ib_ok;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab2_status);
        initLayout();

        bundle = getIntent().getExtras();
        tmp = bundle.getString("image");

        Log.d("ahihi", "onCreate: " + tmp);

        iv_feel = (ImageView) findViewById(R.id.iv_iconfeel);

        switch (tmp) {
            case "icon_bad":
                iv_feel.setImageResource(R.drawable.sad);

                break;
            case "icon_rad":
                iv_feel.setImageResource(R.drawable.happy);
                break;

            case "icon_meh":
                iv_feel.setImageResource(R.drawable.mood_meh_select);
                break;

            case "icon_good":
                iv_feel.setImageResource(R.drawable.cool);
                break;

            case "icon_awful":
                iv_feel.setImageResource(R.drawable.dead);
                break;

        }

        getWindow().setAllowEnterTransitionOverlap(false);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finishAfterTransition();
        return true;
    }

    private void initLayout() {
        icon_love = new Icon_status();
        icon_family = new Icon_status();
        icon_work = new Icon_status();
        icon_passion = new Icon_status();
        icon_friend = new Icon_status();
        ib_back = (ImageButton) findViewById(R.id.ib_backTab2);
        ib_ok = (ImageButton) findViewById(R.id.ib_ok);
        iv_feel = (ImageView) findViewById(R.id.iv_feel);

        icon_love.imageView = (ImageView) findViewById(R.id.iv_love);
        icon_family.imageView = (ImageView) findViewById(R.id.iv_home);
        icon_work.imageView = (ImageView) findViewById(R.id.iv_work);
        icon_passion.imageView = (ImageView) findViewById(R.id.iv_passion);
        icon_friend.imageView = (ImageView) findViewById(R.id.iv_friends);

        icon_friend.imageView.setOnClickListener(this);
        icon_family.imageView.setOnClickListener(this);
        icon_work.imageView.setOnClickListener(this);
        icon_passion.imageView.setOnClickListener(this);
        icon_love.imageView.setOnClickListener(this);

        ib_back.setOnClickListener(this);
        ib_ok.setOnClickListener(this);

    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        finishAfterTransition();
//        return true;
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_love:
                icon_love.status = !icon_love.status;
                if (icon_love.status) {
                    icon_love.imageView.setImageResource(R.drawable.love_pressed);

                    icon_friend.status = false;
                    icon_work.status = false;
                    icon_passion.status = false;
                    icon_family.status = false;


                    icon_passion.imageView.setImageResource(R.drawable.passion);
                    icon_family.imageView.setImageResource(R.drawable.home);
                    icon_work.imageView.setImageResource(R.drawable.briefcase);
                    icon_friend.imageView.setImageResource(R.drawable.friend);



                } else {
                    icon_love.imageView.setImageResource(R.drawable.love2);
                }

                break;

            case R.id.iv_friends:
                icon_friend.status = !icon_friend.status;
                if (icon_friend.status) {
                    icon_friend.imageView.setImageResource(R.drawable.friends_pressed);

                    icon_love.status = false;
                    icon_work.status = false;
                    icon_passion.status = false;
                    icon_family.status = false;

                    icon_passion.imageView.setImageResource(R.drawable.passion);
                    icon_family.imageView.setImageResource(R.drawable.home);
                    icon_work.imageView.setImageResource(R.drawable.briefcase);
                    icon_love.imageView.setImageResource(R.drawable.love2);



                } else {
                    icon_friend.imageView.setImageResource(R.drawable.friend);
                }

                break;

            case R.id.iv_home:
                icon_family.status = !icon_family.status;

                if (icon_family.status) {
                    icon_family.imageView.setImageResource(R.drawable.home_pressed);

                    icon_friend.status = false;
                    icon_work.status = false;
                    icon_passion.status = false;
                    icon_love.status = false;

                    icon_passion.imageView.setImageResource(R.drawable.passion);

                    icon_work.imageView.setImageResource(R.drawable.briefcase);
                    icon_friend.imageView.setImageResource(R.drawable.friend);
                    icon_love.imageView.setImageResource(R.drawable.love2);

                } else {
                    icon_family.imageView.setImageResource(R.drawable.home);
                }
                break;

            case R.id.iv_passion:
                icon_passion.status = !icon_passion.status;

                if (icon_passion.status) {
                    icon_passion.imageView.setImageResource(R.drawable.passion_pressed);

                    icon_friend.status = false;
                    icon_work.status = false;
                    icon_love.status = false;
                    icon_family.status = false;



                    icon_family.imageView.setImageResource(R.drawable.home);
                    icon_work.imageView.setImageResource(R.drawable.briefcase);
                    icon_friend.imageView.setImageResource(R.drawable.friend);
                    icon_love.imageView.setImageResource(R.drawable.love2);

                } else {
                    icon_passion.imageView.setImageResource(R.drawable.passion);
                }

                break;

            case R.id.iv_work:
                icon_work.status = !icon_work.status;
                if (icon_work.status) {
                    icon_work.imageView.setImageResource(R.drawable.briefcase_pressed);

                    icon_friend.status = false;
                    icon_love.status = false;
                    icon_passion.status = false;
                    icon_family.status = false;

                    icon_passion.imageView.setImageResource(R.drawable.passion);
                    icon_family.imageView.setImageResource(R.drawable.home);
                    icon_friend.imageView.setImageResource(R.drawable.friend);
                    icon_love.imageView.setImageResource(R.drawable.love2);

                } else {
                    icon_work.imageView.setImageResource(R.drawable.briefcase);
                }
                break;

            case R.id.ib_backTab2:
//                onBackPressed();
                finishAfterTransition();
                break;

            case R.id.ib_ok:
                Pair[] pair = new Pair[1];

                pair[0] = new Pair<View, String> (iv_feel, "fell_tab2App");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this, pair);
                Intent i = new Intent(Tab2_status.this, MainActivity.class);

                i.putExtra(Constants.KEY_ANIM_TYPE, Constants.TransitionType.SlideJava);
                i.putExtra(Constants.KEY_TITLE, "Slide By XML");

                i.putExtra("name", tmp);


                startActivity(i, options.toBundle());
                break;

            default:
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}

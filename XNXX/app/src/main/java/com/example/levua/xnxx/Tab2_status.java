package com.example.levua.xnxx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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

    ImageButton ib_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testlayout);
        icon_love = new Icon_status();
        icon_family = new Icon_status();
        icon_work = new Icon_status();
        icon_passion = new Icon_status();
        icon_friend = new Icon_status();
        ib_back = (ImageButton) findViewById(R.id.ib_backTab2);

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


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_love:
                icon_love.status = !icon_love.status;
                if (icon_love.status) {
                    icon_love.imageView.setImageResource(R.drawable.love_pressed);
                } else {
                    icon_love.imageView.setImageResource(R.drawable.love);
                }

                break;

            case R.id.iv_friends:
                icon_friend.status = !icon_friend.status;
                if (icon_friend.status) {
                    icon_friend.imageView.setImageResource(R.drawable.friends_pressed);
                } else {
                    icon_friend.imageView.setImageResource(R.drawable.friend);
                }

                break;

            case R.id.iv_home:
                icon_family.status = !icon_family.status;

                if (icon_family.status) {
                    icon_family.imageView.setImageResource(R.drawable.home_pressed);
                } else {
                    icon_family.imageView.setImageResource(R.drawable.home);
                }
                break;

            case R.id.iv_passion:
                icon_passion.status = !icon_passion.status;

                if (icon_passion.status) {
                    icon_passion.imageView.setImageResource(R.drawable.passion_pressed);
                } else {
                    icon_passion.imageView.setImageResource(R.drawable.passion);
                }

                break;

            case R.id.iv_work:
                icon_work.status = !icon_work.status;
                if (icon_work.status) {
                    icon_work.imageView.setImageResource(R.drawable.briefcase_pressed);
                } else {
                    icon_work.imageView.setImageResource(R.drawable.briefcase);
                }
                break;

            case R.id.ib_backTab2:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}

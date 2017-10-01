package com.example.nhem.test;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nhem.test.database.AnswerModel;
import com.example.nhem.test.database.DatabaseHandle;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Random rd = new Random();
    Constants.TransitionType type;
    Bundle bundle;
    String tmp;
    ImageView iv_feel;
    ImageView iv_back;

    View background;

    int x;
    TextView tvquestion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        iv_feel = (ImageView) findViewById(R.id.iv_feel);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        tvquestion = (TextView) findViewById(R.id.tv_question);
        iv_back.setOnClickListener(this);

        background = findViewById(R.id.backgroud_main);

        bundle = getIntent().getExtras();
        tmp = bundle.getString("name");

        switch (tmp) {
            case "icon_bad":
                iv_feel.setImageResource(R.drawable.sad);
                background.setBackgroundColor(Color.parseColor("#c5cae9"));

                break;
            case "icon_rad":
                iv_feel.setImageResource(R.drawable.happy);
                background.setBackgroundColor(Color.parseColor("#ffe0b2"));
                tvquestion.setText("Vui cc :V");
                break;

            case "icon_meh":
                iv_feel.setImageResource(R.drawable.mood_meh_select);
                background.setBackgroundColor(Color.parseColor("#e1bee7"));
                tvquestion.setText("nhìn cc");

                break;

            case "icon_good":
                iv_feel.setImageResource(R.drawable.cool);
                background.setBackgroundColor(Color.parseColor("#c8e6c9"));

                tvquestion.setText("fuck you");
                break;

            case "icon_awful":
                iv_feel.setImageResource(R.drawable.dead);
                background.setBackgroundColor(Color.parseColor("#cfd8dc"));

                tvquestion.setText("Hãy vui lên vì cuộc đời cho phép");
                break;

        }

        initLayout();

        initAnimation();
    }

    private void initLayout() {
        x = rd.nextInt(5);
        AnswerModel answerModelMusic = DatabaseHandle.getInstance(this).getListAnswerMusic().get(x);
        AnswerModel answerModelQuote = DatabaseHandle.getInstance(this).getListAnswerQuote().get(x);

        TextView tvMusic = (TextView) findViewById(R.id.tv_namemusic);
        TextView tvQuote = (TextView) findViewById(R.id.tv_quote);
        tvMusic.setText(answerModelMusic.getContent());
        tvQuote.setText(answerModelQuote.getContent());

        type = (Constants.TransitionType) getIntent().getSerializableExtra(Constants.KEY_ANIM_TYPE);

    }

    private void initAnimation() {
        switch (type) {

//            case ExplodeJava: { // For Explode By Code
//                Explode enterTransition = new Explode();
//                enterTransition.setDuration(getResources().getInteger(R.integer.anim_duration_long));
//                getWindow().setEnterTransition(enterTransition);
//                break;
//            }
//
//            case ExplodeXML: { // For Explode By XML
//                Transition enterTansition = TransitionInflater.from(this).inflateTransition(R.transition.explode);
//                getWindow().setEnterTransition(enterTansition);
//                break;
//            }

            case SlideJava: { // For Slide By Code
                Slide enterTransition = new Slide();
                enterTransition.setSlideEdge(Gravity.LEFT);
                enterTransition.setDuration(1000);
                enterTransition.setInterpolator(new AnticipateOvershootInterpolator());
                getWindow().setEnterTransition(enterTransition);
                break;
            }

//            case SlideXML: { // For Slide by XML
//                Transition enterTansition = TransitionInflater.from(this).inflateTransition(R.transition.slide);
//                getWindow().setEnterTransition(enterTansition);
//                break;
//            }

//            case FadeJava: { // For Fade By Code
//                Fade enterTransition = new Fade();
//                enterTransition.setDuration(1000);
//                getWindow().setEnterTransition(enterTransition);
//                break;
//            }
//
//            case FadeXML: { // For Fade by XML
//                Transition enterTansition = TransitionInflater.from(this).inflateTransition(R.transition.fade);
//                getWindow().setEnterTransition(enterTansition);
//                break;
//
//            }
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back:
                finishAfterTransition();
        }
    }
}

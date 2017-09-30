package com.example.nhem.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.Gravity;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.TextView;

import com.example.nhem.test.database.AnswerModel;
import com.example.nhem.test.database.DatabaseHandle;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random rd = new Random();
    Constants.TransitionType type;
    int x;
    TextView tvDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        x = rd.nextInt(5);
        AnswerModel answerModelMusic = DatabaseHandle.getInstance(this).getListAnswerMusic().get(x);
        AnswerModel answerModelQuote = DatabaseHandle.getInstance(this).getListAnswerQuote().get(x);
        super.onCreate(savedInstanceState);
        TextView tvMusic = (TextView) findViewById(R.id.tv_namemusic);
        TextView tvQuote = (TextView) findViewById(R.id.tv_quote);
        tvMusic.setText(answerModelMusic.getContent());
        tvQuote.setText(answerModelQuote.getContent());

        type = (Constants.TransitionType) getIntent().getSerializableExtra(Constants.KEY_ANIM_TYPE);
        Log.d("ccccc", "onCreate: " + type);

        initAnimation();
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


}

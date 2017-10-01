package com.example.nhem.test;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nhem.test.database.DatabaseHandle;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Random rd = new Random();
    Constants.TransitionType type;
    Bundle bundle;
    String tmp;
    ImageView iv_feel;
    ImageView iv_back;
    ImageView iv_fields;
    ImageView iv_quote;
    ImageView iv_music;


    View background;

    int x;
    TextView tvquestion;
    TextView tv_ttquote;
    TextView tv_ttmusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        iv_feel = (ImageView) findViewById(R.id.iv_feel);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        tvquestion = (TextView) findViewById(R.id.tv_question);
        iv_back.setOnClickListener(this);

        iv_fields = (ImageView) findViewById(R.id.iv_fields);
        iv_music = (ImageView) findViewById(R.id.iv_music);
        iv_quote = (ImageView) findViewById(R.id.iv_quote);

        tv_ttmusic = (TextView) findViewById(R.id.tv_ttmusic);
        tv_ttquote = (TextView) findViewById(R.id.tv_ttquote);

        background = findViewById(R.id.backgroud_main);

        bundle = getIntent().getExtras();
        tmp = bundle.getString("name");

        switch (tmp) {
            case "icon_bad":
                iv_feel.setImageResource(R.drawable.sad);
                background.setBackgroundColor(Color.parseColor("#c5cae9"));
                iv_fields.setImageResource(R.drawable.love_blue);
                tv_ttquote.setTextColor(Color.parseColor("#006DF0"));
                tv_ttmusic.setTextColor(Color.parseColor("#006DF0"));

                iv_quote.setImageResource(R.drawable.quote1);
                iv_music.setImageResource(R.drawable.music1);

                break;
            case "icon_rad":
                iv_feel.setImageResource(R.drawable.happy);
                background.setBackgroundColor(Color.parseColor("#ffe0b2"));
                tvquestion.setText("Vui cc :V");
                iv_fields.setImageResource(R.drawable.love_orange);

                tv_ttquote.setTextColor(Color.parseColor("#E36600"));
                tv_ttmusic.setTextColor(Color.parseColor("#E36600"));

                iv_quote.setImageResource(R.drawable.quote4);
                iv_music.setImageResource(R.drawable.music2);
                break;

            case "icon_meh":
                iv_feel.setImageResource(R.drawable.mood_meh_select);
                background.setBackgroundColor(Color.parseColor("#e1bee7"));
                tvquestion.setText("nhìn cc");
                iv_fields.setImageResource(R.drawable.love_purple);

                tv_ttquote.setTextColor(Color.parseColor("#933EC5"));
                tv_ttmusic.setTextColor(Color.parseColor("#933EC5"));

                iv_quote.setImageResource(R.drawable.quote);
                iv_music.setImageResource(R.drawable.music);

                break;

            case "icon_good":
                iv_feel.setImageResource(R.drawable.cool);
                background.setBackgroundColor(Color.parseColor("#c8e6c9"));
                iv_fields.setImageResource(R.drawable.love_green);

                tv_ttquote.setTextColor(Color.parseColor("#199400"));
                tv_ttmusic.setTextColor(Color.parseColor("#199400"));

                iv_quote.setImageResource(R.drawable.quote3);
                iv_music.setImageResource(R.drawable.music4);

                tvquestion.setText("fuck you");
                break;

            case "icon_awful":
                iv_feel.setImageResource(R.drawable.dead);
                background.setBackgroundColor(Color.parseColor("#cfd8dc"));
                iv_fields.setImageResource(R.drawable.love_grey);

                tv_ttquote.setTextColor(Color.parseColor("#6B6B6B"));
                tv_ttmusic.setTextColor(Color.parseColor("#6B6B6B"));

                iv_quote.setImageResource(R.drawable.quote2);
                iv_music.setImageResource(R.drawable.music3);

                tvquestion.setText("Hãy vui lên vì cuộc đời cho phép");
                break;

        }

        initLayout();

        initAnimation();
    }

    private void initLayout() {
        String musicAnswer = DatabaseHandle.getInstance(this).getMusicAnswer();
        String quoteAnswer = DatabaseHandle.getInstance(this).getQuoteAnswer();
        TextView tvMusic = (TextView) findViewById(R.id.tv_namemusic);
        TextView tvQuote = (TextView) findViewById(R.id.tv_quote);
        tvMusic.setText(musicAnswer);
        tvQuote.setText(quoteAnswer);
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

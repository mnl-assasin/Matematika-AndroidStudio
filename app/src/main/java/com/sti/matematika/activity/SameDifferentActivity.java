package com.sti.matematika.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.sti.matematika.R;

import java.util.Random;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SameDifferentActivity extends AppCompatActivity {


    String TAG = "BigSmall";

    @Bind(R.id.ivLeft)
    ImageView ivLeft;
    @Bind(R.id.ivRight)
    ImageView ivRight;
    @Bind(R.id.linearLayout)
    LinearLayout linearLayout;
    @Bind(R.id.tvResult)
    TextView tvResult;
    @Bind(R.id.tvScore)
    TextView tvScore;


    int result;
    int score = 0;
    int question = 0;

    int difficulty = 0;
    @Bind(R.id.btnSame)
    Button btnSame;
    @Bind(R.id.btnDifferent)
    Button btnDifferent;

    private int drawable[] = {R.drawable.obj1, R.drawable.obj2, R.drawable.obj3, R.drawable.obj4, R.drawable.obj5,
            R.drawable.obj6, R.drawable.obj7, R.drawable.obj8, R.drawable.obj9, R.drawable.obj10, R.drawable.obj11,
            R.drawable.obj12, R.drawable.obj13, R.drawable.obj14, R.drawable.obj15, R.drawable.obj16, R.drawable.obj17,
            R.drawable.obj18, R.drawable.obj19};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_same_different);
        ButterKnife.bind(this);

        initData();
        initQuestion();
    }

    private void initData() {

        difficulty = getIntent().getIntExtra("difficulty", 0);

    }

    private void initQuestion() {

        Random rand = new Random();
        result = rand.nextInt(2);
        Log.d(TAG, "Result: " + result);

        if (result == 0) {
            randomObjects(0);
        } else {
            randomObjects(1);
        }

        question++;

    }

    private void setObjectLeft() {
        Log.d(TAG, "SET OBJECT LEFT");
//        ivLeft.setLayoutParams(new LinearLayout.LayoutParams(getDP(200), getDP(200)));
//        ivRight.setLayoutParams(new LinearLayout.LayoutParams(getDP(120), getDP(120)));


    }

    private void setObjectRight() {
        Log.d(TAG, "SET OBJECT RIGHT");
//        ivRight.setLayoutParams(new LinearLayout.LayoutParams(getDP(200), getDP(200)));
//        ivLeft.setLayoutParams(new LinearLayout.LayoutParams(getDP(120), getDP(120)));

    }

    private void randomObjects(int same) {
        Random random = new Random();

        Log.d(TAG, "Same: " + same);
        if (same == 0) {
            int x = random.nextInt(drawable.length);
            Picasso.with(getApplicationContext()).load(drawable[x]).into(ivLeft);
            Picasso.with(getApplicationContext()).load(drawable[x]).into(ivRight);
        } else {
            int x = random.nextInt(drawable.length);
            int y = random.nextInt(drawable.length);

            if (y == x)
                if (y == 0)
                    y = 1;
                else if (y == drawable.length || y == drawable.length - 1)
                    y = 0;

            Picasso.with(getApplicationContext()).load(drawable[x]).into(ivLeft);
            Picasso.with(getApplicationContext()).load(drawable[y]).into(ivRight);

        }

    }

    private int getDP(int sizeInDP) {

        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, sizeInDP, getResources().getDisplayMetrics());

//        float scale = getResources().getDisplayMetrics().density;
//        return (int) (sizeInDP * scale + 0.5f);

    }

    @OnClick({R.id.btnSame, R.id.btnDifferent})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSame:
                checkAnswer(0);
                break;
            case R.id.btnDifferent:
                checkAnswer(1);
                break;
        }
    }

    private void checkAnswer(int answer) {
        if (answer == result) {
            tvResult.setText("Correct");
            score++;
            tvScore.setText("Score: " + score);
        } else {
            tvResult.setText("Wrong");
        }

        if ((difficulty == 0 && question >= 10) || (difficulty == 1 && question >= 15) || (difficulty == 2 && question >= 20))
            enterName();
        else
            initQuestion();
    }

    private void enterName() {

    }
}

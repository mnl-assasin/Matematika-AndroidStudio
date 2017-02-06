package com.sti.matematika;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.sti.matematika.activity.BigSmallActivity;
import com.sti.matematika.activity.SameDifferentActivity;
import com.sti.matematika.activity.TallShortActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DifficultyActivity extends AppCompatActivity {

    @Bind(R.id.btnEasy)
    Button btnEasy;
    @Bind(R.id.btnModerate)
    Button btnModerate;
    @Bind(R.id.btnFast)
    Button btnFast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnEasy, R.id.btnModerate, R.id.btnFast})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnEasy:
                startGame(0);
                break;
            case R.id.btnModerate:
                startGame(1);
                break;
            case R.id.btnFast:
                startGame(2);
                break;
        }
    }

    private void startGame(int difficulty) {

        int root = getIntent().getIntExtra("root", 0);

        switch (root) {
            case 0:
                startActivity(new Intent(getApplicationContext(), BigSmallActivity.class).putExtra("difficulty", difficulty));
                break;
            case 1:
                startActivity(new Intent(getApplicationContext(), TallShortActivity.class).putExtra("difficulty", difficulty));
                break;
            case 2:
                startActivity(new Intent(getApplicationContext(), SameDifferentActivity.class).putExtra("difficulty", difficulty));
                break;

        }

    }
}

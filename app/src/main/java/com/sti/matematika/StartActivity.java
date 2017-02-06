package com.sti.matematika;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StartActivity extends AppCompatActivity {

    @Bind(R.id.btnBS)
    Button btnBS;
    @Bind(R.id.btnTS)
    Button btnTS;
    @Bind(R.id.btnSD)
    Button btnSD;
    @Bind(R.id.btnAO)
    Button btnAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btnBS, R.id.btnTS, R.id.btnSD, R.id.btnAO})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnBS:
                startActivity(new Intent(getApplicationContext(), DifficultyActivity.class).putExtra("root", 0));
                break;
            case R.id.btnTS:
                startActivity(new Intent(getApplicationContext(), DifficultyActivity.class).putExtra("root", 1));
                break;
            case R.id.btnSD:
                startActivity(new Intent(getApplicationContext(), DifficultyActivity.class).putExtra("root", 2));
                break;
            case R.id.btnAO:
                startActivity(new Intent(getApplicationContext(), DifficultyActivity.class).putExtra("root", 3));
                break;
        }
    }
}

package com.sti.matematika;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainMenuActivity extends AppCompatActivity {

    @Bind(R.id.btnStart)
    Button btnStart;
    @Bind(R.id.btnScore)
    Button btnScore;
    @Bind(R.id.btnAbout)
    Button btnAbout;
    @Bind(R.id.btnExit)
    Button btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        ButterKnife.bind(this);

        test();
    }

    @OnClick({R.id.btnStart, R.id.btnScore, R.id.btnAbout, R.id.btnExit})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnStart:
                startActivity(new Intent(getApplicationContext(), StartActivity.class));
                break;
            case R.id.btnScore:
                startActivity(new Intent(getApplicationContext(), ScoreActivity.class));
                break;
            case R.id.btnAbout:
                startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                break;
            case R.id.btnExit:
                // exit;
                break;
        }
    }

    private void test() {
//
//        final EditText etName = new EditText(this);
//        AlertDialog.Builder builder = new AlertDialog.Builder(MainMenuActivity.this);
//        builder.setView(etName);
//        builder.show();;
//    }


    }
}

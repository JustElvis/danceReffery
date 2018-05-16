package ru.startandroid.refereeing.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ru.startandroid.refereeing.R;


/**
 * Created by Slav on 21.12.2016.
 */

public class JudgesActivity extends AppCompatActivity {
    final String JUDGENAME = "judgeName";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_judges);
    }
    public void onclick(View view){
        Intent intent = new Intent(this, QuarterfinalSw.class);
        String text = ((Button)view).getText().toString();
        intent.putExtra(JUDGENAME, text);
        startActivity(intent);

    }
}

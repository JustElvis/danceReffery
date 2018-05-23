package ru.startandroid.refereeing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ru.startandroid.refereeing.activity.CategoryListActivity;
import ru.startandroid.refereeing.activity.JudgesActivity;
import ru.startandroid.refereeing.activity.RegistrationFieldActivity;

import static ru.startandroid.refereeing.R.id.btnAdjudicate;
import static ru.startandroid.refereeing.R.id.btnProgram;
import static ru.startandroid.refereeing.R.id.btnRegistrationField;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }

    public void onclick(View v){
        switch (v.getId()){
            case btnProgram:
                Intent intent = new Intent(this, CategoryListActivity.class);
                startActivity(intent);
                break;
            case btnAdjudicate:
                intent = new Intent(this, JudgesActivity.class);
                startActivity(intent);
            case btnRegistrationField:
                intent = new Intent(this, RegistrationFieldActivity.class);
                startActivity(intent);
            default:
                break;

        }
    }
}

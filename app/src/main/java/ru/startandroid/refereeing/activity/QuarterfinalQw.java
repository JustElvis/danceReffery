package ru.startandroid.refereeing.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

import ru.startandroid.refereeing.R;

/**
 * Created by Slav on 26.12.2016.
 */

public class QuarterfinalQw extends AppCompatActivity {
    private TextView tvDanceName;
    private Button btnEndDance;
    final String JUDGENAME = "judgeName";
    private TextView judgeName;
    private GridView gl_event1;
    private GridView gl_event2;
    String[] couples1 = {"1", "2","3" ,"4" ,"5" ,"6" ,"7", "8", "9", "10", "11", "12"};
    String[] couples2 = {"13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarterfinaldance);

        tvDanceName = (TextView)findViewById(R.id.tvDanceName);
        tvDanceName.setText("Квікстеп");

        btnEndDance = (Button)findViewById(R.id.btnEndDance);
        btnEndDance.setText("Завершити категорію");

        judgeName = (TextView)findViewById(R.id.judgeName);
        judgeName.setText(getIntent().getExtras().getString(JUDGENAME));

        gl_event1 = (GridView)findViewById(R.id.gl_event1);
        gl_event2 = (GridView)findViewById(R.id.gl_event2);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.couple, R.id.tvText, couples1);
        gl_event1.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.couple, R.id.tvText, couples2);
        gl_event2.setAdapter(adapter2);
        adjustGridView(gl_event1);
        adjustGridView(gl_event2);
    }

    private void adjustGridView(GridView gridView) {
        gridView.setNumColumns(6);
        gridView.setColumnWidth(80);
        gridView.setVerticalSpacing(5);
        gridView.setHorizontalSpacing(5);
    }


    public void onclick (View view){
        view.setBackgroundResource(R.drawable.rect_green);
    }
}

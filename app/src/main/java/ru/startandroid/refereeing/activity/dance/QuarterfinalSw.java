package ru.startandroid.refereeing.activity.dance;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;

import ru.startandroid.refereeing.R;
import ru.startandroid.refereeing.couple.DBcouples;

import static ru.startandroid.refereeing.R.drawable.rect;
import static ru.startandroid.refereeing.R.drawable.rect_green;
import static ru.startandroid.refereeing.R.drawable.rect_red;

/**
 * Created by Slav on 21.12.2016.
 */

public class QuarterfinalSw extends AppCompatActivity {

    Integer test = 123;


    HashSet<String> set = new HashSet<String>();




    Button btnEndDance;
    TextView judgeName, tvDanceName;
    final String JUDGENAME = "judgeName";
    GridView gl_event1, gl_event2;
    DBcouples dbcouples;
    Cursor cursor;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarterfinaldance);

        dbcouples = new DBcouples(this);
        dbcouples.open();


        tvDanceName = (TextView) findViewById(R.id.tvDanceName);
        tvDanceName.setText("Повільний вальс");

        judgeName = (TextView) findViewById(R.id.judgeName);
        final String text1 = getIntent().getExtras().getString(JUDGENAME);
        judgeName.setText(text1);

        gl_event1 = (GridView) findViewById(R.id.gl_event1);
        gl_event2 = (GridView) findViewById(R.id.gl_event2);

        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.couple, R.id.tvText, dbcouples.getFirstNumbers());
        gl_event1.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, R.layout.couple, R.id.tvText, dbcouples.getSecondNumbers());
        gl_event2.setAdapter(adapter2);
        adjustGridView(gl_event1);
        adjustGridView(gl_event2);


        btnEndDance = (Button) findViewById(R.id.btnEndDance);
        btnEndDance.setText("Наступний танець");
        btnEndDance.setClickable(false);

        final Intent intent = new Intent(this, QuarterfinalTg.class);
        btnEndDance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra(JUDGENAME, text1);
                startActivity(intent);
//                ContentValues cv = new ContentValues();
//
//                for (String s : set) {
//                    cv.put("number", s);
//                    cv.put("place", 1);
//                    dbcouples.mDB.update("mDBcouples", cv, "number = " + s, null);
//                }
                Cursor c = dbcouples.mDB.query("mDBcouples", null,
                        null, null, null, null, null);

                if (c.moveToFirst()) {
                    int idColIndex = c.getColumnIndex("id");
                    int numberColIndex = c.getColumnIndex("number");
                    int placeColIndex = c.getColumnIndex("place");

                    do {

//                        Log.d("log_tag", "id = " + c.getInt(idColIndex) + " , number = "
//                                + c.getString(numberColIndex)
//                                + " , place " + c.getString(placeColIndex));

                        Toast.makeText(QuarterfinalSw.this,
                                "id ="
                                , Toast.LENGTH_SHORT)
                                .show();
//                        Toast.makeText(QuarterfinalSw.this,
//                                "id = " + c.getInt(idColIndex) + " , number = "
//                                        + c.getString(numberColIndex)
//                                        + " , place " + c.getString(placeColIndex)
//                                , Toast.LENGTH_SHORT)
//                                .show();
                    } while (c.moveToNext());
                } else {
                    c.close();
                }
                dbcouples.close();
            }
        });
    }

            private void adjustGridView(final GridView gridView) {
                gridView.setNumColumns(6);
                gridView.setColumnWidth(80);
                gridView.setVerticalSpacing(5);
//        gridView.setBackgroundResource(rect);
                gridView.setHorizontalSpacing(5);

                gridView.setLongClickable(true);
                gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                        view.setBackgroundResource(rect_red);
                        if (set.contains(String.valueOf(parent.getItemAtPosition(position))))
                            set.remove(String.valueOf(parent.getItemAtPosition(position)));

//                if (set.size() == 12) {
//                    btnEndDance.setClickable(true);
//                    btnEndDance.setBackgroundResource(rect_green);
//                    }
                        if (set.size() < 12) {
                            btnEndDance.setClickable(false);
                            btnEndDance.setBackgroundResource(rect);
//                    view.setBackgroundResource(rect_green);
                        }

                        Toast.makeText(QuarterfinalSw.this,
                                set.toString()
                                , Toast.LENGTH_SHORT)
                                .show();
                        return true;
                    }
                });


                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                view.getContext().getCo
//                parent.getBackground().toString();
//                view[position].

//                if (gridView.getLayoutParams().equals(rect)) {


                        if (set.size() == 12) {
                            btnEndDance.setClickable(true);
                            btnEndDance.setBackgroundResource(rect_green);
                            return;
                        }
                        if (set.size() < 12) {
                            btnEndDance.setClickable(false);
                            btnEndDance.setBackgroundResource(rect);
                            view.setBackgroundResource(rect_green);
                        }

                        set.add(String.valueOf(parent.getItemAtPosition(position)));
//
//                        Toast.makeText(QuarterfinalSw.this,
//                                set.toString()
//                                , Toast.LENGTH_SHORT)
//                                .show();
                        if (set.size() == 12)
                            btnEndDance.setBackgroundResource(rect_green);
                    }


//                    gridView.getBackground()


//                Toast.makeText(QuarterfinalSw.this,
//                        parent.getSelectedItem().getBackgroundColor().toString
//                        , Toast.LENGTH_SHORT)
//                        .show();

//                }
//                if (view.getBackground().equals(R.drawable.rect_green))
//                    view.setBackgroundResource(R.drawable.rect_red);
//
//                if(view.getBackground().equals(R.drawable.rect_red))
//                    view.setBackgroundResource(rect);

//                String checkNumber = String.valueOf(parent.getItemAtPosition(position));

//                if (checkNumber.equals(String.valueOf())){
//
//                Toast.makeText(QuarterfinalSw.this, checkNumber, Toast.LENGTH_SHORT).show();
//// }

                });
            }

    }

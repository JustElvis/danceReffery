package ru.startandroid.refereeing.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ru.startandroid.refereeing.MainActivity;
import ru.startandroid.refereeing.R;

/**
 * Created by Slav on 20.12.2016.
 */

public class CategoryListActivity extends AppCompatActivity {
    final String ATTRIBUTE_NAME = "names";
    final String ATTRIBUTE_COUNT = "count";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);

        String[] names_category = {"Ювенали1 1/4 фіналу", "Ювенали1 1/2 фіналу", "Ювенали1 фінал"};
        int[] couples_count = {24, 12, 6};

        ArrayList<Map<String, String>> category = new ArrayList<Map<String, String>>(names_category.length);
        Map<String, String> m;
        for (int i = 0; i < names_category.length; i++){
            m = new HashMap<String, String>();
            m.put(ATTRIBUTE_NAME, names_category[i]);
            m.put(ATTRIBUTE_COUNT, Integer.toString(couples_count[i]));
            category.add(m);
        }

        String[] from = {ATTRIBUTE_NAME, ATTRIBUTE_COUNT};
        int[] to = {R.id.tv_Name, R.id.tv_count};

        SimpleAdapter adapter = new SimpleAdapter(this, category, R.layout.category, from, to);

        ListView lv_categoryList = (ListView)findViewById(R.id.lv_categoryList);
        lv_categoryList.setAdapter(adapter);
    }
}



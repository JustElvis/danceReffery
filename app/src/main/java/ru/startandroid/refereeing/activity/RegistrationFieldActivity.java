package ru.startandroid.refereeing.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import ru.startandroid.refereeing.R;

public class RegistrationFieldActivity extends AppCompatActivity {

    String[] category = {"<NONE>", "Юв1", "Юв2", "Юн1", "Юн2"};
    String[] clas = {"<NONE>" ,"Початківці" ,"E", "D", "C"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_field);

        final ArrayAdapter<String> adapter_category = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, category);
        ArrayAdapter<String> adapter_clas = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, clas);
        adapter_category.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_clas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        final Spinner spinner_category = (Spinner)findViewById(R.id.spinnerCategory);
        Spinner spinner_clas = (Spinner)findViewById(R.id.spinnerClass);
        spinner_category.setAdapter(adapter_category);
        spinner_clas.setAdapter(adapter_clas);

        spinner_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), category[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_clas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(), clas[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void onCheckboxClicked (View view){
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.checkboxStandart:
                if (checked) Toast.makeText(getBaseContext(), "ST", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkboxLatin:
                if (checked) Toast.makeText(getBaseContext(), "LA", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}


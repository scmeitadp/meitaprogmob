package com.example.appnovel34;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FormEdit extends AppCompatActivity {
    private ArrayList<Model> dataholder = new ArrayList<>();
    DBHelper db;
    SQLiteDatabase sqLiteDatabase;
    EditText input_keterangan;
    TextView txt_nik, txt_name, txt_phone, txt_gender, txt_age, txt_genre;
    Button button_update;
    RadioGroup radioGroup;
    RadioButton radioButton;

    String nik, keterangan, is_valid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_edit);
        DBHelper db = new DBHelper(this);

        findid();

        if (getIntent().getBundleExtra("datavaksin") != null) {
            Bundle bundle = getIntent().getBundleExtra("datavaksin");
            txt_nik.setText(bundle.getString("nik"));
            txt_name.setText(bundle.getString("name"));
            txt_phone.setText(bundle.getString("phone"));
            txt_gender.setText(bundle.getString("gender"));
            txt_genre.setText(bundle.getString("genre"));
            txt_age.setText(bundle.getString("age"));
            input_keterangan.setText(bundle.getString("keterangan"));

            //get radio
            RadioButton radValid = (RadioButton)findViewById(R.id.yes);
            RadioButton radTidak = (RadioButton)findViewById(R.id.no);

            if ("1".equals(bundle.getString("is_valid"))){
                radValid.setChecked(true);
            } else if ("0".equals(bundle.getString("is_valid"))){
                radTidak.setChecked(true);
            } else {
                radValid.setChecked(false);
                radTidak.setChecked(false);
            }
        }

        button_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radioGroup = findViewById(R.id.radio_valid);
                input_keterangan = findViewById(R.id.input_keterangan);

                int valid = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(valid);

                String value = "";
                if (radioButton.getText().toString().equals("Tolak")) {
                    value = "0";
                }else {
                    value = "1";
                }

                DBHelper db = new DBHelper(FormEdit.this);
                is_valid = radioButton.getText().toString();
                keterangan = input_keterangan.getText().toString();
                Bundle bundle = getIntent().getBundleExtra("datavaksin");
                db.updateData(bundle.getString("nik"), keterangan, value);
            }
        });
    }

    private void findid() {
        txt_nik = findViewById(R.id.txt_nik);
        txt_name = findViewById(R.id.txt_name);
        txt_phone = findViewById(R.id.txt_phone);
        txt_gender = findViewById(R.id.txt_gender);
        txt_genre = findViewById(R.id.txt_genre);
        txt_age = findViewById(R.id.txt_age);
        input_keterangan = findViewById(R.id.input_keterangan);
        button_update = findViewById(R.id.button_update);
    }
}
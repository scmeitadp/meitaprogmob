package com.example.appnovel34;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import static java.sql.Types.NULL;

public class MainActivity extends AppCompatActivity {
    static int genre =0;
    Button button_daftar;
    EditText nik, name, phone;
    CheckBox check_romance, check_horor, check_fantasy;
    RadioGroup radioGroup;
    RadioButton gender;
    SeekBar seekbar_age;
    TextView age;
    String keterangan;
    String is_valid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper db = new DBHelper(this);

        keterangan = " ";
        is_valid = "0";
        nik = findViewById(R.id.input_nik);
        name = findViewById(R.id.input_name);
        phone = findViewById(R.id.input_phone);
        button_daftar = findViewById(R.id.button_daftar);
        radioGroup = findViewById(R.id.radio_gender);
        check_romance = findViewById(R.id.check_romance);
        check_horor = findViewById(R.id.check_horor);
        check_fantasy = findViewById(R.id.check_fantasy);
        seekbar_age = findViewById(R.id.seekbar_age);
        age = findViewById(R.id.age);
        seekbar_age.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                age.setText (progress + ("th"));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        button_daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected_gender = radioGroup.getCheckedRadioButtonId();
                gender = findViewById(selected_gender);

                String genre = "";
                if(check_horor.isChecked() && check_fantasy.isChecked()){
                  genre += "Horor, Fantasi";
                }
                else{
                    if(check_romance.isChecked()) {
                        genre += "Romance";
                    }
                    if(check_horor.isChecked()) {
                        genre += "Horor";
                    }
                    if(check_fantasy.isChecked()) {
                     genre  += "Fantasy";
                    }
                }

                String txt_nik =  nik.getText().toString();
                String txt_name =  name.getText().toString();
                String txt_phone =  phone.getText().toString();
                String txt_gender = gender.getText().toString();
                String txt_genre = genre;
                String txt_age = String.valueOf(seekbar_age.getProgress());

                Boolean checkinsert = db.insert(txt_nik, txt_name, txt_phone, txt_gender, txt_genre, txt_age, " ", "0");
                if(checkinsert ==true){
                    Toast.makeText(MainActivity.this, "Pendaftaran berhasil", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Pendaftaran gagal", Toast.LENGTH_SHORT).show();
                }

                nik.setText(null);
                name.setText(null);
                phone.setText(null);
                radioGroup.clearCheck();
                check_romance.setChecked(false);
                check_horor.setChecked(false);
                check_fantasy.setChecked(false);
                seekbar_age.setProgress(0);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.data){
            startActivity(new Intent(this, Data.class));
        } else if (item.getItemId() == R.id.logout) {
            //startActivity(new Intent(this, SettingActivity.class));
        }
        return true;
    }

}

package com.example.appnovel;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;


public class Registration extends AppCompatActivity {
    String var_name, var_emailaddress, var_username, var_password;
    EditText name, email, user,pass;
    RadioButton male,female;
    SeekBar seekbar;
    CheckBox cb1, cb2, cb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Registration");
        setupSeekBar();
        Button submitButton = (Button) findViewById(R.id.btn3);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Terimakasih Sudah Mengisi Dengan Benar ", Toast.LENGTH_SHORT).show();
    }
    private void showDialog() {
        EditText name = (EditText) findViewById(R.id.name);
        EditText email = (EditText) findViewById(R.id.email);
        EditText user =(EditText) findViewById(R.id.user);
        EditText pass = (EditText) findViewById(R.id.pass);
        RadioGroup radioGroupGenders = (RadioGroup) findViewById(R.id.radioGroupGender);
        RadioButton radioButtonChosen = (RadioButton) findViewById(radioGroupGenders.getCheckedRadioButtonId());
        TextView textViewAgeValue = (TextView) findViewById(R.id.textViewAgeValue);

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Confirm Data");

        AlertDialog.Builder builder = dialogBuilder.setMessage("Apakah anda sudah yakin dengan data berikut?\n\n" +
                "Name: " + name.getText() + "\n" +
                "Email Address: " + email.getText() + "\n" +
                "Username: " + user.getText() + "\n" +
                "Password: " + pass.getText() + "\n" +
                "Gender: " + radioButtonChosen.getText() + "\n" +
                "Age: " + textViewAgeValue.getText() + "\n" +
                "Genre: " + getCheckBoxValue() + "\n")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                        var_name = name.getText().toString();
                        var_emailaddress = email.getText().toString();
                        var_username = user.getText().toString();
                        var_password = pass.getText().toString();

                        //Intent modul 2
                        Intent i = null;
                        i = new Intent(Registration.this, HasilRegis.class);
                        Bundle b = new Bundle();
                        b.putString("name", name.getText().toString());
                        b.putString("email address", email.getText().toString());
                        b.putString("username", user.getText().toString());
                        b.putString("password", pass.getText().toString());
                        b.putString("gender", radioButtonChosen.getText().toString());
                        b.putString("age", textViewAgeValue.getText().toString());
                        b.putString("genre", getCheckBoxValue());

                        int id_pilihan = radioGroupGenders.getCheckedRadioButtonId();

                        //Mendapatkan objek radio_pilihan menggunakan id
                        RadioButton gender_pilihan = (RadioButton) findViewById(id_pilihan);

                        Intent intent = i.putExtras(b);
                        startActivity(i);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        DialogInterface dialogInterface = null;
                        dialogInterface.cancel();
                    }

                })
                .setCancelable(true);
        AlertDialog confirmDialog = dialogBuilder.create();
        confirmDialog.show();

    }
    private String getCheckBoxValue() {
        CheckBox cb1 = (CheckBox) findViewById(R.id.cb1);
        CheckBox cb2 = (CheckBox) findViewById(R.id.cb2);
        CheckBox cb3 =(CheckBox) findViewById(R.id.cb3);

        String checkedValue = "";

        if (cb1.isChecked()) {
            checkedValue += cb1.getText() + "" + ",";
        }
        if (cb2.isChecked()) {
            checkedValue += cb2.getText() + "" + ",";
        }
        if (cb3.isChecked()) {
            checkedValue += cb3.getText() + "";
        }
        return checkedValue;
    }

    private void setupSeekBar() {
        int MIN = 10;
        int MAX = 60;
        int STEP = 1;

        SeekBar sb1 = (SeekBar) findViewById(R.id.sb1);
        TextView textViewAgeValue = (TextView) findViewById(R.id.textViewAgeValue);

        sb1.setMax((MAX - MIN) / STEP);

        sb1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float computeProgress = (MIN + ( progress * STEP )) * 1f;
                textViewAgeValue.setText(String.format("%.1f th", computeProgress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Input Data Anda", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "DONE", Toast.LENGTH_SHORT).show();
    }


}

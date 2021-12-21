package com.example.appnovel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class HasilRegis extends AppCompatActivity {

    TextView HName, HEmail, HUser, HPass, HGender, HAge, HGenre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_regis);

        HName = (TextView) findViewById(R.id.hasil_name);
        HEmail= (TextView) findViewById(R.id.hasil_email);
        HUser = (TextView) findViewById(R.id.hasil_user);
        HPass = (TextView) findViewById(R.id.hasil_pass);
        HGender = (TextView) findViewById(R.id.hasil_gender);
        HAge = (TextView) findViewById(R.id.hasil_age);
        HGenre = (TextView) findViewById(R.id.hasil_genre);

        Intent i = getIntent();
        HName.setText(i.getExtras().getString("name"));
        HEmail.setText(i.getExtras().getString("email address"));
        HUser.setText(i.getExtras().getString("username"));
        HPass.setText(i.getExtras().getString("password"));
        HGender.setText(i.getExtras().getString("gender"));
        HAge.setText(i.getExtras().getString("age"));
        HGenre.setText(i.getExtras().getString("genre"));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Anda Keluar", Toast.LENGTH_SHORT).show();
    }

    //activity lifecycle
//    @Override
//    protected void onStart(){
//        super.onStart();
//
//        Toast.makeText(this, "Proses Berhasil", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onResume(){
//        super.onResume();
//        Toast.makeText(this, "Resume", Toast.LENGTH_SHORT).show();
//    }
//
//   @Override
//    protected void onPause(){
//        super.onPause();
//
//       Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    protected void onStop(){
//        super.onStop();
//
//        Toast.makeText(this, "Selamat Tinggal", Toast.LENGTH_SHORT).show();
//    }

//    @Override
//    protected void onDestory() {
//        super.onDestroy();
//
//        Toast.makeText(this, "Selamat Tinggalll", Toast.LENGTH_SHORT).show();
//    }
}
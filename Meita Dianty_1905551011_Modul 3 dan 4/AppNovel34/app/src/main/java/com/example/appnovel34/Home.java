package com.example.appnovel34;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void pindah1(View view) {
        Intent intent = new Intent(Home.this, MainActivity2.class);
        startActivity(intent);

        Toast.makeText(this, "Selamat Datang Pengguna", Toast.LENGTH_SHORT).show();
    }

}
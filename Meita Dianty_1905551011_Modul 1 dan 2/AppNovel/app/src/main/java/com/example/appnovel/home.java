package com.example.appnovel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void pindah1(View view) {
        Intent intent = new Intent(home.this, MainActivity.class);
        startActivity(intent);

        Toast.makeText(this, "Selamat Datang Pengguna", Toast.LENGTH_SHORT).show();
    }


}

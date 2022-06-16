package com.example.falhafez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void pagefal(View v){
        Intent intent=new Intent(MainActivity.this,fal.class);
        startActivity(intent);
    }
    public void pagesh(View v){
        Intent intent2=new Intent(MainActivity.this,shaeran.class);
        startActivity(intent2);
    }
}
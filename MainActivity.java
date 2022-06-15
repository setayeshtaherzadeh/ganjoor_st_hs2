package com.example.ganjoor_st_hs;

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

    public void onclickfaal_btn(View v)
    {
        Intent intent1 = new Intent(this,
                MainActivity2.class);

        Bundle b = new Bundle();
        intent1.putExtra("bundle data", b);
        startActivity(intent1);
    }



    public void onclickbio_btn(View v)
    {
        Intent intent1 = new Intent(this,
                MainActivity3.class);

        Bundle b = new Bundle();
        intent1.putExtra("bundle data", b);
        startActivity(intent1);
    }
}
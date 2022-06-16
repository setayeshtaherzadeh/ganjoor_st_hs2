package com.example.falhafez;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class fal extends AppCompatActivity {

    TextView txttitle;
    TextView txtghazal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fal);

        txttitle=findViewById(R.id.ghazalnumber);
        txtghazal=findViewById(R.id.ghazal);

        //retrofit
        Retrofit retrofit=new Retrofit.Builder().
                baseUrl("https://ganjgah.ir/api/ganjoor/hafez/").
                addConverterFactory(GsonConverterFactory.create()).
                build();
        //instance for interface
        myAPI myapi=retrofit.create(myAPI.class);
        Call<datamodel> call=myapi.getdata();
        call.enqueue(new Callback<datamodel>() {
            @Override
            public void onResponse(Call<datamodel> call, Response<datamodel> response) {

                //checking fo the respons
                if (response.code() != 200){
                    txttitle.setText("check the connection");
                    return;
                }

                //get the datad into text
                String title="";
                title = response.body().getTitle();

                String ghazal="";
                ghazal = response.body().getPlainText();


                txttitle.append(title);
                txtghazal.append(ghazal);
            }

            @Override
            public void onFailure(Call<datamodel> call, Throwable t) {

            }
        });
    }
    public void refresh(View view){
        txttitle=findViewById(R.id.ghazalnumber);
        txtghazal=findViewById(R.id.ghazal);

        //retrofit
        Retrofit retrofit=new Retrofit.Builder().
                baseUrl("https://ganjgah.ir/api/ganjoor/hafez/").
                addConverterFactory(GsonConverterFactory.create()).
                build();
        //instance for interface
        myAPI myapi=retrofit.create(myAPI.class);
        Call<datamodel> call=myapi.getdata();
        call.enqueue(new Callback<datamodel>() {
            @Override
            public void onResponse(Call<datamodel> call, Response<datamodel> response) {

                //checking fo the respons
                if (response.code() != 200){
                    txttitle.setText("check the connection");
                    return;
                }

                //get the datad into text
                txttitle.setText("");
                String title="";
                title = response.body().getTitle();

                txtghazal.setText("");
                String ghazal="";
                ghazal = response.body().getPlainText();


                txttitle.append(title);
                txtghazal.append(ghazal);
            }

            @Override
            public void onFailure(Call<datamodel> call, Throwable t) {

            }
        });
    }
    public void back(View v){
        Intent intent=new Intent(fal.this,MainActivity.class);
        startActivity(intent);
    }
}
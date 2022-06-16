package com.example.falhafez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class shaeran extends AppCompatActivity {

    RecyclerView recyclerView;
    ProgressBar progressBar;
    LinearLayoutManager linearLayoutManager;
    postadapter adapter;
    List<post> postList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shaeran);

        recyclerView=findViewById(R.id.recycle);
        linearLayoutManager=new LinearLayoutManager(this);
        progressBar=findViewById(R.id.progressBar);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter=new postadapter(postList);
        recyclerView.setAdapter(adapter);

        fetchPosts();
    }

    private void fetchPosts(){
        progressBar.setVisibility(View.VISIBLE);

        retrofitclient.getretrofit().getpost().enqueue(new Callback<List<post>>() {
            @Override
            public void onResponse(Call<List<post>> call, Response<List<post>> response) {
                if(response.isSuccessful() && response.body() != null){
                    postList.addAll(response.body());
                    adapter.notifyDataSetChanged();
                    progressBar.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<List<post>> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(shaeran.this, "eror : "+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void mainpage(View v){
        Intent intent2=new Intent(shaeran.this,MainActivity.class);
        startActivity(intent2);
    }
    public void falpage(View v){
        Intent intent=new Intent(shaeran.this,fal.class);
        startActivity(intent);
    }
}
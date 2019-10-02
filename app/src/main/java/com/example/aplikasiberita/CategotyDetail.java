package com.example.aplikasiberita;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasiberita.adapter.MyAdapter;
import com.example.aplikasiberita.retrofitconfig.GetJsonAll;
import com.example.aplikasiberita.retrofitconfig.RetrofitConfigToJson;
import com.example.aplikasiberita.retrofitjson.News;
import com.example.aplikasiberita.retrofitjson.NewsList;
import com.github.ybq.android.spinkit.SpinKitView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategotyDetail extends AppCompatActivity {

    RecyclerView categorydetail;
    String business;
    GridLayoutManager glm;
    MyAdapter adapter;

    GetJsonAll getJsonAll;
    List<News> news;
    String title;
    SpinKitView spinKitView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_detail);

        categorydetail = findViewById(R.id.recycler_detail);
        glm = new GridLayoutManager(this, 1);
        categorydetail.setLayoutManager(glm);
        adapter = new MyAdapter(this, news);
        spinKitView = findViewById(R.id.spin_kit2);

        business = getIntent().getStringExtra("business");
        news = new ArrayList<>();
        getJsonAll = RetrofitConfigToJson.getResponses();


        switch (business){
            case "business":
                tampilkanCategory("business");
                break;
            case "entertainment":
                tampilkanCategory("entertainment");
                break;
            case "health":
                tampilkanCategory("health");
                break;
            case "science":
                tampilkanCategory("science");
                break;
            case "sports":
                tampilkanCategory("sports");
                break;
            case "technology":
                tampilkanCategory("technology");
                break;
            default:
                Toast.makeText(getApplicationContext(), "CATEGOTY INI TIDAK ADA", Toast.LENGTH_LONG);
        }
    }

    private void tampilkanCategory(String categoty){

        getJsonAll.getNewsListCategory("id",categoty, "3d298ec0b5724b87bb9afe433ef3bb11").enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                Log.d("Berhasil", response + "");

                spinKitView.setVisibility(View.VISIBLE);

                if (response.isSuccessful()){

                    spinKitView.setVisibility(View.GONE);
                    news = response.body().getArticles();
                    title = news.get(0).getTitle();

                    adapter = new MyAdapter(getApplicationContext(), news);
                    categorydetail.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {
                Log.d("Gagal", t + "");


            }
        });
    }
}

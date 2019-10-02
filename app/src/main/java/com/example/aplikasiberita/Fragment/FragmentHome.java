package com.example.aplikasiberita.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasiberita.R;
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

public class FragmentHome extends Fragment {

    GetJsonAll getJsonAll;
    List<News> newsList;
    String title, description;

    RecyclerView recyclerView;
    MyAdapter myAdapter;
    GridLayoutManager glm;
    View view;
    SpinKitView spinKitView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        newsList = new ArrayList<>();
        spinKitView = view.findViewById(R.id.spin_kit);
        recyclerView = view.findViewById(R.id.recycler_view);
        glm = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(glm);
        myAdapter = new MyAdapter(getContext(), newsList);

        recyclerView.setAdapter(myAdapter);

        getJsonAll = RetrofitConfigToJson.getResponses();

        getJsonAll.getNewsList("id","3d298ec0b5724b87bb9afe433ef3bb11").enqueue(new Callback<NewsList>() {
            @Override
            public void onResponse(Call<NewsList> call, Response<NewsList> response) {
                Log.d("Berhasil!!!", call + "");

                spinKitView.setVisibility(View.VISIBLE);
                if (response.isSuccessful()){
                    spinKitView.setVisibility(View.GONE);
                    newsList = response.body().getArticles();
                    title = newsList.get(0).getTitle();
                    description = newsList.get(0).getDescription();
                    Log.d("beritaKu", newsList + "");

                    myAdapter = new MyAdapter(getContext(), newsList);
                    recyclerView.setAdapter(myAdapter);
                    myAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<NewsList> call, Throwable t) {
                Log.d("Gagal", t + "");
            }
        });

        return view;

    }
}

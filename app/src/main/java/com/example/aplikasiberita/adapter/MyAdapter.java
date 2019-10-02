package com.example.aplikasiberita.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasiberita.DetailBerita;
import com.example.aplikasiberita.R;
import com.example.aplikasiberita.retrofitjson.News;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<News> newsList;

    public MyAdapter(Context context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    class MyClassAdapter extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView title;
        private ImageLoader imageLoader;
        private LinearLayout linearLayout;


        public MyClassAdapter(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.img);
            title = itemView.findViewById(R.id.title);
            imageLoader = ImageLoader.getInstance();
            linearLayout = itemView.findViewById(R.id.click);

        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_news, parent, false);


        return new MyClassAdapter(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        ((MyClassAdapter)holder).title.setText(newsList.get(position).getTitle());
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(context)
                .threadPriority(Thread.NORM_PRIORITY - 5)
                .denyCacheImageMultipleSizesInMemory()
                .build();
        ((MyClassAdapter)holder).imageLoader.init(configuration);
        ((MyClassAdapter)holder).imageLoader.displayImage(newsList.get(position).getUrlToImage(), ((MyClassAdapter)holder).img);
        ((MyClassAdapter)holder).linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailBerita.class);
                intent.putExtra("title",newsList.get(position).getTitle());
                intent.putExtra("urlToImage", newsList.get(position).getUrlToImage());
                intent.putExtra("content", newsList.get(position).getContent());
                intent.putExtra("url",newsList.get(position).getUrl());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }
}

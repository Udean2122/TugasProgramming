package com.example.aplikasiberita;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class DetailBerita extends AppCompatActivity {

    String title, image, content, url;
    TextView titles;
    ImageView imageView;
    WebView webView;

    ImageLoaderConfiguration configuration;
    ImageLoader loader;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_berita);

        titles = findViewById(R.id.titleDetail);
        imageView = findViewById(R.id.image);
        webView = findViewById(R.id.webku);
        loader = ImageLoader.getInstance();
        url = getIntent().getStringExtra("url");

        title = getIntent().getStringExtra("title");
        image = getIntent().getStringExtra("urlToImage");
        content = getIntent().getStringExtra("content");
        titles.setText(title);

        /*configuration = new ImageLoaderConfiguration.Builder(this)
                .threadPriority(Thread.NORM_PRIORITY - 5)
                .denyCacheImageMultipleSizesInMemory()
                .build();

        loader.init(configuration);
        loader.displayImage(image,imageView);
        webView.loadData(content,"text/html", "utf-8");
        webView.setWebViewClient(new WebViewClient());*/
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient());


    }
}

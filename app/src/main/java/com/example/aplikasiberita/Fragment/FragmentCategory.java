package com.example.aplikasiberita.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.aplikasiberita.CategotyDetail;
import com.example.aplikasiberita.R;

public class FragmentCategory extends Fragment {

    View view;
    ImageView icon1, icon2, icon3, icon4, icon5, icon6;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_category, container, false);


        icon1 = view.findViewById(R.id.icon1);
        icon2 = view.findViewById(R.id.icon2);
        icon3 = view.findViewById(R.id.icon3);
        icon4 = view.findViewById(R.id.icon4);
        icon5 = view.findViewById(R.id.icon5);
        icon6 = view.findViewById(R.id.icon6);

        icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CategotyDetail.class);
                intent.putExtra("business", "business");
                startActivity(intent);
            }
        });

        icon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CategotyDetail.class);
                intent.putExtra("business", "entertainment");
                startActivity(intent);
            }
        });

        icon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CategotyDetail.class);
                intent.putExtra("business", "health");
                startActivity(intent);
            }
        });

        icon4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CategotyDetail.class);
                intent.putExtra("business", "science");
                startActivity(intent);
            }
        });

        icon5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CategotyDetail.class);
                intent.putExtra("business", "sports");
                startActivity(intent);
            }
        });

        icon6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), CategotyDetail.class);
                intent.putExtra("business", "technology");
                startActivity(intent);
            }
        });



        return view;
    }
}

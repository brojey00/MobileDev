package com.example.myapplication2;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerViewVilles);
        // Setting up a GridLayoutManager with 2 columns similar to the original GridView
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        List<City> cityList = new ArrayList<>();
        cityList.add(new City("Casablanca", R.drawable.casablanca));
        cityList.add(new City("Marrakech", R.drawable.marrakech));
        cityList.add(new City("Fès", R.drawable.fes));
        cityList.add(new City("Tanger", R.drawable.tanger));
        cityList.add(new City("Agadir", R.drawable.agadir));
        cityList.add(new City("Rabat", R.drawable.rabat));

        CityAdapter adapter = new CityAdapter(cityList, city -> 
                Toast.makeText(RecyclerViewActivity.this, city.getName(), Toast.LENGTH_SHORT).show()
        );

        recyclerView.setAdapter(adapter);
    }
}

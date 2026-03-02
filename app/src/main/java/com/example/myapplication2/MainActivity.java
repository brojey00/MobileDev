package com.example.myapplication2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class MainActivity extends AppCompatActivity {
    String[] villes = {"Casablanca", "Marrakech", "Fès", "Tanger", "Agadir", "Rabat"};
    int[] images = {
            R.drawable.casablanca,
            R.drawable.marrakech,
            R.drawable.fes,
            R.drawable.tanger,
            R.drawable.agadir,
            R.drawable.rabat
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        List<Map<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < villes.length; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("nom", villes[i]);
            item.put("image", images[i]);
            data.add(item);
        }

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                data,
                R.layout.item_ville,
                new String[]{"nom", "image"},
                new int[]{R.id.villeName, R.id.villeImage}
        );

        adapter.setViewBinder((view, data1, textRepresentation) -> {
            if (view instanceof ImageView) {
                ((ImageView) view).setImageResource((Integer) data1);
                return true;
            }
            return false;
        });

        GridView gridView = findViewById(R.id.gridVilles);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener((parent, view, position, id) ->
                Toast.makeText(this, villes[position], Toast.LENGTH_SHORT).show()
        );
    }
}
package com.example.myapplication2;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.myapplication2.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        LatLng tanger = new LatLng(35.7517, -5.8087);
        LatLng rabat = new LatLng(34.0209, -6.8416);
        LatLng casablanca = new LatLng(33.5731, -7.5898);
        LatLng agadir = new LatLng(30.4278, -9.5981);

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(tanger).title("Tanger").icon(BitmapDescriptorFactory.fromResource(R.drawable.tanger_icon)));
        mMap.addMarker(new MarkerOptions().position(rabat).title("Rabat").icon(BitmapDescriptorFactory.fromResource(R.drawable.rabat_icon)));
        mMap.addMarker(new MarkerOptions().position(casablanca).title("Casablanca").icon(BitmapDescriptorFactory.fromResource(R.drawable.casabalnca_icon)));
        mMap.addMarker(new MarkerOptions().position(agadir).title("Agadir").icon(BitmapDescriptorFactory.fromResource(R.drawable.agadir_icon)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rabat, 10));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_maps, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_normal) {
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            return true;
        } else if (id == R.id.action_satellite) {
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
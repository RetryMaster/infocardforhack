package com.example.last;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.last.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

        private GoogleMap mMap;
        private ActivityMapsBinding binding;

        MarkerOptions marker;
        MarkerOptions markerKreml;
        MarkerOptions markerNaberejnaya;
        MarkerOptions markerMuseiTukaya;
        MarkerOptions markerKirlai;

        LatLng centerlocation;

        Button button_kazan;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            binding = ActivityMapsBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());

            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.map);
            mapFragment.getMapAsync(this);

            centerlocation = new LatLng(55.47, 49.6);

            marker = new MarkerOptions().title("Kazan")
                    .position(new LatLng(55.47, 49.6))
                    .snippet("Узнать подробнее...")
                    .draggable(true);
            markerKreml = new MarkerOptions().title("Kreml")
                    .position(new LatLng(55.797557, 49.107295))
                    .snippet("Узнать подробнее...");

            markerNaberejnaya = new MarkerOptions().title("Naberejnaya")
                    .position(new LatLng(55.800357, 49.099695))
                    .snippet("Узнать подробнее...");
            markerMuseiTukaya = new MarkerOptions().title("MuseiTukaya")
                    .position(new LatLng(55.800357, 49.099695))
                    .snippet("Узнать подробнее...");
            markerKirlai = new MarkerOptions().title("Kirlai")
                    .position(new LatLng(55.800357, 49.099695))
                    .snippet("Узнать подробнее...");
        }

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera. In this case,
         * we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to install
         * it inside the SupportMapFragment. This method will only be triggered once the user has
         * installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;

            // Add a marker in Sydney and move the camera
            mMap.addMarker(marker);
            mMap.addMarker(markerKreml);
            mMap.addMarker(markerNaberejnaya);
            mMap.addMarker(markerMuseiTukaya);
            mMap.addMarker(markerKirlai);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centerlocation, 8));
            enableMyLocation();
        }
        private void enableMyLocation() {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                if (mMap != null) {
                    mMap.setMyLocationEnabled(true);
                }
            } else {
                String perms[] = {"android.permission.ACCESS_FINE_LOCATION"};
                // Permission to access the location is missing. Show rationale and request permission
                ActivityCompat.requestPermissions(this, perms, 200);
            }
        }
    }
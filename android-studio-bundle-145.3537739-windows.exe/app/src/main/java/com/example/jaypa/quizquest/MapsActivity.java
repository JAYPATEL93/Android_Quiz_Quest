package com.example.jaypa.quizquest;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker myMarker;
    private final int MY_PERMISSION_REQUEST_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        mMap.setOnMarkerClickListener(mapListener);

        LatLng florida = new LatLng(28.1834091, -81.6861474);
        LatLng california = new LatLng(36.5336838,-119.6693404);
        LatLng newyork = new LatLng(40.7290341, -74.6650879);
        LatLng illinois = new LatLng(41.8720828,-87.649924);
        LatLng georgia = new LatLng(32.8876255,-83.9861806);
        LatLng arizona = new LatLng(33.5163669,-112.0221902);
        LatLng montana = new LatLng(46.8338182,-109.5286052);

        LatLng center = new LatLng(38.6154061,-98.5169088);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(center,3.5f));

        myMarker = mMap.addMarker(new MarkerOptions().position(florida).title("FLORIDA"));
        myMarker = mMap.addMarker(new MarkerOptions().position(california).title("CALIFORNIA"));
        myMarker = mMap.addMarker(new MarkerOptions().position(newyork).title("NEW YORK"));
        myMarker = mMap.addMarker(new MarkerOptions().position(illinois).title("ILLINOIS"));
        myMarker = mMap.addMarker(new MarkerOptions().position(georgia).title("GEORGIA"));
        myMarker = mMap.addMarker(new MarkerOptions().position(arizona).title("ARIZONA"));
        myMarker = mMap.addMarker(new MarkerOptions().position(montana).title("MONTANA"));

        if ((ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) && (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSION_REQUEST_CODE);
                mMap.setMyLocationEnabled(true);
            }
            else{}
        } else{
            mMap.setMyLocationEnabled(true);
        }
    }

    public GoogleMap.OnMarkerClickListener mapListener = new GoogleMap.OnMarkerClickListener(){
        @Override
        public boolean onMarkerClick(Marker arg0) {
            String state = "";
            if(arg0.getTitle().equals("FLORIDA")){ state = "FLORIDA";
            }
            else if(arg0.getTitle().equals("ILLINOIS")){ state = "ILLINOIS";
            }
            else if(arg0.getTitle().equals("NEW YORK")){ state = "NEW YORK";
            }
            else if(arg0.getTitle().equals("CALIFORNIA")){ state = "CALIFORNIA";
            }
            else if(arg0.getTitle().equals("GEORGIA")){ state = "GEORGIA";
            }
            else if(arg0.getTitle().equals("ARIZONA")){ state = "ARIZONA";
            }
            else if(arg0.getTitle().equals("MONTANA")){ state = "MONTANA";
            }
            else{ return false; }

            Intent i = new Intent(MapsActivity.this, takeQuizActivity.class);
            i.putExtra("place",state);
            startActivityForResult(i,1);
            return true;
        }
    };
}
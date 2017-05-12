package com.tengtonghann.android.timeset.view;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.tengtonghann.android.timeset.R;
import com.tengtonghann.android.timeset.service.MapApiImpl;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        Marker marker;

        for (int i = 0; i < MapApiImpl.allPhotos.size(); i++) {

            double lat = Double.parseDouble(MapApiImpl.allPhotos.get(i).getLatitude());
            double lng = Double.parseDouble(MapApiImpl.allPhotos.get(i).getLongitude());
            LatLng sydney = new LatLng(lat, lng);
            marker = mMap.addMarker(new MarkerOptions().position(sydney).title(MapApiImpl.allPhotos.get(i).getTitle()));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            marker.setTag(i);

            mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                @Override
                public boolean onMarkerClick(Marker marker) {
                    String pos = marker.getTag().toString();
                    Toast.makeText(MapsActivity.this, MapApiImpl.allPhotos.get(Integer.parseInt(pos)).getOwnername(), Toast.LENGTH_SHORT).show();
                    return true;
                }
            });
        }

    }

}

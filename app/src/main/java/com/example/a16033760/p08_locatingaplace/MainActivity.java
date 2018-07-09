package com.example.a16033760.p08_locatingaplace;

import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.PermissionChecker;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment)
                fm.findFragmentById(R.id.map);

        mapFragment.getMapAsync(new OnMapReadyCallback(){
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;

                UiSettings ui = map.getUiSettings();
                ui.setCompassEnabled(true);
                ui.setZoomControlsEnabled(true);

                LatLng poi_CausewayPoint = new LatLng(1.436065, 103.786263);
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_CausewayPoint,
                        15));
                Marker cp = map.addMarker(new
                        MarkerOptions()
                        .position(poi_CausewayPoint)
                        .title("HQ-North")
                        .snippet("Block 333, Admiralty Ave 3, 765654 \nOperating hours: 10am-5pm\n" +
                                "Tel:65433456\n")
                        .icon(BitmapDescriptorFactory.fromResource(android.R.drawable.star_on)));

                LatLng poi_CausewayPoint1 = new LatLng(1.3015829, 103.83827050000002);
                Marker cp2 = map.addMarker(new
                        MarkerOptions()
                        .position(poi_CausewayPoint1)
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));

                LatLng poi_CausewayPoint3 = new LatLng(1.361572, 103.950136);
                Marker cp3 = map.addMarker(new
                        MarkerOptions()
                        .position(poi_CausewayPoint3)
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this,
                        android.Manifest.permission.ACCESS_FINE_LOCATION);

                if (permissionCheck == PermissionChecker.PERMISSION_GRANTED) {
                    map.setMyLocationEnabled(true);
                } else {
                    Log.e("GMap - Permission", "GPS access has not been granted");
                }

            }
        });

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (map != null){
                    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                    LatLng poi_CausewayPoint = new LatLng(1.436065, 103.786263);
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_CausewayPoint,
                            15));
                    Marker cp = map.addMarker(new
                            MarkerOptions()
                            .position(poi_CausewayPoint)
                            .title("HQ-North")
                            .snippet("Block 333, Admiralty Ave 3, 765654 \nOperating hours: 10am-5pm\n" +
                                    "Tel:65433456\n")
                            .icon(BitmapDescriptorFactory.fromResource(android.R.drawable.star_on)));
                    Toast.makeText(MainActivity.this, "HQ-North", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (map != null){
                    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                    LatLng poi_CausewayPoint = new LatLng(1.3015829, 103.83827050000002);
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_CausewayPoint,
                            15));
                    Marker cp = map.addMarker(new
                            MarkerOptions()
                            .position(poi_CausewayPoint)
                            .title("Central")
                            .snippet("Block 3A, Orchard Ave 3, 134542 \n" +
                                    "Operating hours: 11am-8pm\n")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                    Toast.makeText(MainActivity.this, "Central", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (map != null){
                    map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                    LatLng poi_CausewayPoint = new LatLng(1.361572, 103.950136);
                    map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_CausewayPoint,
                            15));
                    Marker cp = map.addMarker(new
                            MarkerOptions()
                            .position(poi_CausewayPoint)
                            .title("East")
                            .snippet("Block 555, Tampines Ave 3, 287788 \n" +
                                    "Operating hours: 9am-5pm\n" +
                                    "Tel:66776677\n")
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                    Toast.makeText(MainActivity.this, "East", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

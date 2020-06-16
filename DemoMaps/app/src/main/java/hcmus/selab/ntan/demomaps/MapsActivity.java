package hcmus.selab.ntan.demomaps;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private ArrayList<Place> places;
    private ArrayList<Marker> markers;
    private GoogleMap mMap;
    private TextToSpeech textToSpeech;
    private boolean isTxt2SpchReady = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        textToSpeech = new TextToSpeech(getBaseContext(),
                new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        isTxt2SpchReady = true;
                    }
                });
        initData();
    }

    private void initData() {
        Place p1 = new Place(new LatLng(10.763092, 106.682182), "HCMUS",
                "This is University of Science");
        Place p2 = new Place(new LatLng(10.761597, 106.682149), "HCMUP",
                "This is University of Education");
        Place p3 = new Place(new LatLng(10.760184, 106.682299), "SGU",
                "This is Saigon University");
        places = new ArrayList<>();
        places.add(p1);
        places.add(p2);
        places.add(p3);
        markers = new ArrayList<>();
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
        mMap.setMyLocationEnabled(true);
//        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
//            @Override
//            public void onMapClick(LatLng latLng) {
//                mMap.addMarker(new MarkerOptions()
//                        .position(latLng)
//                        .title("new marker")
//                );
//            }
//        });

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                if (isTxt2SpchReady)
                {
                    int i = markers.indexOf(marker);
                    textToSpeech.speak(places.get(i).getDescription(),
                            TextToSpeech.QUEUE_FLUSH, null);
                    Toast.makeText(getApplicationContext(),
                            places.get(i).getDescription(),
                            Toast.LENGTH_SHORT
                            ).show();
                }
                return false;
            }
        });

        for (Place pp: places) {
            Marker mk = mMap.addMarker(new MarkerOptions()
                            .position(pp.getLatlng())
                            .title(pp.getTitle())
                            .snippet(pp.getDescription())
            );
            markers.add(mk);
        }

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
                places.get(0).getLatlng(), 15));

        // Add a marker in Sydney and move the camera
//        LatLng hcmus = new LatLng(10.763092, 106.682182);
//        Bitmap logo = BitmapFactory.decodeResource(getResources(),
//                R.drawable.logo_hcmus);
//        BitmapDescriptor logo_desc = BitmapDescriptorFactory.fromBitmap(logo);
//        mMap.addMarker(new MarkerOptions()
//                .position(hcmus)
//                .title("Marker in HCMUS")
//                .snippet("This is University of Science")
//                .icon(logo_desc)
//        );
//
//        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(hcmus, 15));
    }

    public void btn_clear_onclick(View view) {
        mMap.clear();
    }
}

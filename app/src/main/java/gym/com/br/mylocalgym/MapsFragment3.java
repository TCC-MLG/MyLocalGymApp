package gym.com.br.mylocalgym;

import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment3 extends SupportMapFragment implements OnMapReadyCallback,
        GoogleMap.OnMapClickListener {

    private GoogleMap mMap;
    private LocationManager locationManager;
    private static final String TAG = "MapsFragment3";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_maps);
//        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
        getMapAsync(this);
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


//        try {
        mMap = googleMap;

        mMap.setOnMapClickListener(this);

        mMap.getUiSettings().setZoomControlsEnabled(true);

//teste
//        }catch (SecurityException ex){
//            Log.e(TAG,"Error", ex);
//        }

        // Coordenadas para a cidade de Sidney
//        LatLng sydney = new LatLng(-33.87365, 151.20689);
//
//        MarkerOptions marker = new MarkerOptions();
//        marker.position(sydney);
//        marker.title("Marker in Sidney");

        // Coordenadas para a cidade de São paulo
        LatLng saoPaulo = new LatLng(-23.55382, -46.6355);

        MarkerOptions marker2 = new MarkerOptions();
        marker2.position(saoPaulo);
        marker2.title("Marker in São Paulo");

        mMap.addMarker(marker2);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(saoPaulo));
    }

    @Override
    public void onMapClick(LatLng latLng) {

        Toast.makeText(getContext(), "Coordenadas" + latLng.toString(),
                Toast.LENGTH_SHORT).show();
    }

    public GoogleMap getMap() {
        return mMap;
    }
}

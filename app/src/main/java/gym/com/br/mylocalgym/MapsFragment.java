package gym.com.br.mylocalgym;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsFragment extends SupportMapFragment implements OnMapReadyCallback,
        GoogleMap.OnMapClickListener,
        android.location.LocationListener {

    private GoogleMap mMap;
    private LocationManager locationManager;
    private static final String TAG = "";
    private boolean criado=false;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getMapAsync(this);

    }

    @Override
    public void onResume() {
        super.onResume();
        //ativa o GPS
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        if (ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 100,0 , this);
            Toast.makeText(getActivity(), "Provider Habilitado", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getActivity(), "Provider desabilitado :): ", Toast.LENGTH_LONG).show();
            // Show rationale and request permission.
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        if (ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            locationManager.removeUpdates(this);
        } else {
            // Show rationale and request permission.
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        mMap.setOnMapClickListener(this);

        mMap.getUiSettings().setZoomControlsEnabled(true);


        try {
            if (ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);
                Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                handleNewLocation(location);
            } else {
                // Show rationale and request permission.
            }
        }catch (Exception e){

        }


//        Coordenadas para a cidade de São paulo
//        LatLng saoPaulo = new LatLng(-23.55382, -46.6355);
//
//        MarkerOptions marker2 = new MarkerOptions();
//        marker2.position(saoPaulo);
//        marker2.title("Marker in São Paulo");
        //marcar sua
//
//        mMap.addMarker(marker2);
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(saoPaulo));
    }

    @Override
    public void onMapClick(LatLng latLng) {

        Toast.makeText(getContext(), "Coordenadas" + latLng.toString(),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLocationChanged(Location location) {
        criado= true;
        handleNewLocation(location);
    }

    private void handleNewLocation(Location location) {

        MarkerOptions options = new MarkerOptions();
        Log.d(TAG, location.toString());

        double currentLatitude = location.getLatitude();
        double currentLongitude = location.getLongitude();
        LatLng latLng = new LatLng(currentLatitude, currentLongitude);

        if (!criado) {
            options = new MarkerOptions()
                    .position(latLng)
                    .title("Eu estou aqui!");
            mMap.addMarker(options);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16));
        }else {
            options.position(latLng);
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(getActivity(), "Provider Ativo :): "+ provider, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(getActivity(), "Provider desabilitado :): "+ provider, Toast.LENGTH_LONG).show();
    }
}
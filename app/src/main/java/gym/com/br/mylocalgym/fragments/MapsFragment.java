package gym.com.br.mylocalgym.fragments;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import gym.com.br.mylocalgym.R;

public class MapsFragment extends SupportMapFragment implements OnMapReadyCallback,
                                                                GoogleMap.OnMapClickListener,
                                                                android.location.LocationListener,
                                                                GoogleMap.OnMarkerClickListener,
                                                                GoogleMap.OnInfoWindowClickListener{

    private FragmentManager fragmentManager;
    private GoogleMap mMap;
    private LocationManager locationManager;
    private static final String TAG = "";
    private boolean criado=false;

    private LatLng latLng;


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
        mMap.setOnMarkerClickListener(this);
        mMap.setOnInfoWindowClickListener(this);

        try {
            if (ContextCompat.checkSelfPermission(getContext(), android.Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                mMap.setMyLocationEnabled(true);
                Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                handleNewLocation(location);
                //  convert the location object to a LatLng object that can be used by the map API
                LatLng currentPosition = new LatLng(location.getLatitude(), location.getLongitude());
                // zoom to the current location
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentPosition,18));

                double currentLatitude = location.getLatitude();
                double currentLongitude = location.getLongitude();
//<<<<<<< HEAD
//                LatLng latLng = new LatLng(currentLatitude, currentLongitude);
//                addMarker("Academia","Smart Fit", latLng);
//                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18));
//                currentLatitude=-23.57269218035935;
//                currentLongitude=-46.63999686501232;
//                LatLng unip = new LatLng(currentLatitude, currentLongitude);
//                addMarker("Academia","Unip",unip);
//=======

                this.latLng = new LatLng(currentLatitude, currentLongitude);

                this.criarMarcacao();

            } else {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        1);
                // Show rationale and request permission.
            }
        }catch (Exception e){

        }
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

        this.latLng = new LatLng(currentLatitude, currentLongitude);

        if (!criado) {
//<<<<<<< HEAD
//            addMarker("Academia","Just Fit",latLng);
////            Marker marker = mMap.addMarker(new MarkerOptions()
////                    .position(latLng)
////                  .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_domain_black_24dp))
////                    .snippet("Just fit")
////                    .flat(true)
////                    .title("Academia"));
////            marker.showInfoWindow();
////            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18));
////
//=======

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18));
        }else {
            options.position(latLng);
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18));
        }
    }

    public void criarMarcacao(){

        Marker marker = mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_domain_black_24dp))
                .snippet("Just fit")
                .flat(true)
                .title("Academia"));
        marker.showInfoWindow();
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18));

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

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }

    @Override
    public void onInfoWindowClick(Marker marker) {

        fragmentManager =  getFragmentManager();

        FragmentTransaction fragment = fragmentManager.beginTransaction();

        fragment.replace(R.id.conteiner, new CheckinFragment(), "Checkin");
        fragment.addToBackStack("Checkin");
        fragment.commitAllowingStateLoss();

//        return false;
//    }
//
//    public void addMarker(String snipped, String title, LatLng latlng){
//        Marker marker = mMap.addMarker(new MarkerOptions()
//                .position(latlng)
//                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_domain_black_24dp))
//                .snippet(snipped)
//                .flat(true)
//                .title(title));
//        marker.showInfoWindow();
//    }

    }
}
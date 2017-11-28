package com.example.jurara.ruta;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity implements LocationListener {
    double latTepic = 21.500739669885, lonTepic = -104.87930613762728;
    double latMangos = 21.714487532854733, lonMangos = -105.33756771703338;
    double latSentis = 21.804625322030702, lonSentis = -105.34674087186431;
    double latSantiago = 21.8131863, lonSantiago = -105.20432700000003;
    double latTequila = 20.8819452, lonTequila = -103.8325001;
    double latTec = 21.4805961, lonTec = -104.86489879999999;
    double latTec2 = 21.4805961, lonTec2 = -104.86489879999999;
    ArrayAdapter adapter;
    ListView lista;
    Button btn;
    Intent intent;

    LocationManager locationManager;
    String provider = "";
    LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            latTec2 = location.getLatitude();
            lonTec2 = location.getLongitude();
        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = (ListView) findViewById(R.id.lista);
        btn = (Button) findViewById(R.id.mapa);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();

        provider =locationManager.getBestProvider(criteria, false);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);







        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(getApplicationContext(),MapsActivity.class);
                intent.putExtra("lat",latTec2);
                intent.putExtra("lon",lonTec2);
                intent.putExtra("latDes",latTepic);
                intent.putExtra("lonDes",lonTepic);
                startActivity(intent);
            }
        });
        String[] array = new String[] {
                "Casa Tepic"
                ,"Casa Mangos"
                ,"Casa Sentispac"
                ,"Santiago Ixcuintla"
                ,"Tequila Jalisco"
                ,"Tecnologico de Tepic"
        };
        ListAdapter adaptador = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, array);


        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast toast = Toast.makeText(getApplicationContext(), i+"", LENGTH_SHORT);
                toast.show();
                switch (i){
                    case 0:
                        intent=new Intent(getApplicationContext(),MapsActivity.class);
                        intent.putExtra("lat",latTec2);
                        intent.putExtra("lon",lonTec2);
                        intent.putExtra("latDes",latTepic);
                        intent.putExtra("lonDes",lonTepic);
                        intent.putExtra("nombre","Casa Tepic");
                        startActivity(intent);
                        break;
                    case 1:
                        intent=new Intent(getApplicationContext(),MapsActivity.class);
                        intent.putExtra("lat",latTec2);
                        intent.putExtra("lon",lonTec2);
                        intent.putExtra("latDes",latMangos);
                        intent.putExtra("lonDes",lonMangos);
                        intent.putExtra("nombre","Casa Mangos");
                        startActivity(intent);
                        break;
                    case 2:
                        intent=new Intent(getApplicationContext(),MapsActivity.class);
                        intent.putExtra("lat",latTec2);
                        intent.putExtra("lon",lonTec2);
                        intent.putExtra("latDes",latSentis);
                        intent.putExtra("lonDes",lonSentis);
                        intent.putExtra("nombre","Casa Sentispac");
                        startActivity(intent);
                        break;
                    case 3:
                        intent=new Intent(getApplicationContext(),MapsActivity.class);
                        intent.putExtra("lat",latTec2);
                        intent.putExtra("lon",lonTec2);
                        intent.putExtra("latDes",latSantiago);
                        intent.putExtra("lonDes",lonSantiago);
                        intent.putExtra("nombre","Santiago");
                        startActivity(intent);
                        break;
                    case 4:
                        intent=new Intent(getApplicationContext(),MapsActivity.class);
                        intent.putExtra("lat",latTec2);
                        intent.putExtra("lon",lonTec2);
                        intent.putExtra("latDes",latTequila);
                        intent.putExtra("lonDes",lonTequila);
                        intent.putExtra("nombre","Tequila Jalisco");
                        startActivity(intent);
                        break;
                    case 5:
                        intent=new Intent(getApplicationContext(),MapsActivity.class);
                        intent.putExtra("lat",latTec2);
                        intent.putExtra("lon",lonTec2);
                        intent.putExtra("latDes",latTec);
                        intent.putExtra("lonDes",lonTec);
                        intent.putExtra("nombre","Tec Tepic");
                        startActivity(intent);
                        break;

                }

            }
        });

    }

    @Override
    public void onLocationChanged(Location location) {

        latTec2 = location.getLatitude();
        lonTec2 = location.getLongitude();
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
/*
package com.example.raulrcg.gm_loc_rr;

import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LocationListener {

    LocationManager locationManager;
    TextView lat, longi;
    String provider="";
    double la,ln;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lat = (TextView) findViewById(R.id.lat);
        longi = (TextView) findViewById(R.id.longi);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();

        provider =locationManager.getBestProvider(criteria, false);
        Location location = locationManager.getLastKnownLocation(provider);
        if (location != null) {
            onLocationChanged(location);
        }

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                la=Double.parseDouble(lat.getText().toString());
                ln=Double.parseDouble(longi.getText().toString());
                Intent i=new Intent(getApplicationContext(),MapsActivity.class);
                i.putExtra("la",la);
                i.putExtra("ln",ln);
                startActivity(i);
            }
        });



    }

    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
    }

    double lati=21.7169444;
    double lng=-105.3352777;
    @Override
    public void onLocationChanged(Location location) {

        lati = location.getLatitude();
        lng = location.getLongitude();
        lat.setText(String.valueOf(lati));
        longi.setText(String.valueOf(lng));
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
    }

    @Override
    public void onProviderEnabled(String s) {
    }

    @Override
    public void onProviderDisabled(String s) {
    }
}
* */
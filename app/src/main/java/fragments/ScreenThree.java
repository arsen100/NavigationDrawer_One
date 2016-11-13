package fragments;

// http://startandroid.ru/ru/uroki/vse-uroki-spiskom/291-urok-138-opredelenie-mestopolozhenija-gps-koordinaty.html
//  http://developer.alexanderklimov.ru/android/theory/fragment-view.php
// https://gist.github.com/louisbl/770c0a2c636865a9025b
// http://techlovejump.com/android-gps-location-manager-tutorial/

/**
 * Created by adex on 12.04.16.
 */
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import home.study.R;
//import com.example.adex.navigationdrawer1.R;
import com.example.adex.navigationdrawer1.R;
//import com.example.adex.navigationdrawer1.R;

//import android.app.Fragment;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Context;
import android.util.Log;

//public class ScreenThree extends Fragment implements  LocationListener
public class ScreenThree extends Fragment implements View.OnClickListener,  LocationListener    {

    private TextView tvGetMsg;
    private EditText edit;
    private Button butGetMsg;

    private static final String TAG = "LocationFragment";
    private LocationManager myLocationManager;

    //constructor
    public ScreenThree() {
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        myLocationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        // Inflate the layout for this fragment
        //  View rootView = inflater.inflate(R.layout.screen_third, container, false);
        View view = inflater.inflate(R.layout.screen_third,null,false);

        // get the widgets reference from Fragment XML layout
        Button btn_fragment = (Button) view.findViewById(R.id.btn_fragment);

        // Set a click listener for Fragment button
        btn_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //.............................................................
                // Create a Toast notification/message
                Toast toast = Toast.makeText(
                        //getActivity(),"Custom Toast From Fragment",Toast.LENGTH_LONG
                        getActivity().getApplicationContext(), "Custom Toast From Fragment", Toast.LENGTH_LONG
                );
                // Set the Toast display position layout center
                toast.setGravity(Gravity.CENTER,0,0);
                // Finally, show the toast
                toast.show();
                //.............................................................
            }
        });

        //// Return the view as Fragment layout
       // return rootView;
        return view;
    } //-----END View onCreateView()

    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();


        edit = (EditText)getActivity().findViewById(R.id.editText);
        butGetMsg = (Button)getActivity().findViewById(R.id.butGetText);
        tvGetMsg = (TextView)getActivity().findViewById(R.id.tvGetMessage);

        butGetMsg.setOnClickListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.i(TAG, "onResume");
        myLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
        myLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        //or
       // myLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
       //         1000 * 10, 10, locationListener);
      //  myLocationManager.requestLocationUpdates(
      //          LocationManager.NETWORK_PROVIDER, 1000 * 10, 10,
      //          locationListener);
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.i(TAG, "onPause");
        myLocationManager.removeUpdates(this);
    }

    //====================== IMPLEMENTS METHOD OF LocalListener ==================
    @Override
    public void onLocationChanged(Location location) {
        String msg = "New Latitude: " + location.getLatitude()
                + "\nNew Longitude: " + location.getLongitude();

        Toast.makeText(getActivity().getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        tvGetMsg.setText(msg);
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onProviderEnabled(String s) {

        Toast.makeText(getActivity().getApplicationContext(), "Gps is turned on!! ",
                Toast.LENGTH_SHORT).show();


    }

    @Override
    public void onProviderDisabled(String s) {
                // переход в настройки
       // Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
       // startActivity(intent);
        Toast.makeText(getActivity().getApplicationContext(), "Gps is turned off!! ",
                Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View view) {
        tvGetMsg.setText(edit.getText());
    }
}

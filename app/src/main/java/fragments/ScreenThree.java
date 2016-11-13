package fragments;

/**
 * Created by adex on 12.04.16.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import home.study.R;
//import com.example.adex.navigationdrawer1.R;
import com.example.adex.navigationdrawer1.R;
//import com.example.adex.navigationdrawer1.R;

import android.os.Bundle;
//import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class ScreenThree extends Fragment {

    public ScreenThree() {
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
    }
}

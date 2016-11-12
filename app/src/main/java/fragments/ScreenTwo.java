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


public class ScreenTwo extends Fragment{

    public ScreenTwo() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.screen_second,container,
                false);

        return rootView;
    }
}

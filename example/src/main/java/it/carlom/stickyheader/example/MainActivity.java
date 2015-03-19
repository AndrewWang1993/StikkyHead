package it.carlom.stickyheader.example;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;

import it.carlom.stickyheader.example.fragment.MainFragment;


public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int maxMemory=(int)((Runtime.getRuntime()).maxMemory()/(1024*1024));
        Log.v(TAG,""+maxMemory);
        if (savedInstanceState == null) {
            loadFragment(new MainFragment());
        }

    }


    public void loadFragment(final Fragment fragment) {

        getFragmentManager().beginTransaction().replace(R.id.layout_container, fragment, fragment.getClass().getName()).addToBackStack(fragment.getClass().getName()).commit();

    }

}

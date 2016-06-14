package es.gidm.appmulti;

import android.app.Activity;
import android.app.Fragment;
import android.app.Service;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Miguel and JCristobal on 08/06/2016.
 */
public class SensoresFragment extends Fragment {
    static String TAG = "Sensores";
    SensorManager sensorManager;
    private FragmentActivity myContext;

    @Override
    public void onAttach(Activity activity) {

        if (activity instanceof FragmentActivity) {
            myContext = (FragmentActivity) activity;


        }

        super.onAttach(activity);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sensores, container, false);

        super.onCreate(savedInstanceState);

        sensorManager = (SensorManager) getActivity().getSystemService(Service.SENSOR_SERVICE);
        List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
        List<Map<String, String>> sensorData = new ArrayList<Map<String,String>>();

        for (Sensor sensor: sensorList) {
            Map<String, String> data = new HashMap<String, String>();
            data.put("name", sensor.getName());
            data.put("vendor", sensor.getVendor());
            sensorData.add(data);
        }

        SimpleAdapter sa = new SimpleAdapter(myContext, sensorData, android.R.layout.simple_list_item_2, new String[]{"name", "vendor"}, new int[]{android.R.id.text1, android.R.id.text2});

        ListView lv = (ListView) rootView.findViewById(R.id.sensorList);
        lv.setAdapter(sa);


        return rootView;
    }

    // Funciones para controlar el estado de la aplicación
    @Override
    public void onStart(){
        super.onStart();

        boolean muestra_estado;
        SharedPreferences prefs = this.getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        //SharedPreferences prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        muestra_estado = prefs.getBoolean("muestra_estados", true);

        if(muestra_estado) {
            Log.i(TAG, (String) getText(R.string.onStart));
            Toast.makeText(myContext, R.string.onStart, Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onResume(){
        super.onResume();
        boolean muestra_estado;
        SharedPreferences prefs = this.getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE); // SharedPreferences prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        muestra_estado = prefs.getBoolean("muestra_estados", true);

        if(muestra_estado) {
            Log.i(TAG, (String) getText(R.string.onResume));
            Toast.makeText(myContext, R.string.onResume, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPause(){
        super.onPause();
        boolean muestra_estado;
        SharedPreferences prefs = this.getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE); //SharedPreferences prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        muestra_estado = prefs.getBoolean("muestra_estados", true);

        if(muestra_estado) {
            Log.i(TAG, (String) getText(R.string.onPause));
            Toast.makeText(myContext, R.string.onPause, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onStop(){
        super.onStop();
        boolean muestra_estado;
        SharedPreferences prefs = this.getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE); //SharedPreferences prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        muestra_estado = prefs.getBoolean("muestra_estados", true);

        if(muestra_estado) {
            Log.i(TAG, (String) getText(R.string.onStop));
            Toast.makeText(myContext, R.string.onStop, Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        boolean muestra_estado;
        SharedPreferences prefs = this.getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE); //SharedPreferences prefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        muestra_estado = prefs.getBoolean("muestra_estados", true);

        if(muestra_estado) {
            Log.i(TAG, (String) getText(R.string.onDestroy));
            Toast.makeText(myContext, R.string.onDestroy, Toast.LENGTH_SHORT).show();
        }
    }
}

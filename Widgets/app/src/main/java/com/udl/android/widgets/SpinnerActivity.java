package com.udl.android.widgets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity {

    private String mPlantillaMensajeItemSelected;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        mPlantillaMensajeItemSelected = getString(R.string.plantilla_mensaje_spinner);
        Spinner spinner1 = (Spinner)findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new SpinnerInfo());

        Spinner spinner2 = (Spinner)findViewById(R.id.spinner2);
        List<String> futureAndroidVendors = getFutureAndroidVendors();

        ArrayAdapter<String> spinner2Adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, futureAndroidVendors);
        spinner2Adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner2.setAdapter(spinner2Adapter);
        spinner2.setOnItemSelectedListener(new SpinnerInfo());

    }


    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    /** Returns a slightly randomized List of names.
     *  You can pass either a String[] or a List<String> to the ArrayAdapter<String> constructor.
     *  Here I convert an array to a List so that I can randomize the order of the elements, in
     *  order to demonstrate that Java can dynamically compute the elements to display in a Spinner.
     *  If you have fixed elements, use XML instead of Java, as in the first Spinner example.
     */
    private List<String> getFutureAndroidVendors() {
        String[] vendorArray = { "RIM", "Palm", "Nokia" };
        //Integer [] vendorArray = { 1, 2, 3, 4, 5 };
        List<String> vendorList = Arrays.asList(vendorArray);
        Collections.shuffle(vendorList);
        return(vendorList);
    }

    private class SpinnerInfo implements AdapterView.OnItemSelectedListener {
        private boolean isFirst = true;

        /** Shows a Toast for the selected item. Ignored the very first time,
         *  which is when the item is selected on initial display, rather than
         *  by user interaction.
         */
        @Override
        public void onItemSelected(AdapterView<?> spinner, View selectedView,
                                   int selectedIndex, long id) {
            if (isFirst) {
                isFirst = false;
            } else {
                String selection = spinner.getItemAtPosition(selectedIndex).toString();
                String message =
                        String.format(mPlantillaMensajeItemSelected, selection);
                showToast(message);
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> spinner) {
            // Won't be invoked for a Spinner unless you programmatically remove items from the view
        }
    }
}

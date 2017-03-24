package com.udl.android.widgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class list_grid_view extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_grid_view);
        GridView gridv = (GridView)findViewById(R.id.gridview);
        String[] vendorArray = { "RIM", "Palm", "Nokia", "Iphone", "Mac" , "Android" };
        List<String> lista = new ArrayList<String>(Arrays.asList(vendorArray));
        Collections.shuffle(lista);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1, lista);
        gridv.setAdapter(adapter);
        gridv.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = (String)  parent.getItemAtPosition(position);

                String message = String.format(getString(R.string.plantilla_mensaje_spinner), item);
                Toast.makeText(list_grid_view.this, message , Toast.LENGTH_LONG).show();
            }
        });
    }
}

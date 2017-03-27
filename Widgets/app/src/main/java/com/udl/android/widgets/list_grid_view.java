package com.udl.android.widgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
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
        final String[] vendorArray = getResources().getStringArray(R.array.grid_view);
        int[] images ={R.drawable.dell,R.drawable.hp, R.drawable.samsung, R.drawable.sonyericsson, R.drawable.motorola, R.drawable.huawei, R.drawable.tmobile, R.drawable.htc};
        gridv.setAdapter(new ImageAdapter(this, images)); //existe una clase adapter que hereda de Base adapter que se encarga de preparar la gridview con los elementos
        gridv.setGravity(Gravity.CENTER);
        gridv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {//optengo la posicion de la imagen y la asocio con su nombre
                String message = String.format(getString(R.string.plantilla_mensaje_spinner), vendorArray[position]);//aqui uso el array de Fabricantes = vendorArray para optener el nombre del fabricante
                Toast.makeText(list_grid_view.this, message , Toast.LENGTH_LONG).show();
            }
        });


    }
}

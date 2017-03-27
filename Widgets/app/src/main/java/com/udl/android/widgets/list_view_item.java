package com.udl.android.widgets;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class list_view_item extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_item);
        List<String> lista = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.entradas_spinner1)));
        Collections.shuffle(lista); //hace una mezcla de los elementos de la lista
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,lista);//layou_simple_Exaple_list_item1 es la layour por default del xml el <listView/>
        setListAdapter(adapter);//el adaptador se encarga de crear la lista
    }
    @Override
    protected void onListItemClick(ListView l , View v, int position, long id){
        String item = (String) getListAdapter().getItem(position);
        String message = String.format(getString(R.string.plantilla_mensaje_spinner), item);
        Toast.makeText(this, message , Toast.LENGTH_LONG).show();
    }

}



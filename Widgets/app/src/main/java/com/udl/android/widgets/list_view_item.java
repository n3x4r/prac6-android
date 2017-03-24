package com.udl.android.widgets;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static android.R.id.list;

public class list_view_item extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_item);

        //ListView listv = (ListView)findViewById(R.id.listview);
        //listv.setOnItemClickListener(new ListViewInfo());
        List<String> lista = new ArrayList<String>(Arrays.asList(getResources().getStringArray(R.array.entradas_spinner1)));
        Collections.shuffle(lista);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,lista);
        setListAdapter(adapter);
    }
    @Override
    protected void onListItemClick(ListView l , View v, int position, long id){
        String item = (String) getListAdapter().getItem(position);
        String message = String.format(getString(R.string.plantilla_mensaje_spinner), item);
        Toast.makeText(this, message , Toast.LENGTH_LONG).show();
    }
 /*
    private class ListViewInfo implements AdapterView.OnItemClickListener{


        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String selection = parent.getItemAtPosition(position).toString();
            showToast(getString(R.string.plantilla_mensaje_spinner), selection);
        }

        public void showToast(String text1, String text2) {
            String message = String.format(text1, text2); //format si le pasas dos %s %s tiene que pasarle aqui dos parametros si no lanza excepcion
            Toast.makeText(list_view_item.this, message, Toast.LENGTH_LONG).show();

        }
    }
*/
}



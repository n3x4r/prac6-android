package com.udl.android.widgets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void muestraBotones (View clickedButton) {
        Intent in = new Intent(this, ButtonActivity.class);
        startActivity(in);
    }

    /** Switches to the SpinnerActivity when the associated button is clicked. */

    public void muestraSpinners(View clickedButton) {
        Intent in = new Intent(this, SpinnerActivity.class);
        startActivity(in);
    }

    public void startnewActivity (View viewbutton){
        int id = viewbutton.getId();
        Intent intent;
        switch (id){
            case R.id.buttonListView:
                intent = new Intent(this, list_view_item.class);
                startActivity(intent);
                break;
            case R.id.buttonGridView:
                intent = new Intent(this, list_grid_view.class);
                startActivity(intent);
                break;
        }
    }
}

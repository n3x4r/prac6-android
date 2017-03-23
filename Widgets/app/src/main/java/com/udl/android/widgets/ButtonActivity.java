package com.udl.android.widgets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ButtonActivity extends AppCompatActivity {

    private String mPlantillaMensajeBoton;
    private String mPlantillaMensajeImageBoton;
    private String mPlantillaMensajeToggleBotonSimple;
    private String mPlantillaMensajeradiobutton;
    private String mPlantillaMensajecheckbutton;
    private String selectRadiobutton;
    private String etiquetaToggleButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        mPlantillaMensajeBoton = getString(R.string.plantilla_mensaje_boton);
        mPlantillaMensajeradiobutton = getString(R.string.plantilla_mensaje_radiobutton);
        mPlantillaMensajecheckbutton = getString(R.string.plantilla_mensaje_checkbutton);
        mPlantillaMensajeImageBoton = getString(R.string.plantilla_mensaje_imagebutton);
        mPlantillaMensajeToggleBotonSimple = getString(R.string.plantilla_mensaje_togglebutton_simple);
        selectRadiobutton = getString(R.string.select_before);
        etiquetaToggleButton = getString(R.string.etiqueta);
    }

    /** Makes a Toast showing the label of the Button, RadioButton, or CheckBox.
     *  ImageButtons do not have text, and are not subclasses of Button, so you
     *  cannot pass an ImageButton to this method.
     *  You need the muestraInfoImageButton method.
     */

    public void muestraTextButton(View clickedButton) {
        Button button = (Button)clickedButton;
        String text = button.getText().toString();
        showToast(mPlantillaMensajeBoton ,text);
    }

    public void muestraTextCheckBox(View clickedButton) {
        CheckBox button = (CheckBox) clickedButton;
        String text = button.getText().toString();
        if(button.isChecked()){
            showToast(mPlantillaMensajecheckbutton ,text + "- Marcado");
        }else{
            showToast(mPlantillaMensajecheckbutton ,text + "- Desmarcado");
        }
    }

    public void muestraTextRadioButton(View clickedButton) {
        RadioButton button = (RadioButton) clickedButton;
        String text = button.getText().toString();
        showToast(selectRadiobutton ,"");
        showToast(mPlantillaMensajeradiobutton ,text);
        selectRadiobutton = getString(R.string.select_after) + text;
    }

    public void muestraInfoImageButton (View clickedImageButton){
        ImageButton img = (ImageButton)clickedImageButton;
        int select = img.getId();
        switch (select){
            case R.id.android_plataform:
                muestraInfoImageButton(R.string.info_imagebutton_1);
                break;
            case R.id.camera_phone:
                muestraInfoImageButton(R.string.info_imagebutton_2);
                break;
            case R.id.gps:
                muestraInfoImageButton(R.string.info_imagebutton_3);
                break;
            case R.id.button_android:
                muestraInfoImageButton(R.string.info_imagebutton_4);
                break;
            case R.id.button_dialog:
                muestraInfoImageButton(R.string.info_imagebutton_5);
                break;
            case R.id.button_rating_star:
                muestraInfoImageButton(R.string.info_imagebutton_6);
                break;
        }
    }

    private void muestraInfoImageButton(int imageId) {
        String imageString = getString(imageId);
        showToast(mPlantillaMensajeImageBoton, imageString);
    }


    /** Makes a Toast showing whether you turned ToggleButton on or off. Also
     *  shows the resultant text (label).
     */

    public void muestraInfoToggleBoton(View clickedToggleButton) {
        ToggleButton toggleButton = (ToggleButton)clickedToggleButton;
        String textoToggle = toggleButton.getText().toString();
        String status;
        if (toggleButton.isChecked()) {
            status = "ON";
        } else {
            status = "OFF";
        }
        String mss = etiquetaToggleButton+" "+ textoToggle +" "+mPlantillaMensajeToggleBotonSimple;
        showToast(mss, status);
    }

    private void showToast(String text1, String text2) {
        String message = String.format(text1, text2); //format si le pasas dos %s %s tiene que pasarle aqui dos parametros si no lanza excepcion
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}

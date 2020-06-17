package com.example.herramientas;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;

public class ActividadHerramientas extends AppCompatActivity implements ComunicaMenu{

    //array que guardará los distintos fragment que dependera del botón pulsado (linterna, musica, o giroscopio).
    Fragment[] misFragmentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_herramientas);

        misFragmentos = new Fragment[3];

        misFragmentos[0] = new Linterna();

        misFragmentos[1] = new Musica();

        misFragmentos[2] = new Nivel();



        //CON ESTO SE OBTIENE LA INFORMACIÓN DEL BUNDLE CREADO EN MAINACTIVITY
        Bundle extras = getIntent().getExtras();

        //con esto extraemos esa información y se la pasamos al método menu
        menu(extras.getInt("BOTONPULSADO"));
    }

    @Override
    public void menu(int queboton) {

        FragmentManager miManejador = getFragmentManager();

        FragmentTransaction miTransaccion = miManejador.beginTransaction();

        miTransaccion.replace(R.id.herramientas, misFragmentos[queboton] );

        miTransaccion.commit();
    }
}

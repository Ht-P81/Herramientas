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


        //aqui le decimos a los botones iluminados sobre que boton se ha pulsado
        //programar de forma programática
        //esto es posible gracias al princpio de es un... pues menú está heredando de fragment
        Fragment menu_iluminado = new Menu();

        //mediante un bundle vamos a pasarle la información a este nuevo menu_iluminado
        Bundle datos = new Bundle();
        datos.putInt("BOTONPULSADO", queboton);//ahora esta empaquetada toda la información del boton pulsado

        //mediante este método se le pasa la información desde esta actividad hasta la clase menu
        //de tal forma que nuestro nuevo fragmento de menu (menu iluminado) ya sabe que tiene que crear un nuevo fragmento de menu
        menu_iluminado.setArguments(datos);

        //aquí es donde le decimos a nuestra actividad que reemplace el menu que hay en pantalla por este nuevo que hemos creado
        miTransaccion.replace(R.id.menu, menu_iluminado);

        miTransaccion.replace(R.id.herramientas, misFragmentos[queboton] );

        miTransaccion.commit();
    }
}

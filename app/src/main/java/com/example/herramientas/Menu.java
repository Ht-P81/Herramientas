package com.example.herramientas;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


/**
 * A simple {@link Fragment} subclass.
 */
public class Menu extends Fragment {

    //vamos a crear un array de los botones (linterna, altavoz, giroscopio)
    private final int[] BOTONESMENU={R.id.linterna, R.id.musica, R.id.nivel};

    public Menu() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mimenu = inflater.inflate(R.layout.fragment_menu, container, false); //devuelve un view que será el fragmento que queremos cargar

        //crear objeto de tipo ImageButon para trabajar con los botones del menu
        ImageButton botonmenu;

        //vamos a poner los botones del menu a la escucha del evento click.
        //recorremos el array donde tengo lo botones y ponerlos a la escucha
        for(int i=0; i<BOTONESMENU.length; i++){

            //almacenamos dentro de la variable objeto botonmenu cada una de las variables;
            botonmenu = (ImageButton) mimenu.findViewById(BOTONESMENU[i]);

            //debemos saber en qué botón hemos pulsado, esta variable es la misma que pasamos por parámetro al método de la interfaz comunicaMenu
            final int queBoton = i;

            //con este método pone los botones a la escucha y lo hará a cada vuelta de bucle
            botonmenu.setOnClickListener(new View.OnClickListener(){
                //Al ser una interfaz tiene que implementar el método mas info https://developer.android.com/reference/android/view/View.OnClickListener?hl=en

                public void onClick (View v){
                   // este método es el que tiene que hacer las dos cosas que hemos dicho, detectar en qué actividad se encuentra el botón pulsado
                    //y enviar al método menú de la interfaz comunica menú en qué botones hemos pulsado

                    //para detectar en qué actividad nos encontramos
                    Activity estaActividad = getActivity();

                    //hay que enviar al menu de la interfaz comunicamenú la información.
                    //esta línea así da error "estaActividad.menu(queBoton);"
                    // pq estoy utilizando una variable de tipo activity que es de una actividad,
                    // para llamar a un método que es menú que pertenece a una interfaz llamada comunica comunica menu:
                    //entonces no corresponden los tipos, para que correspondan los tipos hacemos un casting
                    ((ComunicaMenu)estaActividad).menu(queBoton);
                }
            });
        }
        return mimenu;
    }
}

package com.example.herramientas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.app.Fragment;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Linterna extends Fragment {

    private ImageView botonCamara;

    //el valor por defecto de una variable booleana en java es false.
    private boolean encendida;


    public Linterna() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmento = inflater.inflate(R.layout.fragment_linterna, container, false);

        //con esta línea ya tenemos almacenado la imagen de la linterna en la variable botonCamara
        botonCamara=(ImageView)fragmento.findViewById(R.id.linterna);

        //Ahora vamos a ponerlo a la escucha
        botonCamara.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if(encendida){
                    //como decir que apague el flash de la camara
                    botonApagaFlash();
                    encendida=false; //no lo ponemos pq por defecto está en false.
                }else {
                    botonEnciendeFlash();
                    encendida=true;
                }
            }
        }); //clase anónima dentro del método onCreateView


        return fragmento;

    }//esta llave cierra el método onCreateView

        //hacemos el método botonEnciendeFlash

        public void botonEnciendeFlash(){

            botonCamara.setImageResource(R.drawable.linterna2);

        }

        public void botonApagaFlash(){

            botonCamara.setImageResource(R.drawable.linterna);
        }

}

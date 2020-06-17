package com.example.herramientas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ComunicaMenu{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //este método que implementamos es de la interfaz ComunicaMenu
    @Override
    public void menu(int queboton) {
        //desde aquí le decimos desde donde estamos hacia donde queremos ir
        Intent in = new Intent (this, ActividadHerramientas.class);
        //utilizamos este objeto (bundle) para cargar la información que queremos pasar a la siguiente actividad
        in.putExtra("BOTONPULSADO", queboton);
        // para que comience esta actividad, pues el método start.
        startActivity(in);
    }
}

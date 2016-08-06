package com.alonsodiez.mascotaspracticasemana3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public MascotaAdaptador adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotas);
        //ahora de qué forma queremos mostrar los datos
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();


    }

    public void paginaFavoritos(View v){
        Intent intent = new Intent(MainActivity.this, MascotasFavoritas.class);
        startActivity(intent);
    }

    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota(R.drawable.img3, "Sandokan", "Tigre", true, 8));
        mascotas.add(new Mascota(R.drawable.img4, "Bob", "Perro", true, 3));
        mascotas.add(new Mascota(R.drawable.img5, "Pirata", "Loro", false, 0));
        mascotas.add(new Mascota(R.drawable.img6, "Bokeh", "Águila", true, 4));
        mascotas.add(new Mascota(R.drawable.img7, "Thunder", "Caballo", true, 9));
        mascotas.add(new Mascota(R.drawable.img8, "Pingu", "Pantera", true, 8));
        mascotas.add(new Mascota(R.drawable.img1, "Teddy", "Hamster", false, 0));
        mascotas.add(new Mascota(R.drawable.img2, "Paddy", "Conejo", false, 0));
    }

    public void inicializarAdaptador(){
        //Creamos un objeto de ContactoAdaptador
        adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }
}

package com.example.ejemploadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivityAderezo extends AppCompatActivity {

    GridView grid;
    Button btnEliminar, btnContinuar;
    Variables variables = new Variables();

    ArrayList<String> Productos =new ArrayList<>();
    ArrayList<String>Imagenes =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_aderezo);

        grid = (GridView) findViewById(R.id.grid);
        btnEliminar = (Button) findViewById(R.id.btnReiniciar);
        btnContinuar = (Button) findViewById(R.id.btnEnviar);

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (variables.getListaImagen().size()==5){
                    variables.setUltimoProducto(4);
                    Imagenes.clear();
                    Productos.clear();
                    variables.getListaNombreProducto().remove(4);
                    variables.getListaImagen().remove(4);
                    CargarGrid();
                }
            }
        });

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (variables.getListaImagen().size()==5){
                    Intent intent = new Intent(MainActivityAderezo.this, MainActivityAcomp.class);
                    MainActivityAderezo.this.startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivityAderezo.this, "Seleccione un aderezo principal", Toast.LENGTH_SHORT).show();
                }
            }
        });

        CargarGrid();
    }

    public void CargarGrid(){

        variables.setUltimaPantalla(5);

        Imagenes.add("https://cdn.kiwilimon.com/recetaimagen/427/th5-320x320-3585.jpg");
        Imagenes.add("https://www.cardamomo.news/__export/1616863396328/sites/debate/img/2021/03/27/aderezo_para_camarones_empanizados_crop1616863334263.jpeg_1753094345.jpeg");
        Imagenes.add("https://www.hola.com/imagenes/cocina/recetas/20200205159833/salsa-bufalo-casera/0-778-726/salsa-bufalo-casera-m.jpg");
        Imagenes.add("https://www.hola.com/imagenes/cocina/recetas/20200204159692/salsa-barbacoa/0-777-986/salsa-barbacoa-m.jpg");

        Productos.add("Ranch");
        Productos.add("Chipotle");
        Productos.add("Buffalo");
        Productos.add("Barbacoa");

        GridAdapter adapter = new GridAdapter(MainActivityAderezo.this, Imagenes, Productos);
        grid.setAdapter(adapter);
    }
}
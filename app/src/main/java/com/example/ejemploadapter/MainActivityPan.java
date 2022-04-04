package com.example.ejemploadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivityPan extends AppCompatActivity {

    GridView grid;
    Button btnEliminar, btnContinuar;
    Variables variables = new Variables();

    ArrayList<String>Productos =new ArrayList<>();
    ArrayList<String>Imagenes =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_pan);

        grid = (GridView) findViewById(R.id.grid);
        btnEliminar = (Button) findViewById(R.id.btnReiniciar);
        btnContinuar = (Button) findViewById(R.id.btnEnviar);

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (variables.getListaImagen().size()==1){
                    variables.setUltimoProducto(0);
                    Imagenes.clear();
                    Productos.clear();
                    variables.getListaNombreProducto().remove(0);
                    variables.getListaImagen().remove(0);
                    CargarGrid();
                }
            }
        });

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (variables.getListaImagen().size()==1){
                    Intent intent = new Intent(MainActivityPan.this, MainActivityQueso.class);
                    MainActivityPan.this.startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivityPan.this, "Seleccione un tipo de pan", Toast.LENGTH_SHORT).show();
                }
            }
        });

        CargarGrid();
    }

    public void CargarGrid(){

        variables.setUltimaPantalla(1);

        Imagenes.add("https://us.123rf.com/450wm/bigacis/bigacis1911/bigacis191100012/135029921-pan-de-hamburguesa-abierto-y-vac%C3%ADo-aislado-sobre-fondo-blanco-profundidad-de-campo-completa.jpg?ver=6");
        Imagenes.add("https://img.freepik.com/foto-gratis/pan-hamburguesa-voladora-sesamo-o-bollo-nada-aislado_184700-1650.jpg");
        Imagenes.add("https://us.123rf.com/450wm/artjazz/artjazz1701/artjazz170100050/69540979-%E5%88%86%E9%9B%A2%E3%81%AE%E3%83%8F%E3%83%B3%E3%83%90%E3%83%BC%E3%82%AC%E3%83%BC%E3%81%AE%E3%83%90%E3%83%B3%E3%82%BA%E7%A9%BA.jpg");

        Productos.add("Multigrano");
        Productos.add("Liso");
        Productos.add("Bollo tostado");

        GridAdapter adapter = new GridAdapter(MainActivityPan.this, Imagenes, Productos);
        grid.setAdapter(adapter);
    }
}
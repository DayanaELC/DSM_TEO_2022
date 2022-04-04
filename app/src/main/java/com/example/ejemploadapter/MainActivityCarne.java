package com.example.ejemploadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivityCarne extends AppCompatActivity {

    GridView grid;
    Button btnEliminar, btnContinuar;
    Variables variables = new Variables();

    ArrayList<String> Productos =new ArrayList<>();
    ArrayList<String>Imagenes =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_carne);

        grid = (GridView) findViewById(R.id.grid);
        btnEliminar = (Button) findViewById(R.id.btnReiniciar);
        btnContinuar = (Button) findViewById(R.id.btnEnviar);

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (variables.getListaImagen().size()==3){
                    variables.setUltimoProducto(2);
                    Imagenes.clear();
                    Productos.clear();
                    variables.getListaNombreProducto().remove(2);
                    variables.getListaImagen().remove(2);
                    CargarGrid();
                }
            }
        });

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (variables.getListaImagen().size()==3){
                    Intent intent = new Intent(MainActivityCarne.this, MainActivityComplemento.class);
                    MainActivityCarne.this.startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivityCarne.this, "Seleccione una proteína", Toast.LENGTH_SHORT).show();
                }
            }
        });

        CargarGrid();
    }

    public void CargarGrid(){

        variables.setUltimaPantalla(3);

        Imagenes.add("https://thumbs.dreamstime.com/b/carne-recientemente-asada-la-parrilla-de-hamburguesa-117778726.jpg");
        Imagenes.add("https://www.yayamaria.com/user_files/product/90079_yaya_8824.jpg");
        Imagenes.add("https://carniceriasancristobal.com/wp-content/uploads/2020/10/crispy-chicken.png");

        Productos.add("Carne a la parrilla");
        Productos.add("Pollo a la parrilla");
        Productos.add("Pollo empanizado");

        GridAdapter adapter = new GridAdapter(MainActivityCarne.this, Imagenes, Productos);
        grid.setAdapter(adapter);
    }
}
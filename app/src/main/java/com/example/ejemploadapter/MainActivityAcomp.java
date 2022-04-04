package com.example.ejemploadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivityAcomp extends AppCompatActivity {

    GridView grid;
    Button btnEliminar, btnContinuar;
    Variables variables = new Variables();

    ArrayList<String> Productos =new ArrayList<>();
    ArrayList<String>Imagenes =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_acomp);

        grid = (GridView) findViewById(R.id.grid);
        btnEliminar = (Button) findViewById(R.id.btnReiniciar);
        btnContinuar = (Button) findViewById(R.id.btnEnviar);

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (variables.getListaImagen().size()==6){
                    variables.setUltimoProducto(5);
                    Imagenes.clear();
                    Productos.clear();
                    variables.getListaNombreProducto().remove(5);
                    variables.getListaImagen().remove(5);
                    CargarGrid();
                }
            }
        });

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (variables.getListaImagen().size()==6){
                    Intent intent = new Intent(MainActivityAcomp.this, MainActivityResultado.class);
                    MainActivityAcomp.this.startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivityAcomp.this, "Seleccione un acompañamiento", Toast.LENGTH_SHORT).show();
                }
            }
        });

        CargarGrid();
    }

    public void CargarGrid(){

        variables.setUltimaPantalla(6);

        Imagenes.add("https://plazavea.vteximg.com.br/arquivos/ids/2164147-450-450/131925.jpg?v=637626621064700000");
        Imagenes.add("https://ibagaru.mx/wp-content/uploads/2020/06/Aros-de-cebolla.png");
        Imagenes.add("https://cdn.shopify.com/s/files/1/0058/0281/9655/products/dedosdequeso-100_503x503.jpg?v=1593451045");

        Productos.add("Papas francesas");
        Productos.add("Aros de cebolla");
        Productos.add("Deditos de queso");

        GridAdapter adapter = new GridAdapter(MainActivityAcomp.this, Imagenes, Productos);
        grid.setAdapter(adapter);
    }
}
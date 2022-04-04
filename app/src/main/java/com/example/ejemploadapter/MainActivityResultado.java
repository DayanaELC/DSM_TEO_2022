package com.example.ejemploadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivityResultado extends AppCompatActivity {

    GridView grid;
    Button btnEliminar, btnContinuar;
    Variables variables = new Variables();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_resultado);

        grid = (GridView) findViewById(R.id.grid);
        btnEliminar = (Button) findViewById(R.id.btnReiniciar);
        btnContinuar = (Button) findViewById(R.id.btnEnviar);

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                variables.getListaNombreProducto().clear();
                variables.getListaImagen().clear();
                variables.setUltimoProducto(0);
                Intent intent = new Intent(MainActivityResultado.this, MainActivityPan.class);
                MainActivityResultado.this.startActivity(intent);

            }
        });

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                variables.getListaNombreProducto().clear();
                variables.getListaImagen().clear();
                variables.setUltimoProducto(0);
                Toast.makeText(MainActivityResultado.this, "Las indicaciones fueron enviadas", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivityResultado.this, MainActivity.class);
                MainActivityResultado.this.startActivity(intent);
            }
        });

        CargarGrid();
    }

    public void CargarGrid(){
        variables.setUltimaPantalla(7);
        GridAdapter adapter = new GridAdapter(MainActivityResultado.this, variables.getListaImagen(), variables.getListaNombreProducto());
        grid.setAdapter(adapter);
    }
}
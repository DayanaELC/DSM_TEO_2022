package com.example.ejemploadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivityQueso extends AppCompatActivity {

    GridView grid;
    Button btnEliminar, btnContinuar;
    Variables variables = new Variables();

    ArrayList<String> Productos =new ArrayList<>();
    ArrayList<String>Imagenes =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_queso);

        grid = (GridView) findViewById(R.id.grid);
        btnEliminar = (Button) findViewById(R.id.btnReiniciar);
        btnContinuar = (Button) findViewById(R.id.btnEnviar);

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (variables.getListaImagen().size()==2){
                    variables.setUltimoProducto(1);
                    Imagenes.clear();
                    Productos.clear();
                    variables.getListaNombreProducto().remove(1);
                    variables.getListaImagen().remove(1);
                    CargarGrid();
                }
            }
        });

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (variables.getListaImagen().size()==2){
                    Intent intent = new Intent(MainActivityQueso.this, MainActivityCarne.class);
                    MainActivityQueso.this.startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivityQueso.this, "Seleccione un tipo de queso", Toast.LENGTH_SHORT).show();
                }
            }
        });

        CargarGrid();
    }

    public void CargarGrid(){

        variables.setUltimaPantalla(2);

        Imagenes.add("https://mercaki.co/rails/active_storage/representations/eyJfcmFpbHMiOnsibWVzc2FnZSI6IkJBaHBBL0pqU1E9PSIsImV4cCI6bnVsbCwicHVyIjoiYmxvYl9pZCJ9fQ==--41670bbedc82ee8d6e4e4010d66b303c21c318d6/eyJfcmFpbHMiOnsibWVzc2FnZSI6IkJBaDdDRG9TY21WemFYcGxYM1J2WDJacGRGc0hhUUlnQTJrQ0lBTTZER052Ym5abGNuUkpJZ2hxY0djR09nWkZWRG9LYzJGMlpYSjdDRG9NY1hWaGJHbDBlV2xmT2dwemRISnBjRlE2RDJKaFkydG5jbTkxYm1SYkNHa0IvMmtCLzJrQi93PT0iLCJleHAiOm51bGwsInB1ciI6InZhcmlhdGlvbiJ9fQ==--f9b6205701877dad933126b17f2a1a57fbbba520/QUESO-MOZZARELLA-LAMINADO-40-GRASA-1-LIBRA.png?locale=pt");
        Imagenes.add("https://www.comervipc.com/wp-content/uploads/2020/05/queso_doble_crema_tajado_comervipc_domicilios.jpg");

        Productos.add("Blanco");
        Productos.add("Amarillo");

        GridAdapter adapter = new GridAdapter(MainActivityQueso.this, Imagenes, Productos);
        grid.setAdapter(adapter);
    }
}
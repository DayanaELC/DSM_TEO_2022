package com.example.ejemploadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivityComplemento extends AppCompatActivity {

    GridView grid;
    Button btnEliminar, btnContinuar;
    Variables variables = new Variables();

    ArrayList<String> Productos =new ArrayList<>();
    ArrayList<String>Imagenes =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_complemento);

        grid = (GridView) findViewById(R.id.grid);
        btnEliminar = (Button) findViewById(R.id.btnReiniciar);
        btnContinuar = (Button) findViewById(R.id.btnEnviar);

        btnEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (variables.getListaImagen().size()==4){
                    variables.setUltimoProducto(3);
                    Imagenes.clear();
                    Productos.clear();
                    variables.getListaNombreProducto().remove(3);
                    variables.getListaImagen().remove(3);
                    CargarGrid();
                }
            }
        });

        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (variables.getListaImagen().size()==4){
                    Intent intent = new Intent(MainActivityComplemento.this, MainActivityAderezo.class);
                    MainActivityComplemento.this.startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivityComplemento.this, "Seleccione un complemento", Toast.LENGTH_SHORT).show();
                }
            }
        });

        CargarGrid();
    }

    public void CargarGrid(){

        variables.setUltimaPantalla(4);

        Imagenes.add("https://static.turbosquid.com/Preview/2019/03/27__07_17_09/Fried_Bacon_600_0001.jpgE94126A2-124D-45E3-8A9D-B81C7DA86C6ALarge.jpg");
        Imagenes.add("https://media.istockphoto.com/photos/fresh-guacamole-isolated-on-white-background-picture-id1051626492?k=20&m=1051626492&s=170667a&w=0&h=OwDWcmcjClcwe6CW5FjCTpSAh31y0bSgkOFZyh8LzhY=");
        Imagenes.add("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT1rfaLhUkr5r-iHjaPpUkYPUH7xXmxik4R5iP-VwLWcA6QpIylgS4gI-jvB3WfDJiFHG8&usqp=CAU");
        Imagenes.add("https://cdn2.cocinadelirante.com/sites/default/files/styles/gallerie/public/salsa_de_pina_facil_con_habanero.jpg");

        Productos.add("Tocino");
        Productos.add("Guacamole");
        Productos.add("Cebolla caramelizada");
        Productos.add("Piña asada");

        GridAdapter adapter = new GridAdapter(MainActivityComplemento.this, Imagenes, Productos);
        grid.setAdapter(adapter);
    }
}
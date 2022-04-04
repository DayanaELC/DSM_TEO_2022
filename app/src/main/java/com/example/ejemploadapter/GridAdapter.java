package com.example.ejemploadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GridAdapter extends BaseAdapter {
    Context contexto;
    List<String> ListaImagenes;
    List<String> ListaNombre;

    Variables variables = new Variables();

    public GridAdapter(Context contexto, List<String> listaImagenes, List<String> listaNombre) {
        this.contexto = contexto;
        ListaImagenes = listaImagenes;
        ListaNombre = listaNombre;
    }

    @Override
    public int getCount() {
        return ListaImagenes.size();
    }

    @Override
    public Object getItem(int i) {
        return ListaImagenes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View vista = view;
        LayoutInflater inflate = LayoutInflater.from(contexto);
        vista = inflate.inflate(R.layout.grid_items,null);

        ImageView Item = (ImageView) vista.findViewById(R.id.imgProducto);
        Picasso.get().load(ListaImagenes.get(i)).into(Item);
        //Glide.with(Item.getContext()).load("").into(Item);

        TextView txtNombre = (TextView) vista.findViewById(R.id.txtNombre);
        txtNombre.setText(ListaNombre.get(i));

        Item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (variables.getUltimaPantalla()==variables.getUltimoProducto()){
                    Toast.makeText(contexto, "Debe eliminar el producto seleccionado", Toast.LENGTH_SHORT).show();
                } else if (variables.getUltimaPantalla()==7){
                    Toast.makeText(contexto, ListaNombre.get(i), Toast.LENGTH_SHORT).show();
                }
                else {
                    variables.setImagen(ListaImagenes.get(i));
                    variables.setProducto(ListaNombre.get(i));
                    variables.setUltimoProducto(variables.getUltimaPantalla());
                    txtNombre.setText("Seleccionado: " + ListaNombre.get(i));
                    Toast.makeText(contexto, "Producto seleccionado", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return vista;
    }
}

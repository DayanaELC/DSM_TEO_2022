package com.example.ejemploadapter;

import java.util.ArrayList;

public class Variables {
    static String Imagen, Producto;
    static int ultimaPantalla, ultimoProducto;
    static ArrayList<String> ListaNombreProducto=new ArrayList<>();
    static ArrayList<String>ListaImagen=new ArrayList<>();

    public int getUltimaPantalla() {
        return ultimaPantalla;
    }

    public void setUltimaPantalla(int ultimaPantalla) {
        Variables.ultimaPantalla = ultimaPantalla;
    }

    public int getUltimoProducto() {
        return ultimoProducto;
    }

    public void setUltimoProducto(int ultimoProducto) {
        Variables.ultimoProducto = ultimoProducto;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
        ArregloImagen();
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String producto) {
        Producto = producto;
        ArregloProducto();
    }

    public ArrayList<String> getListaNombreProducto() {
        return ListaNombreProducto;
    }

    public void setListaNombreProducto(ArrayList<String> listaNombreProducto) {
        ListaNombreProducto = listaNombreProducto;
    }

    public ArrayList<String> getListaImagen() {
        return ListaImagen;
    }

    public void setListaImagen(ArrayList<String> listaImagen) {
        ListaImagen = listaImagen;
    }

    public void ArregloProducto(){
        ListaNombreProducto.add(Producto);
    }

    public void ArregloImagen(){
        ListaImagen.add(Imagen);
    }
}

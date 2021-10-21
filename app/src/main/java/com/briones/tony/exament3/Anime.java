package com.briones.tony.exament3;

public class Anime {

    public  String Nombre;

    public String Descripcion;

    public String img;


    public Anime() {
    }

    public Anime(String nombre, String descripcion, String img) {
        Nombre = nombre;
        Descripcion = descripcion;
        this.img = img;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}

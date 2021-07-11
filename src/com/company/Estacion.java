package com.company;

public class Estacion {

    private String nombre;

    public Estacion(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object obj) {
        return nombre.equals(((Estacion)obj).nombre);
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return  nombre;
    }
}

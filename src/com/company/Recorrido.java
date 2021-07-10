package com.company;

import java.util.ArrayList;
import java.util.List;

public class Recorrido {
    private String estacionDestino;
    private String estacionOrigen;
    private Integer cantPersonas;
    private List<String> estaciones;

    public Boolean esRecorridoCompleto(){
        return estacionOrigen.equals("Buenos Aires") && estacionDestino.equals("Bragado") || estacionOrigen.equals("Bragado") && estacionDestino.equals("Buenos Aires");
    }

    public Boolean existeLaEstacion(String estacion){
        List<String> estaciones = new ArrayList<>();
        estaciones.add("Buenos Aires");
        estaciones.add("Lujan");
        estaciones.add("Mercedes");
        estaciones.add("Suipacha");

        return estaciones.contains(estacion);
    }


}

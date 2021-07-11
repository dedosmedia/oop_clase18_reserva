package com.company;

import java.util.ArrayList;
import java.util.List;

public class Recorrido {

    private Estacion origen;
    private Estacion destino;

    private Double precioRecorrido;

    public Recorrido(Estacion origen, Estacion destino) throws RecorridoExcepcion {

        if(origen.equals(destino))
        {
            throw new RecorridoExcepcion("La estación de origen y destino son la misma: "+origen.getNombre());
        }
        if(origen == null || destino == null){
            throw new RecorridoExcepcion("Alguna de ls estaciones es nula");
        }

        this.origen = origen;
        this.destino = destino;
        this.precioRecorrido = calcularPrecioRecorrido();
    }

    public Double getPrecioRecorrido() {
        return precioRecorrido;
    }

    public Estacion getOrigen() {
        return origen;
    }

    public Estacion getDestino() {
        return destino;
    }

    /*
        Calcula el precio total de este recorrido, basado en precio por trayecto y la cantidad de trayectos de este recorrido.
     */
    private Double calcularPrecioRecorrido() {
        return getCantidadTrayectos()*Empresa.precioPorTrayecto;        // TODO: Aquí uso el static de empresa. ¿Está bien?
    }

    /*
        Nos retorna la primera estación en el orden en que están en la lista de estaciones
     */
    private Estacion getPrimeraEstacion(){
        return Empresa.listaEstaciones.get(0);
    }

    /*
        Nos retorna la última estación en el orden en que están en la lista de estaciones
     */
    private Estacion getUltimaEstacion(){
        return Empresa.listaEstaciones.get( Empresa.listaEstaciones.size()-1);
    }
    /*
        Verifica si el recorrido es entre la primera estación y la última o no
     */
    public Boolean esRecorridoCompleto() {
        Estacion primera = getPrimeraEstacion();
        Estacion ultima = getUltimaEstacion();
        return origen.getNombre().equals(primera.getNombre()) && destino.getNombre().equals(ultima.getNombre()) || destino.getNombre().equals(primera.getNombre()) && origen.getNombre().equals(ultima.getNombre()) ;
    }

    /*
        Calcula cuantos trayectos hay entre el origen y destino de este recorrido
     */
    private Integer getCantidadTrayectos(){
        Integer index1 = Empresa.listaEstaciones.indexOf(origen);
        Integer index2 = Empresa.listaEstaciones.indexOf(destino);
        return Math.abs(index1-index2);
    }
}

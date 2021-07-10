package com.company;

public class Reserva {
    private String codigo;
    private Recorrido recorrido;
    private Integer cantPersonas;
    private Double precioBoleto;

    public Reserva(String codigo, Recorrido recorrido, Integer cantPersonas) {
        this.codigo = codigo;
        this.recorrido = recorrido;
        this.cantPersonas = cantPersonas;
        precioBoleto = 50.0;
    }

    public Double calcularPrecio(){
        Double precio = cantPersonas * precioBoleto;
        if(recorrido.esRecorridoCompleto()){
            precio = precio * 0.8;
        }
        return precio;
    }
}
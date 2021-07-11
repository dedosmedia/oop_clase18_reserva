package com.company;

public class Reserva {
    private Integer codigo;
    private Recorrido recorrido;
    private Integer cantPersonas;
    private Double precioReserva;

    public Reserva(Integer codigo, Recorrido recorrido, Integer cantPersonas) throws ReservaException {

        if(cantPersonas < 0){
            throw new ReservaException("No puedes crear una reserva sin personas.");
        }

        this.codigo = codigo;
        this.recorrido = recorrido;
        this.cantPersonas = cantPersonas;
        this.precioReserva = calcularPrecioReserva();  // TODO: ¿Está bien o mal esto de inicializar en el constructor llamando un método?
    }

    public Integer getCodigo() {
        return codigo;
    }

    public Recorrido getRecorrido() {
        return recorrido;
    }

    public Integer getCantPersonas() {
        return cantPersonas;
    }

    public Double getPrecioReserva() {
        return precioReserva;
    }

    /*
        Si esta reserva tiene como destino la misma estación del parámetro, retornará la cantidad de personas de la misma
        caso contrario retornará 0.
     */
    public Integer getPersonasPorDestino(Estacion estacion){
        return recorrido.getDestino().getNombre() == estacion.getNombre() ? cantPersonas : 0;
    }

    /*
        Determina el precio de la reserva dependiendo de la cantidad de personas y el precio por persona del recorrido.
        Aplica descuento del 20% si es recorrido completo.
     */
    public Double calcularPrecioReserva(){
        Double precio = cantPersonas * recorrido.getPrecioRecorrido();
        if(recorrido.esRecorridoCompleto()){
            precio = precio * 0.8;
        }
        return precio;
    }
}
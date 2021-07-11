package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Empresa empresa = new Empresa(50.0);

        Estacion buenosAires = new Estacion("Buenos Aires");
        Estacion lujan = new Estacion("Luján");
        Estacion mercedes = new Estacion("Mercedes");
        Estacion suipacha = new Estacion("Suipacha");
        Estacion chivilcoy = new Estacion("Chivilcoy");
        Estacion alberti = new Estacion("Alberti");
        Estacion bragado = new Estacion("Bragado");

        try {
            empresa.agregarEstacion(buenosAires);
            empresa.agregarEstacion(lujan);
            empresa.agregarEstacion(mercedes);
            empresa.agregarEstacion(suipacha);
            empresa.agregarEstacion(chivilcoy);
            empresa.agregarEstacion(alberti);
            empresa.agregarEstacion(bragado);
        }
        catch (EmpresaException e){
            // En caso que intente agregar 2 estaciones con el mismo nombre
            e.printStackTrace();
        }

        Recorrido recorrido1 = null;
        Recorrido recorrido2 = null;
        Recorrido recorrido3 = null;
        try{
            recorrido1 = new Recorrido(buenosAires, bragado);
            recorrido2 = new Recorrido(buenosAires, alberti);
            recorrido3 = new Recorrido(lujan, buenosAires);
        }
        catch (RecorridoExcepcion e){
            // En caso que las estaciones de origen y destino sean las mismas
            // o alguna de ellas sea nula.
            e.printStackTrace();
        }

        Reserva reserva1 = null;
        Reserva reserva2 = null;
        Reserva reserva3 = null;
        Reserva reserva4 = null;
        try {
            reserva1 = new Reserva(1, recorrido1, 5);
            reserva2 = new Reserva(2, recorrido2, 1);
            reserva3 = new Reserva(3, recorrido3, 3);
            reserva4 = new Reserva(4, recorrido1, 8);
        }
        catch (ReservaException e){
            // Si la reserva se intenta hacer con menos de 1 persona
            e.printStackTrace();
        }

        empresa.agregarReserva(reserva1);
        empresa.agregarReserva(reserva2);
        empresa.agregarReserva(reserva3);
        empresa.agregarReserva(reserva4);


        System.out.println("La recaudación total es: "+empresa.recaudacionTotal());

        try {
            Estacion prueba = new Estacion("Pichincha");
            Integer personasQueDescienden = empresa.cantVecesRecorrida(prueba);
        }
        catch (EmpresaException e) {
            // Si no hay ninguna persona que descienda en la estación pasada como parámetro
            e.printStackTrace();
        }


        try {
            System.out.println("La cantidad de personas que descienden en "+bragado.getNombre() +" son: "+ empresa.cantVecesRecorrida(bragado).toString());
        }
        catch (EmpresaException e)
        {
            // Si no hay ninguna persona que descienda en la estación pasada como parámetro
            e.printStackTrace();
        }




    }
}

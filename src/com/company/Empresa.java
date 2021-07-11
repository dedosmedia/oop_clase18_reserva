package com.company;

import java.util.ArrayList;
import java.util.List;

public class Empresa {

   public static List<Estacion> listaEstaciones;  // TODO: ¿Esto como static está bien o hay otra mejor manera de hacerlo?
   public static Double precioPorTrayecto;        // TODO: ¿Esto como static está bien o hay otra mejor manera de hacerlo?

   private List<Reserva> listaReservas;

   public Empresa(Double precioPorTrayecto) {
      this.precioPorTrayecto = precioPorTrayecto;
      listaReservas = new ArrayList<>();
      listaEstaciones = new ArrayList<>();
   }

   /*
      Agrega una estación con el nombre indicado.
      Genera error si la estación con ese nombre ya existe
    */
   public void agregarEstacion(Estacion estacion) throws EmpresaException {
      if(!listaEstaciones.contains(estacion)) {
         listaEstaciones.add(estacion);
      }
      else {
         throw new EmpresaException("Ya existe una estación con este nombre: "+estacion.getNombre());
      }
   }
   /*
      Agrega una reserva
    */
   public void agregarReserva(Reserva reserva){
      listaReservas.add(reserva);
   }

   /*
      Calcula el costo total de todas las reservas en la lista
    */
   public Double recaudacionTotal(){

      Double total = 0.0;
      for (Reserva reserva: listaReservas ) {
         Double parcial = reserva.getPrecioReserva();
         System.out.println("La reserva "+reserva.getCodigo()+" de "+reserva.getCantPersonas()+" personas, entre "+reserva.getRecorrido().getOrigen()+" y "+reserva.getRecorrido().getDestino()+" cuesta: "+ parcial);
         total += parcial;
      }
      return total;
   }

   /*
      Cuenta cuantas personas tienen como destino la estación indicada según las reservas
    */
   public Integer cantVecesRecorrida(Estacion estacion) throws EmpresaException{
      Integer total = 0;
      for(Reserva reserva:listaReservas) {
         Integer parcial = reserva.getPersonasPorDestino(estacion);
         System.out.println("De la reserva "+reserva.getCodigo()+" descienden " + parcial+ " personas en "+estacion);
         total += parcial;
      }
      if(total == 0 ) {
         throw new EmpresaException("No hay personas que se bajen en la estación: "+estacion.getNombre());
      }
      return total;
   }

   /*
      Verifica si la estación que indicamos ya existe o no
    */
   public Boolean existeEstacion(Estacion estacion){
      return listaEstaciones.contains(estacion);
   }



}

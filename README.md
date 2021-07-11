# oop_clase18_reserva
Solución ejercicio clase 18 de OOP en Java. 

**Ejercicio de modelado UML y programación en Java**

**Objetivo**

Modelar en UML y luego programar en Java la siguiente problemática.

**Enunciado**

Se desea un primer prototipo de sistema de reservas de viajes en tren por el interior del país. La empresa cuenta con una lista de reservas, de las cuales se conoce su código, su recorrido y la cantidad de personas que viajarán.

Del recorrido se sabe la estación de destino y la estación de partida. Las estaciones posibles, en orden, son: Buenos Aires, Luján, Mercedes, Suipacha, Chivilcoy, Alberti y Bragado.

Para calcular el precio de una reserva debe multiplicarse la cantidad de personas por el precio del boleto, el cual es de $50. Si el viaje fue de cabecera a cabecera (por ahora, Buenos Aires-Bragado o viceversa) se ofrece un 20% de descuento.

La empresa nos menciona que, en el futuro, está previsto que el tren pare en más pueblos y, por ende, haya nuevas estaciones, incluso intermedias, por lo que espera que el software sea escalable.

Con base en este enunciado realice:
*	El diagrama de clases que lo modelice, con sus relaciones, atributos y métodos.
*	La explotación del método **recaudacionTotal** que retorne el monto total recaudado según el precio de todas las reservas.
* La explotación del método **cantVecesRecorrida** que reciba una estación por parámetro y retorna cuántas personas pasarán por esa estación, de acuerdo a las reservas existentes. Si el parámetro recibido no corresponde a ninguna de las estaciones, arrojar una excepción.

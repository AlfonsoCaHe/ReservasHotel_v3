package org.iesalandalus.programacion.reservashotel.vista;

public enum Opcion {
    INSERTAR_HUESPED("Insertar hu�sped."),
    BUSCAR_HUESPED("Buscar hu�sped."),
    BORRAR_HUESPED("Borrar hu�sped."),
    MOSTRAR_HUESPEDES("Mostrar hu�spedes."),
    INSERTAR_HABITACION("Insertar habitaci�n."),
    BUSCAR_HABITACION("Buscar habitaci�n."),
    BORRAR_HABITACION("Borrar habitaci�n."),
    MOSTRAR_HABITACIONES("Mostrar habitaciones."),
    INSERTAR_RESERVA("Insertar reserva."),
    ANULAR_RESERVA("Anular reserva."),
    MOSTRAR_RESERVAS("Mostrar reservas."),
    CONSULTAR_DISPONIBILIDAD("Consultar disponibilidad."),
    REALIZAR_CHECKIN("Realizar CheckIn."),
    REALIZAR_CHECKOUT("Realizar CheckOut."),
    SALIR("Salir.");

    private String cadenaAMostrar;
    private Opcion(String cadenaAMostrar){
        this.cadenaAMostrar = cadenaAMostrar;
    }

    @Override
    public String toString() {
        return (ordinal()+1)+".- "+cadenaAMostrar;
    }
}
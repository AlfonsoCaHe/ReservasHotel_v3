package org.iesalandalus.programacion.reservashotel.modelo.negocio.memoria;

import org.iesalandalus.programacion.reservashotel.modelo.dominio.*;
import org.iesalandalus.programacion.reservashotel.modelo.negocio.IReservas;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

public class Reservas implements IReservas {
    private ArrayList<Reserva> coleccionReservas;

    /*Crea el constructor con par�metros que crear� una lista de la capacidad indicada en el par�metro e inicializar� los atributos de la clase a los valores correspondientes.*/
    public Reservas() {
        coleccionReservas = new ArrayList<>();
    }

    /*Crea el m�todo get que devolver� una copia profunda de la colecci�n haciendo uso del m�todo copiaProfundaReservas.*/
    public ArrayList<Reserva> get() {
        return copiaProfundaReservas();
    }

    private ArrayList<Reserva> copiaProfundaReservas() {
        ArrayList<Reserva> copiaReservas = new ArrayList<>();
        Iterator it = coleccionReservas.iterator();
        while(it.hasNext()){
            copiaReservas.add(new Reserva((Reserva) it.next()));
        }
        return copiaReservas;
    }

    public int getTamano() {
        return coleccionReservas.size();
    }

    /*Se permitir�n insertar reservas no nulas al final de la colecci�n sin admitir repetidos.*/
    public void insertar(Reserva reserva) throws OperationNotSupportedException {
        try {
            if (reserva != null) {
                if(!coleccionReservas.contains(reserva)) {//El resultado ser� -1 si no se encuentra ya incluida la reserva
                    coleccionReservas.add(reserva);
                }else{
                    throw new OperationNotSupportedException("ERROR: Ya existe una reserva igual.");
                }
            } else {
                throw new NullPointerException("ERROR: No se puede insertar una reserva nula.");
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("ERROR: No se puede insertar una reserva nula.");
        }
    }

    private int buscarIndice(Reserva reserva) {
        if (reserva == null)
            throw new NullPointerException("ERROR: No se puede buscar una reserva nula.");

        return coleccionReservas.indexOf(reserva);
    }

    /*El m�todo buscar devolver� una reserva si �sta se encuentra en la colecci�n y null en caso contrario.*/
    public Reserva buscar(Reserva reserva) {
        if(reserva == null)
            throw new NullPointerException("ERROR: No se puede buscar una reserva nula.");

        Reserva reservaEncontrada = null;

        if(coleccionReservas.contains(reserva)){
            reservaEncontrada = coleccionReservas.get(coleccionReservas.indexOf(reserva));
        }
        return reservaEncontrada;
    }

    /*El m�todo borrar, si la reserva se encuentra en la colecci�n, la borrar� y desplazar� los elementos hacia la izquierda
    para dejar el array compactado.
    */
    public void borrar(Reserva reserva) throws OperationNotSupportedException {
        try {
            if(reserva != null) {
                if(coleccionReservas.contains(reserva)){//Si la reserva est� contenida en la colecci�n
                    coleccionReservas.remove(reserva);
                }else {
                    throw new OperationNotSupportedException("ERROR: No existe ninguna reserva como la indicada.");
                }
            }else{
                throw new NullPointerException("ERROR: No se puede borrar una reserva nula.");
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("ERROR: No se puede borrar una reserva nula.");
        }

    }

    /*El m�todo getReservas que est� sobrecargado y devolver� una colecci�n de las reservas realizadas por el hu�sped pasado
    por par�metro o una colecci�n de las reservas realizadas para el tipo de habitaci�n indicada como par�metro.
    */
    public ArrayList<Reserva> getReservas(Huesped huesped) {
        if (huesped == null) {
            throw new NullPointerException("ERROR: No se pueden buscar reservas de un hu�sped nulo.");
        }

        ArrayList<Reserva> copiaReservas = new ArrayList<>();
        Iterator it = coleccionReservas.iterator();

        while(it.hasNext()){
            Reserva r = (Reserva) it.next();
            if(r.getHuesped().equals(huesped)){
                copiaReservas.add(r);
            }
        }
        return copiaReservas;
    }

    public ArrayList<Reserva> getReservas(TipoHabitacion tipoHabitacion) {
        ArrayList<Reserva> copiaReservas = new ArrayList<>();
        try{
            if(tipoHabitacion == null) {
                throw new NullPointerException("ERROR: No se pueden buscar reservas de un tipo de habitaci�n nula.");
            }

            /*for(Reserva r : coleccionReservas){
                switch (r.getHabitacion().getClass().getName()){
                    case "org.iesalandalus.programacion.reservashotel.modelo.dominio.Simple":
                        if(tipoHabitacion.toString().toUpperCase().equals("SIMPLE"))
                            copiaReservas.add(r);
                        break;
                    case "org.iesalandalus.programacion.reservashotel.modelo.dominio.Doble":
                        if(tipoHabitacion.toString().toUpperCase().equals("DOBLE"))
                            copiaReservas.add(r);
                        break;
                    case "org.iesalandalus.programacion.reservashotel.modelo.dominio.Triple":
                        if(tipoHabitacion.toString().toUpperCase().equals("TRIPLE"))
                            copiaReservas.add(r);
                        break;
                    case "org.iesalandalus.programacion.reservashotel.modelo.dominio.Suite":
                        if(tipoHabitacion.toString().toUpperCase().equals("SUITE"))
                            copiaReservas.add(r);
                }
            }*/
            for(Reserva r : coleccionReservas){
                if(r.getHabitacion() instanceof Simple){
                    if(tipoHabitacion.toString().toUpperCase().equals("SIMPLE"))
                        copiaReservas.add(r);
                }
                if(r.getHabitacion() instanceof Doble){
                    if(tipoHabitacion.toString().toUpperCase().equals("DOBLE"))
                        copiaReservas.add(r);
                }
                if(r.getHabitacion() instanceof Triple){
                    if(tipoHabitacion.toString().toUpperCase().equals("TRIPLE"))
                        copiaReservas.add(r);
                }
                if(r.getHabitacion() instanceof Suite){
                    if(tipoHabitacion.toString().toUpperCase().equals("SUITE"))
                        copiaReservas.add(r);
                }
            }

        }catch(NullPointerException e) {
            throw new NullPointerException("ERROR: No se pueden buscar reservas de un tipo de habitaci�n nula.");
        }
        return copiaReservas;
    }


    /*El m�todo getReservasFuturas que devolver� una colecci�n de las reservas realizadas para la habitaci�n indicada como
    par�metro y que sean posteriores a la fecha de hoy.
    */
    public ArrayList<Reserva> getReservasFuturas(Habitacion habitacion) {
        if(habitacion == null) {
            throw new NullPointerException("ERROR: No se pueden buscar reservas de una habitaci�n nula.");
        }

        ArrayList<Reserva> copiaReservas = new ArrayList<>();
        Iterator it = coleccionReservas.iterator();

        while(it.hasNext()){
            Reserva r = (Reserva) it.next();
            if(r.getHabitacion().equals(habitacion) && r.getFechaInicioReserva().atStartOfDay().isAfter(LocalDateTime.now())){
                copiaReservas.add(new Reserva(r));
            }
        }
        return copiaReservas;
    }

    public void realizarCheckin(Reserva reserva, LocalDateTime fecha) {
        try{
            int indice = buscarIndice(reserva);
            coleccionReservas.get(indice).setCheckIn(fecha);
        }catch(NullPointerException e) {
            throw new NullPointerException(e.getMessage());
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public void realizarCheckout(Reserva reserva, LocalDateTime fecha) {
        try {
            int indice = buscarIndice(reserva);
            coleccionReservas.get(indice).setCheckOut(fecha);
        }catch(NullPointerException e) {
            throw new NullPointerException(e.getMessage());
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
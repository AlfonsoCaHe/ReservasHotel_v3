package org.iesalandalus.programacion.reservashotel.modelo.negocio.memoria;

import org.iesalandalus.programacion.reservashotel.modelo.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.TipoHabitacion;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Iterator;

public class Habitaciones {

    private ArrayList<Habitacion> coleccionHabitaciones;

    /*Crea el constructor que crear� una lista del tipo Habitacion*/
    public Habitaciones(){
        coleccionHabitaciones = new ArrayList<>();
    }

    /*Crea el m�todo get que est� sobrecargado y devolver�
    El m�todo sin par�metros, una copia profunda de la colecci�n haciendo uso del m�todo copiaProfundaHabitaciones.
    */
    public ArrayList<Habitacion> get() {
        return copiaProfundaHabitaciones();
    }

    private ArrayList<Habitacion> copiaProfundaHabitaciones(){
        ArrayList<Habitacion> copiaHabitaciones = new ArrayList<>();
        Iterator it = coleccionHabitaciones.iterator();
        while(it.hasNext()){
            copiaHabitaciones.add(new Habitacion((Habitacion) it.next()));
        }
        return copiaHabitaciones;
    }

    /*
    El m�todo con el par�metro TipoHabitacion, un copia profunda de la colecci�n pero de solo aquellas habitaciones cuyo tipo sea
    el indicado como par�metro.
     */
    public ArrayList<Habitacion> get(TipoHabitacion tipoHabitacion) {
        ArrayList<Habitacion> copiaHabitaciones = new ArrayList<>();

        Iterator it = coleccionHabitaciones.iterator();

        while(it.hasNext()){
            Habitacion habitacionAuxiliar = (Habitacion) it.next();
            if(habitacionAuxiliar.getTipoHabitacion().equals(tipoHabitacion))
                copiaHabitaciones.add(new Habitacion(habitacionAuxiliar));
        }
        return copiaHabitaciones;
    }

    /*Se permitir�n insertar habitaciones no nulas al final de la colecci�n sin admitir repetidos.*/
    public void insertar(Habitacion habitacion) throws OperationNotSupportedException {
        try{
            if(habitacion != null) {
                if(!coleccionHabitaciones.contains(habitacion)) {
                    coleccionHabitaciones.add(habitacion);//Insertamos al final del array
                }else{
                    throw new OperationNotSupportedException("ERROR: Ya existe una habitaci�n con ese identificador.");
                }
            }else{
                throw new NullPointerException("ERROR: No se puede insertar una habitaci�n nula.");
            }
        }catch(NullPointerException e){
            throw new NullPointerException("ERROR: No se puede insertar una habitaci�n nula.");
        }
    }

    /*El m�todo buscar devolver� una habitaci�n si �sta se encuentra en la colecci�n y null en caso contrario.*/
    public Habitacion buscar(Habitacion habitacion){
        if(habitacion == null)
            throw new NullPointerException("ERROR: No se puede buscar una habitaci�n nula.");
        Habitacion habitacionEncontrada = null;
        if(coleccionHabitaciones.contains(habitacion)) {//Si no se encuentra �ndice, es que la habitacion no se encuentra dentro del array
            habitacionEncontrada = coleccionHabitaciones.get(coleccionHabitaciones.indexOf(habitacion));
        }
        return habitacionEncontrada;
    }

    /*El m�todo borrar, si la habitaci�n se encuentra en la colecci�n, la borrar� y desplazar� los elementos hacia la izquierda para dejar el array compactado.*/
    public void borrar(Habitacion habitacion) throws OperationNotSupportedException {
        if(habitacion == null)
            throw new NullPointerException("ERROR: No se puede borrar una habitaci�n nula.");
        if(coleccionHabitaciones.contains(habitacion)){
            coleccionHabitaciones.remove(habitacion);
        }else{
            throw new OperationNotSupportedException("ERROR: No existe ninguna habitaci�n como la indicada.");
        }
    }

    public int getTamano(){
        return coleccionHabitaciones.size();
    }
}
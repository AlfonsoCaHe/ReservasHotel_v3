package org.iesalandalus.programacion.reservashotel.modelo.negocio.memoria;

import org.iesalandalus.programacion.reservashotel.modelo.dominio.Habitacion;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.TipoHabitacion;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Iterator;

public class Habitaciones {

    private ArrayList<Habitacion> coleccionHabitaciones;

    /*Crea el constructor que creará una lista del tipo Habitacion*/
    public Habitaciones(){
        coleccionHabitaciones = new ArrayList<>();
    }

    /*Crea el método get que está sobrecargado y devolverá
    El método sin parámetros, una copia profunda de la colección haciendo uso del método copiaProfundaHabitaciones.
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
    El método con el parámetro TipoHabitacion, un copia profunda de la colección pero de solo aquellas habitaciones cuyo tipo sea
    el indicado como parámetro.
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

    /*Se permitirán insertar habitaciones no nulas al final de la colección sin admitir repetidos.*/
    public void insertar(Habitacion habitacion) throws OperationNotSupportedException {
        try{
            if(habitacion != null) {
                if(!coleccionHabitaciones.contains(habitacion)) {
                    coleccionHabitaciones.add(habitacion);//Insertamos al final del array
                }else{
                    throw new OperationNotSupportedException("ERROR: Ya existe una habitación con ese identificador.");
                }
            }else{
                throw new NullPointerException("ERROR: No se puede insertar una habitación nula.");
            }
        }catch(NullPointerException e){
            throw new NullPointerException("ERROR: No se puede insertar una habitación nula.");
        }
    }

    /*El método buscar devolverá una habitación si ésta se encuentra en la colección y null en caso contrario.*/
    public Habitacion buscar(Habitacion habitacion){
        if(habitacion == null)
            throw new NullPointerException("ERROR: No se puede buscar una habitación nula.");
        Habitacion habitacionEncontrada = null;
        if(coleccionHabitaciones.contains(habitacion)) {//Si no se encuentra índice, es que la habitacion no se encuentra dentro del array
            habitacionEncontrada = coleccionHabitaciones.get(coleccionHabitaciones.indexOf(habitacion));
        }
        return habitacionEncontrada;
    }

    /*El método borrar, si la habitación se encuentra en la colección, la borrará y desplazará los elementos hacia la izquierda para dejar el array compactado.*/
    public void borrar(Habitacion habitacion) throws OperationNotSupportedException {
        if(habitacion == null)
            throw new NullPointerException("ERROR: No se puede borrar una habitación nula.");
        if(coleccionHabitaciones.contains(habitacion)){
            coleccionHabitaciones.remove(habitacion);
        }else{
            throw new OperationNotSupportedException("ERROR: No existe ninguna habitación como la indicada.");
        }
    }

    public int getTamano(){
        return coleccionHabitaciones.size();
    }
}
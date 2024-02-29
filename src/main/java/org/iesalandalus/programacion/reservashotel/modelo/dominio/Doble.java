package org.iesalandalus.programacion.reservashotel.modelo.dominio;

public class Doble extends Habitacion{

    private static int NUM_MAXIMO_PERSONAS = 2;
    static final int MIN_NUM_CAMAS_INDIVIDUALES = 0;
    static final int MAX_NUM_CAMAS_INDIVIDUALES = 2;
    static final int MIN_NUM_CAMAS_DOBLES = 0;
    static final int MAX_NUM_CAMAS_DOBLES = 1;
    private int numCamasIndividuales;
    private int numCamasDobles;

    public Doble(int planta, int puerta, double precio, int numCamasIndividuales, int numCamasDobles){
        super(planta, puerta, precio);
        try{
            setNumCamasIndividuales(numCamasIndividuales);
            setNumCamasDobles(numCamasDobles);
            validaNumCamas();
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Doble(Doble habitacionDoble){
        super(habitacionDoble.getPlanta(), habitacionDoble.getPuerta(), habitacionDoble.getPrecio());
        try{
            setNumCamasIndividuales(habitacionDoble.getNumCamasIndividuales());
            setNumCamasDobles(habitacionDoble.getNumCamasDobles());
            validaNumCamas();
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public int getNumCamasIndividuales() {
        return numCamasIndividuales;
    }

    public void setNumCamasIndividuales(int numCamasIndividuales) {
        this.numCamasIndividuales = numCamasIndividuales;
    }

    public int getNumCamasDobles() {
        return numCamasDobles;
    }

    public void setNumCamasDobles(int numCamasDobles) {
        this.numCamasDobles = numCamasDobles;
    }

    private void validaNumCamas(){
        if(numCamasIndividuales != MAX_NUM_CAMAS_INDIVIDUALES){//Si no hay dos camas individuales
            if(numCamasDobles != MAX_NUM_CAMAS_DOBLES){//Debe haber una doble
                throw new IllegalArgumentException("ERROR: El número de camas no es correcto.");
            }
        }else{
            if(numCamasDobles != MIN_NUM_CAMAS_DOBLES){//Hay dos camas individuales y al menos una doble
                throw new IllegalArgumentException("ERROR: El número de camas no es correcto.");
            }
        }
    }

    @Override
    public int getNumeroMaximoPersonas() {
        return NUM_MAXIMO_PERSONAS;
    }

    @Override
    public String toString() {
        return super.toString()+"doble, capacidad="+NUM_MAXIMO_PERSONAS+" personas, " + "camas individuales="+numCamasIndividuales+", camas dobles="+numCamasDobles;
    }
}
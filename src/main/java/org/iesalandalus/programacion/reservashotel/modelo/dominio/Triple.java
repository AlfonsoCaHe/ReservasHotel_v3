package org.iesalandalus.programacion.reservashotel.modelo.dominio;

public class Triple extends Habitacion{

    private static int NUM_MAXIMO_PERSONAS = 3;
    static final int MIN_NUM_BANOS = 1;
    static final int MAX_NUM_BANOS = 2;
    static final int MIN_NUM_CAMAS_INDIVIDUALES = 1;
    static final int MAX_NUM_CAMAS_INDIVIDUALES = 3;
    static final int MIN_NUM_CAMAS_DOBLES = 0;
    static final int MAX_NUM_CAMAS_DOBLES = 1;
    private int numBanos;
    private int numCamasIndividuales;
    private int numCamasDobles;

    public Triple(int planta, int puerta, double precio, int numBanos, int numCamasIndividuales, int numCamasDobles){
        super(planta, puerta, precio);
        try{
            setNumBanos(numBanos);
            setNumCamasIndividuales(numCamasIndividuales);
            setNumCamasDobles(numCamasDobles);
            validaNumCamas();
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Triple(Triple habitacionTriple){
        super(habitacionTriple.getPlanta(), habitacionTriple.getPuerta(), habitacionTriple.getPrecio());
        try{
            setNumBanos(habitacionTriple.getNumBanos());
            setNumCamasIndividuales(habitacionTriple.getNumCamasIndividuales());
            setNumCamasDobles(habitacionTriple.getNumCamasDobles());
            validaNumCamas();
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public int getNumBanos() {
        return numBanos;
    }

    public void setNumBanos(int numBanos) {
        this.numBanos = numBanos;
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
        if(numCamasDobles == MAX_NUM_CAMAS_DOBLES){
            if(numCamasIndividuales != MIN_NUM_CAMAS_INDIVIDUALES){
                throw new IllegalArgumentException("ERROR: El número de camas no es correcto.");
            }
        }else{
            if(numCamasIndividuales != MAX_NUM_CAMAS_INDIVIDUALES){
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
        return super.toString()+"triple, capacidad="+NUM_MAXIMO_PERSONAS+" personas, " + "baños="+numBanos+", camas individuales="+numCamasIndividuales+", camas dobles="+numCamasDobles;
    }
}
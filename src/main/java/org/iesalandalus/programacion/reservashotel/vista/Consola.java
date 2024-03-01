package org.iesalandalus.programacion.reservashotel.vista;

import org.iesalandalus.programacion.reservashotel.modelo.dominio.*;
import org.iesalandalus.programacion.utilidades.Entrada;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Consola {
    /*
    Crea su constructor teniendo en cuenta que es una clase de utilidades y que no tiene sentido instanciar objetos de la misma.
     */
    private Consola(){

    }

    /*Crea el m�todo mostrarMenu que mostrar� las diferentes opciones de nuestro programa de forma autom�tica teniendo en cuenta
    cada uno de los objetos instancias del Enumerado Opcion (insertar, buscar, borrar, ...).
    */
    public static void mostrarMenu(){
        for(Opcion op : Opcion.values())
            System.out.println(op.toString());
    }

    /*Crea el m�todo elegirOpcion que pedir� que elijamos la opci�n y devolver� la instancia del enumerado Opcion correspondiente.*/
    public static Opcion elegirOpcion() {
        int opcionElegida = -1;//Inicializamos a una opci�n no v�lida.
        Opcion opcion = Opcion.SALIR;
        do{
            mostrarMenu();
            System.out.print("\nElija una opci�n: (0-" + (Opcion.values().length-1) + ") ");
            opcionElegida = Entrada.entero();
        }while((opcionElegida < 0) || (opcionElegida > Opcion.values().length-1));//Las opciones van del 0 a la �ltima opci�n
        switch (opcionElegida){
            case 1:
                opcion = Opcion.INSERTAR_HUESPED;
                break;
            case 2:
                opcion = Opcion.BUSCAR_HUESPED;
                break;
            case 3:
                opcion = Opcion.BORRAR_HUESPED;
                break;
            case 4:
                opcion = Opcion.MOSTRAR_HUESPEDES;
                break;
            case 5:
                opcion = Opcion.INSERTAR_HABITACION;
                break;
            case 6:
                opcion = Opcion.BUSCAR_HABITACION;
                break;
            case 7:
                opcion = Opcion.BORRAR_HABITACION;
                break;
            case 8:
                opcion = Opcion.MOSTRAR_HABITACIONES;
                break;
            case 9:
                opcion = Opcion.INSERTAR_RESERVA;
                break;
            case 10:
                opcion = Opcion.ANULAR_RESERVA;
                break;
            case 11:
                opcion = Opcion.MOSTRAR_RESERVAS;
                break;
            case 12:
                opcion = Opcion.LISTAR_RESERVAS_HUESPED;
                break;
            case 13:
                opcion = Opcion.LISTAR_RESERVAS_TIPO_HABITACION;
                break;
            case 14:
                opcion = Opcion.CONSULTAR_DISPONIBILIDAD;
                break;
            case 15:
                opcion = Opcion.REALIZAR_CHECKIN;
                break;
            case 16:
                opcion = Opcion.REALIZAR_CHECKOUT;
        }
        return opcion;
    }

    /*Crea el m�todo leerHuesped que nos pedir� los datos correspondientes a un hu�sped y devolver� un objeto instancia de dicha
    clase en el caso que los datos introducidos sean correctos o propague la excepci�n correspondiente en caso contrario.
    */
    public static Huesped leerHuesped() throws IllegalArgumentException{
        Huesped huesped = null;
        try{
            System.out.print("Nombre y apellidos:\t");
            String nombre = Entrada.cadena();
            System.out.print("\nDNI:\t");
            String dni = Entrada.cadena();
            System.out.print("\nCorreo:\t");
            String correo = Entrada.cadena();
            System.out.print("\nTel�fono:\t");
            String telefono = Entrada.cadena();
            System.out.println("\nFecha de Nacimiento:\t");
            System.out.print("\tD�a de Nacimiento:");
            int dia = Entrada.entero();
            System.out.print("\n\tMes de Nacimiento:");
            int mes = Entrada.entero();
            System.out.print("\n\tA�o de Nacimiento:");
            int ano = Entrada.entero();
            LocalDate fechaNacimiento = LocalDate.of(ano, mes, dia);
            System.out.println("Fecha de nacimiento: "+fechaNacimiento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

            huesped = new Huesped(nombre, dni, correo, telefono, fechaNacimiento);

        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return huesped;
    }

    /*Crea el m�todo leerClientePorDni que nos pedir� el dni del hu�sped y devolver� un huesped con el dni introducido y con el
    resto de datos ficticios cumpliendo las restricciones de creaci�n de un hu�sped. En caso contrario, deber� propagar la
    excepci�n correspondiente.
    */
    public static Huesped leerClientePorDni(String dni){
        Huesped huesped = null;
        try{
            if(dni == null) {
                throw new NullPointerException("ERROR: El dni de un huesped no puede ser nulo.");
            }
            huesped = new Huesped("Huesped", dni, "huesped@iesalandalus.es", "123456789", LocalDate.of(2000,1,1));
        }catch (IllegalArgumentException e){
            System.out.println("ERROR: No se puede crear un huesped con ese dni.");
        }
        return huesped;
    }

    /*Crea el m�todo leerFecha que nos pedir� que introduzcamos una cadena correspondiente a una fecha en el formato adecuado y
    devolver� el objeto LocalDate correspondiente. Esto se repetir� mientras la fecha introducida no sea v�lida.
    */
    public static LocalDate leerFecha() throws DateTimeException{
        LocalDate fecha = null;
        do{
            try {
                System.out.print("\tIntroduzca el d�a: ");
                int dia = Entrada.entero();
                System.out.print("\n\tIntroduzca el mes: ");
                int mes = Entrada.entero();
                System.out.print("\n\tIntroduzca el a�o: ");
                int ano = Entrada.entero();
                System.out.println(" ");
                fecha = LocalDate.of(ano, mes, dia);
            }catch(DateTimeException e) {
                System.err.println("ERROR: La fecha introducida no es correcta.");
            }
        }while(fecha == null);
        return fecha;
    }

    /*Crea el m�todo leerHabitacion que nos pedir� los datos correspondientes a una habitaci�n y devolver� un objeto instancia de
    dicha clase en el caso que los datos introducidos sean correctos o propague la excepci�n correspondiente en caso contrario.
    */
    public static Habitacion leerHabitacion(){
        Habitacion habitacion = null;
        try {
            System.out.print("\tIntroduzca la planta: ");
            int planta = Entrada.entero();
            System.out.print("\n\tIntroduzca la puerta: ");
            int puerta = Entrada.entero();
            System.out.print("\n\tIntroduzca el precio de la habitaci�n: ");
            double precio = Entrada.realDoble();
            System.out.println(" ");
            TipoHabitacion tipoHabitacion = leerTipoHabitacion();
            int camasIndividuales;
            int camasDobles;
            int numBanos;
            switch (tipoHabitacion.toString()){
                case "SIMPLE":
                    habitacion = new Simple(planta, puerta, precio);
                    break;
                case "DOBLE":
                    System.out.println("Introduzca el n�mero de camas individuales:");
                    camasIndividuales = Entrada.entero();
                    System.out.println(" ");
                    System.out.println("Introduzca el n�mero de camas dobles:");
                    camasDobles = Entrada.entero();
                    System.out.println(" ");
                    habitacion = new Doble(planta, puerta, precio, camasIndividuales, camasDobles);
                    break;
                case "TRIPLE":
                    System.out.println("Introduzca el n�mero de camas individuales:");
                    camasIndividuales = Entrada.entero();
                    System.out.println(" ");
                    System.out.println("Introduzca el n�mero de camas dobles:");
                    camasDobles = Entrada.entero();
                    System.out.println(" ");
                    System.out.println("Introduzca el n�mero de ba�os:");
                    numBanos = Entrada.entero();
                    System.out.println(" ");
                    habitacion = new Triple(planta, puerta, precio, numBanos, camasIndividuales, camasDobles);
                    break;
                case "SUITE":
                    boolean jacuzzi = false;
                    System.out.println("Introduzca el n�mero de ba�os:");
                    numBanos = Entrada.entero();
                    System.out.println(" ");
                    int opcion;
                    do{
                        System.out.println("�La habitaci�n posee jacuzzi? \n1.S�\n2.No");
                        opcion = Entrada.entero();
                        System.out.println(" ");
                    }while(opcion < 1 || opcion > 2);
                    habitacion = new Suite(planta, puerta, precio, numBanos, jacuzzi);
            }
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
        return habitacion;
    }

    /*Crea el m�todo leerTipoHabitacion que pedir� que elijamos un tipo de habitaci�n y devolver� la instancia del enumerado
    TipoHabitaci�n correspondiente.
    */
    public static TipoHabitacion leerTipoHabitacion(){
        TipoHabitacion tipoHabitacion = null;
        int opcion;
        do {
            System.out.print("\n\tIntroduzca el tipo de habitaci�n: ");
            System.out.println("\n\t\t1. Suite.\n\t\t2. Simple.\n\t\t3. Doble.\n\t\t4. Triple.");
            opcion = Entrada.entero();
            switch (opcion) {
                case 1:
                    tipoHabitacion = TipoHabitacion.SUITE;
                    break;
                case 2:
                    tipoHabitacion = TipoHabitacion.SIMPLE;
                    break;
                case 3:
                    tipoHabitacion = TipoHabitacion.DOBLE;
                    break;
                case 4:
                    tipoHabitacion = TipoHabitacion.TRIPLE;
            }
        } while (opcion < 1 || opcion > 4);
        return tipoHabitacion;
    }

    /*Crea el m�todo leerRegimen que pedir� que elijamos un tipo de r�gimen y devolver� la instancia del enumerado
    Regimen correspondiente.*/
    public static Regimen leerRegimen(){
        Regimen regimen = null;
        int opcion;
        do {
            System.out.print("\n\tIntroduzca el tipo de r�gimen: ");
            System.out.println("\t\t1. Solo alojamiento.\n\t\t2. Alojamiento y desayuno.\n\t\t3. Media pensi�n.\n\t\t4. Pensi�n completa.");
            opcion = Entrada.entero();
            switch (opcion) {
                case 1:
                    regimen = Regimen.SOLO_ALOJAMIENTO;
                    break;
                case 2:
                    regimen = Regimen.ALOJAMIENTO_DESAYUNO;
                    break;
                case 3:
                    regimen = Regimen.MEDIA_PENSION;
                    break;
                case 4:
                    regimen = Regimen.PENSION_COMPLETA;
            }
        } while (opcion < 1 || opcion > 4);
        return regimen;
    }

    /*Crea el m�todo leerReserva que nos pedir� los datos correspondientes a una reserva y devolver� un objeto instancia de
    dicha clase en el caso que los datos introducidos sean correctos o propague la excepci�n correspondiente en caso contrario.
    */
    public static Reserva leerReserva(){
        Reserva reserva;
        int numero_Personas;
        System.out.print("Introduzca el dni del cliente: ");
        Huesped huesped = leerClientePorDni(Entrada.cadena());
        System.out.println(" ");
        Regimen regimen = leerRegimen();
        do{
            System.out.print("Introduzca el n�mero de personas para la reserva: (1 -4) ");
            numero_Personas = Entrada.entero();
            System.out.println(" ");
        }while(numero_Personas < 1 || numero_Personas > 4);
        reserva = new Reserva(huesped, new Suite(Habitacion.MIN_NUMERO_PLANTA+1, Habitacion.MIN_NUMERO_PUERTA+1, Habitacion.MIN_PRECIO_HABITACION, 1, false), regimen, LocalDate.now().plusDays(1), LocalDate.now().plusDays(2), numero_Personas);
        return reserva;
    }
}

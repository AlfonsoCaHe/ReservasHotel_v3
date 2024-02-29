package org.iesalandalus.programacion.reservashotel.vista;

import org.iesalandalus.programacion.reservashotel.controlador.Controlador;
import org.iesalandalus.programacion.reservashotel.modelo.dominio.*;
import org.iesalandalus.programacion.utilidades.Entrada;

import javax.naming.OperationNotSupportedException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Vista {
    private Controlador controlador;
    public void setControlador(Controlador controlador){
        if(controlador != null)
            this.controlador = controlador;
        else{
            throw new NullPointerException("ERROR: El controlador no puede ser nulo.");
        }
    }

    public void comenzar(){
        System.out.println("************************************************************");
        System.out.println("Bienvenido al sistema de gestión de nuestra cadena hotelera.");
        System.out.println("************************************************************\n");
        int opcion = 0;
        do {
            /*try {
                opcion = Consola.elegirOpcion();
                ejecutarOpcion(opcion);
                System.out.println("\n************************************************************\n");
            }catch(OperationNotSupportedException | IllegalArgumentException | NullPointerException e){
                System.out.println("ERROR: Operación no permitida. "+e.getMessage());
            }*/
        } while (opcion != Opcion.values().length);
    }

    public void terminar(){
        System.out.println("\t\tFIN DE LA APLICACIÓN. Les esperamos pronto.\n");
        System.out.println("************************************************************");
    }

    /*private void ejecutarOpcion(int opcion) throws OperationNotSupportedException {
        try{
            switch(opcion){
                case 1:
                    System.out.println("\n************************************************************");
                    System.out.println("Insertar huésped");
                    System.out.println("************************************************************\n");
                    insertarHuesped();
                    break;
                case 2:
                    System.out.println("\n************************************************************");
                    System.out.println("Buscar huésped");
                    System.out.println("************************************************************\n");
                    buscarHuesped();
                    break;
                case 3:
                    System.out.println("\n************************************************************");
                    System.out.println("Borrar huésped");
                    System.out.println("************************************************************\n");
                    borrarHuesped();
                    break;
                case 4:
                    System.out.println("\n************************************************************");
                    System.out.println("Mostrar huéspedes");
                    System.out.println("************************************************************\n");
                    mostrarHuespedes();
                    break;
                case 5:
                    System.out.println("\n************************************************************");
                    System.out.println("Insertar habitación");
                    System.out.println("************************************************************\n");
                    insertarHabitacion();
                    break;
                case 6:
                    System.out.println("\n************************************************************");
                    System.out.println("Buscar habitación");
                    System.out.println("************************************************************\n");
                    buscarHabitacion();
                    break;
                case 7:
                    System.out.println("\n************************************************************");
                    System.out.println("Borrar habitación");
                    System.out.println("************************************************************\n");
                    borrarHabitacion();
                    break;
                case 8:
                    System.out.println("\n************************************************************");
                    System.out.println("Mostrar habitaciones");
                    System.out.println("************************************************************\n");
                    mostrarHabitaciones();
                    break;
                case 9:
                    System.out.println("\n************************************************************");
                    System.out.println("Insertar Reserva");
                    System.out.println("************************************************************\n");
                    insertarReserva();
                    break;
                case 10:
                    System.out.println("\n************************************************************");
                    System.out.println("Anular reserva");
                    System.out.println("************************************************************\n");
                    anularReserva();
                    break;
                case 11:
                    System.out.println("\n************************************************************");
                    System.out.println("Mostrar Reservas");
                    System.out.println("************************************************************\n");
                    mostrarReservas();
                    break;
                case 12:
                    System.out.println("\n************************************************************");
                    System.out.println("Comprobar habitaciones disponibles");
                    System.out.println("************************************************************\n");
                    TipoHabitacion tipoHabitacion = Consola.leerTipoHabitacion();
                    System.out.println("Introduzca la fecha de inicio de reserva:");
                    LocalDate fechaInicioReserva = Consola.leerFecha();
                    System.out.println("Introduzca la fecha de fin de reserva:");
                    LocalDate fechaFinReserva = Consola.leerFecha();
                    Habitacion habitacion = consultarDisponibilidad(tipoHabitacion, fechaInicioReserva, fechaFinReserva);
                    if(habitacion == null){
                        System.out.println("\nNo existen habitaciones del tipo "+tipoHabitacion.toString()+" en las fechas escogidas.");
                    }else{
                        System.out.println("\n"+habitacion.toString());
                    }
                    break;
                case 13:
                /*Para localizar la reserva deber? preguntarse por el huesped de la misma, obtener su lista de reservas y
                establecer la fecha y hora de checkin de la reserva correspondiente. Hay que tener en cuenta que un huesped
                puede haber realizado varias reservas para el mismo d?a. Adem?s, en caso de intentar hacer checkin de una
                reserva no existente en el d?a indicado para el hu?sped, la aplicaci?n deber? informar con alg?n mensaje de
                lo sucedido.*/
       /*             System.out.println("\n************************************************************");
                    System.out.println("Realizar check in");
                    System.out.println("************************************************************\n");

                    System.out.print("Introduzca el dni del huesped: ");//Buscamos el huesped
                    String cadena = Entrada.cadena();
                    Huesped huespedReserva = Consola.leerClientePorDni(cadena);//Obtenemos la informaci?n del huesped
                    System.out.println(" ");
                    if(huespedReserva != null) {
                        ArrayList<Reserva> reserva = controlador.getReservas(huespedReserva);//Obtenemos las reservas del huesped
                        LocalDate fechaCheck = Consola.leerFecha();
                        int horas, minutos;
                        do {
                            System.out.print("Introduzca la hora: ");
                            horas = Entrada.entero();
                        }while(horas < 0 || horas > 23);
                        do {
                            System.out.print("Introduzca los minutos: ");
                            minutos = Entrada.entero();
                        }while(minutos < 0 || minutos > 59);
                        LocalTime horaCheck = LocalTime.of(horas, minutos, 0);
                        LocalDateTime fecha = LocalDateTime.of(fechaCheck, horaCheck);

                        Iterator it = reserva.iterator();

                        boolean checkValido = false;//Validamos que se haya realizado el check in al menos 1 vez
                        while(it.hasNext()){
                            Reserva r = (Reserva) it.next();
                            if(r.getFechaInicioReserva().isEqual(fecha.toLocalDate())){
                                controlador.realizarCheckIn(r, fecha);
                                checkValido = true;
                            }
                        }

                        if (!checkValido) {
                            System.out.println("No se ha podido realizar el check in. El hu?sped no tiene reserva la fecha dada.");
                        }else{
                            System.out.println("Check In realizado correctamente.");
                        }
                    }else{
                        System.out.println("No existe un huésped con ese dni.");
                    }
                    break;
                case 14:
                    System.out.println("\n************************************************************");
                    System.out.println("Realizar check out");
                    System.out.println("************************************************************\n");

                    System.out.print("Introduzca el dni del huesped: ");//Buscamos el huesped
                    cadena = Entrada.cadena();
                    huespedReserva = Consola.leerClientePorDni(cadena);//Obtenemos la informaci?n del huesped
                    System.out.println(" ");
                    if(huespedReserva != null) {
                        ArrayList<Reserva> reserva = controlador.getReservas(huespedReserva);//Obtenemos las reservas del huesped
                        LocalDate fechaCheck = Consola.leerFecha();
                        int horas, minutos;
                        do {
                            System.out.print("Introduzca la hora: ");
                            horas = Entrada.entero();
                        }while(horas < 0 || horas > 23);
                        do {
                            System.out.print("Introduzca los minutos: ");
                            minutos = Entrada.entero();
                        }while(minutos < 0 || minutos > 59);
                        LocalTime horaCheck = LocalTime.of(horas, minutos, 0);
                        LocalDateTime fecha = LocalDateTime.of(fechaCheck, horaCheck);

                        boolean checkValido = false;//Validamos que se realice al menos 1 check out correctamente
                        Iterator it = reserva.iterator();

                        while(it.hasNext()){
                            Reserva r = (Reserva) it.next();
                            if(r.getFechaFinReserva().isEqual(fecha.toLocalDate())){
                                controlador.realizarCheckOut(r, fecha);
                                checkValido = true;
                            }
                        }

                        if (!checkValido) {
                            System.out.println("No se ha podido realizar el check in. El hu?sped no tiene reserva la fecha dada.");
                        }else{
                            System.out.println("Check Out realizado correctamente.");
                        }
                    }else{
                        System.out.println("No existe un hu?sped con ese dni.");
                    }
                    break;
            }
        }catch(IllegalArgumentException | OperationNotSupportedException | NullPointerException e){
            System.out.println(e.getMessage());
        }
    }*/

    /*Crea el método insertarHuesped que nos pedir? los datos de un hu?sped, haciendo uso de la clase Consola, y lo insertar? en
    la colecci?n correspondiente si es posible o informar? del problema en caso contrario.*/
    private void insertarHuesped()throws OperationNotSupportedException{
        Huesped huesped = null;
        try{
            huesped = Consola.leerHuesped();
            controlador.insertar(huesped);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

    /*Crea el método buscarHuesped que nos pedir? el dni de un hu?sped, haciendo uso de la clase Consola, mostr?ndonos a dicho
    huesped o informar? de que no existe o informar? del problema en caso acontecido.*/
    private void buscarHuesped(){
        try{
            if(!controlador.getHuespedes().isEmpty()){//Si el primer huesped no es vac?o, es que existen huespedes en el array
                System.out.print("Introduzca el dni que desea buscar: ");
                String dni = Entrada.cadena();
                System.out.println(" ");
                Huesped huesped = Consola.leerClientePorDni(dni);
                boolean encontrado = false;
                ArrayList<Huesped> huespedesBusqueda = controlador.getHuespedes();

                if(huespedesBusqueda.contains(huesped)){
                    huesped = controlador.buscar(huesped);
                    encontrado = true;
                }

                if(encontrado) {
                    System.out.println(huesped.toString());
                } else {
                    System.out.println("No se ha encontrado un huesped con ese dni.");
                }
            }else{
                System.out.println("No existen registros de huéspedes.");
            }
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /*Crea el método borrarHuesped que nos pedir? el dni de un hu?sped, haciendo uso de la clase Consola, borr?ndolo si es
    posible o informar? del problema en caso contrario.*/
    private void borrarHuesped()throws OperationNotSupportedException {
        try {
            if(!controlador.getHuespedes().isEmpty()) {
                System.out.print("Introduzca el dni que desea buscar: ");
                String dni = Entrada.cadena();
                System.out.println(" ");
                Huesped huesped = Consola.leerClientePorDni(dni);

                if (controlador.getHuespedes().contains(huesped)) {
                    huesped = controlador.buscar(huesped);
                    ArrayList<Reserva> reservasAnulables = new ArrayList<>();
                    if(!controlador.getReservas(huesped).isEmpty()) {
                        reservasAnulables = getReservasAnulables(controlador.getReservas(huesped));
                    }
                    if (reservasAnulables.isEmpty()) {//Si no quedan reservas de ese huesped
                        controlador.borrar(huesped);
                        System.out.println("Huesped borrado correctamente.");
                    } else {
                        System.out.println("No se puede borrar un huesped con reservas pendientes.");
                    }
                } else {
                    System.out.println("No se ha encontrado un huesped con ese dni.");
                }
            }else {
                System.out.println("No existen registros de huéspedes.");
            }
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    /*Crea el método mostrarHuespedes que mostrar? todos los hu?spedes almacenados si es que hay o si no, nos informar? de que
    no hay hu?spedes.*/
    private void mostrarHuespedes(){
        if(controlador.getHuespedes().isEmpty()){
            System.out.println("No existen registros de huéspedes.");
        }else{
            ArrayList<Huesped> huespedesOrdenados = controlador.getHuespedes();
            Collections.sort(huespedesOrdenados);

            Iterator it = huespedesOrdenados.iterator();
            while(it.hasNext()){
                Huesped h = (Huesped) it.next();
                System.out.println(h.toString());
            }
        }
    }

    /*Crea el método insertarHabitacion que nos pedir? los datos de una habitaci?n, haciendo uso de la clase Consola, y lo
    insertar? en la colecci?n correspondiente si es posible o informar? del problema en caso contrario.*/
    private void insertarHabitacion(){
        Habitacion habitacion = null;
        try{
            habitacion = Consola.leerHabitacion();
            controlador.insertar(habitacion);
        }catch(IllegalArgumentException |OperationNotSupportedException e){
            System.out.println(e.getMessage());
        }
    }

    /*Crea el método buscarHabitacion que nos pedir? el n?mero de puerta y el n?mero de planta de una habitaci?n, haciendo uso
    de la clase Consola, mostr?ndonos a dicha habitaci?n o informar? de que no existe o informar? del problema en caso
    acontecido.*/
    private void buscarHabitacion(){
        try{
            if(!controlador.getHabitaciones().isEmpty()){//Si el primer huesped no es nulo, es que existen huespedes en el array
                System.out.print("Introduzca el número de planta: ");
                int plantaBuscada = Entrada.entero();
                System.out.println(" ");
                System.out.print("Introduzca el número de habitación: ");
                int puertaBuscada = Entrada.entero();
                System.out.println(" ");
                Habitacion habitacion = new Simple(plantaBuscada, puertaBuscada, Habitacion.MIN_PRECIO_HABITACION);
                boolean encontrado = false;
                ArrayList<Habitacion> habitacionesBusqueda = controlador.getHabitaciones();

                if(habitacionesBusqueda.contains(habitacion)){
                    habitacion = controlador.buscar(habitacion);
                    encontrado = true;
                }

                if(encontrado) {
                    System.out.println(habitacion.toString());
                } else {
                    System.out.println("No se ha encontrado una habitación con el identificador "+plantaBuscada+puertaBuscada+".");
                }
            }else{
                System.out.println("No existen registros de habitaciones.");
            }
        }catch(IllegalArgumentException e){
            System.out.println("ERROR NO ESPERADO. " + e.getMessage());
        }
    }

    /*Crea el método borrarHabitacion que nos pedir? el n?mero de puerta y el n?mero de planta de una habitaci?n, haciendo uso
    de la clase Consola, borr?ndolo si es posible o informar? del problema en caso contrario.*/
    private void borrarHabitacion() throws OperationNotSupportedException {
        try{
            if(!controlador.getHabitaciones().isEmpty()) {
                System.out.print("Introduzca el número de planta: ");
                int plantaBuscada = Entrada.entero();
                System.out.println(" ");
                System.out.print("Introduzca el número de habitación: ");
                int puertaBuscada = Entrada.entero();
                System.out.println(" ");
                Habitacion habitacion = new Simple(plantaBuscada, puertaBuscada, Habitacion.MIN_PRECIO_HABITACION);

                if (controlador.getHabitaciones().contains(habitacion)) {
                    habitacion = controlador.buscar(habitacion);
                    ArrayList<Reserva> reservasAnulables = getReservasAnulables(controlador.getReservasFuturas(habitacion));
                    if (reservasAnulables.isEmpty()) {//Si no quedan reservas de esa habitacion
                        controlador.borrar(habitacion);
                        System.out.println("Habitación borrada correctamente.");
                    } else {
                        System.out.println("No se puede borrar una habitación con reservas pendientes.");
                    }
                } else {
                    System.out.println("No se ha encontrado una habitación con el identificador " + plantaBuscada + puertaBuscada + ".");
                }
            }else {
                System.out.println("No existen registros de habitaciones.");
            }
        }catch(IllegalArgumentException | OperationNotSupportedException e){
            System.out.println(e.getMessage());
        }
    }

    /*Crea el método mostrarHabitaciones que mostrar? todos las habitaciones almacenadas si es que hay o si no, nos informar?
    de que no hay habitaciones.*/
    private void mostrarHabitaciones(){
        ArrayList<Habitacion> habitaciones = controlador.getHabitaciones();

        if(habitaciones.isEmpty()){
            System.out.println("No existen registros de habitaciones.");
        }else{
            Collections.sort(habitaciones);
            Iterator it = habitaciones.iterator();

            while(it.hasNext()){
                Habitacion h = (Habitacion) it.next();
                System.out.println(h.toString());
            }
        }
    }

    /*Crea el método insertarReserva que nos pedir? los datos de una reserva, haciendo uso de la clase Consola, y lo insertar?
    en la colecci?n correspondiente si es posible o informar? del problema en caso contrario. Debe tenerse en cuenta que para
    poder insertar una reserva debe haber disponibilidad del tipo de habitaci?n deseada por el hu?sped en el periodo indicado.*/
    private void insertarReserva(){
        try{
            TipoHabitacion t = Consola.leerTipoHabitacion();
            System.out.println("Introduzca la fecha de inicio de la reserva: ");
            LocalDate fi = Consola.leerFecha();
            System.out.println(" ");
            System.out.println("Introduzca la fecha de fin de la reserva: ");
            LocalDate ff = Consola.leerFecha();
            System.out.println(" ");
            Habitacion habitacionReserva = consultarDisponibilidad(t, fi, ff);
            if(habitacionReserva != null) {
                Reserva r = Consola.leerReserva();
                Huesped huespedReserva = controlador.getHuespedes().get(controlador.getHuespedes().indexOf(r.getHuesped()));
                controlador.insertar(new Reserva(huespedReserva, habitacionReserva, r.getRegimen(), fi, ff, r.getNumeroPersonas()));
            }else{
                System.out.println("No hay ninguna habitación "+t.toString()+" disponible en esas fechas.");
            }
        }catch(IllegalArgumentException | NullPointerException | OperationNotSupportedException e){
            System.out.println(e.getMessage());
        }
    }










    public void mostrarReservasHuesped(){

    }












    /*Crea el método listarReservas que est? sobrecargado, mostrando todas las reservas almacenadas (si es que hay) del hu?sped,
    del tipo de habitaci?n o de la fecha indicada como par?metro. Si no hay, nos informar? de que no hay reservas.*/
    private void listarReservas(Huesped huesped){
        ArrayList<Reserva> reservasHuesped = controlador.getReservas(huesped);
        Collections.sort(reservasHuesped, new Comparator<Reserva>() {
            @Override
            public int compare(Reserva o1, Reserva o2) {
                int valor = 0;//Definimos como valor por defecto que las reservas sean iguales
                if(o1.getFechaInicioReserva().isBefore(o2.getFechaInicioReserva())){//Si la fecha de inicio es anterior va despu?s
                    valor = 1;
                }else{
                    if(o1.getFechaInicioReserva().isAfter(o2.getFechaInicioReserva())){//Si la fecha de inicio es posterior va primero
                        valor = -1;
                    }else{//Si ambas fechas de inicio son la misma, pasamos a ordenar por el identificador de la Habitacion, que ya se encuentra implementado en Habitacion
                        valor = o1.getHabitacion().compareTo(o2.getHabitacion());
                    }
                }
                return valor;
            }
        });

        Iterator it = reservasHuesped.iterator();
        while(it.hasNext()){
            Reserva r = (Reserva) it.next();
            System.out.println(r.toString());
        }
    }









    public void mostrarReservasTipoHabitacion(){

    }











    private void listarReservas(LocalDate fecha){
        ArrayList<Reserva> reservasFecha = controlador.getReservas();
        Collections.sort(reservasFecha);
        Iterator it = reservasFecha.iterator();
        while(it.hasNext()){
            Reserva r = (Reserva) it.next();
            if(r.getFechaInicioReserva().isBefore(fecha) && r.getFechaFinReserva().isAfter(fecha)){
                System.out.println(r.toString());
            }else{
                if(r.getFechaInicioReserva().isEqual(fecha) || r.getFechaFinReserva().isEqual(fecha)){
                    System.out.println(r.toString());
                }
            }
        }
    }

    /*Crea el método getReservasAnulables que de la colecci?n de reservas recibida como par?metro, devolver? aquellas que sean
    anulables, es decir, cuya fecha de inicio de la reserva a?n no haya llegado.*/
    private ArrayList<Reserva> getReservasAnulables(ArrayList<Reserva> reservasAAnular){
        ArrayList<Reserva> reserva = new ArrayList<>();
        try{
            if(!reservasAAnular.isEmpty()){
                Iterator it = reservasAAnular.iterator();
                while(it.hasNext()){
                    Reserva r = (Reserva) it.next();
                    if(r.getFechaInicioReserva().isAfter(LocalDate.now())){//Si la fecha de inicio es posterior a hoy, se a?ade al array a devolver.
                        reserva.add(r);
                    }
                }
            }else{
                throw new IllegalArgumentException("ERROR: el array reservasAAnular est? vac?o.");
            }
        }catch(IllegalArgumentException | NullPointerException e){
            System.out.println("ERROR INESPERADO. " + e.getMessage());
        }
        return reserva;
    }

    /*Crea el método anularReserva que pedir? el dni del hu?sped del que se desea anular una reserva (haciendo uso de la clase
    Consola), obteniendo de todas las reservas de dicho hu?sped aquellas que sean anulables. En el caso de que no tenga ninguna
    anulable deber? de informarse de dicha circunstancia. Si solo tiene una reserva anulable deber? confirmarse de que realmente
    se quiere anular. Y por ?ltimo, en el caso de que el hu?sped tenga m?s de una reserva anulable, deber?n ser listadas
    precedidas por un n?mero para que el usuario elija la reserva que desea anular. */
    private void anularReserva() throws OperationNotSupportedException{
        System.out.print("Introduzca el dni del cliente: ");
        Huesped huesped = controlador.buscar(Consola.leerClientePorDni(Entrada.cadena()));
        System.out.println(" ");

        ArrayList<Reserva> reservaHuesped = getReservasAnulables(controlador.getReservas(huesped));
        if(!reservaHuesped.isEmpty()){
            int opcion;
            if(reservaHuesped.size() == 1){
                System.out.println("El hu?sped solo dispone de 1 reserva anulable: ");
                System.out.println(reservaHuesped.get(0).toString());
                System.out.println("?Desea realmente anularla?\n\t1. S?\n\t2. No");
                do{
                    opcion = Entrada.entero();
                }while(opcion < 1 || opcion > 2);
                if(opcion == 1){
                    controlador.borrar(reservaHuesped.get(0));
                    System.out.println("Reserva anulada correctamente.");
                }else{
                    System.out.println("No se ha borrado ninguna reserva.");
                }
            }else{
                Iterator it = reservaHuesped.iterator();
                int contador = 0;//Iniciamos un contador para las diferentes opciones
                while(it.hasNext()){
                    Reserva r = (Reserva) it.next();
                    System.out.println(""+(contador+1)+". "+r.toString());
                    contador++;
                }
                do{
                    System.out.print("\nSeleccione una reserva para anularla o escoja 0 para cancelar: ");
                    opcion = Entrada.entero();
                }while(opcion < 0 || opcion > reservaHuesped.size());
                if(opcion != 0){
                    controlador.borrar(reservaHuesped.get(opcion - 1));//Borramos el contenido de (opcion-1) que ser? el elemento escogido
                    System.out.println("Reserva anulada correctamente.");
                }else{
                    System.out.println("No se ha borrado ninguna reserva.");
                }
            }
        }else{
            System.out.println("No existen reservas anulables para el huesped.");
        }
    }

    /*Crea el método mostrarReservas que mostrar? todas las reservas almacenadas si es que hay o si no, nos informar? de que no
    hay reservas. */
    private void mostrarReservas(){
        int opcion = 0;
        ArrayList<Reserva> reservas = new ArrayList<>();
        if(controlador.getReservas().isEmpty()){
            System.out.println("No existen registros de reservas.");
        }else{
            do{
                System.out.println("1. Mostrar todas las reservas.");
                System.out.println("2. Mostrar todas las reservas de un huesped.");
                System.out.println("3. Mostrar todas las reservas de un tipo de habitaci?n.");
                System.out.println("4. Mostrar todas las reservas en una fecha.");
                System.out.println("0. Cancelar.");
                System.out.print("Escoja una opci?n: ");
                opcion = Entrada.entero();
                System.out.println(" ");
            } while(opcion < 0 || opcion > 4);
            switch(opcion){
                case 1://Mostrar todas las reservas
                    reservas = controlador.getReservas();
                    Collections.sort(reservas);
                    Iterator it = reservas.iterator();

                    while(it.hasNext()){
                        Reserva rAux = (Reserva) it.next();
                        System.out.println(rAux.toString());
                    }
                    break;
                case 2://Mostrar las reservas de un huesped
                    System.out.print("Introduzca el dni del hu?sped: ");
                    String dni = Entrada.cadena();
                    System.out.print(" ");
                    Huesped huespedBusqueda = controlador.buscar(Consola.leerClientePorDni(dni));

                    if(huespedBusqueda != null){
                        if(!controlador.getReservas(huespedBusqueda).isEmpty()) {//Comprobamos que existan reservas del huesped
                            listarReservas(huespedBusqueda);//Mostramos las reservas del huesped
                        }else{
                            System.out.println("No se han encontrado reservas del huesped.");
                        }
                    }else {
                        System.out.println("No se ha encontrado un huesped con ese dni.");
                    }
                    break;
                case 3:
                    TipoHabitacion tipo = Consola.leerTipoHabitacion();
                    listarReservas(tipo);
                    break;
                case 4:
                    LocalDate fecha = Consola.leerFecha();
                    listarReservas(fecha);
                    break;
                default:
            }
        }
    }

    /*Crea el método consultarDisponibilidad que devuelve una habitaci?n del tipo indicado por par?metro y que est? disponible
    entre las fechas de inicio y fin de la reserva, tambi?n indicados por par?metro.*/
    private Habitacion consultarDisponibilidad(TipoHabitacion tipoHabitacion, LocalDate fechaInicioReserva, LocalDate fechaFinReserva){
        Habitacion habitacion = null;

        try{
            ArrayList<Habitacion> habitacionesDisponibles = controlador.getHabitaciones(tipoHabitacion);//Creamos una copia profunda de todas las habitaciones del hotel que sean del tipo solicitado.
            /*
            Ahora vamos a eliminar aquellas habitaciones del tipo esperado que est?n ocupadas en la fecha solicitada.
            Para ello vamos a crear otra copia de las reservas del tipo de habitaci?n y las vamos a ir recorriendo para
            borrar aquellas habitaciones que no est?n disponibles en el intervalo de fechas solicitado.
            */
            ArrayList<Reserva> reservas = controlador.getReservas(tipoHabitacion);
            Iterator it = reservas.iterator();

            while(it.hasNext() && !habitacionesDisponibles.isEmpty()){
                Reserva r = (Reserva) it.next();
                if(fechaInicioReserva.isBefore(r.getFechaFinReserva()) && fechaFinReserva.isAfter(r.getFechaInicioReserva())){//Si la fecha de inicio de la reserva es anterior a la fecha de la reserva y la fecha de fin de la reserva es mayor que la de inicio. La habitaci?n estar? ocupada. Por tanto se borra.
                    if(habitacionesDisponibles.contains(r.getHabitacion())){//Nos aseguramos que la habitaci?n no haya sido borrada ya
                        habitacionesDisponibles.remove(r.getHabitacion());
                    }
                }else{
                    if(fechaInicioReserva.equals(r.getFechaInicioReserva())){//Si las fechas de inicio coindicen, la habitaci?n no estar? disponible. Por tanto se borra.
                        if(habitacionesDisponibles.contains(r.getHabitacion())){//Nos aseguramos que la habitaci?n no haya sido borrada ya
                            habitacionesDisponibles.remove(r.getHabitacion());
                        }
                    }else{//Solo queda que la fecha de inicio fuera posterior a la fecha de inicio de la reserva
                        if(fechaInicioReserva.isAfter(r.getFechaInicioReserva()) && fechaInicioReserva.isBefore(r.getFechaFinReserva())){//Si la fecha de inicio es posterior a la de inicio de la reserva y anterior de a la de fin de la reserva, no estar? disponible. Por tanto se borra.
                            if(habitacionesDisponibles.contains(r.getHabitacion())){//Nos aseguramos que la habitaci?n no haya sido borrada ya
                                habitacionesDisponibles.remove(r.getHabitacion());
                            }
                        }
                    }
                }
            }

            if(!habitacionesDisponibles.isEmpty()){//Si todav?a quedan habitaciones
                habitacion = habitacionesDisponibles.get(0);
            }
        }catch(IllegalArgumentException | NullPointerException e){
            System.out.println(e.getMessage());
        }
        return habitacion;
    }

    private void listarReservas(TipoHabitacion tipoHabitacion){
        ArrayList<Reserva> reservasTipoHabitacion = controlador.getReservas(tipoHabitacion);
        Collections.sort(reservasTipoHabitacion, new Comparator<Reserva>() {
            @Override
            public int compare(Reserva o1, Reserva o2) {
                int valor = 0;//Definimos como valor por defecto que las reservas sean iguales
                if(o1.getFechaInicioReserva().isBefore(o2.getFechaInicioReserva())){//Si la fecha de inicio es anterior va despu?s
                    valor = 1;
                }else{
                    if(o1.getFechaInicioReserva().isAfter(o2.getFechaInicioReserva())){//Si la fecha de inicio es posterior va primero
                        valor = -1;
                    }else{//Si ambas fechas de inicio son la misma, pasamos a ordenar por nombre del huesped, que ya se encuentra implementado en Huesped
                        valor = o1.getHuesped().compareTo(o2.getHuesped());
                    }
                }
                return valor;
            }
        });
        Iterator it = reservasTipoHabitacion.iterator();
        while(it.hasNext()){
            Reserva r = (Reserva) it.next();
            System.out.println(r.toString());
        }
    }

    /*Crea el método getNumElementosNoNulos que devolver? el n?mero de elementos del array que no son nulos.*/
    /*private int getNumElementosNoNulos(ArrayList<Reserva> reservas){
        int contador = 0;
        for(int i = 0; i < reservas.size() && reservas.get(i) != null; i++){
            contador--;//Cada vez que hay un elemento no nulo, sumamos al total de elementos
        }
        return contador;//Si ning?n elemento es nulo devolver? el tama?o total. Si est? vac?o devolver? 0
    }*/
}
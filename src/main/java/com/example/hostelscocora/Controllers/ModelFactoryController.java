package com.example.hostelscocora.Controllers;

import com.example.hostelscocora.Model.*;
import com.example.hostelscocora.Persistencia.Persistencia;

import java.io.IOException;
import java.util.ArrayList;

public class ModelFactoryController {
    Hostal hostal;

    public Empleado crearEmpleado(String nombre, String cedula, Usuario usuario) throws Exception {
        return hostal.crearEmpleado(nombre,cedula,usuario);
    }
    public Usuario crearUsuario(String username, String password, TipoUsuario tipoUsuario) throws Exception {
        return hostal.crearUsuario(username,password,tipoUsuario);
    }
    public Cliente crearCliente(String nombre, String cedula, Usuario usuario) throws Exception {
        return hostal.crearCliente(nombre,cedula,usuario);
    }
    public Cama crearCama(String id, TipoProducto tipo) throws Exception {
        return hostal.crearCama(id,tipo);
    }
    public HabitacionSencilla crearHabitacionSencilla(String id, TipoProducto tipo, boolean isCamaExtra, boolean isReservada, double precioNoche) throws Exception {
        return hostal.crearHabitacionSencilla(id,tipo,isCamaExtra,isReservada,precioNoche);
    }
    public HabitacionDoble crearHabitacionDoble(String id, TipoProducto tipo, boolean isCamaExtra, boolean isReservada, int numCamasDobles, int numCamasSencillas, double precioNoche) throws Exception {
        return hostal.crearHabitacionDoble(id,tipo,isCamaExtra,isReservada,numCamasDobles,numCamasSencillas,precioNoche);
    }
    public void agregarProducto(Producto producto) throws Exception {
        hostal.agregarProducto(producto);
    }
    public void eliminarUsuario(Usuario usuario) throws Exception {
        hostal.eliminarUsuario(usuario);
    }
    public void eliminarEmpleado(Empleado empleado) throws Exception {
        hostal.eliminarEmpleado(empleado);
    }
    public void eliminarCliente(Cliente cliente) throws Exception {
        hostal.eliminarCliente(cliente);
    }
    public void eliminarCama(Cama cama) throws Exception {
        hostal.eliminarCama(cama);
    }
    public void eliminarHabitacion(Habitacion habitacion) throws Exception {
        hostal.eliminarHabitacion(habitacion);
    }
    public void eliminarProducto(Producto producto) throws Exception {
        hostal.elimnarProducto(producto);
    }
    public Empleado iniciarSesionEmpleado(String username, String password) throws Exception {
       return hostal.iniciarSesionEmpleado(username,password);
    }
    public Cliente iniciarSesionCliente(String username, String password) throws Exception {
        return hostal.iniciarSesionCliente(username, password);
    }
    public ArrayList<Empleado> getListaEmpleados(){
        return hostal.getListaEmpleados();
    }
    public ArrayList<Cliente> getListaClientes(){
        return hostal.getListaClientes();
    }
    public ArrayList<Habitacion> getListaHabitaciones(){
        return hostal.getListaHabitaciones();
    }
    public ArrayList<Cama> getListaCamas(){
        return hostal.getListaCamas();
    }
    public ArrayList<Reserva> getListaReservas(){
        return hostal.getListaReservas();
    }
    public ArrayList<Producto> getListaProdcutos(){ return hostal.getListaProductos();
    }
    public void cambiarCama(Cama cama, String id, EstadoProducto estadoProducto) throws IOException {
        hostal.cambiarCama(cama,id,estadoProducto);
    }
    public void cambiarHabitacion(Habitacion habitacion, EstadoProducto estadoProducto, boolean isReservada) throws IOException {
        hostal.cambiarHabitacion(habitacion,estadoProducto,isReservada);
    }
    public ArrayList<Habitacion> getListaHabitacionesDisponibles(){
        return hostal.getListaHabitacionesDisponibles();
    }




    //------------------------------  Singleton ------------------------------------------------
    // Clase estatica oculta. Tan solo se instanciara el singleton una vez
    private static class SingletonHolder {
        // El constructor de Singleton puede ser llamado desde aqu� al ser protected
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // M�todo para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {


        guardarResourceBinario();
        cargarResourceXML();


        //Siempre se debe verificar si la raiz del recurso es null
        if(hostal == null)
        {
            System.out.println("es null");
            inicializarDatos();
            guardarResourceXML();
            guardarResourceBinario();
        }

        //Registrar la accion de incio de sesi�n
        Persistencia.guardaRegistroLog("Inicio de sesion del usuario:pedro", 1, "inicioSesion");


    }


    public void guardarResourceBinario() {

        Persistencia.guardarRecursoHostalBinario(hostal);
    }


    public void cargarResourceXML() {

        hostal = Persistencia.cargarRecursoHostalXML();
    }


    public void guardarResourceXML() {

        Persistencia.guardarRecursoHostalXML(hostal);
    }



    private void inicializarDatos() {

        hostal = new Hostal();
        System.out.println("Hostels inicializado "+ hostal );

    }



}

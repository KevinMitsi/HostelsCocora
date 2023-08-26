package com.example.hostelscocora.Persistencia;

import com.example.hostelscocora.Model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {
    public static final String RUTA_ARCHIVO_EMPLEADOS = "C:\\Users\\Kevin\\Documents\\GitHub\\HostelsCocora\\src\\main\\java\\com\\example\\hostelscocora\\archivos\\archivoEmpleados.txt";
    public static final String RUTA_ARCHIVO_USUARIOS = "C:\\Users\\Kevin\\Documents\\GitHub\\HostelsCocora\\src\\main\\java\\com\\example\\hostelcocora\\archivos\\archivoUsuarios.txt";
    public static final String RUTA_ARCHIVO_CLIENTES = "C:\\Users\\Kevin\\Documents\\GitHub\\HostelsCocora\\src\\main\\java\\com\\example\\hostelcocora\\archivos\\archivoClientes.txt";
    public static final String RUTA_ARCHIVO_RESERVAS = "C:\\Users\\Kevin\\Documents\\GitHub\\HostelsCocora\\src\\main\\java\\com\\example\\hostelscocora\\archivos\\archivoReseras.txt";
    public static final String RUTA_ARCHIVO_LOG = "C:\\Users\\Kevin\\Documents\\GitHub\\HostelsCocora\\src\\main\\java\\com\\example\\hostelscocora\\archivos\\SnowaloweLog.txt";
    public static final String RUTA_ARCHIVO_MODELO_HOTAL_BINARIO = "C:\\Users\\Kevin\\Documents\\GitHub\\HostelsCocora\\src\\main\\java\\com\\example\\hostelscocora\\archivos\\model.dat";
    public static final String RUTA_ARCHIVO_MODELO_HOSTAL_XML = "C:\\Users\\Kevin\\Documents\\GitHub\\HostelsCocora\\src\\main\\java\\com\\example\\hostelscocora\\archivos\\model.xml";









    /**
     * Guarda en un archivo de texto todos la informaci�n de las personas almacenadas en el ArrayList

     * @throws IOException
     */



    public static void guardarArchivoEmpleados(ArrayList<Empleado> listaEmpleados) throws IOException {

        // TODO Auto-generated method stub
        String contenido = "";

        for(Empleado empleado:listaEmpleados)
        {
            contenido+= empleado.getNombre()+","+empleado.getCedula()+"\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_EMPLEADOS, contenido, false);
    }

    public static void guardarArchivoUsuarios(ArrayList<Usuario>listaUsuarios) throws IOException {
        String contenido="";
        for (Usuario usuario: listaUsuarios)
        {
            contenido+= usuario.getUsername()+","+usuario.getContrasena()+","+usuario.getTipo()+"\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_USUARIOS, contenido, false);
    }

    public static void guardarArchivoClientes(ArrayList<Cliente> listaClientes) throws IOException {
        String contenido="";
        for (Cliente cliente: listaClientes)
        {
            contenido+=cliente.getNombre()+","+cliente.getCedula()+","+cliente.getListaReservas()+"\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_CLIENTES, contenido, false);
    }

    public static void guardarArchivoReservas(ArrayList<Reserva> listaReservas) throws  IOException{
        String contenido="";
        for (Reserva reserva: listaReservas)
        {
            contenido+=reserva.getId()+","+reserva.getNombreCliente()+","+reserva.getIdHabitacion()+",";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_RESERVAS, contenido, false);
    }



    public static void guardaRegistroLog(String mensajeLog, int nivel, String accion)
    {

        ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
    }


    //------------------------------------SERIALIZACI�N  y XML


    public static Hostal cargarRecursoHostalBinario() {

        Hostal hostal = null;

        try {
            hostal = (Hostal) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_HOTAL_BINARIO);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return hostal;
    }

    public static void guardarRecursoHostalBinario(Hostal hostal) {

        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_HOTAL_BINARIO, hostal);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    public static Hostal cargarRecursoHostalXML() {

        Hostal hostal = null;

        try {
            hostal = (Hostal) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_HOSTAL_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return hostal;
    }



    public static void guardarRecursoHostalXML(Hostal hostal) {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_HOSTAL_XML, hostal);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
